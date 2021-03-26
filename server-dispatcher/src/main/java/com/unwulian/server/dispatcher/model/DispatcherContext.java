package com.unwulian.server.dispatcher.model;

import lombok.Data;

/**
 * 转发上下文
 *
 * @author yaojie
 */
@Data
public class DispatcherContext {

    private DispatcherRequest request;

    private DispatcherResponse response;

}
