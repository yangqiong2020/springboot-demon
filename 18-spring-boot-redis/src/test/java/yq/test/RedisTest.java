package yq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yq.App;
import yq.pojo.Users;


/**
 * Spring Data Redis测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= App.class)
public class RedisTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 添加一个字符串
	 */
	@Test
	public void testSet(){
		this.redisTemplate.opsForValue().set("key", "111111");
	}
	
	/**
	 * 获取一个字符串
	 */
	@Test
	public void testGet(){
		String value = (String)this.redisTemplate.opsForValue().get("key");
		System.out.println(value);
	}



	/**
	 * 添加Users对象
	 */
	@Test
	public void testSetUesrs(){
		Users users = new Users();
		users.setAge(20);
		users.setName("张三丰");
		users.setId(1);
		//重新设置序列化器
		//this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		//基于JSON格式存Users对象
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		this.redisTemplate.opsForValue().set("users1", users);
	}

	/**
	 * 取Users对象
	 */
	@Test
	public void testGetUsers(){
		//重新设置序列化器
		//this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		//基于JSON格式存Users对象
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		Users users = (Users)this.redisTemplate.opsForValue().get("users1");

		System.out.println(users);
	}
}
