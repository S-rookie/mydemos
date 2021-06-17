package com.deng.controller;

import com.deng.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author deng
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    FeignService feignService;

    @RequestMapping("getInfo")
    public String test(){
        String msg = "xiaoxiao";
        return feignService.test(msg);
    }
}
