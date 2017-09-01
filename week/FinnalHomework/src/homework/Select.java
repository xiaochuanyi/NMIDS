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
		String StudentId=request.getParameter("stdNumber");	//�����������ֻ���ѧ��	
		String sql=null;		
		try {
			conn=JDBCTools.connection();
			statement=conn.createStatement();									
			sql="select * from student where StudentId='"+StudentId+"'or Studentname='"+name+"'";//��̬��д��sql���	
			rs=statement.executeQuery(sql);//ִ��sql���
			if(rs.next()){										
					stu=new Student(rs.getString("Studentname"),rs.getString("StudentId"),rs.getString("Age"),rs.getString("Majors"));//����ѯ���Ľ������student����				
					String num="";					
					if(num!=StudentId&&!(rs.getString("StudentId").equals(StudentId))){	//��������ѧ�Ų�ƥ������ʾ��Ϣ		
						request.setAttribute("error1", "������ѧ�Ų�ƥ��,������ʾѧ����ǰ��");
					}
					String name1="";
					if(name1!=name&&!(rs.getString("Studentname").equals(name))){//��������ѧ�Ų�ƥ������ʾ��Ϣ
						request.setAttribute("error1", "������ѧ�Ų�ƥ�䣬������ʾѧ����ǰ��");
					}
			}			
			request.setAttribute("stu",stu );//��student��Ķ�����	����jsp��ò�����д��ҳ��
			if(stu==null){
				request.setAttribute("error", "��������ȷ��ѧ�Ż�������");//δ��ѯ�����ʱ����ʾ��������
			}		
			request.getRequestDispatcher("/index.jsp").forward(request,response);//��ת����ѯ����			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			JDBCTools.release(statement, conn, rs);	//�ر�����
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
