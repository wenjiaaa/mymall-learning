package com.mall.demo.service;

import com.mall.demo.mbg.model.UmsAdmin;

/**
 * @author kongwenjia
 * @date 2023/7/15 17:44
 * @description 后台用户管理Service
 */
public interface UmsAdminService {
    void create(UmsAdmin entity);

    void update(UmsAdmin entity);

    void delete(Long id);

    UmsAdmin select(Long id);

}
