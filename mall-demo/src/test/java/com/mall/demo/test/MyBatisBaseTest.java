package com.mall.demo.test;

import cn.hutool.crypto.digest.BCrypt;
import com.mall.demo.dao.UmsAdminDao;
import com.mall.demo.model.UmsAdmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MyBatisBaseTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisBaseTest.class);

	@Autowired
	private UmsAdminDao umsAdminDao;
	@Test
	void testSelectByIdSimple() {
		UmsAdmin umsAdmin = umsAdminDao.selectByIdSimple(1L);
		LOGGER.info("testSelectByIdSimple result = {}", umsAdmin);
	}

	@Test
	void testSelectById() {
		UmsAdmin umsAdmin = umsAdminDao.selectById(1L);
		LOGGER.info("testSelectByIdSimple result = {}", umsAdmin);
	}

	@Test
	void testSelectByIds(){
		List <UmsAdmin> umsAdminList = umsAdminDao.selectByIds(Arrays.asList(1L, 2L, 3L));
		for (UmsAdmin umsAdmin : umsAdminList){
			LOGGER.info("testSelectByIds result = {}", umsAdmin);
		}
	}
	@Test
	void testSelectByUsernameAndEmailLike(){
		List<UmsAdmin> umsAdminList = umsAdminDao.selectByUsernameAndEmailLike("test","qq");
		for (UmsAdmin umsAdmin : umsAdminList){
			LOGGER.info("testSelectByUsernameAndEmailLike result = {}", umsAdmin);
		}

	}

	@Test
	void testInsert(){
		UmsAdmin admin = new UmsAdmin();
		admin.setUsername("newTest");
		admin.setPassword(BCrypt.hashpw("123456"));
		admin.setEmail("newTest@qq.com");
		admin.setNickName("tester");
		admin.setCreateTime(new Date());
		admin.setStatus(1);
		int result = umsAdminDao.insert(admin);
		LOGGER.info("testInsert id={},result={}",admin.getId(),result);
		Assertions.assertEquals(1,result);
	}

	@Test
	void testUpdateById(){
		UmsAdmin admin = new UmsAdmin();
		admin.setId(1L);
		admin.setUsername("test666-update");
		admin.setPassword(BCrypt.hashpw("123456"));
		admin.setEmail("test666@qq.com");
		admin.setNickName("tester");
		admin.setCreateTime(new Date());
		admin.setStatus(1);
		int result  = umsAdminDao.updateById(admin);
		LOGGER.info("testUpdateById result={}",result);
		Assertions.assertEquals(1,result);

	}

	@Test
	void testUpdateByIdSelective(){
		UmsAdmin admin = new UmsAdmin();
		admin.setId(1L);
		admin.setUsername("test666-update");
		admin.setPassword(BCrypt.hashpw("123456"));
		admin.setEmail("test666@qq.com");
		admin.setNickName("tester");
		admin.setCreateTime(new Date());
		admin.setStatus(1);
		int result  = umsAdminDao.updateByIdSelective(admin);
		LOGGER.info("testUpdateByIdSelective result={}",result);
		Assertions.assertEquals(1,result);
	}

	@Test
	void testDeleteById(){
		int result = umsAdminDao.deleteById(14L);
		LOGGER.info("testDeleteById result={}",result);
		//Assertions.assertEquals(1,result);
	}
}
