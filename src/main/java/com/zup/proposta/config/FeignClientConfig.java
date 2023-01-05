package com.zup.proposta.config;

import feign.RequestInterceptor;

public class FeignClientConfig {

    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
        };
    }

}
