package com.shine.dao.Matlab;

import java.util.List;

import com.shine.entity.Emp;
import com.shine.entity.Matlab;
import com.shine.entity.youkexinxi;

public interface Matlabdao {
	List<Matlab> findAll();
	void addMatlab(Matlab e );
	void deleteMatlab(int matNum);
	Matlab findById(int matNum);
	void updateMatlab(Matlab e);
}
