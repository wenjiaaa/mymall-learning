package com.mall.demo.test;

import com.github.pagehelper.PageInfo;
import com.mall.demo.dao.UmsResourceCategoryDao;
import com.mall.demo.dao.UmsResourceDao;
import com.mall.demo.domain.UmsResourceCategoryExt;
import com.mall.demo.domain.UmsResourceExt;
import com.mall.demo.model.UmsResource;
import com.mall.demo.service.UmsResourceService;
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

    @Autowired
    private UmsResourceService umsResourceService;

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

    /**
     * pageInfo.getTotal() 表示该类别ID下一共有几条数据
     * pageInfo.getPages() 表示筛选完类别ID后的数据可以被分成几页
     * pageInfo.getList() 表示最终查询到的数据列表
     * pageNum 表示查第几页
     * pageSize 表示每页几条记录
     */
    @Test
    void testPage() {
        // 每页5条记录，所以查第2页时 OFFSET=5
        // 等价SQL语句：select * from ums_resource where category_id = 2 LIMIT 5, 5
        int pageNum = 2;
        int pageSize = 5;
        PageInfo<UmsResource> pageInfo = umsResourceService.page(pageNum, pageSize, 1L);
        LOGGER.info("testPage total={},pages={},resourceList={}", pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
    }
}
