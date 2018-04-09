package com.hivescm.scm.service.start;

import com.hivescm.common.listener.SpringBootPreparedEventListener;
import com.hivescm.common.listener.SpringBootStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@ComponentScan({"com.hivescm"})
@ImportResource({"classpath:spring-tsharding.xml"})
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
@EnableFeignClients(basePackages={
		"com.hivescm.info.contact.service",//基础信息
		"com.hivescm.crm.api.service.customer",//CRM客户
		"com.hivescm.crm.api.service.store",//CRM门店
		"com.hivescm.crm.api.service.base",//CRM基础
		"com.hivescm.wms.api.share",//WMS出库
		"com.hivescm.org.api",//组织机构
		"com.hivescm.tms.api.feign.waybill",//TMS运单
		"com.hivescm.tms.api.feign.sign",//TMS签收
		"com.hivescm.tms.api.feign.capacity",//TMS派车
		"com.hivescm.tms.api.feign.dispatcher",//TMS分配
		"com.hivescm.promotion.contact.service",//促销
		"com.hivescm.scm.common",//SCM
		"com.hivescm.stock.contract.service",//库存
		"com.hivescm.scm.base.service",//SCM基础服务
		"com.hivescm.billing.service",//应收应付
		"com.hivescm.b2b.api",//B2B
		"com.hivescm.permission.api",//促销
		"com.hivescm.open.external.platform.youzan.api",//有赞
		"com.hivescm.oms.listener",
		"com.hivescm.oms.service",
		"com.hivescm.open.inner.gateway.api.code",//网关
		"com.hivescm.open.inner.gateway.api.generated",
})
public class AppStart {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AppStart.class);
		app.addListeners(new SpringBootStartedEventListener());
		app.addListeners(new SpringBootPreparedEventListener());
		app.run(args);
	}
	
}
