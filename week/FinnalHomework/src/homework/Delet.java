package homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ʵ����ɾ������
 */
public class Delet extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student stu=new Student();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		Connection conn=null;
		Statement statement=null;
		ResultSet rs=null;
		String studentid=request.getParameter("stdNumber");//�����Ҫɾ����ѧ��ѧ��
		stu.setStudentId(studentid);
		try {
			conn=JDBCTools.connection();//��ȡ���ݿ�����			 
			 statement=conn.createStatement();//��ȡStatement����
			 String sql="delete from student where StudentId="+stu.getStudentId()+"";//���sql���
			 statement.executeUpdate(sql);//����ɾ�����
			 out.write("ɾ���ɹ�");
			 out.write("<a href='http://localhost:8080/FinnalHomework/index.jsp'>���������ҳ��</a>");//��ʾɾ���ɹ����������ذ�ť
		} catch (Exception e) {
			System.out.println(e.getMessage());
			out.write("�������󣬸�ѧ����Ϣ�Ѿ�ɾ���򲻴���");
			out.write("<a href='http://localhost:8080/FinnalHomework/index.jsp'>���������ҳ��</a>");
		}finally{
			JDBCTools.release(statement, conn, rs);//�ر�����
		}
	}

	
	private PrintWriter write(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
