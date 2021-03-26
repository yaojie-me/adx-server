package com.unwulian.server.data.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 广告位转发配置
 *
 * @author yaojie
 */
@Getter
@Setter
public class AdSlotTrafficConfig implements Comparable<AdSlotTrafficConfig> {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int slotId;
    private int platformId;
    private int priority;
    private int percent;
    private String expression;
    private int type;


    @Override
    public int compareTo(AdSlotTrafficConfig o) {
        return this.getPriority() - o.getPriority();
    }


}