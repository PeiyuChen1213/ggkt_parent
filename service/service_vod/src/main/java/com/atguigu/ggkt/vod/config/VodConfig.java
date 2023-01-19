package com.atguigu.ggkt.vod.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
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
    //将返回的类交给spring管理
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
