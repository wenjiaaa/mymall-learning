package com.mall.demo.domain;

/**
 * @author kongwenjia
 * @date 2023/7/29 16:53
 * @description 按照角色统计后台用户数量
 */
public class RoleStatDto {
    private  Long roleId;
    private String roleName;
    private Integer count;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "RoleStatDto{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", count=" + count +
                '}';
    }
}
