package tech.seems.dubbodemo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.seems.dubbodemo.consumer.action.DemoServiceConsumer;

@RestController
public class HelloController {

    @Autowired
    private DemoServiceConsumer demoServiceConsumer;

    @GetMapping("/")
    public String index() {
        return "test";
    }

    @GetMapping("/say")
    public String sayHello() {
        return demoServiceConsumer.doSayHello("xxx");
    }
}
