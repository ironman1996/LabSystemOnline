package com.shine.service.user;

import com.shine.entity.Result;

/**
 * 处理用户管理的业务
 * @author xyd
 *
 */
public interface UserService {
	Result checkUsername(String username,String password);
}
