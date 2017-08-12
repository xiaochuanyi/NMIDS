package TcpTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
class A implements Runnable{
	OutputStream out=null;
	Socket s=null;
	/*
	 * 将发送消息放在子线程中，并传入Socket对象参数
	 */
	public A(Socket s){	
		this.s=s;
		 try {
			out=this.s.getOutputStream();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	/*
	 * 将发送消息的代码放在run方法中，用线程去实现它
	 * 
	 */
	public void run(){	
		try {
			String str=null;
			 Scanner a=new Scanner(System.in);
			 while((str=a.nextLine())!=null){
	         out.write(str.getBytes());
			 }
		     s.shutdownOutput();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

public class Client{		
	public static void main(String[] args) {
		/*
		 * 将接受消息的代码放在主线程中，然后调用子线程，两个线程交替运行。
		 */
		  Socket s=null;
		  InputStream in=null;
		  Thread t=null;		   
		  try {
			  s=new Socket("127.0.0.1",7700);//创建一个socket对象，通过构造器指明服务端的ip地址及接受的端口号
			  t=new Thread(new A(s));		        	
	          t.start();
			  in=s.getInputStream();//接受服务端发送的消息			  
			  byte[] b=new byte[20];
		        int len;
		        while((len=in.read(b))!=-1){		        	
		        	String str=new String(b,0,len);//将数组传入字符串中
		        	System.out.println(str);//输出字符串
		        }
		} catch (Exception e) {	
			e.printStackTrace();

		}
}	
	}

