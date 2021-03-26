/**
 *
 */
package com.unwulian.server.common.chain;

import reactor.core.publisher.Mono;

/**
 * 可复用的过滤器链
 * @author yaojie
 *
 */
public abstract class SimpleMultiFilterChain<T> implements FilterContainer<T> {

    private final ThreadLocal<Integer> pos = new ThreadLocal<>();

    private int n;

    private Filter<T>[] filters;

    public SimpleMultiFilterChain() {
        super();
    }

    public SimpleMultiFilterChain(Filter<T>[] filters) {
        if (filters == null || filters.length <= 0) {
            throw new IllegalArgumentException(
                    "The argument [filters] is null or size of it is zero.");
        }
        this.filters = filters;
        this.n = filters.length;
    }


    @Override
    public void doFilter(Mono<T> context) {
        int posValue = pos.get() == null ? 0 : pos.get();
        try {
            if (posValue < n && filters != null) {
                Filter<T> filter = filters[posValue];
                pos.set(++posValue);
                filter.doFilter(context, this);
            }
        } finally {
            pos.remove();
        }
    }
}
