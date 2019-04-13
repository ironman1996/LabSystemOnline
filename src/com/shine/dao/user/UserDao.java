package com.shine.dao.user;

import com.shine.entity.User;

public interface UserDao {
	//public abstract 
	User findByUsername(String username);
}
