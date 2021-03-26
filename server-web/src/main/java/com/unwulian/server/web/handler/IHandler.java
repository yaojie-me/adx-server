package com.unwulian.server.web.handler;

import com.unwulian.server.common.utils.SpringContextUtil;
import com.unwulian.server.dispatcher.model.DispatcherContext;
import com.unwulian.server.dispatcher.model.DispatcherRequest;
import com.unwulian.server.dispatcher.model.DispatcherResponse;
import com.unwulian.server.dispatcher.core.TrafficDispatcher;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.lang.reflect.ParameterizedType;

/**
 * 媒体协议处理 handler
 *
 * @author yaojie
 */
public interface IHandler<R, Q> {

    /**
     * 解析请求协议
     *
     * @param request ServerRequest
     * @return 协议请求
     */
    default Mono<R> parseRequest(ServerRequest request) {
        return request.bodyToMono(getRequestType());
    }

    /**
     * 核心转发处理逻辑
     *
     * @param request 请求
     * @return 响应
     */
    default Mono<ServerResponse> doHandler(ServerRequest request) {
        Mono<R> rMono = parseRequest(request);
        Mono<DispatcherRequest> mono = rMono.map(this::convertRequest);
        // 直接使用上下文获取转发器
        TrafficDispatcher dispatcher = SpringContextUtil.getBean(TrafficDispatcher.class);
        Mono<DispatcherContext> context = mono.map(e -> {
            DispatcherContext dc = new DispatcherContext();
            dc.setRequest(e);
            return dc;
        });
        dispatcher.doDispatcher(context);
        Mono<DispatcherResponse> responseMono = Mono.empty();
        Mono<Q> response = responseMono.map(this::convertResponse);
        return createResponse(response);
    }

    /**
     * 转换请求协议
     *
     * @param r 协议请求
     * @return 转发请求
     */
    DispatcherRequest convertRequest(R r);

    /**
     * 转换响应协议
     *
     * @param response 转发响应
     * @return 协议响应
     */
    Q convertResponse(DispatcherResponse response);


    /**
     * 生成响应结果
     *
     * @param response 协议响应
     * @return ServerResponse
     */
    default Mono<ServerResponse> createResponse(Mono<Q> response) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response, getResponseType());
    }

    /**
     * 获取请求泛型类型
     *
     * @return R 类型
     */
    default Class<R> getRequestType() {
        @SuppressWarnings("unchecked")
        Class<R> clazz = (Class<R>) ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        return clazz;
    }

    /**
     * 获取响应泛型类型
     *
     * @return R 类型
     */
    default Class<R> getResponseType() {
        @SuppressWarnings("unchecked")
        Class<R> clazz = (Class<R>) ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[1];
        return clazz;
    }
}
