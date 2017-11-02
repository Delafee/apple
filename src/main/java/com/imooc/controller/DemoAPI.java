package com.imooc.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Use to test JMeter
 */
@RestController
@RequestMapping("/guowang/demoAPI")
public class DemoAPI{

    @RequestMapping(value="/getDemo/{userName}", method = RequestMethod.GET)
    public String getDemo(@PathVariable String userName){
        return userName;
    }
    public static int count = 0;
    @RequestMapping(value = "/postDemo", method = RequestMethod.POST)
    public String postDemo(@RequestParam String userName){
        count ++;
        String result = "接口是第" + count + "次被调用，您的用户名是： " + userName;
        return result;
    }

    @RequestMapping(value = "/postJson", method = RequestMethod.POST)
    public @ResponseBody Student postDemo(@RequestBody Student s){
        Student student = new Student();
        student.name = s.name;
        student.clazz = s.clazz;
        return student;
    }
}