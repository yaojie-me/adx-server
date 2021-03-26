package com.unwulian.server.data.persistence;

import com.unwulian.server.data.domain.AdSlot;
import com.unwulian.server.data.domain.AdSlotTrafficConfig;
import com.unwulian.server.data.domain.AdSlotTrafficConfigDocking;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 数据获取
 *
 * @author yaojie
 */
@Component
public class DataRepository {

    @Resource
    private DataDao dataDao;

    private Map<String, AdSlot> slotIdCache = new ConcurrentHashMap<>();

    private Map<Integer, List<AdSlotTrafficConfig>> trafficConfigIdCache = new ConcurrentHashMap<>();

    private Map<Integer, AdSlotTrafficConfigDocking> dockingTrafficConfigIdCache = new ConcurrentHashMap<>();

    @Scheduled(fixedDelay = 60 * 1000)
    @PostConstruct
    private void loadData() {

        slotIdCache = dataDao.getAllAdSlot().stream().collect(Collectors.toMap(AdSlot::getShowId, e -> e, (e1, e2) -> e2));

        trafficConfigIdCache = dataDao.getAllAdSlotTrafficConfig().stream().collect(Collectors.groupingBy(AdSlotTrafficConfig::getSlotId));

        dockingTrafficConfigIdCache = dataDao.getAllAdSlotTrafficConfigDocking().stream().collect(Collectors.toMap(AdSlotTrafficConfigDocking::getConfigId, e -> e, (e1, e2) -> e2));
    }

    public AdSlot getAdSlotByShowId(String showId) {
        return slotIdCache.get(showId);
    }

    public List<AdSlotTrafficConfig> getConfigListBySpaceId(int spaceId) {
        return trafficConfigIdCache.get(spaceId);
    }

    public AdSlotTrafficConfigDocking getDockingByConfigId(int configId) {
        return dockingTrafficConfigIdCache.get(configId);
    }
}
