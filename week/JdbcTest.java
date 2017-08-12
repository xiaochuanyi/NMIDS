package week;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.Driver;
class Test{
	
	/*
	 * ����һ������������д��student�����ԣ����ҽ�д���Ķ�����addstudent������
	 */
	public Student getStudent(){
		Scanner scanner=new Scanner(System.in);
		Student student=new Student();
		System.out.println("name:");
		student.setname(scanner.next());
		System.out.println("id");
		student.setid(scanner.nextInt());
		System.out.println("grade");
		student.setgrade(scanner.nextInt());
		addstudent(student);
		return student;
	}
	/*
	 * ����insert������sql�����Ҫ���������ֵ���Լ��ӿ���̨д�롣
	 */
	private void addstudent(Student student){
		String sql="insert into cumstomers values ('"+student.getname()+"',"+student.getid()+","+student.getgrade()+")";
		update(sql);
	}
	/*
	 * ���ݿ���̨�����id�õ���ѯ���
	 */
	public void testgetstudent(){
		int search=getsearch();
		Student student=searchstudent(search);
		printstudent(student);
	}
	/*
	 * ���student
	 */
	private void printstudent(Student student) {		
		if(student!=null){
			System.out.println(student);
		}
		else
			System.out.println("���޴���");
	}
	/*
	 * 
	 */
	private Student searchstudent(int search) {
		String sql="select id,name,grade from cumstomers where id=1";
		Student student=getstudent(sql);	
		return student;
	}
	/*
	 * ���ݴ����sqlִ�в�ѯ
	 */
	public Student getstudent(String sql){
		Student stu=null;
        Connection connection=null;
        Statement statement=null;
		ResultSet rs=null;
		try {
			connection=JDBCTools.connection();
			statement=connection.createStatement();
			rs=statement.executeQuery(sql);			
			if(rs.next()){//��rs��Ϊ��ʱ������һ�����Բ�Ϊ�գ���������е����Բ�ָ����һ��					
				stu=new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("grade"));								
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			JDBCTools.release(statement, connection, rs);
		}
		return stu;
	}
	/*
	 * ����id ��ѯ��Ϣ
	 */
	private int getsearch() {
		System.out.println("����id��ѯ��Ϣ��");
		Scanner scanner=new Scanner(System.in);
		int search=scanner.nextInt();
		return search;
	}
	public void update(String sql){
		/*
		 * statement�����executeUpdate()�����мȿ��Դ��������䣬Ҳ���Դ���update����delete
		 */
		Connection conn=null;
		Statement statement=null;
		try {
			conn=JDBCTools.connection();//��ȡ���ݿ�����
			String sql1="update cumstomers set name='������� ' where id =4";//׼������sql���
			String sql2="delete from cumstomers where id=3";//׼��ɾ�����
		    statement=conn.createStatement();//��ȡStatement����
			statement.executeUpdate(sql);//����statement�����executeUpdate(sql)����ִ��sql������
			statement.executeUpdate(sql1);
			//statement.executeUpdate(sql2);
		} catch (Exception e) {			
			e.printStackTrace();
		} finally{
			if(statement!=null){
			try {				
				statement.close();//�ر�����
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				if(conn!=null){
			try {				
				conn.close();//�ر�����
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			}
		}
	}
}
		}
}

public class JdbcTest {

	public static void main(String[] args) throws Exception {
		Test test=new Test();			      
        test.getStudent();//���£�����������º�ɾ��
        test.testgetstudent();//��ѯ
	}

}
