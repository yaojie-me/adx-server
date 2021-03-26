package com.unwulian.server.dispatcher.core;

import com.unwulian.server.dispatcher.model.DispatcherContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Component
public class TrafficDispatcher {

    @Resource
    private DispatcherFilterChain filterChain;

    public void doDispatcher(Mono<DispatcherContext> context) {
        filterChain.doFilter(context);
    }
}
