package com.shine.service.emp;

import com.shine.entity.Emp;
import com.shine.entity.Result;

public interface EmpService {
	Result  findAll();
	Result addEmp(Emp e);
	Result deleteEmp(int id );
	Result updateEmp(Emp e);
	Result findById(int id);
	
}
