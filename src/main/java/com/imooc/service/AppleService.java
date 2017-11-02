package com.imooc.service;


import com.imooc.domain.Apple;
import com.imooc.repository.AppleRepository;
import com.imooc.controller.AppleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppleService {

    @Autowired
    private AppleRepository appleRepository;

    @Transactional
    public void inserTwo()
    {
        Apple appleA = new Apple();
        appleA.setColor("Pink");
        appleA.setPrice(5);
        appleRepository.save(appleA);

        Apple appleB = new Apple();
        appleB.setColor("green");
        appleB.setPrice(7);
        appleRepository.save(appleB);
    }

    public void getPrice(Integer id) throws Exception
    {
        Apple apple = appleRepository.findOne(id);
        Integer price = apple.getPrice();
        if (price <10)
        {
            //返回"价格小于10"
            throw new Exception("price lower than 10");
        }
        else if(price >10 && price <16)
        {
            //返回"16>price>10"
            throw new Exception("price lagerer than 10 lower than 16");
        }
    }
}
