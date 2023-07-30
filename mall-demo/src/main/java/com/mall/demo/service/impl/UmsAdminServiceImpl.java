package com.mall.demo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.mall.demo.dao.UmsAdminDao;
import com.mall.demo.domain.AdminRoleDto;
import com.mall.demo.domain.RoleStatDto;
import com.mall.demo.mbg.mapper.UmsAdminMapper;
import com.mall.demo.mbg.model.UmsAdmin;
import com.mall.demo.mbg.model.UmsAdminExample;
import com.mall.demo.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kongwenjia
 * @date 2023/7/15 17:46
 * @description 后台用户管理Service实现类
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UmsAdminMapper adminMapper;

    @Override
    public void create(UmsAdmin entity) {
        adminMapper.insert(entity);
    }

    @Override
    public void update(UmsAdmin entity) {
        adminMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public void delete(Long id) {
        adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UmsAdmin select(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询全部，使用Mybatis-generator自动生成的Example类
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<UmsAdmin> listAll(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return adminMapper.selectByExample(new UmsAdminExample());
    }

    /**
     * 按用户名和状态查询后台用户并按创建时间降序排列，且分页查询
     * 使用Mybatis-generator自动生成的Example类
     * @param pageNum
     * @param pageSize
     * @param username
     * @param statusList
     * @return
     */
    @Override
    public List<UmsAdmin> list(Integer pageNum, Integer pageSize, String username, List<Integer> statusList){
        PageHelper.startPage(pageNum,pageSize);
        UmsAdminExample umsAdminExample = new UmsAdminExample();
        UmsAdminExample.Criteria criteria = umsAdminExample.createCriteria();
        if(StrUtil.isNotEmpty(username)){
            criteria.andUsernameEqualTo(username);
        }
        criteria.andStatusIn(statusList);
        umsAdminExample.setOrderByClause("create_time desc");
        return adminMapper.selectByExample(umsAdminExample);
    }

    /**
     * 子查询：按角色ID查询后台用户
     * 在UmsAdminMapper.xml中使用Mybatis-generator自动生成的BaseResultMap
     * @param roleId
     * @return
     */
    @Override
    public List<UmsAdmin> subList(Long roleId) {
        return adminMapper.subList(roleId);
    }

    /**
     * 按角色ID查询后台用户
     * @return
     */
    @Override
    public List<RoleStatDto> groupList(){
        return adminMapper.groupList();
    }

    /**
     * 按用户名删除后台用户
     * @param username
     */
    @Override
    public void deleteByUsername(String username){
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        adminMapper.deleteByExample(example);
    }

    /**
     * 按指定ID修改后台用户的状态
     * 特别注意这里要使用 updateByExampleSelective， 而不是 updateByExample
     */
    @Override
    public void updateByIds(List<Long> ids, Integer status){
        UmsAdmin record = new UmsAdmin();
        record.setStatus(status);
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andIdIn(ids);
        adminMapper.updateByExampleSelective(record,example);

    }

    /**
     * 一对多查询：按ID查询后台用户信息（包含对应角色列表）
     * @param id
     * @return
     */
    @Override
    public AdminRoleDto selectWithRoleList(Long id){
        return  adminMapper.selectWithRoleList(id);
    }
}
