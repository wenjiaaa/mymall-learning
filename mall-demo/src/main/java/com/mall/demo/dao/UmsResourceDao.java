package com.mall.demo.dao;

import com.mall.demo.domain.UmsResourceExt;
import com.mall.demo.model.UmsResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kongwenjia
 * @date 2023/7/9 12:33
 * @description 自定义UmsResource表查询
 */
@Repository
public interface UmsResourceDao {

    /**
     * 根据资源ID获取资源及分类信息
     */
    UmsResourceExt selectResourceWithCategory(Long id);

    /**
     * 根据资源ID获取资源及分类信息
     * 使用 ResultMap+association 实现一对一查询
     */
    UmsResourceExt selectResourceWithCategory2(Long id);

    /**
     * 根据分类ID查询资源
     */
    List<UmsResource> selectListByCategoryId(Long categoryId);


}
