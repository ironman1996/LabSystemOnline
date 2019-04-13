package com.shine.service.cheliangxinxi;

import com.shine.entity.Result;
import com.shine.entity.cheliangxinxi;
import com.shine.entity.youkexinxi;

public interface cheliangxinxiService {
	Result  findAll();
	Result addcheliangxinxi(cheliangxinxi e);
	Result deletecheliangxinxi(int cheliangbianhao );
	Result updatecheliangxinxi(cheliangxinxi e);
	Result findById(int cheliangbianhao);
}
