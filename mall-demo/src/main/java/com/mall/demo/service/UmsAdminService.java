package com.mall.demo.service;

import cn.hutool.db.Page;
import com.github.pagehelper.PageHelper;
import com.mall.demo.domain.AdminRoleDto;
import com.mall.demo.domain.RoleStatDto;
import com.mall.demo.mbg.model.UmsAdmin;
import com.mall.demo.mbg.model.UmsAdminExample;

import java.util.List;

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

    List<UmsAdmin> listAll(Integer pageNum, Integer pageSize);

    List<UmsAdmin> list(Integer pageNum, Integer pageSize, String username, List<Integer> statusList);

    List<UmsAdmin> subList(Long roleId);

    List<RoleStatDto> groupList();

    void deleteByUsername(String username);

    void updateByIds(List<Long> ids, Integer status);

    AdminRoleDto selectWithRoleList(Long id);

}
