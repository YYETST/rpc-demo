package ms.service;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import ms.constants.AppInfoConstant;
import ms.dto.ItemEntity;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/9
 * @des 熔断测试
 */
@RemoteCall(AppInfoConstant.APP_INF_PROVIDER)
public interface IProviderService {

    public ItemEntity getItemInfo() throws Exception;
}
