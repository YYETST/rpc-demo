package com.yonyou.client.service;

import ms.dto.ItemEntity;
import ms.service.IProviderService;
import com.yonyou.cloud.middleware.rpc.Fallback;
/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/10
 * @des  熔断测试
 * 熔断规则可在控制台进行配置（详见：用户指南-熔断），也可以@Fallback注解方式配置，控制台规则优先级高于注解。
 * timeout 	1000 	超时时间，单位：ms，当调用执行时间超过此时间，执行降级逻辑
 * threshold 	20 	熔断触发的最小个数/10s
 * ratio 	20 	错误率，单位：%，失败率达到多少百分比后熔断
 * window 	10 	时间窗口，单位s，熔断多少秒后去变为半开状态，放过一次请求去尝试下游服务的状态，如果成功则关闭熔断，如果失败则继续开启
 *
 * @Fallback(window=10, threshold=0, ratio=0, timeout=0)
 */
@Fallback(window=10, threshold=40, ratio=10, timeout=2000)
public class FallBackProviderService implements IProviderService {
    @Override
    public ItemEntity getItemInfo() throws Exception {
        ItemEntity itemEntity = new ItemEntity("Fallback test","001");
        return itemEntity;
    }
}
