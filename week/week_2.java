package week;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class GetRandom{
	public int random(){
		int a=(int)(Math.random()*100);
		return a;
	}//����һ��1��100���������
}
class Game{
	public int m=0;
	 public int k=-1;
	public void A(){
		GetRandom ran=new GetRandom();
		Scanner a=new Scanner(System.in);
		int y=ran.random();//��÷��ص����ֵ
		for(int i=1;i>0;i++){
			System.out.println("��������²�����֣�Ŀǰ�²����Ϊ"+m);
			m++;
			System.out.println(y);
			int b=a.nextInt();
			/*
			 * �ж��������ֵ���ȷ�ԣ���������Ϣ
			 */
			if(b==y){
				System.out.println("�²���ȷ������Ϊ"+b+"�ܹ��²����Ϊ"+m);
				k++;
				Rank l=new Rank();
				l.rank(m,k);
				break;
			}
			else if(b>y){
			System.out.println("���ֹ���");
			continue;
		}
			else if(b<y){
			System.out.println("���ֹ�С");
			continue; 
		}

		}
		
		
	}
}
class Inputjudge{
	public void B(){
		Game ga=new Game();
		/*����һ�����������ж��û��Ƿ���Ҫ��ʼ���߽�����Ϸ
		 * 
		 */
		for(int i=1;i>=0;i++){
			System.out.println("(���¿�ʼ)��ʼ��Ϸ������1��������Ϸ����2,�鿴���а�����3");
			Scanner a=new Scanner(System.in);
			int x=0;
			try{
				 x=a.nextInt();
			}catch(Exception e){
				System.out.println("error,���Ƥ,�밴����ʾ��������");
			}
			if(x==1){
				ga.m=0;
				ga.A();
				continue;
			}
			else if(x==2){
				System.out.println("��Ϸ����");
				break;
			}
			else if(x==3){
				Rank l=new Rank();
				l.rank(ga.m,ga.k);
				l.outputranks();
			}
			else{
				System.out.println("�����������������");
				continue;
			}
		}
		
		
	}
}
class Rank{
	static public int[] a=new int[10];
	public void rank(int x,int y){
		if(y<=9){
			a[y]=x;
			Arrays.sort(a);//������С��10��ʱ�򣬽�ÿһ�������������а񲢶�������
		}
		else if(y>9){
			if(x<=a[9]){
				for(int i=0;i<a.length;i++){
					for(int j=0;j<a.length-i-1;i++){
					if(a[i]<a[i+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					}
					}
					}//����������10ʱ������һ�εĴ��������а������һ���Ƚϣ���������һ��С�������滻�����¶����а�����

			}
		}}
	public void outputranks(){
		String s=Arrays.toString(a);
		System.out.println(s);//������ת��λ�ַ������
	}
}
public class week_2 {

	public static void main(String[] args) {
		Inputjudge input=new Inputjudge();
		input.B();
		

	}

}
