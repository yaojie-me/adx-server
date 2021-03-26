package com.unwulian.server.dispatcher.sender;

import com.unwulian.server.dispatcher.model.DispatcherContext;

import java.util.Map;

/**
 * 转发配置器
 */
public interface ISenderConfigure<Q, R> {

    /**
     * 返回发送请求方式
     *
     * @return
     */
    String getMethod();

    /**
     * 返回消息类型
     *
     * @return
     */
    String getContentType();

    /**
     * 请求超时设置,单位 毫秒
     */
    int getTimeout(DispatcherContext context);

    /**
     * 返回请求url
     *
     * @param sendPacket
     * @return
     */
    String getRequestUrl(DispatcherContext context);

    /**
     * 返回请求Header信息
     *
     * @param sendPacket
     * @return
     */
    Map<String, String> getHeader(DispatcherContext context);

    /**
     * 返回发送数据
     *
     * @param context
     * @return
     */
    Object getHttpBody(DispatcherContext context);


    /**
     * 读取HTTP响应数据
     *
     * @param context
     * @param data
     * @return 结果
     */
    R readHttpResponse(DispatcherContext context, byte[] data);

}
