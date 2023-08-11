package tech.seems.dubbodemo.consumer.action;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.seems.dubbodemo.dubbo.api.DemoService;

@Component
public class DemoServiceConsumer {

    @DubboReference
    private DemoService demoService;

    public String doSayHello(String name) {
        return demoService.sayHello(name);
    }
}
