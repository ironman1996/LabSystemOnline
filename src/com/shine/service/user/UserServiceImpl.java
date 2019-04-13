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
		if(user == null){//�û���������
			result.setStatus(1);
			result.setMessage("�û�������");
			result.setData(user);
		}else if(!user.getPassword().equals(password)){//
			result.setStatus(2);
			result.setMessage("�������");
		}else{
			result.setStatus(0);
			result.setMessage("��¼�ɹ�");
			result.setData(user);
		}
		return result;
	}

}
