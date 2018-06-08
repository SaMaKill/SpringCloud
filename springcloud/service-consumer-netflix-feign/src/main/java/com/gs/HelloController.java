package com.gs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private HiService hiService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("say")
    public String say() {
        System.out.println(discoveryClient.getInstances("service-provider").get(0).getPort());
        return helloService.say("test");
    }

    @GetMapping("say1")
    public String say1() {
        System.out.println(discoveryClient.getInstances("service-provider").get(0).getPort());
        return hiService.say("test");
    }

}
