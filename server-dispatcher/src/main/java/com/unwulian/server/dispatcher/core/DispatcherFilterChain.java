package com.unwulian.server.dispatcher.core;

import com.unwulian.server.common.chain.Filter;
import com.unwulian.server.common.chain.SimpleMultiFilterChain;
import com.unwulian.server.common.utils.SpringContextUtil;
import com.unwulian.server.dispatcher.model.DispatcherContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 转发过滤链
 *
 * @author yaojie
 */
@Component
@DependsOn(value = {"springContextUtil"})
public class DispatcherFilterChain extends SimpleMultiFilterChain<DispatcherContext> {

    @Override
    @PostConstruct
    public void setFilters(List<Filter<DispatcherContext>> filters) {

    }
}
