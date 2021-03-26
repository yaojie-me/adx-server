package com.unwulian.server.data.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 广告位转发对接配置
 *
 * @author yaojie
 */
@Getter
@Setter
public class AdSlotTrafficConfigDocking {

    private int id;
    private int configId;
    private String targetSlotId;
    private String appId;
    private String appSecret;


}