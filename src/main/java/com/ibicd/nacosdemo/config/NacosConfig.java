package com.ibicd.nacosdemo.config;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 服务发现配置
 */
@Configuration
public class NacosConfig {

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String appName;

    @NacosInjected
    private NamingService namingService;

    @PostConstruct
    public void registerService() throws NacosException {

        namingService.registerInstance(appName, "127.0.0.1", serverPort);

    }



}
