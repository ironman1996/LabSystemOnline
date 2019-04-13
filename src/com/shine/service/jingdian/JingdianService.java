package com.shine.service.jingdian;

import com.shine.entity.EmpJingdian;
import com.shine.entity.Result;

public interface JingdianService {
	Result findAll();
	Result addEmpJingdian(EmpJingdian e);
	Result deleteEmpJingdian(int jdnum);
	Result updateEmpJingdian(EmpJingdian e);
	Result findById(int jdnum);
}
