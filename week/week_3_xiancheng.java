package week;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class week_3_xiancheng {

	public static void main(String[] args) {
		ExecutorService pool=Executors.newFixedThreadPool(2);//����һ����С�̶�Ϊ2���̳߳�
		A a=new A();//�����̳���Thread�Ķ���
		/*
		 * ѭ������4���̣߳��γ��߳������б�Ȼ���̳߳ػ���а���ȡ��ִ���̳߳ص����������̳߳ش�СΪ2�����4���̻߳����������ڵȴ����ȴ��̳߳��е��߳�ִ��
		 * ��ɲſ�ʼִ�С�
		 */
		for(int i=0;i<=3;i++){
			pool.execute(a);
			
		}
		pool.shutdown();//�ر��̳߳�
	}

}
class A implements Runnable{
	Object obj=new Object();//����һ��obj������ͬ�������̻߳�ô˶���ȥִ��ͬ�����������ݡ�
	private  int a=0;
	public  void  run(){	
		/*
		 * ͬ������飬��һ���߳�ִ��ʱ�����obj����Ȼ��ִ��ͬ�����������ݣ�ִ����Ϸſ�obj��������һ���̼߳���ִ�У�
		 */
		synchronized(obj){
			for(int i=0;i<=4;i++){
			try{
				Thread.sleep(100);
				}
			catch(Exception e){
				
			}	
		System.out.println(Thread.currentThread().getName()+"ִ�е�:"+ ++a+"��");
	}	
			System.out.println(Thread.currentThread().getName()+"ִ�����");
}
}}