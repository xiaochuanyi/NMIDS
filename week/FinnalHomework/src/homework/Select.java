package homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Select extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student stu=null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Connection conn=null;
		Statement statement=null;
		ResultSet rs=null;		
		String name=request.getParameter("name");
		String StudentId=request.getParameter("stdNumber");	//获得输入的名字或者学号	
		String sql=null;		
		try {
			conn=JDBCTools.connection();
			statement=conn.createStatement();									
			sql="select * from student where StudentId='"+StudentId+"'or Studentname='"+name+"'";//动态的写入sql语句	
			rs=statement.executeQuery(sql);//执行sql语句
			if(rs.next()){										
					stu=new Student(rs.getString("Studentname"),rs.getString("StudentId"),rs.getString("Age"),rs.getString("Majors"));//将查询到的结果放入student类中				
					String num="";					
					if(num!=StudentId&&!(rs.getString("StudentId").equals(StudentId))){	//当姓名和学号不匹配是提示消息		
						request.setAttribute("error1", "姓名和学号不匹配,优先显示学号在前的");
					}
					String name1="";
					if(name1!=name&&!(rs.getString("Studentname").equals(name))){//当姓名和学号不匹配是提示消息
						request.setAttribute("error1", "姓名和学号不匹配，优先显示学号在前的");
					}
			}			
			request.setAttribute("stu",stu );//将student类的对象传入	，有jsp获得并将其写入页面
			if(stu==null){
				request.setAttribute("error", "请输入正确的学号或者姓名");//未查询到结果时，提示重新输入
			}		
			request.getRequestDispatcher("/index.jsp").forward(request,response);//跳转到查询界面			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			JDBCTools.release(statement, conn, rs);	//关闭连接
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
