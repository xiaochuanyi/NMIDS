package homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ʵ�����ݵ���ӹ��ܡ�
 */
public class AddInformation extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student stu=new Student();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		Connection conn=null;
		Statement statement=null;
		ResultSet rs=null;
		String name=request.getParameter("name");
		String Age=request.getParameter("age");
		String StudentId=request.getParameter("stdNumber");
		String major=request.getParameter("major");		//��ȡ�������Ϣ
		stu.setAge(Age);
		stu.setMajors(major);
		stu.setStudentId(StudentId);
		stu.setStudentname(name);
		try {			
			 conn=JDBCTools.connection();//��ȡ���ݿ�����			 
			  statement=conn.createStatement();//��ȡStatement����					  
			  String sql="insert into student values ('"+stu.getStudentId()+"','"+stu.getStudentname()+"',"+stu.getAge()+",'"+stu.getMajors()+"')";		
			  statement.executeUpdate(sql);	
			  out.write("��ӳɹ�");
			  out.write("<a href='http://localhost:8080/FinnalHomework/index.jsp'>�������</a>");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			out.write("��ѧ���Ѿ����ڻ�������������������");
			 out.write("<a href='http://localhost:8080/FinnalHomework/index.jsp'>�������</a>");
		}finally{
			JDBCTools.release(statement, conn, rs);//�ر�����
		}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
