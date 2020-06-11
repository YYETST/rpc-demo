package com.yonyou.provider.service;

import ms.dto.ItemEntity;
import ms.service.IProviderService;
import org.springframework.stereotype.Service;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/9
 * @des
 */
@Service
public class ProviderServiceImpl implements IProviderService {
    @Override
    public ItemEntity getItemInfo() throws Exception {
        ItemEntity itemEntity = new ItemEntity("nsc","001");
        return itemEntity;
    }
}

