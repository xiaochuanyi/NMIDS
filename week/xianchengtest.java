package week;
/*
 * һ����Ʊ�����������ͬ������飬����Ʊ��Ϊ�������������Ϊ��if���ʱ�������ʱʣ��һ��Ʊ���߳�1�ж�ticket��0�������if��䣬
 * ��ʱ�߳�1˯��100���룬�߳�2ҳ���е����ҳ�����ж�ticket����0��Ҳ���룬֮��ͻ���ֳ��ָ����������
 * ������ͬ������飬���߳�1����if�����߳�2�޷�ִ��ͬ������������ݣ��߳�1ִ�����
 * ��ticketС��0���߳�2�Ͳ���ִ��if�е���䣬�ͱ����˰�ȫ���⣬
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
		t3.start();//�����ĸ��̲߳���ʼִ��
		

	}

}
class Seail extends Thread{
	private static int ticket=100;
	Object obj=new Object();
	public void run(){
		/*
		 * ����ͬ������飬��֤����İ�ȫ��
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
		System.out.println(Thread.currentThread().getName()+"��Ʊʣ��"+ticket--);
		}
	}}
}
//}