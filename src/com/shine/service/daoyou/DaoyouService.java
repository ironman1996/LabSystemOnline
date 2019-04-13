package com.shine.service.daoyou;

import com.shine.entity.EmpDaoyou;
import com.shine.entity.Result;

public interface DaoyouService {
	Result  findAll();
	Result addEmpDaoyou(EmpDaoyou e);
	Result deleteEmpDaoyou(int dynum );
	Result updateEmpDaoyou(EmpDaoyou e);
	Result findById(int dynum);
}
