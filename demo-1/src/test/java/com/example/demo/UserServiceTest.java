package com.example.demo;
import static org.hamcrest.CoreMatchers.is;
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	@Resource
    private UserService userService;
	@Test
	public void createTest()throws Exception{
		String result = userService.userCreate(new User("test","test"));
		Assert.assertThat(result, is("success"));
	}
	@Test
	public void loginTest1() throws Exception {
		Thread.sleep(3000);
		String result  = userService.userLogin(new User("A","S"));
		Assert.assertThat(result, is("success"));
	}
	@Test
	public void loginTest2() throws Exception {
		String result  = userService.userLogin(new User("test","xxxx"));
		Assert.assertThat(result, is("fail"));
	}
}
