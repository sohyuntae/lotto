package com.example.testweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class basicController {

    private final com.example.testweb.service.aopTestService aopTestService;

    public basicController(com.example.testweb.service.aopTestService aopTestService) {
        this.aopTestService = aopTestService;
    }

    @RequestMapping(value = "/testAop")
    public void baseSelect(HttpServletRequest request, HttpServletResponse response) throws IOException, ModelAndViewDefiningException
    {
        log.info("test Controller Start");
        StopWatch sw = new StopWatch();
        sw.start();

        aopTestService.sum(1L, 2L);

        sw.stop();

        log.info("걸린시간: {} ms", sw.getLastTaskTimeMillis());

        log.info("test Controller End");

    }
}
