package com.shine.service.Matlab;

import java.util.List;

import com.shine.dao.Matlab.MatlabDaoImpl;
import com.shine.dao.emp.EmpDao;
import com.shine.dao.emp.EmpDaoImpl;
import com.shine.dao.user.UserDao;
import com.shine.dao.user.UserDaoImpl;
import com.shine.dao.youkexinxi.youkexinxiDaoImpl;
import com.shine.dao.youkexinxi.youkexinxidao;
import com.shine.entity.Emp;
import com.shine.entity.Matlab;
import com.shine.entity.Result;
import com.shine.entity.User;
import com.shine.entity.youkexinxi;

public class MatlabServiceImpl implements MatlabService {
	public Result findAll() {
		Result result = new Result();
		MatlabDaoImpl dao = new MatlabDaoImpl();
		List<Matlab> list = dao.findAll();
		result.setStatus(0);
		result.setMessage("查询成功");
		result.setData(list);
		return result;
	}

	public Result addMatlab(Matlab e) {
		Result result = new Result();
		MatlabDaoImpl dao = new MatlabDaoImpl();
		dao.addMatlab(e);
		result.setStatus(0);
		result.setMessage("添加成功");
		result.setData(e);
		return result;
	}

	public Result deleteMatlab(int matNum) {
		Result result = new Result();
		MatlabDaoImpl dao = new MatlabDaoImpl();
		dao.deleteMatlab(matNum);
		result.setStatus(0);
		result.setMessage("删除成功");
		return result;
	}

	public Result updateMatlab(Matlab e) {
		Result result = new Result();
		MatlabDaoImpl dao =  new MatlabDaoImpl();
		dao.updateMatlab(e);
		result.setStatus(0);
		result.setMessage("修改成功");
		result.setData(e);
		return result;
	}

	public Result findById(int matNum) {
		Result result = new Result();
		MatlabDaoImpl dao =  new MatlabDaoImpl();
		Matlab e = dao.findById(matNum);
		result.setStatus(0);
		result.setMessage("查询成功");
		result.setData(e);
		return result;
	}
	public Result checkMatPackageName(String youkexingming,String youkemima) {
		System.out.println(youkemima+' '+"SI");
		Result result = new Result();
		youkexinxiDaoImpl dao = new youkexinxiDaoImpl();
		youkexinxi user = dao.findByyoukexingming(youkexingming);
		System.out.println(user.getyoukexingming()+"111"+user.getyoukemima());
		if(user == null){//用户名不存在
			result.setStatus(1);
			result.setMessage("用户不存在");
			result.setData(user);
		}else if(!user.getyoukemima().equals(youkemima)){//
			result.setStatus(2);
			result.setMessage("密码错误");
		}else{
			result.setStatus(0);
			result.setMessage("登录成功");
			result.setData(user);
		}
		return result;
	}
	
}
