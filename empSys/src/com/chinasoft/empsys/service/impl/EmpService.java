package com.chinasoft.empsys.service.impl;

import java.util.List;

import com.chinasoft.empsys.dao.IEmpDao;
import com.chinasoft.empsys.dao.impl.EmpDao;
import com.chinasoft.empsys.entity.Emp;
import com.chinasoft.empsys.service.IEmpService;
/**
 *服务实现类
 */
public class EmpService implements IEmpService {
	IEmpDao dao=new EmpDao();
	@Override
	public Emp login(String name, String password) {
		
		return dao.findEmpByNameAndPassword(name,password);
	}
	@Override
	public int register(Emp emp) {
		if (dao.findEmpByName(emp.getName())!=null) {
			return -1;
		}else {
			boolean emp2 = dao.insertEmp(emp);
			if (emp2) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	@Override
	public List<Emp> searchAll() {
		return dao.findEmp();
	}
	@Override
	public void deleteEmp(String parameter) {
		Emp emp=dao.findEmpById(parameter);
		dao.insertEmployee(emp);
		dao.deleteEmployee(emp);
	}
	@Override
	public List<Emp> searchDeleteAll() {
		List<Emp> emps= dao.findDeleteEmp();
		return emps;
	}
	@Override
	public void clearEmp(String parameter) {
		Emp emp = dao.findEmpByIdDelete(parameter);
		dao.deleteEmployeeDelete(emp);
	}
	@Override
	public void recoveryEmp(String parameter) {
		Emp emp = dao.findEmpByIdDelete(parameter);
		dao.insertEmpByDelete(emp);
		dao.deleteEmployeeDelete(emp);
	}
	@Override
	public Emp searchEmpById(String parameter) {
		
		return dao.findEmpById(parameter);
	}
	@Override
	public int modifyEmp(Emp emp) {
		dao.modifyEmployee(emp);
		return 0;
	}
	@Override
	public List<Emp> serachById(String id) {
		 List<Emp> list=dao.findById(id);
		 return list;
	}
	@Override
	public List<Emp> searchEmpByName(String name) {
		List<Emp> list=  dao.findByName(name);
		return list;
	}
	@Override
	public List<Emp> searchEmpByAge(String age1, String age2) {
		List<Emp> list= dao.findEmpByAge(age1,age2);
		return list;
	}
	@Override
	public List<Emp> searchEmpByAgeAndName(String age1, String age2, String name) {
		List<Emp> list= dao.findEmpByAgeAndName(age1,age2,name);
		return list;
	}

}
