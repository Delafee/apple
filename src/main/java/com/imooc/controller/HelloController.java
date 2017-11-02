package com.imooc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Dela
 * 2017-09-03
 */

@RestController
public class HelloController {

    @Autowired
    private com.imooc.properties.AppleProperties AppleProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return AppleProperties.getColor();
    }
}


