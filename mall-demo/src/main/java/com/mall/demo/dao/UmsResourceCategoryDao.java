package com.mall.demo.dao;

import com.mall.demo.domain.UmsResourceCategoryExt;
import org.springframework.stereotype.Repository;

/**
 * @author kongwenjia
 * @date 2023/7/9 15:36
 * @description 自定义UmsResourceCategory表查询
 */
@Repository
public interface UmsResourceCategoryDao {
    /**
     * 根据分类ID获取该分类下的资源列表
     * 使用 ResultMap+collection 实现一对多查询
     */
    UmsResourceCategoryExt selectCategoryWithResource(Long id);
}
