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
 * 实现了删除功能
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
		String studentid=request.getParameter("stdNumber");//获得需要删除的学生学号
		stu.setStudentId(studentid);
		try {
			conn=JDBCTools.connection();//获取数据库连接			 
			 statement=conn.createStatement();//获取Statement对象
			 String sql="delete from student where StudentId="+stu.getStudentId()+"";//获得sql语句
			 statement.executeUpdate(sql);//传入删除语句
			 out.write("删除成功");
			 out.write("<a href='http://localhost:8080/FinnalHomework/index.jsp'>点击返回主页面</a>");//提示删除成功，给出返回按钮
		} catch (Exception e) {
			System.out.println(e.getMessage());
			out.write("输入有误，该学生信息已经删除或不存在");
			out.write("<a href='http://localhost:8080/FinnalHomework/index.jsp'>点击返回主页面</a>");
		}finally{
			JDBCTools.release(statement, conn, rs);//关闭连接
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
