package com.chinasoft.empsys.dao;

import java.util.List;

import com.chinasoft.empsys.entity.Emp;

public interface IEmpDao {
	/**
	 * 根据用户名和密码查询用户
	 */
	Emp findEmpByNameAndPassword(String name,String password);
	/**
	 * 根据用户名查询用户
	 */
	Emp findEmpByName(String name);
	/**
	 * 添加用户
	 */
	boolean insertEmp(Emp employee);
	
	
	/**
	 * 添加员工
	 */
	boolean insertEmployee(Emp employee);
	
	/**
	 * 修改员工信息
	 */
	boolean modifyEmployee(Emp employee);
	
	/**
	 * 删除员工
	 */
	boolean deleteEmployee(Emp employee);
	/**
	 * 查询所有员工
	 * @return
	 */
	List<Emp> findEmp();
	/**
	 * 通过id查询员工
	 * @param parameter
	 * @return
	 */
	Emp findEmpById(String parameter);
	List<Emp> findById(String id);
	/**
	 * 查询删除的员工列表
	 * @return
	 */
	List<Emp> findDeleteEmp();
	/**
	 * 清空删除列表的员工信息
	 * @param emp
	 */
	
	void deleteEmployeeDelete(Emp emp);
	/**
	 * 根据ID查找删除列表的员工
	 * @param parameter
	 * @return
	 */
	Emp findEmpByIdDelete(String parameter);
	/**
	 * 把删除的员工信息从删除表恢复
	 * @param emp
	 */
	void insertEmpByDelete(Emp emp);
	/**
	 * 查询两个年龄间的员工信息
	 * @param age1
	 * @param age2
	 * @return
	 */
	List<Emp> findEmpByAge(String age1, String age2);
	/**
	 * 根据姓名年龄查询员工信息
	 * @param age1
	 * @param age2
	 * @param name
	 * @return
	 */
	List<Emp> findEmpByAgeAndName(String age1, String age2, String name);
	/**
	 * 根据姓名查询员工信息,返回列表
	 * @param name
	 * @return
	 */
	List<Emp> findByName(String name);
}
