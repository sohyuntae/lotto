package com.example.testweb.controller;

import graphql.*;
import graphql.language.SourceLocation;
import io.leangen.graphql.spqr.spring.web.dto.GraphQLRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GraphQLController {

    private final GraphQL graphQL;

    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object graphql(@RequestBody GraphQLRequest graphQLRequest, HttpServletRequest raw) throws IOException {
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(graphQLRequest.getQuery())
                .context(raw)
                .build();

        log.info(graphQLRequest.getQuery());

        ExecutionResult executionResult = graphQL.execute(executionInput);

        if (!executionResult.getErrors().isEmpty())
        {
            return sanitize(executionResult);
        }

        return executionResult.toSpecification();
    }

    private ExecutionResult sanitize(ExecutionResult executionResult)
    {
        return new ExecutionResultImpl(executionResult.getErrors().stream()
            .peek(err -> log.error(err.getMessage()))
            .map(this::sanitize)
            .collect(Collectors.toList()));
    }

    private GraphQLError sanitize(GraphQLError error)
    {
        if (error instanceof ExceptionWhileDataFetching)
        {
            return new GraphQLError()
            {
                @Override
                public String getMessage()
                {
                    Throwable cause = ((ExceptionWhileDataFetching) error).getException().getCause();
                    return cause instanceof InvocationTargetException ? ((InvocationTargetException) cause).getTargetException().getMessage() : cause.getMessage();
                }

                @Override
                public List<SourceLocation> getLocations()
                {
                    return error.getLocations();
                }

                @Override
                public ErrorType getErrorType()
                {
                    return (ErrorType) error.getErrorType();
                }
            };
        }
        return error;
    }
}
