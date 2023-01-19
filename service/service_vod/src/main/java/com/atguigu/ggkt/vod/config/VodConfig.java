package com.atguigu.ggkt.vod.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


/**
 * @author Chen Peiyu
 * @version 1.0
 * @description vod服务的配置类
 * @date 1/19/2023 10:55 AM
 */


@MapperScan("com.atguigu.ggkt.vod.mapper")
@Configuration
public class VodConfig {

}
