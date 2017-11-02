package com.imooc.repository;

import com.imooc.domain.Apple;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppleRepository extends JpaRepository<Apple, Integer>{

    //search by price
    public List<Apple> findByPrice(Integer price);

}
