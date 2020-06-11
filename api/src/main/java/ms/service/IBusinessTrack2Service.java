package ms.service;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import ms.constants.AppInfoConstant;
import ms.dto.ItemEntity;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/10
 * @des  测试业务追踪   provider->server
 */
@RemoteCall(AppInfoConstant.APP_INF_SERVER)
public interface IBusinessTrack2Service {

    public ItemEntity getItemInfo2() throws Exception;
}
