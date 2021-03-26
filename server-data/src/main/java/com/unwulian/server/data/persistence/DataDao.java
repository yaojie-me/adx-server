package com.unwulian.server.data.persistence;

import com.unwulian.server.data.domain.AdSlot;
import com.unwulian.server.data.domain.AdSlotTrafficConfig;
import com.unwulian.server.data.domain.AdSlotTrafficConfigDocking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * mybatis 数据获取
 *
 * @author yaojie
 */
@Mapper
public interface DataDao {

    @Select("SELECT * FROM ad_slot WHERE status = 1 OR status = 2")
    List<AdSlot> getAllAdSlot();

    @Select("SELECT * FROM ad_slot_traffic_config WHERE status = 1")
    List<AdSlotTrafficConfig> getAllAdSlotTrafficConfig();

    @Select("SELECT * FROM ad_slot_traffic_config_docking WHERE status = 1")
    List<AdSlotTrafficConfigDocking> getAllAdSlotTrafficConfigDocking();
}
