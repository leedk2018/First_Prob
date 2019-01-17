package com.chinasoft.empsys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.empsys.entity.Emp;
import com.chinasoft.empsys.service.IEmpService;
import com.chinasoft.empsys.service.impl.EmpService;

/**
 * 登录servlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		IEmpService service=new EmpService();
		Emp emp = service.login(name,password);
		if (emp!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("emp", emp);
			//获取上次登录时间
			SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
			String date = sFormat.format(new Date());
			Cookie[] cookies = request.getCookies();
			if (cookies==null) {
				Cookie cookie=new Cookie("lastTime", date);
				cookie.setPath("/");
				cookie.setMaxAge(60*60*24*365);
				session.setAttribute("lastTime", date);
				response.addCookie(cookie);
			}else {
				Cookie c=null;
				for (Cookie cookie : cookies) {
					if ("lastTime".equals(cookie.getName())) {
						c=cookie;
					}
				}
				if (c!=null) {
					session.setAttribute("lastTime", c.getValue());
					c.setPath("/");
					c.setMaxAge(60*60*24*365);
					c.setValue(date);
					response.addCookie(c);
				}else {
					c=new Cookie("lastTime", date);
					c.setPath("/");
					c.setMaxAge(60*60*24*365);
					session.setAttribute("lastTime", date);
					response.addCookie(c);
				}
			}
			response.getWriter().write("登录成功,3后跳转到主页");
			response.setHeader("refresh", "3;url="+request.getContextPath()+"/index.jsp");
			return;
		}else {
			request.setAttribute("error_msg", "账号或密码有误, 请检查后登录");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
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
