package com.unwulian.server.dispatcher.sender;

import com.unwulian.server.dispatcher.model.DispatcherContext;

public interface IProtocolConvert<Q, R> {


    /**
     * 将发送的源消息实例转换为发送消息对象实例
     *
     * @param context
     * @return
     */
    Q convertSendRequest(DispatcherContext context);

    /**
     * 根据流量请求中的相关配置将响应结果实例转换成AdResponse实例
     *
     * @param context 上下文
     * @param response   发送终端返回的响应结果对象实例
     * @return
     */
    void convertToAdResponse(DispatcherContext context, R response);
}
