package week;

public class week_3_duotai {
	public static void main(String args[]){
		Building a=new House();
		Building b=new Bridge();//����Ӧ�ø���Ķ����ʵ�����������󣬷��㽲��������õ����С�
		Function c=new Function();//ʵ������������ת�Ͷ�����Ǹ���
		c.Use(a);
		c.Use(b);//������ת�͵Ķ�������õ����С�
	}

}
abstract class Building{
	public abstract void height();
	public abstract void material();//����һ�������࣬ԭ��Ϊ���������������󷽷���һ���ǽ����߶�һ���ǽ����Ĳ���
}
/*
 * ���෿�ݣ��̳еĸ��࣬����д�˸���ĳ��󷽷���
 */
class House extends Building{
    public void height(){
    	System.out.println("���ݸ�20��");
    }
    public void material(){
    	System.out.println("�����û���������");
    }
}
/*
 * �����������̳и��ಢ��д�˸��෽��
 */
class Bridge extends Building{
	public void height(){
		System.out.println("������50��");
	}
	public void material(){
		System.out.println("�����øֽ��");
	}
	public void role(){
		System.out.println("����������������ͨ��");
	}
}
/*
 * ����һ�������ڽ�������ת�͵Ķ��󲢵����䷽��
 */
class Function{
	public void Use(Building a){
		a.height();
		a.material();//���ǳ�����������������������������ಢ�����Ե��ã����Ǵ�������ת�͵���������Ϳ��Ե���
	}
}