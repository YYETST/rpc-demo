package ms.service;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.cloud.middleware.rpc.RpcMock;
import ms.constants.AppInfoConstant;
import ms.dto.SupportEntity;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/8
 * @des  在微服务的开发和测试中，我们经常会需要调用特定地址或者版本的微服务，
 *  * 有两种方法可以实现这个目的，一是指定需要调用的微服务ip地址，
 *  * 二是为微服务设置版本，只调用响应版本的微服务。
 *  * ---本例为指定ip地址-通过注解的方式实现
 */

@RpcMock(serviceIp = "10.6.207.30:8083")    //如果不能调通请加上应用context再试
@RemoteCall(AppInfoConstant.APP_INF_SERVER)
public interface IRpcMockService {

    public SupportEntity getSupportInfo() throws Exception;
}
