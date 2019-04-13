package com.shine.dao.youkexinxi;

import java.util.List;

import com.shine.entity.Emp;
import com.shine.entity.youkexinxi;

public interface youkexinxidao {
	List<youkexinxi> findAll();
	void addyoukexinxi(youkexinxi e );
	void deleteyoukexinxi(int youkebianhao);
	youkexinxi findById(int id);
	void updateyoukexinxi(youkexinxi e);
}
