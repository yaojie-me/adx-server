package com.unwulian.server.web.router;

import com.unwulian.server.web.sts.StsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 路由器，所有的 api 接入都在这里统一处理
 *
 * @author yaojie
 */
@Configuration
public class ApiRouter {


    @Bean
    RouterFunction<ServerResponse> stsRouter(StsHandler handler) {
        return RouterFunctions.route(RequestPredicates.POST("/v1/sts/{ch}"), handler::doHandler);
    }


}
