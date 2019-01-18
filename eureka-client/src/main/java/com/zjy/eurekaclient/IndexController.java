package com.zjy.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    EurekaClientConfigBean eurekaClientConfigBean;

    @Value("${eureka.client.ssl.key-store}")
    String keyStoreFileName;

    @Value("${eureka.client.ssl.key-store-password}")
    String keyStorePassword;

    @RequestMapping("/test")
    public String test(){
        return keyStoreFileName+"--"+keyStorePassword;
    }

    @RequestMapping("/eureka-server")
    public Object getEurekaServerUrl(){
        return eurekaClientConfigBean.getServiceUrl();
    }
}
