package com.wang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("/hello")
public class SpringBootController {
    @Autowired
    private DataSource dataSource;
    @RequestMapping("/spring")
    public String hello() {
        System.out.println(dataSource);
        return "hello springboot"+ dataSource;
    }
}
