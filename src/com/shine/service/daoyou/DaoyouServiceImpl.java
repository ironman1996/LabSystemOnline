package com.shine.service.daoyou;

import java.util.List;

import com.shine.dao.daoyou.DaoyouDao;
import com.shine.dao.daoyou.DaoyouDaoImpl;
import com.shine.entity.EmpDaoyou;
import com.shine.entity.Result;

public class DaoyouServiceImpl implements DaoyouService{

	@Override
	public Result findAll() {
		// TODO Auto-generated method stub
		Result result = new Result();
		DaoyouDao dao = new DaoyouDaoImpl();
		List<EmpDaoyou> list = dao.findAll();
		result.setStatus(0);
		result.setMessage("查询成功");
		result.setData(list);
		return result;
	}

	@Override
	public Result addEmpDaoyou(EmpDaoyou e) {
		// TODO Auto-generated method stub
		Result result = new Result();
		DaoyouDao dao = new DaoyouDaoImpl();
		dao.addEmpDaoyou(e);
		result.setStatus(0);
		result.setMessage("添加成功");
		result.setData(e);
		return result;
	}

	@Override
	public Result deleteEmpDaoyou(int dynum) {
		// TODO Auto-generated method stub
		Result result = new Result();
		DaoyouDao dao = new DaoyouDaoImpl();
		dao.deleteEmpDaoyou(dynum);
		result.setStatus(0);
		result.setMessage("删除成功");
		return result;
	}

	@Override
	public Result updateEmpDaoyou(EmpDaoyou e) {
		// TODO Auto-generated method stub
		Result result = new Result();
		DaoyouDao dao = new DaoyouDaoImpl();
		dao.updateEmpDaoyou(e);
		result.setStatus(0);
		result.setMessage("修改成功");
		result.setData(e);
		return result;
	}

	@Override
	public Result findById(int dynum) {
		// TODO Auto-generated method stub
		Result result = new Result();
		DaoyouDao dao = new DaoyouDaoImpl();
		EmpDaoyou e = dao.findById(dynum);
		result.setStatus(0);
		result.setMessage("查询成功");
		result.setData(e);
		return result;
	}
	
}
