package week;

public class week_1 {

	public static void main(String[] args) {
	boolean a=false;
	int c=1,b=5;
	
     if(!a)
     {
    	 System.out.println(c<=b|c>b++);//用单个|或者&时，无论左边为true还是false，都会运行|右边的运算式，用两个||时，只有左边为false时，才会运行右边算式
    	 a=c>b&&c++<b;//用两个&时，左边为false，则不运行右边的算式，用单个&时，左边为false时也会运行右边算式
    	 System.out.println(a);//输出布尔变量a
    	 System.out.println(c);//输出c，此时c的值并未改变
    	 System.out.println(b);//输出b。此时b的值已经自加1
     }
     else
    	 System.out.println("...");

	switch(c*b){
	case 10 :
		System.out.println("hello world");
		break;
	case 15 :
		System.out.println("HELLO WORLD");//在c*b=15时，运行此条语句然后break。
		break;
	}

}
}
