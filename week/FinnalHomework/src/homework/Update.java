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

public class Update extends HttpServlet {
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
		String major=request.getParameter("major");		//获取输入的信息
		stu.setAge(Age);
		stu.setMajors(major);
		stu.setStudentId(StudentId);
		stu.setStudentname(name);
		try {
			conn=JDBCTools.connection();//获取数据库连接			 
			  statement=conn.createStatement();//获取Statement对象	
			  String sql="update student set StudentId="+stu.getStudentId()+",Age="+stu.getAge()+",Studentname='"+stu.getStudentname()+"',Majors='"+major+"' where StudentId="+stu.getStudentId()+"";
			  statement.executeUpdate(sql);	
			  out.write("修改成功");
			  out.write("<a href='http://localhost:8080/FinnalHomework/index.jsp'>点击返回</a>");
		} catch (Exception e) {
		System.out.println(e.getMessage());
		out.write("找不到需要修改的学生的学号或者输入有误");
		out.write("<a href='http://localhost:8080/FinnalHomework/index.jsp'>点击返回</a>");
		}finally{
			JDBCTools.release(statement, conn, rs);//关闭连接
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
