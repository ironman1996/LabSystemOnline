package com.shine.test.emp;

import java.util.List;

import org.apache.tomcat.util.collections.SynchronizedStack;
import org.junit.Test;

import com.shine.dao.emp.EmpDao;
import com.shine.dao.emp.EmpDaoImpl;
import com.shine.entity.Emp;

public class TestDao {
	@Test
	public void test() {
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findAll();
		for(Emp e :list) {
			System.out.println(e);
		}
	}
	@Test
	public void test1() {
		EmpDao dao = new EmpDaoImpl();
		Emp e = new Emp();
		e.setName("Ðìá¿");
		e.setSalary(900);
		e.setGender("M");
		dao.addEmp(e);
	}
	
	@Test
	public void test2() {
		EmpDao dao = new EmpDaoImpl();
		dao.deleteEmp(1015);
	}
	
	@Test
	public void test3() {
		EmpDao dao = new EmpDaoImpl();
		Emp e = dao.findById(1018);
		
		e.setName("Ñî¹óåú");
		System.out.println(e);
		
		dao.updateEmp(e);
	}
}
