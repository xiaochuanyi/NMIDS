package week;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class week_3_xiancheng {

	public static void main(String[] args) {
		ExecutorService pool=Executors.newFixedThreadPool(2);//创建一个大小固定为2的线程池
		A a=new A();//创建继承了Thread的对象
		/*
		 * 循环放入4个线程，形成线程任务列表，然后线程池会从中挨个取出执行线程池的任务。由于线程池大小为2，因此4个线程会有两个处于等待，等待线程池中的线程执行
		 * 完成才开始执行、
		 */
		for(int i=0;i<=3;i++){
			pool.execute(a);
			
		}
		pool.shutdown();//关闭线程池
	}

}
class A implements Runnable{
	Object obj=new Object();//创建一个obj对象让同步代码线程获得此对象去执行同步代码块的内容。
	private  int a=0;
	public  void  run(){	
		/*
		 * 同步代码块，当一个线程执行时，获得obj锁，然后执行同步代码块的内容，执行完毕放开obj锁，由下一个线程继续执行，
		 */
		synchronized(obj){
			for(int i=0;i<=4;i++){
			try{
				Thread.sleep(100);
				}
			catch(Exception e){
				
			}	
		System.out.println(Thread.currentThread().getName()+"执行第:"+ ++a+"次");
	}	
			System.out.println(Thread.currentThread().getName()+"执行完毕");
}
}}