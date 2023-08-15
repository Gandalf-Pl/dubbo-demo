package tech.seems.dubbodemo.consumer.common;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class RcpRequest {
    private String appId;

    private String interfaceName;

    private String method;

    private String version;

    private Object params;
}
