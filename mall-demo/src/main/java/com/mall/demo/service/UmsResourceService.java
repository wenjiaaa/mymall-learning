package com.mall.demo.service;

import com.github.pagehelper.PageInfo;
import com.mall.demo.model.UmsResource;

/**
 * @author kongwenjia
 * @date 2023/7/9 16:55
 * @description 分页查询接口
 */
public interface UmsResourceService {
    PageInfo<UmsResource> page(Integer pageNum, Integer pageSize, Long categoryId);
}
