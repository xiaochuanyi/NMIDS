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
	  * �������߳��еĲ�������Socket�����ServerSocket����
	  */
	 public B(Socket s, ServerSocket ss){
		 this.s=s;
		 this.ss=ss;
	 }
	 /*
	  * ��������Ϣ�Ĵ������run�����У�Ȼ����һ���߳�ȥʵ������
	  * 
	  */
	 
    public void run(){
		 try {				    
		        it=s.getInputStream();//�������������ȡ������	       	       	        
		        byte[] a=new byte[20];
		        int len;
		        while((len=it.read(a))!=-1){
		        	String str=new String(a,0,len);//�����鴫���ַ�����
		        	System.out.println(str);//����ַ���        	        	
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
			ss=new ServerSocket(7700);//����һ��ServerSocket����ָ������˿ں�
	        s=ss.accept();//�������������ȡocket����
			x=new Thread(new B(s,ss));//�����̶߳��󣬲��������
	        x.start();
	        /*
	         * �ظ���Ϣ
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