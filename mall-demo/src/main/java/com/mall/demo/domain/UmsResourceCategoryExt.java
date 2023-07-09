package com.mall.demo.domain;

import com.mall.demo.model.UmsResource;
import com.mall.demo.model.UmsResourceCategory;
import lombok.Data;

import java.util.List;

/**
 * @author kongwenjia
 * @date 2023/7/9 12:24
 * @description UmsResourceCategor 扩展类，用于 Mybatis 一对多查询
 *  根据ums_resource_category 中的类别，找出该类下都有哪些资源 （关联ums_resource表）
 */
@Data
public class UmsResourceCategoryExt extends UmsResourceCategory {
    private List<UmsResource> resourceList;
}
