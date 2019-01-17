package com.chinasoft.empsys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.empsys.entity.Emp;
import com.chinasoft.empsys.service.IEmpService;
import com.chinasoft.empsys.service.impl.EmpService;

/**
 * 用户信息显示servlet
 */
@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encoding");
		
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		
		
		if (session.getAttribute("emp")==null) {
			response.getWriter().write("请先进行登录后操作!3s后跳转到登录页面~");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/login.jsp");
			return;
		}else {
			IEmpService service=new EmpService();
			List<Emp> list = service.searchAll();
			request.setAttribute("listEmp", list);
			request.getRequestDispatcher("/emplist.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
