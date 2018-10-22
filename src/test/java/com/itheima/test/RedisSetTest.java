package com.itheima.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author lk
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class RedisSetTest {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Test
	public void addTest() {
		redisTemplate.boundSetOps("setName").add("≤‹≤Ÿ");
		redisTemplate.boundSetOps("setName").add("¡ı±∏");
		redisTemplate.boundSetOps("setName").add("ÀÔ»®");
		
	}
	
	@Test
	public void getTest() {
		Set  set = redisTemplate.boundSetOps("setName").members();
		System.out.println(set);
	}
	
	@Test
	public void removeTest() {
		redisTemplate.boundSetOps("setName").remove("¡ı±∏");
		
	}
	
	@Test
	public void deleteTest() {
		redisTemplate.delete("setName");
	}
	
}
