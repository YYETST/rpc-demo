package com.yonyou.provider.service;

import ms.dto.ItemEntity;
import ms.service.IBusinessTrack2Service;
import ms.service.IBusinessTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/10
 * @des  测试业务追踪
 */
@Service
public class BusinessTrackServiceImpl implements IBusinessTrackService {

    @Autowired(required = false)
    IBusinessTrack2Service businessTrack2Service;

    @Override
    public ItemEntity getItemInfo() throws Exception {
        ItemEntity  itemEntity = businessTrack2Service.getItemInfo2();
        itemEntity.setName("cccccc");
        return itemEntity;
    }
}
