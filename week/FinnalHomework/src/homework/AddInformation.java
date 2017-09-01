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
 * 实现数据的添加功能。
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
		String major=request.getParameter("major");		//获取输入的信息
		stu.setAge(Age);
		stu.setMajors(major);
		stu.setStudentId(StudentId);
		stu.setStudentname(name);
		try {			
			 conn=JDBCTools.connection();//获取数据库连接			 
			  statement=conn.createStatement();//获取Statement对象					  
			  String sql="insert into student values ('"+stu.getStudentId()+"','"+stu.getStudentname()+"',"+stu.getAge()+",'"+stu.getMajors()+"')";		
			  statement.executeUpdate(sql);	
			  out.write("添加成功");
			  out.write("<a href='http://localhost:8080/FinnalHomework/index.jsp'>点击返回</a>");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			out.write("该学生已经存在或输入有误，请重新输入");
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
