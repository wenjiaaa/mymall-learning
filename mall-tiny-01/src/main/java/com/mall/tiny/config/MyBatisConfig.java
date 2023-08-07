package com.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kongwenjia
 * @date 2023/8/7 20:21
 * @description MyBatis配置类
 */

@Configuration
@MapperScan({"com.mall.tiny.mbg.mapper","com.mall.tiny.dao"})
public class MyBatisConfig {
}
