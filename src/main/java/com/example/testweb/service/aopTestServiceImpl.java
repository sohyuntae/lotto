package com.example.testweb.service;

import com.example.testweb.service.annotation.protocolTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class aopTestServiceImpl implements aopTestService{

    @Override
    @protocolTest
    public Long sum(Long x, Long y) {
        return x + y;
    }
}
