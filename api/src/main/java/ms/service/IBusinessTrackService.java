package ms.service;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import ms.constants.AppInfoConstant;
import ms.dto.ItemEntity;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/10
 * @des  测试业务追踪  client->provider
 */
@RemoteCall(AppInfoConstant.APP_INF_PROVIDER)
public interface IBusinessTrackService {

    public ItemEntity getItemInfo() throws Exception;
}
