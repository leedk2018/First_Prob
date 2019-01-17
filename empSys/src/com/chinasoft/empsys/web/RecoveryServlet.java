package com.chinasoft.empsys.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.empsys.service.IEmpService;
import com.chinasoft.empsys.service.impl.EmpService;

/**
 * Servlet implementation class RecoveryServlet
 */
@WebServlet("/RecoveryServlet")
public class RecoveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecoveryServlet() {
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
		String parameter = request.getParameter("id");
		IEmpService service=new EmpService();
		service.recoveryEmp(parameter);
		request.getRequestDispatcher("/ShowDeleteServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
