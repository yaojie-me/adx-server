package com.unwulian.server.common.chain;

import reactor.core.publisher.Mono;

/**
 * 责任链执行器
 *
 * @author yaojie
 */
public interface FilterChain<T> {

    void doFilter(Mono<T> context);

}
