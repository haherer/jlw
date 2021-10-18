package com.example.demo1123.service;

import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements FooService {
    @Override
    public String service() {
        return "Foo Service";
    }
}
