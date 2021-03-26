package com.unwulian.server.data.domain;


import com.unwulian.server.data.enumeration.AdFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


/**
 * 广告位信息
 *
 * @author yaojie
 */
@Getter
@Setter
public class AdSlot {

    private int id;
    private String name;
    private String showId;
    private String instructions;
    private int mediaId;
    private AdFormat adFormat;
    private String accessMethod;
    private int defaultCreativeId;
    private String description;
    private int showTime;
    private int timeout;
    private BigDecimal floorPrice;
    private List<AdSlotTrafficConfig> trafficConfigList;


}
