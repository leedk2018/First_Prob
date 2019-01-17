package com.chinasoft.empsys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.empsys.entity.Emp;
import com.chinasoft.empsys.service.IEmpService;
import com.chinasoft.empsys.service.impl.EmpService;

/**
 * 查询按钮功能
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encoding");
		
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		//参数
		String age1=request.getParameter("eage");
		String age2=request.getParameter("eage1");
		String id=request.getParameter("eid");  
		String  name=request.getParameter("ename");
		IEmpService service=new EmpService();
		if (!id.equals("")) {
			List<Emp> list= service.serachById(id);
			request.setAttribute("listEmp", list);
			request.getRequestDispatcher("/emplist.jsp").forward(request, response);
		}else {
			if (age1.equals("")||age2.equals("")) {
				if (name.equals("")) {
					List<Emp> list = service.searchAll();
					request.setAttribute("listEmp", list);
					request.getRequestDispatcher("/emplist.jsp").forward(request, response);
				}else {
					List<Emp> list=service.searchEmpByName(name);
					request.setAttribute("listEmp", list);
					request.getRequestDispatcher("/emplist.jsp").forward(request, response);
				}
			}else {
				if (name.equals("")) {
					List<Emp> list= service.searchEmpByAge(age1,age2);
					request.setAttribute("listEmp", list);
					request.getRequestDispatcher("/emplist.jsp").forward(request, response);
				}
				else {
					List<Emp>list =service.searchEmpByAgeAndName(age1,age2,name);
					request.setAttribute("listEmp", list);
					request.getRequestDispatcher("/emplist.jsp").forward(request, response);
				}
			}
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
