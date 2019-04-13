package com.shine.service.youkexinxi;

import com.shine.entity.Emp;
import com.shine.entity.Result;
import com.shine.entity.youkexinxi;

public interface youkexinxiService {
	
		Result  findAll();
		Result addyoukexinxi(youkexinxi e);
		Result deleteyoukexinxi(int id );
		Result updateyoukexinxi(youkexinxi e);
		Result findById(int youkebianhao);
		
	
}
