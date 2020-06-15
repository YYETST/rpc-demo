package com.yonyou.provider.service;

import ms.dto.SupportEntity;
import ms.service.IRpcMockService;
import org.springframework.stereotype.Service;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/8
 * @des
 */
@Service
public class RpcMockServiceImpl implements IRpcMockService {
    @Override
    public SupportEntity getSupportInfo() throws Exception {
        SupportEntity supportEntity = new SupportEntity("nscer","com.yonyou.server:this is a test","007");
        return supportEntity;
    }
}
