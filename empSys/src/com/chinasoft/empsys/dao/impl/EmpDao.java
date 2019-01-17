package com.chinasoft.empsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.chinasoft.empsys.dao.IEmpDao;
import com.chinasoft.empsys.entity.Emp;
import com.chinasoft.empsys.utils.MyDButils;

/**
 * dao实现类
 */
public class EmpDao implements IEmpDao {
	private QueryRunner runner = new QueryRunner(MyDButils.getDataSource());

	@Override
	public Emp findEmpByNameAndPassword(String name, String password) {
		try {
			Emp emp = runner.query("select * from emp where name=? and password=?", new BeanHandler<Emp>(Emp.class),
					name, password);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Emp findEmpByName(String name) {
		try {
			Emp emp = runner.query("select * from emp where name=?", new BeanHandler<Emp>(Emp.class), name);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertEmp(Emp emp) {
		try {
			runner.update("insert into emp values(null,?,?,?,?,?,?,?,?)", emp.getName(), emp.getPassword(),
					emp.getGender(), emp.getAge(), emp.getHiredate(),emp.getSalary(), emp.getPhone(), emp.getEmail());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertEmployee(Emp emp) {
		try {
			runner.update("insert into emp_delete values(?,?,?,?,?,?,?,?,?)",emp.getId() , emp.getName(), emp.getPassword(),
					emp.getGender(), emp.getAge(), emp.getHiredate(),emp.getSalary(), emp.getPhone(), emp.getEmail());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modifyEmployee(Emp emp) {
		try {
			runner.update("update emp set name=?,password=?,gender=?,age=?,hiredate=?,salary=?,phone=?,email=? where id=?", 
					emp.getName(),emp.getPassword(),emp.getGender(),emp.getAge(),emp.getHiredate(),emp.getSalary(),emp.getPhone(),emp.getEmail(),emp.getId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(Emp employee) {
		try {
			 runner.update("delete from emp where id=?", employee.getId());
			 return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Emp> findEmp() {
		try {
			List<Emp> list = runner.query("select * from emp", new BeanListHandler<Emp>(Emp.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Emp findEmpById(String parameter) {
		try {
			return runner.query("select * from emp where id=?", new BeanHandler<Emp>(Emp.class),parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Emp> findDeleteEmp() {
		try {
			return runner.query("select * from emp_delete", new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteEmployeeDelete(Emp emp) {
		try {
			runner.update("delete from emp_delete where id=?", emp.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Emp findEmpByIdDelete(String parameter) {
		try {
			return runner.query("select * from emp_delete where id=?", new BeanHandler<Emp>(Emp.class),parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertEmpByDelete(Emp emp) {
		try {
			runner.update("insert into emp values(?,?,?,?,?,?,?,?,?)",emp.getId() , emp.getName(), emp.getPassword(),
					emp.getGender(), emp.getAge(), emp.getHiredate(),emp.getSalary(), emp.getPhone(), emp.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Emp> findEmpByAge(String age1, String age2) {
		try {
			List<Emp> list = runner.query("select * from emp where age between ? and ?", new BeanListHandler<Emp>(Emp.class), age1,age2);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Emp> findEmpByAgeAndName(String age1, String age2, String name) {
		try {
			List<Emp> list = runner.query("select * from emp where name=? and age between ? and ? ", new BeanListHandler<Emp>(Emp.class), name,age1,age2);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Emp> findById(String id) {
		try {
			List<Emp> list = runner.query("select * from emp where id=?", new BeanListHandler<Emp>(Emp.class), id);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Emp> findByName(String name) {
		try {
			List<Emp> list = runner.query("select * from emp where name=?", new BeanListHandler<Emp>(Emp.class), name);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
