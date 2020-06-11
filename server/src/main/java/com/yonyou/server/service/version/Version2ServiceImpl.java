package com.yonyou.server.service.version;

import com.alibaba.dubbo.config.annotation.Service;
import ms.dto.SupportEntity;
import ms.service.IVersionService;
import org.springframework.stereotype.Component;

/**
 * @author nishch
 * @version 2.0
 * @date 2020/6/8
 * @des   测试指定微服务版本  配置文件中增加 app.tag
 */
@Component
@Service(version="2.0")
public class Version2ServiceImpl implements IVersionService {

    @Override
    public SupportEntity getSupportInfo() throws Exception {
        SupportEntity supportEntity = new SupportEntity("nscer","server2.0:this is a version test","007");
        return supportEntity;
    }
}
