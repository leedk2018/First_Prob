package com.chinasoft.empsys.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.chinasoft.empsys.entity.Emp;
import com.chinasoft.empsys.service.IEmpService;
import com.chinasoft.empsys.service.impl.EmpService;

/**
 * 注册servlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encoding");
		
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		Map<String, String[]> map = request.getParameterMap();
		
		Emp emp=new Emp();
		SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd");
		String date = sFormat.format(new Date());
		emp.setHiredate(java.sql.Date.valueOf(date));
		emp.setSalary(4500.0);
		try {
			BeanUtils.populate(emp, map);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		IEmpService service= new EmpService();
		int i = service.register(emp);
		switch (i) {
		case -1:
			request.setAttribute("erro_msg", "该用户已存在");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		case 0:
			request.setAttribute("erro_msg", "注册失败,稍后再试!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		case 1:
			response.getWriter().write("注册成功,3后跳转到登录页面");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/login.jsp");
			return;
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
