package week;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class GetRandom{
	public int random(){
		int a=(int)(Math.random()*100);
		return a;
	}//返回一个1到100的随机数字
}
class Game{
	public int m=0;
	 public int k=-1;
	public void A(){
		GetRandom ran=new GetRandom();
		Scanner a=new Scanner(System.in);
		int y=ran.random();//获得返回的随机值
		for(int i=1;i>0;i++){
			System.out.println("情输入你猜测的数字，目前猜测次数为"+m);
			m++;
			System.out.println(y);
			int b=a.nextInt();
			/*
			 * 判断输入数字的正确性，并反馈消息
			 */
			if(b==y){
				System.out.println("猜测正确，数字为"+b+"总共猜测次数为"+m);
				k++;
				Rank l=new Rank();
				l.rank(m,k);
				break;
			}
			else if(b>y){
			System.out.println("数字过大");
			continue;
		}
			else if(b<y){
			System.out.println("数字过小");
			continue; 
		}

		}
		
		
	}
}
class Inputjudge{
	public void B(){
		Game ga=new Game();
		/*输入一个数字用于判断用户是否需要开始或者结束游戏
		 * 
		 */
		for(int i=1;i>=0;i++){
			System.out.println("(重新开始)开始游戏请输入1，结束游戏输入2,查看排行榜输入3");
			Scanner a=new Scanner(System.in);
			int x=0;
			try{
				 x=a.nextInt();
			}catch(Exception e){
				System.out.println("error,别调皮,请按照提示输入数字");
			}
			if(x==1){
				ga.m=0;
				ga.A();
				continue;
			}
			else if(x==2){
				System.out.println("游戏结束");
				break;
			}
			else if(x==3){
				Rank l=new Rank();
				l.rank(ga.m,ga.k);
				l.outputranks();
			}
			else{
				System.out.println("输入错误，请重新输入");
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
			Arrays.sort(a);//当次数小于10的时候，将每一个次数放入排行榜并对其排序
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
					}//当次数大于10时，将这一次的次数和排行榜上最后一个比较，如果比最后一个小，将其替换并重新对排行榜排序

			}
		}}
	public void outputranks(){
		String s=Arrays.toString(a);
		System.out.println(s);//将数组转换位字符串输出
	}
}
public class week_2 {

	public static void main(String[] args) {
		Inputjudge input=new Inputjudge();
		input.B();
		

	}

}
