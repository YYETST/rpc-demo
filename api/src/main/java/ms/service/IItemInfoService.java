package ms.service;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.cloud.mwclient.servmeta.annotation.ApiParam;
import com.yonyou.cloud.mwclient.servmeta.annotation.ApiReturnValue;
import ms.constants.AppInfoConstant;
import ms.dto.ItemEntity;

/**
 * 获取项目信息
 * ------自动生成文档,接口调用流程测试    client->com.yonyou.server
 */
@RemoteCall(AppInfoConstant.APP_INF_SERVER)
public interface IItemInfoService {
	
	/**
	 * 获取项目信息
	 * 
	 * @return ItemEntity
	 */
	public @ApiReturnValue(name="获取项目信息", description="根据项目名称获取项目信息")
	ItemEntity statisticCallInfo(
            @ApiParam(name = "项目名称", required = false) String itemName) throws Exception;

}
