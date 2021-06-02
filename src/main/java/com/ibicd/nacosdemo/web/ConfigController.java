package com.ibicd.nacosdemo.web;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 配置中心
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache}", autoRefreshed = true)
    private boolean useLocalCache;


    @RequestMapping(value = "/getValue", method = RequestMethod.GET)
    public void getValue() {
        System.out.println("获取 nacos 配置的值： " + useLocalCache);
    }


}
