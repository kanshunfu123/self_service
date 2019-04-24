package com.xiaowei;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableDiscoveryClient //让注册中心能够发现 ,可以是其他注册中心
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, PageHelperAutoConfiguration.class, RedisAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class})
@ComponentScan(basePackages = "com.xiaowei")
@EnableFeignClients({"com.xiaowei.feign"}) //调用其他服务的api
@EnableCircuitBreaker //启动断路器
@EnableHystrixDashboard //仪表盘
@EnableAsync
public class XiaoweiSelfServiceWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(XiaoweiSelfServiceWebApplication.class, args);
	}

}
