package com.mall.demo.service.impl;

import com.mall.demo.dao.UmsAdminDao;
import com.mall.demo.mbg.mapper.UmsAdminMapper;
import com.mall.demo.mbg.model.UmsAdmin;
import com.mall.demo.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
