package com.shine.service.cheliangxinxi;

import java.util.List;

import com.shine.dao.cheliangxinxi.cheliangxinxiDaoImpl;
import com.shine.dao.youkexinxi.youkexinxiDaoImpl;
import com.shine.entity.Result;
import com.shine.entity.cheliangxinxi;
import com.shine.entity.youkexinxi;

public class cheliangxinxiServiceImpl implements cheliangxinxiService {

	@Override
	public Result findAll() {
		// TODO Auto-generated method stub
		Result result = new Result();
		cheliangxinxiDaoImpl dao = new cheliangxinxiDaoImpl();
		List<cheliangxinxi> list = dao.findAll();
		result.setStatus(0);
		result.setMessage("查询成功");
		result.setData(list);
		return result;
		
	}

	@Override
	public Result addcheliangxinxi(cheliangxinxi e) {
		// TODO Auto-generated method stub
		Result result = new Result();
		cheliangxinxiDaoImpl dao = new cheliangxinxiDaoImpl();
		dao.addcheliangxinxi(e);
		result.setStatus(0);
		result.setMessage("添加成功");
		result.setData(e);
		return result;
		
	}

	@Override
	public Result deletecheliangxinxi(int cheliangbianhao) {
		// TODO Auto-generated method stub
		Result result = new Result();
		cheliangxinxiDaoImpl dao = new cheliangxinxiDaoImpl();
		dao.deletecheliangxinxi(cheliangbianhao);
		result.setStatus(0);
		result.setMessage("删除成功");
		return result;
	
	}

	@Override
	public Result updatecheliangxinxi(cheliangxinxi e) {
		// TODO Auto-generated method stub
		Result result = new Result();
		cheliangxinxiDaoImpl dao =  new cheliangxinxiDaoImpl();
		dao.updatecheliangxinxi(e);
		result.setStatus(0);
		result.setMessage("修改成功");
		result.setData(e);
		return result;
	}

	@Override
	public Result findById(int cheliangbianhao) {
		// TODO Auto-generated method stub
		Result result = new Result();
		cheliangxinxiDaoImpl dao =  new cheliangxinxiDaoImpl();
		cheliangxinxi e = dao.findById(cheliangbianhao);
		result.setStatus(0);
		result.setMessage("查询成功");
		result.setData(e);
		return result;
	}

}
