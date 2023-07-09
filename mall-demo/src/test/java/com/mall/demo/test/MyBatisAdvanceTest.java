package com.mall.demo.test;

import com.mall.demo.dao.UmsResourceCategoryDao;
import com.mall.demo.dao.UmsResourceDao;
import com.mall.demo.domain.UmsResourceCategoryExt;
import com.mall.demo.domain.UmsResourceExt;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kongwenjia
 * @date 2023/7/9 15:30
 * @description MyBatis高级查询测试
 */

@SpringBootTest
public class MyBatisAdvanceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisBaseTest.class);

    @Autowired
    private UmsResourceDao umsResourceDao;

    @Autowired
    private UmsResourceCategoryDao umsResourceCategoryDao;

    @Test
    void testSelectResourceWithCategory(){
        UmsResourceExt umsResourceExt = umsResourceDao.selectResourceWithCategory(1L);
        LOGGER.info("testOneToOne category={}",umsResourceExt.getCategory());
    }

    @Test
    void testSelectResourceWithCategory2(){
        UmsResourceExt umsResourceExt = umsResourceDao.selectResourceWithCategory2(1L);
        LOGGER.info("testOneToOne category={}",umsResourceExt.getCategory());
    }

    @Test
    void testSelectCategoryWithResource(){
        UmsResourceCategoryExt umsResourceCategoryExt = umsResourceCategoryDao.selectCategoryWithResource(1L);
        LOGGER.info("testOneToMany resourceList={}",umsResourceCategoryExt.getResourceList());
    }
}
