package com.yonyou.server.service;

import com.yonyou.iuap.context.InvocationInfoProxy;
import lombok.extern.slf4j.Slf4j;
import ms.dto.ItemEntity;
import ms.service.IItemInfoService;
import org.springframework.stereotype.Service;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/8
 * @des
 */
@Service
public class ItemServiceImpl implements IItemInfoService {
    @Override
    public ItemEntity statisticCallInfo(String itemName) throws Exception {
        String name = InvocationInfoProxy.getParameter("name");
        String name1 = InvocationInfoProxy.getUsername();
        ItemEntity entity = new ItemEntity(name1,"aaa");
        return entity;
    }
}
