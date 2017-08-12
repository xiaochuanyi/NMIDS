package week;
/*
 * 一个售票程序，如果不加同步代码块，出现票数为负数的情况。因为在if语句时，如果此时剩余一张票，线程1判断ticket》0，则进入if语句，
 * 此时线程1睡眠100毫秒，线程2页运行到这里，页可以判断ticket大于0，也进入，之后就会出现出现负数的情况。
 * 而加入同步代码块，在线程1进入if语句后，线程2无法执行同步代码块中内容，线程1执行完毕
 * 则ticket小于0，线程2就不会执行if中的语句，就避免了安全问题，
 */

public class xianchengtest {

	public static void main(String[] args) {
		Seail t1=new Seail();
		Seail t2=new Seail();
		Seail t3=new Seail();
		Seail t4=new Seail();
		t1.start();
		t4.start();
		t2.start();
		t3.start();//创建四个线程并开始执行
		

	}

}
class Seail extends Thread{
	private static int ticket=100;
	Object obj=new Object();
	public void run(){
		/*
		 * 加入同步代码块，保证程序的安全性
		 */
		while(true){
			//synchronized(obj){
		if(ticket>0){
			try{
				sleep(100);
			}
			catch(Exception e)
			{
				
		}
		System.out.println(Thread.currentThread().getName()+"售票剩下"+ticket--);
		}
	}}
}
//}