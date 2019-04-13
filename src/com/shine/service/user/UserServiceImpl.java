package com.shine.service.user;

import com.shine.dao.user.UserDao;
import com.shine.dao.user.UserDaoImpl;
import com.shine.entity.Result;
import com.shine.entity.User;

public class UserServiceImpl implements UserService {

	@Override
	public Result checkUsername(String username,String password) {
		Result result = new Result();
		UserDao dao = new UserDaoImpl();
		User user = dao.findByUsername(username);
		if(user == null){//用户名不存在
			result.setStatus(1);
			result.setMessage("用户不存在");
			result.setData(user);
		}else if(!user.getPassword().equals(password)){//
			result.setStatus(2);
			result.setMessage("密码错误");
		}else{
			result.setStatus(0);
			result.setMessage("登录成功");
			result.setData(user);
		}
		return result;
	}

}
