package com.unwulian.server.dispatcher.core.filter;

import com.unwulian.server.common.chain.Filter;
import com.unwulian.server.common.chain.FilterChain;
import com.unwulian.server.dispatcher.model.DispatcherContext;
import reactor.core.publisher.Mono;

public class DispatcherFilter implements Filter<DispatcherContext> {

    @Override
    public Mono<DispatcherContext> doFilter(Mono<DispatcherContext> context, FilterChain<DispatcherContext> filterChain) {
        return context.doOnNext(e -> System.out.println(e));
    }

    public static void main(String[] args) {
        Mono<String> mono1 = Mono.just("aaa");
        System.out.println(mono1);
        Mono<String> mono2 = mono1.doOnNext(System.out::println);
        System.out.println(mono2.hashCode());
        Mono<String> mono3 = mono2.doOnNext(System.out::println);
        System.out.println(mono3.hashCode());

        Mono<A> m1 = Mono.just(new A("asb"));
        m1.map(e -> {
            e.setC("ccc");
            return e;
        });
        System.out.println(m1.block().getC());

        m1.doOnNext(e -> {
            e.setC("ccc");
        });
        System.out.println(m1.block().getC());

        m1.subscribe(e -> {
            e.setC("ccc");
        });
        System.out.println(m1.block().getC());

        m1.subscribe(e -> {
            e.setC("ccc1");
        });
        System.out.println(m1.block().getC());

        m1.doFinally(e -> System.out.println(e)).subscribe();
    }

    public static class A {

        public A(String c) {
            this.c = c;
        }

        private String c;

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
    }

}
