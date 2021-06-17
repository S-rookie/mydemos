package com.deng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author deng
 */
@RestController
@RequestMapping("stock")
public class StockController {

    @RequestMapping("test")
    public String test(String info){
        return "stock接收:"+info;
    }

}
