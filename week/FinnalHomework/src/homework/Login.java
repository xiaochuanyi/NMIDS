package homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//实现了验证用户名和密码是否正确，如果正确，跳转到查询界面，如果错误，重新输入
public class Login extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out=response.getWriter();
	String name=request.getParameter("uuid");
	String password=request.getParameter("passwd");//获取到输入的名字和密码
	if("xiaoyi".equals(name)&&"xcy199776".equals(password)){	//验证名字和密码是否正确	
		request.getRequestDispatcher("/index.jsp").forward(request, response);//正确则跳转到查询界面
	}else{
		request.setAttribute("error","密码或用户名错误，请重新输入");//传入提示语
		request.getRequestDispatcher("/login.jsp").forward(request,response);//密码或者用户名错误时跳转到登录界面，将提示语传入
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
