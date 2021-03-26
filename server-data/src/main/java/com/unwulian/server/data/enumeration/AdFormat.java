package com.unwulian.server.data.enumeration;

/**
 * 广告形式
 *
 * @author yaojie
 */
public enum AdFormat implements IEnum {

    /**
     * 视频
     */
    VIDEO(1),

    /**
     * 图片
     */
    IMAGE(2);

    int code;

    AdFormat(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }
}
