package com.deng.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author deng
 */
@RestController
@RequestMapping("/nacos")
@RefreshScope
public class NacosConfigController {

    @Value("${mapp.name}")
    private String name;

    @Value("${mapp.password}")
    private String password;

    @RequestMapping("/getInfo")
    public String getConfigInfo(){
        return name+"-"+password;
    }
}
