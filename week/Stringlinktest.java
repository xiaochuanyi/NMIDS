package week;

import java.util.Scanner;

public class Stringlinktest {

	public static void main(String[] args) {
	 
	 String firststring;
	 String secondstring;
	 String laststring;//���������ַ���������Ϊ�Լ����룬���һ���ַ���=�����ַ�������
	 Scanner a=new Scanner(System.in);
	 System.out.println("����firststring");
	 firststring=a.nextLine();
	 System.out.println("����secondstring");
	 secondstring=a.nextLine();//�����ַ���
	 a.close();
	 laststring=firststring+secondstring;//�����ַ���
	 System.out.println("laststring="+laststring);//���
	}

}
