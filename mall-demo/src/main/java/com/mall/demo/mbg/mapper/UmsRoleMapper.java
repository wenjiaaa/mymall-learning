package com.mall.demo.mbg.mapper;

import com.mall.demo.mbg.model.UmsRole;
import com.mall.demo.mbg.model.UmsRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsRoleMapper {
    long countByExample(UmsRoleExample example);

    int deleteByExample(UmsRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsRole row);

    int insertSelective(UmsRole row);

    List<UmsRole> selectByExample(UmsRoleExample example);

    UmsRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UmsRole row, @Param("example") UmsRoleExample example);

    int updateByExample(@Param("row") UmsRole row, @Param("example") UmsRoleExample example);

    int updateByPrimaryKeySelective(UmsRole row);

    int updateByPrimaryKey(UmsRole row);
}