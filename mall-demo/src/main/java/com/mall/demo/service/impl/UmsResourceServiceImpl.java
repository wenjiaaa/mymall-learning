package com.mall.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.demo.dao.UmsResourceDao;
import com.mall.demo.model.UmsResource;
import com.mall.demo.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kongwenjia
 * @date 2023/7/9 16:56
 * @description 实现分类查询接口
 */
@Service
public class UmsResourceServiceImpl implements UmsResourceService {
    @Autowired
    private UmsResourceDao umsResourceDao;

    /**
     * 分页查询语句：select * from tableA LIMIT 3 OFFSET 0; 表示每页3条记录，要获取第1页的记录（OFFSET 不写默认是0）
     * OFFSET指的是跳过多少记录，比如 LIMIT 3 OFFSET 3 表示跳过第3条记录，也就是查询第2页
     * LIMIT 3 OFFSET 6 表示跳过第6条记录，也就是查询第3页，以此类推
     * @param pageNum 第几页
     * @param pageSize 每页几条
     * @param categoryId 筛选的类别ID，注意这里是先把类别筛选出来，对类别数据再做分页查询。而不是先分页再查类别ID
     * @return
     */
    @Override
    public PageInfo<UmsResource> page(Integer pageNum, Integer pageSize, Long categoryId) {
        PageHelper.startPage(pageNum,pageSize);
        List<UmsResource> resourceList = umsResourceDao.selectListByCategoryId(categoryId);
        PageInfo<UmsResource> pageInfo = new PageInfo<>(resourceList);
        return pageInfo;
    }

}
