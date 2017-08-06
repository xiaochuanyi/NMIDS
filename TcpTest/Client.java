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
	 * ��������Ϣ�������߳��У�������Socket�������
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
	 * ��������Ϣ�Ĵ������run�����У����߳�ȥʵ����
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
		 * ��������Ϣ�Ĵ���������߳��У�Ȼ��������̣߳������߳̽������С�
		 */
		  Socket s=null;
		  InputStream in=null;
		  Thread t=null;		   
		  try {
			  s=new Socket("127.0.0.1",7700);//����һ��socket����ͨ��������ָ������˵�ip��ַ�����ܵĶ˿ں�
			  t=new Thread(new A(s));		        	
	          t.start();
			  in=s.getInputStream();//���ܷ���˷��͵���Ϣ			  
			  byte[] b=new byte[20];
		        int len;
		        while((len=in.read(b))!=-1){		        	
		        	String str=new String(b,0,len);//�����鴫���ַ�����
		        	System.out.println(str);//����ַ���
		        }
		} catch (Exception e) {	
			e.printStackTrace();

		}
}	
	}

