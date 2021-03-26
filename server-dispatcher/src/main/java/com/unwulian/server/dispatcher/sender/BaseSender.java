package com.unwulian.server.dispatcher.sender;

import com.unwulian.server.dispatcher.model.DispatcherContext;

import java.util.Map;

public abstract class BaseSender<Q,R> implements IProtocolConvert<Q,R>,ISenderConfigure<Q,R>{



    @Override
    public String getMethod() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public int getTimeout(DispatcherContext context) {
        return 0;
    }

    @Override
    public String getRequestUrl(DispatcherContext context) {
        return null;
    }

    @Override
    public Map<String, String> getHeader(DispatcherContext context) {
        return null;
    }

    @Override
    public Object getHttpBody(DispatcherContext context) {
        return null;
    }

    @Override
    public R readHttpResponse(DispatcherContext context, byte[] data) {
        return null;
    }
}
