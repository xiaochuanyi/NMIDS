package week;

import java.util.Scanner;

public class Stringlinktest {

	public static void main(String[] args) {
	 
	 String firststring;
	 String secondstring;
	 String laststring;//创建三个字符串，两个为自己输入，最后一个字符串=两个字符串连接
	 Scanner a=new Scanner(System.in);
	 System.out.println("输入firststring");
	 firststring=a.nextLine();
	 System.out.println("输入secondstring");
	 secondstring=a.nextLine();//输入字符串
	 a.close();
	 laststring=firststring+secondstring;//连接字符串
	 System.out.println("laststring="+laststring);//输出
	}

}
