package com.shine.dao.jingdian;

import java.util.List;

import com.shine.entity.EmpJingdian;

public interface JingdianDao {
	List<EmpJingdian> findAll();
	void addEmpJingdian(EmpJingdian e);
	void deleteEmpJingdian(int jdnum);
	EmpJingdian findById(int jdnum);
	void updateEmpJingdian(EmpJingdian e);
}
