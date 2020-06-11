package ms.service;

import com.yonyou.cloud.middleware.rpc.Async;
import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.cloud.middleware.tcctransaction.TccTransactionContext;
import com.yonyou.cloud.middleware.tcctransaction.TccTransactional;
import ms.constants.AppInfoConstant;
import ms.dto.TourOrder;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/11
 * @des   事务管理
 */
@RemoteCall(AppInfoConstant.APP_INF_PROVIDER)
public interface ITccService {

    @TccTransactional(confirm="confirmOrder", cancel="cancelOrder")
    public abstract TourOrder order(TourOrder paramTourOrder);

    @Async
    public abstract TourOrder confirmOrder(TccTransactionContext context, TourOrder paramTourOrder);

    @Async
    public abstract TourOrder cancelOrder(TccTransactionContext context, TourOrder paramTourOrder);

}
