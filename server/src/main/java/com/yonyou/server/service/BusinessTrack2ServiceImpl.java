package com.yonyou.server.service;

import ms.dto.ItemEntity;
import ms.service.IBusinessTrack2Service;
import org.springframework.stereotype.Service;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/10
 * @des 测试业务追踪2
 */
@Service
public class BusinessTrack2ServiceImpl implements IBusinessTrack2Service {
    @Override
    public ItemEntity getItemInfo2() throws Exception {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setCode("001");
        return itemEntity;
    }
}
