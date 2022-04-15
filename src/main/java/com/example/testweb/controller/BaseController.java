package com.example.testweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BaseController {

    @RequestMapping(value = "/Login", method= RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) {
        return "index.html";
    }
}
