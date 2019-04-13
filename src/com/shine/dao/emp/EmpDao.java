package com.shine.dao.emp;

import java.util.List;

import com.shine.entity.Emp;

public interface EmpDao {
	List<Emp> findAll();
	void addEmp(Emp e );
	void deleteEmp(int id);
	Emp findById(int id);
	void updateEmp(Emp e);
}
