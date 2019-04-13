package com.shine.service.jingdian;

import java.util.List;

import com.shine.dao.jingdian.JingdianDao;
import com.shine.dao.jingdian.JingdianDaoImpl;
import com.shine.entity.EmpJingdian;
import com.shine.entity.Result;

public class JingdianServiceImpl implements JingdianService {

	@Override
	public Result findAll() {
		// TODO Auto-generated method stub
		Result result = new Result();
		JingdianDao dao = new JingdianDaoImpl();
		List<EmpJingdian> list = dao.findAll();
		result.setStatus(0);
		result.setMessage("��ѯ�ɹ�");
		result.setData(list);
		return result;
	}

	@Override
	public Result addEmpJingdian(EmpJingdian e) {
		// TODO Auto-generated method stub
		Result result = new Result();
		JingdianDao dao = new JingdianDaoImpl();
		dao.addEmpJingdian(e);
		result.setStatus(0);
		result.setMessage("��ӳɹ�");
		result.setData(e);
		return result;
	}

	@Override
	public Result deleteEmpJingdian(int jdnum) {
		// TODO Auto-generated method stub
		Result result = new Result();
		JingdianDao dao = new JingdianDaoImpl();
		dao.deleteEmpJingdian(jdnum);
		result.setStatus(0);
		result.setMessage("ɾ���ɹ�");
		return result;
	}

	@Override
	public Result updateEmpJingdian(EmpJingdian e) {
		// TODO Auto-generated method stub
		Result result = new Result();
		JingdianDao dao = new JingdianDaoImpl();
		dao.updateEmpJingdian(e);
		result.setStatus(0);
		result.setMessage("�޸ĳɹ�");
		result.setData(e);
		return result;
	}

	@Override
	public Result findById(int jdnum) {
		// TODO Auto-generated method stub
		Result result = new Result();
		JingdianDao dao = new JingdianDaoImpl();
		EmpJingdian e =dao.findById(jdnum);
		result.setStatus(0);
		result.setMessage("��ѯ�ɹ�");
		result.setData(e);
		return result;
	}
	
}
