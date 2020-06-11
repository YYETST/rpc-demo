package com.yonyou.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.cloud.middleware.iris.RPCInvocationInfoProxy;
import com.yonyou.cloud.yyeye.itf.Tracer;
import com.yonyou.iuap.context.InvocationInfoProxy;
import lombok.extern.slf4j.Slf4j;
import ms.dto.ItemEntity;
import ms.dto.SupportEntity;
import ms.dto.TourOrder;
import ms.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "/")
@Slf4j
public class IndexController {

	@Autowired(required = false)
	IItemInfoService iItemInfoService;   //测试流程，文档注释,上下文
	@Autowired(required = false)
	IRpcMockService iRpcMockService;   //测试指定ip
	@Autowired(required = false)
	IVersionService iVersionService;   //测试指定版本
	@Autowired(required = false)
	IProviderService iProviderService; //测试熔断
	@Autowired(required = false)
	IBusinessTrackService iBusinessTrackService; //测试业务追踪
	@Autowired(required = false)
	ITccService iTccService;  //分布式事务
	
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value = "index" ,method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		logger.info("welcome to line.html");
		
		return "forward:/line.html";
	}

	/**
	 * 测试调用微服务流程
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "item" ,method = RequestMethod.GET)
	public String item() throws Exception {
		ItemEntity itemEntity =  iItemInfoService.statisticCallInfo("");
		return JSONObject.toJSON(itemEntity).toString();
	}

	/**
	 * 测试指定微服务ip调用
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "support" ,method = RequestMethod.GET)
	public String support() throws Exception {
		SupportEntity itemEntity =  iRpcMockService.getSupportInfo();
		return JSONObject.toJSON(itemEntity).toString();
	}

	/**
	 * 测试指定微服务版本调用
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "version" ,method = RequestMethod.GET)
	public String version() throws Exception {
		//将调用版本设置为1.0
		RPCInvocationInfoProxy.setInstanceZone("2.0");
		SupportEntity itemEntity =  iVersionService.getSupportInfo();
		return JSONObject.toJSON(itemEntity).toString();
	}


	/**
	 * 测试上下文信息传递
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "context" ,method = RequestMethod.GET)
	public String context() throws Exception {
		InvocationInfoProxy.setParameter("name","test");
		InvocationInfoProxy.setUsername("ssss");
		ItemEntity itemEntity =  iItemInfoService.statisticCallInfo("");
		return JSONObject.toJSON(itemEntity).toString();
	}


	/**
	 * 测试熔断
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "fallback" ,method = RequestMethod.GET)
	public String fallback() throws Exception {
		ItemEntity itemEntity =  iProviderService.getItemInfo();
		return JSONObject.toJSON(itemEntity).toString();
	}

	/**
	 * 测试业务跟踪   ----好像不好使呀
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "tracer" ,method = RequestMethod.GET)
	public String tracer() throws Exception {
		Random random = new Random();
		int result=random.nextInt(10000);
		String code = "N"+ result;
		Tracer.setBusiCode(code);
		System.out.println("这是设置的code:"+code);
		logger.debug("这是设置的code:"+code);
		ItemEntity itemEntity =  iBusinessTrackService.getItemInfo();
		return JSONObject.toJSON(itemEntity).toString();
	}

	/**
	 * TCC分布式事务
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "tcc" ,method = RequestMethod.GET)
	public String tcc() throws Exception {
		TourOrder paramTourOrder = new TourOrder();
		paramTourOrder.setOrderName("test tcc");
		TourOrder order = iTccService.order(paramTourOrder);
		return JSONObject.toJSON(order).toString();
	}

}