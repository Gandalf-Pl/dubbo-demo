package tech.seems.dubbodemo.consumer.common;

import com.alibaba.fastjson2.JSON;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonRcpCall {

    @Value("${dubbo.registry.address}")
    private String nacosUrl;

    /**
     * 远程调用信息
     * @param request rcp调用参数
     * @return 调用结果
     */
    public Object rcpInvoke(RcpRequest request) {
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<GenericService>();
        referenceConfig.setInterface(request.getInterfaceName());
        referenceConfig.setGeneric("true");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(nacosUrl);

        GenericService genericService = referenceConfig.get();
        Object result = genericService.$invoke(
                request.getMethod(),
                new String[]{"java.lang.String"},
                new Object[] {"seems"}
        );
        System.out.println(JSON.toJSONString(result));
        return result;
    }
}
