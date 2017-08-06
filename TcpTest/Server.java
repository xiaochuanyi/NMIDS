package TcpTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
class B implements Runnable{
	 Socket s=null;
	 ServerSocket ss=null;	 
	 InputStream it=null;
	 /*
	  * 传入主线程中的参数，即Socket对象和ServerSocket对象
	  */
	 public B(Socket s, ServerSocket ss){
		 this.s=s;
		 this.ss=ss;
	 }
	 /*
	  * 将接受消息的代码放在run方法中，然后用一个线程去实现它。
	  * 
	  */
	 
    public void run(){
		 try {				    
		        it=s.getInputStream();//调用这个方法获取输入流	       	       	        
		        byte[] a=new byte[20];
		        int len;
		        while((len=it.read(a))!=-1){
		        	String str=new String(a,0,len);//将数组传入字符串中
		        	System.out.println(str);//输出字符串        	        	
		        }
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
}
}
public class Server{
	public static void main(String[] args) {
   	 ServerSocket ss=null;
   	 Socket s=null;	 
   	 Thread x=null;	  	
	 OutputStream out=null;
		try {
			ss=new ServerSocket(7700);//创建一个ServerSocket对象，指明自身端口号
	        s=ss.accept();//调用这个方法获取ocket对象
			x=new Thread(new B(s,ss));//创建线程对象，并传入参数
	        x.start();
	        /*
	         * 回复消息
	         */
			Scanner b=new Scanner(System.in);
            String str=null;
            out=s.getOutputStream();
			while((str=b.nextLine())!=null){
			out.write(str.getBytes());																				        	
	        }	              	       
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}