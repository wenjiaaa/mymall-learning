package com.mall.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 自己写的接口放到"com.mall.demo.dao"， generator自动生成的放到"com/mall/demo/mbg/mapper"
@MapperScan({"com.mall.demo.dao", "com/mall/demo/mbg/mapper"})
public class MyBatisConfig {
}
