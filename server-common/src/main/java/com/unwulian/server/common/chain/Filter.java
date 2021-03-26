package com.unwulian.server.common.chain;

import reactor.core.publisher.Mono;

public interface Filter<T> {

    Mono<T> doFilter(Mono<T> context, FilterChain<T> filterChain);
}
