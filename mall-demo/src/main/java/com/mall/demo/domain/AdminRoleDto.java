package com.mall.demo.domain;

import com.mall.demo.mbg.model.UmsAdmin;
import com.mall.demo.mbg.model.UmsRole;

import java.util.List;

/**
 * @author kongwenjia
 * @date 2023/7/30 14:23
 * @description 一对多查询，按ID查询后台用户信息（包含对应角色列表）
 */
public class AdminRoleDto extends UmsAdmin {
    private List<UmsRole> roleList;

    public List<UmsRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<UmsRole> roleList) {
        this.roleList = roleList;
    }
}
