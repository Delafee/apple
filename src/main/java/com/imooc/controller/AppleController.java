package com.imooc.controller;

import com.imooc.aspect.HttpAspect;
import com.imooc.domain.Apple;
import com.imooc.domain.Result;
import com.imooc.repository.AppleRepository;
import com.imooc.service.AppleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utils.ResultUtil;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AppleController {

    private final static Logger logger = LoggerFactory.getLogger(AppleController.class);


    @Autowired
    private AppleRepository appleRepository;

    @Autowired
    private AppleService appleService;

    @GetMapping(value = "/apples")
    public List<Apple> appleList() {
        logger.info("appleList");
        return appleRepository.findAll();

    }

    /**
     * 添加
     * @return
     */
    @PostMapping(value = "/apples")
    public Result<Apple> appleAdd(@Valid Apple apple, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());

        }
        apple.setColor(apple.getColor());
        apple.setPrice(apple.getPrice());

        return ResultUtil.success(appleRepository.save(apple));

    }
    //查询
    @GetMapping(value="/apples/{id}")
    public Apple appleFindOne(@PathVariable("id") Integer id)
    {
        return appleRepository.findOne(id);
    }

    @PutMapping(value="/apples/{id}")
    public Apple appleUpdate(@PathVariable("id") Integer id,
                            @RequestParam("color") String color,
                            @RequestParam("price") Integer price)
    {
        Apple apple = new Apple();
        apple.setId(id);
        apple.setColor(color);
        apple.setPrice(price);

        return appleRepository.save(apple);
    }

    @DeleteMapping(value="/apples/{id}")
    public void appleDelete(@PathVariable("id") Integer id)
    {
        appleRepository.delete(id);
    }

    //search by price
    @GetMapping(value="/apples/price/{price}")
    public List<Apple> appleListByPrice(@PathVariable("price") Integer price)
    {
        return appleRepository.findByPrice(price);
    }

    @PostMapping(value="/apples/two")
    public void appleTwo()
    {
        appleService.inserTwo();
    }

    @GetMapping(value = "apples/getPrice/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception
    {
        appleService.getPrice(id);
    }
}
