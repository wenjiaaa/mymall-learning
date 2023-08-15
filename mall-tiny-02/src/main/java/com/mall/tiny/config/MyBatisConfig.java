package com.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kongwenjia
 * @date 2023/8/15 21:42
 * @description MyBatis配置类
 */
@Configuration
@MapperScan("com.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}
