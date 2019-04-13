package com.shine.service.youkexinxi;

import java.util.List;

import com.shine.dao.emp.EmpDao;
import com.shine.dao.emp.EmpDaoImpl;
import com.shine.dao.user.UserDao;
import com.shine.dao.user.UserDaoImpl;
import com.shine.dao.youkexinxi.youkexinxiDaoImpl;
import com.shine.dao.youkexinxi.youkexinxidao;
import com.shine.entity.Emp;
import com.shine.entity.Result;
import com.shine.entity.User;
import com.shine.entity.youkexinxi;

public class youkexinxiServiceImpl implements youkexinxiService {
	public Result findAll() {
		Result result = new Result();
		youkexinxiDaoImpl dao = new youkexinxiDaoImpl();
		List<youkexinxi> list = dao.findAll();
		result.setStatus(0);
		result.setMessage("��ѯ�ɹ�");
		result.setData(list);
		return result;
	}

	public Result addyoukexinxi(youkexinxi e) {
		Result result = new Result();
		youkexinxiDaoImpl dao = new youkexinxiDaoImpl();
		dao.addyoukexinxi(e);
		result.setStatus(0);
		result.setMessage("��ӳɹ�");
		result.setData(e);
		return result;
	}

	public Result deleteyoukexinxi(int youkebianhao) {
		Result result = new Result();
		youkexinxiDaoImpl dao = new youkexinxiDaoImpl();
		dao.deleteyoukexinxi(youkebianhao);
		result.setStatus(0);
		result.setMessage("ɾ���ɹ�");
		return result;
	}

	public Result updateyoukexinxi(youkexinxi e) {
		Result result = new Result();
		youkexinxiDaoImpl dao =  new youkexinxiDaoImpl();
		dao.updateyoukexinxi(e);
		result.setStatus(0);
		result.setMessage("�޸ĳɹ�");
		result.setData(e);
		return result;
	}

	public Result findById(int youkebianhao) {
		Result result = new Result();
		youkexinxiDaoImpl dao =  new youkexinxiDaoImpl();
		youkexinxi e = dao.findById(youkebianhao);
		result.setStatus(0);
		result.setMessage("��ѯ�ɹ�");
		result.setData(e);
		return result;
	}
	public Result checkUsername(String youkexingming,String youkemima) {
		System.out.println(youkemima+' '+"SI");
		Result result = new Result();
		youkexinxiDaoImpl dao = new youkexinxiDaoImpl();
		youkexinxi user = dao.findByyoukexingming(youkexingming);
		System.out.println(user.getyoukexingming()+"111"+user.getyoukemima());
		if(user == null){//�û���������
			result.setStatus(1);
			result.setMessage("�û�������");
			result.setData(user);
		}else if(!user.getyoukemima().equals(youkemima)){//
			result.setStatus(2);
			result.setMessage("�������");
		}else{
			result.setStatus(0);
			result.setMessage("��¼�ɹ�");
			result.setData(user);
		}
		return result;
	}

}
