package com.chinasoft.empsys.service;
/**
 *服务接口
 */

import java.util.List;

import com.chinasoft.empsys.entity.Emp;

public interface IEmpService {
	/**
	 * 登录方法
	 * @param name
	 * @param password
	 * @return
	 */
	Emp login(String name, String password);

	int register(Emp emp);
	
	List<Emp> searchAll();

	void deleteEmp(String parameter);
	/**
	 * 查看删除员工列表
	 * @return
	 */
	List<Emp> searchDeleteAll();
	/**
	 * 清空删除员工
	 * @param parameter
	 */
	void clearEmp(String parameter);
	/**
	 * 将删除的员工信息恢复
	 * @param parameter
	 */
	void recoveryEmp(String parameter);
	/**
	 * 根据员工id查询员工信息
	 * @param parameter
	 * @return
	 */
	Emp searchEmpById(String parameter);

	/**
	 * 修改员工信息
	 * @param emp
	 * @return
	 */
	int modifyEmp(Emp emp);
	/**
	 * 根据信息查询员工信息
	 * @param id
	 * @param name
	 * @param age1
	 * @param age2
	 * @return
	 */
	/**
	 * 根据id查询员工信息
	 * @param id
	 * @return
	 */

	List<Emp> serachById(String id);
	/**
	 * 根据姓名查询员工信息
	 * @param name
	 * @return
	 */
	List<Emp> searchEmpByName(String name);
	/**
	 * 根据年龄查询员工信息
	 * @param age1
	 * @param age2
	 * @return
	 */
	List<Emp> searchEmpByAge(String age1, String age2);

	/**
	 * 根据员工姓名和年龄查询员工信息
	 * @param age1
	 * @param age2
	 * @param name
	 * @return
	 */
	List<Emp> searchEmpByAgeAndName(String age1, String age2, String name);
}
