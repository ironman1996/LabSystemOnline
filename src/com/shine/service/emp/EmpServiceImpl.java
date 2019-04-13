package com.shine.service.emp;

import java.util.List;

import com.shine.dao.emp.EmpDao;
import com.shine.dao.emp.EmpDaoImpl;
import com.shine.entity.Emp;
import com.shine.entity.Result;

public class EmpServiceImpl implements EmpService {

	@Override
	public Result findAll() {
		Result result = new Result();
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findAll();
		result.setStatus(0);
		result.setMessage("查询成功");
		result.setData(list);
		return result;
	}

	@Override
	public Result addEmp(Emp e) {
		Result result = new Result();
		EmpDao dao = new EmpDaoImpl();
		dao.addEmp(e);
		result.setStatus(0);
		result.setMessage("添加成功");
		result.setData(e);
		return result;
	}

	@Override
	public Result deleteEmp(int id) {
		Result result = new Result();
		EmpDao dao = new EmpDaoImpl();
		dao.deleteEmp(id);
		result.setStatus(0);
		result.setMessage("删除成功");
		return result;
	}

	@Override
	public Result updateEmp(Emp e) {
		Result result = new Result();
		EmpDao dao = new EmpDaoImpl();
		dao.updateEmp(e);
		result.setStatus(0);
		result.setMessage("修改成功");
		result.setData(e);
		return result;
	}

	@Override
	public Result findById(int id) {
		Result result = new Result();
		EmpDao dao = new EmpDaoImpl();
		Emp e = dao.findById(id);
		result.setStatus(0);
		result.setMessage("查询成功");
		result.setData(e);
		return result;
	}

}
