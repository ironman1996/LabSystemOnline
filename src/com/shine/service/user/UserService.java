package com.shine.service.user;

import com.shine.entity.Result;

/**
 * �����û������ҵ��
 * @author xyd
 *
 */
public interface UserService {
	Result checkUsername(String username,String password);
}
