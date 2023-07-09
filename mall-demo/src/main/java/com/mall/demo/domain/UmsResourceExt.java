package com.mall.demo.domain;

import com.mall.demo.model.UmsResource;
import com.mall.demo.model.UmsResourceCategory;
import lombok.Data;

/**
 * @author kongwenjia
 * @date 2023/7/9 12:23
 * @description UmsResource扩展类，用于 Mybatis 一对一查询。
 * 根据ums_resource 表的资源ID和类别ID，找出类型详情（关联ums_resource_category）
 */

@Data
public class UmsResourceExt extends UmsResource {
    private UmsResourceCategory category;
}
