package com.mall.demo.test;

import ch.qos.logback.core.joran.action.IADataForComplexProperty;
import com.mall.demo.domain.AdminRoleDto;
import com.mall.demo.domain.RoleStatDto;
import com.mall.demo.mbg.model.UmsAdmin;
import com.mall.demo.service.UmsAdminService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.relation.Role;
import java.util.Arrays;
import java.util.List;

/**
 * @author kongwenjia
 * @date 2023/7/15 17:56
 * @description MyBatisGenerator测试类
 */
@SpringBootTest
public class MyBatisGeneratorTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisGeneratorTest.class);

    @Autowired
    UmsAdminService umsAdminService;

    @Test
    void testSelectByPrimaryKey(){
        Long selectId = 1L;
        UmsAdmin umsAdmin = umsAdminService.select(selectId);
        LOGGER.info("testSelectByPrimaryKey umsAdmin = {}", umsAdmin.toString());
    }

    @Test
    void testListAll(){
        int pageNum = 2;
        int pageSize = 5;
        List<UmsAdmin> umsAdmins = umsAdminService.listAll(pageNum,pageSize);
        for (UmsAdmin umsAdmin : umsAdmins){
            LOGGER.info("testListAll umsAdmin = {}", umsAdmin.toString());
        }
    }

    @Test
    void testSubList(){
        Long roleId = 5L;
        List<UmsAdmin> umsAdmins = umsAdminService.subList(roleId);
        for (UmsAdmin umsAdmin : umsAdmins){
            LOGGER.info("testSubList umsAdmin = {}", umsAdmin.toString());
        }
    }

    @Test
    void testGroupList(){
        List<RoleStatDto> roleStatDtos = umsAdminService.groupList();
        for (RoleStatDto roleStatDto : roleStatDtos){
            LOGGER.info("testGroupList roleStatDto = {}",roleStatDto.toString());
        }
    }

    @Test
    void testDeleteByUsername(){
        String username = "newTest";
        umsAdminService.deleteByUsername(username);
    }

    @Test
    void testUpdateByIds(){
        List<Long> ids = Arrays.asList(1L,3L);
        System.out.println(ids);
        Integer status = 1;
        umsAdminService.updateByIds(ids,status);
    }

    @Test
    void testSelectWithRoleList(){
        Long id = 1L;
        AdminRoleDto adminRoleDto = umsAdminService.selectWithRoleList(id);
        LOGGER.info("testSelectWithRoleList adminRoleDto = {}", adminRoleDto.getRoleList());
    }


}
