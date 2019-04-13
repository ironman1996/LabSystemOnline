package com.shine.service.Matlab;

import com.shine.entity.Emp;
import com.shine.entity.Matlab;
import com.shine.entity.Result;
import com.shine.entity.youkexinxi;

public interface MatlabService {
	
		Result  findAll();
		Result addMatlab(Matlab e);
		Result deleteMatlab(int matNum );
		Result updateMatlab(Matlab e);
		Result findById(int matNum);
		
	
}
