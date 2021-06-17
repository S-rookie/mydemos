package com.deng.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author deng
 */
@FeignClient("nacos-stock")
public interface FeignService {

    @RequestMapping("stock/test")
    public String test(@RequestParam("info") String info);
}
