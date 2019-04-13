package com.shine.dao.daoyou;

import java.util.List;

import com.shine.entity.EmpDaoyou;

public interface DaoyouDao {
	List<EmpDaoyou> findAll();
	void addEmpDaoyou(EmpDaoyou e );
	void deleteEmpDaoyou(int dynum);
	EmpDaoyou findById(int dynum);
	void updateEmpDaoyou(EmpDaoyou e);
}
