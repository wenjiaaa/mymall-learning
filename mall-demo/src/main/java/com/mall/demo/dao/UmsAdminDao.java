package com.mall.demo.dao;

import com.mall.demo.model.UmsAdmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmsAdminDao {
    /**
     *根据ID查询用户，select *，查询全部
     * @param id
     * @return
     */
    UmsAdmin selectByIdSimple(Long id);

    /**
     * 根据ID查询用户，查询部分字段
     * @param id
     * @return
     */
    UmsAdmin selectById(Long id);

    /**
     * 根据用户ID批量查询
     * @param ids
     * @return
     */
    List<UmsAdmin> selectByIds(@Param("ids") List<Long> ids);

    /**
     * 根据用户名和Email模糊查询用户
     * @param username
     * @param email
     * @return
     */
    List<UmsAdmin> selectByUsernameAndEmailLike(@Param("username") String username, @Param("email") String email);


    /**
     * 插入用户
     * @param umsAdmin
     * @return
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 批量插入用户
     * @param adminList
     * @return
     */
    int insertBatch(@Param("entityList") List<UmsAdmin> adminList);
    /**
     * 根据ID修改用户信息
     * @param umsAdmin
     * @return
     */
    int updateById(UmsAdmin umsAdmin);

    /**
     * 根据ID选择性修改用户信息
     * @param entity
     * @return
     */
    int updateByIdSelective(UmsAdmin entity);

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    int deleteById(Long id);
}
