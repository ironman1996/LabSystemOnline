package com.shine.test.user;

import org.junit.Test;

import com.shine.entity.Result;
import com.shine.service.user.UserService;
import com.shine.service.user.UserServiceImpl;

public class TestService {

	
	@Test
	public void test(){
		UserService service = new UserServiceImpl();
		Result result = service.checkUsername("wangbaoqiang", "songzhe");
		System.out.println(result);
	}
}
