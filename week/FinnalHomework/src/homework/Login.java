package homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ʵ������֤�û����������Ƿ���ȷ�������ȷ����ת����ѯ���棬���������������
public class Login extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out=response.getWriter();
	String name=request.getParameter("uuid");
	String password=request.getParameter("passwd");//��ȡ����������ֺ�����
	if("xiaoyi".equals(name)&&"xcy199776".equals(password)){	//��֤���ֺ������Ƿ���ȷ	
		request.getRequestDispatcher("/index.jsp").forward(request, response);//��ȷ����ת����ѯ����
	}else{
		request.setAttribute("error","������û�����������������");//������ʾ��
		request.getRequestDispatcher("/login.jsp").forward(request,response);//��������û�������ʱ��ת����¼���棬����ʾ�ﴫ��
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
