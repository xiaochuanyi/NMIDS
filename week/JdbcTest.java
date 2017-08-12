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
	 * 构造一个方法，用于写入student的属性，并且将写入后的对象传入addstudent方法中
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
	 * 调用insert方法，sql语句中要插入的属性值由自己从控制台写入。
	 */
	private void addstudent(Student student){
		String sql="insert into cumstomers values ('"+student.getname()+"',"+student.getid()+","+student.getgrade()+")";
		update(sql);
	}
	/*
	 * 根据控制台输入的id得到查询结果
	 */
	public void testgetstudent(){
		int search=getsearch();
		Student student=searchstudent(search);
		printstudent(student);
	}
	/*
	 * 输出student
	 */
	private void printstudent(Student student) {		
		if(student!=null){
			System.out.println(student);
		}
		else
			System.out.println("查无此人");
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
	 * 根据传入的sql执行查询
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
			if(rs.next()){//当rs不为空时，即下一个属性不为空，就输出此行的属性并指向下一行					
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
	 * 输入id 查询信息
	 */
	private int getsearch() {
		System.out.println("输入id查询信息：");
		Scanner scanner=new Scanner(System.in);
		int search=scanner.nextInt();
		return search;
	}
	public void update(String sql){
		/*
		 * statement对象的executeUpdate()方法中既可以传入插入语句，也可以传入update或者delete
		 */
		Connection conn=null;
		Statement statement=null;
		try {
			conn=JDBCTools.connection();//获取数据库连接
			String sql1="update cumstomers set name='更新语句 ' where id =4";//准备更新sql语句
			String sql2="delete from cumstomers where id=3";//准备删除语句
		    statement=conn.createStatement();//获取Statement对象
			statement.executeUpdate(sql);//调用statement对象的executeUpdate(sql)方法执行sql语句插入
			statement.executeUpdate(sql1);
			//statement.executeUpdate(sql2);
		} catch (Exception e) {			
			e.printStackTrace();
		} finally{
			if(statement!=null){
			try {				
				statement.close();//关闭连接
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				if(conn!=null){
			try {				
				conn.close();//关闭连接
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
        test.getStudent();//更新，包含插入更新和删除
        test.testgetstudent();//查询
	}

}
