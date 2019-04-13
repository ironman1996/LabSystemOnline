package com.shine.dao.cheliangxinxi;

import java.util.List;

import com.shine.entity.Emp;
import com.shine.entity.cheliangxinxi;
import com.shine.entity.youkexinxi;

public interface cheliangxinxidao {
	List<cheliangxinxi> findAll();
	void addcheliangxinxi(cheliangxinxi e );
	void deletecheliangxinxi(int cehliangbianhao);
	cheliangxinxi findById(int cheliangbianhao);
	void updatecheliangxinxi(cheliangxinxi e);
}
