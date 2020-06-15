package com.yonyou.provider.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yonyou.cloud.config.eos.EosConfig;
import com.yonyou.cloud.middleware.tcctransaction.TccTransactionContext;
import com.yonyou.cloud.middleware.tcctransaction.TccTransactionUtils;
import com.yonyou.cloud.yyeye.itf.Tracer;
import lombok.extern.slf4j.Slf4j;
import ms.constants.AppInfoConstant;
import ms.dto.TourOrder;
import ms.service.ITccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/6/11
 * @des
 */
@Service
@Slf4j
public class TccServiceImpl implements ITccService {

    @Autowired
    private EosConfig eosConfig;

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    @Transactional
    public TourOrder order(TourOrder dto) {
        Tracer.setBusiCode("tcc");
        log.info("这是一个订单："+dto.getOrderName());
        try {
            TccTransactionUtils.setContext(OBJECT_MAPPER.writeValueAsString(dto));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException("参数序列化异常");
        }
        throw new RuntimeException("参数序列化异常");
    }

    @Override
    @Transactional
    public TourOrder confirmOrder(TccTransactionContext context, TourOrder paramTourOrder) {
        String restore = TccTransactionUtils.getContext(context);
        log.info("这是系统的确认订单："+paramTourOrder.getOrderName());
        //throw new RuntimeException("confirm error!!!!!!!!!!!!!!");
        return paramTourOrder;
    }

    @Override
    @Transactional
    public TourOrder cancelOrder(TccTransactionContext context, TourOrder paramTourOrder) {
        String restore = TccTransactionUtils.getContext(context);
        log.info("===========================" + restore);
        log.info("这是系统的取消订单："+paramTourOrder.getOrderName());
        return paramTourOrder;
    }
}
