package com.unwulian.server.common.chain;

import java.util.List;

/**
 * Filter 容器接口
 *
 * @author yaojie
 */
public interface FilterContainer<T> extends FilterChain<T> {


    /**
     * 设置Filter列表
     *
     * @param filters
     */
    void setFilters(List<Filter<T>> filters);

}
