package com.example.testweb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class aopTestServiceImpl implements aopTestService{

    @Override
    public Long sum(Long x, Long y) {
        return x + y;
    }
}
