package week;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;



public class week_4_CollectiontTest {
public static void main(String[] args) {
ArrayList a=new ArrayList();	//�������϶���a
 a.add("nihao");
 a.add(1);
 a.add("˧��");//����������Ӳ�ͬ�Ķ���
for(Iterator a1=a.iterator();a1.hasNext();){
	System.out.println(a1.next());
}
LinkedList b=new LinkedList();
b.addFirst("hello");
b.addFirst("hellooooo");//���ײ����Ԫ�أ��ڶ��δ��ײ����ʱ����һ�����ɵڶ���
b.addLast(1);//��β�����Ԫ��
System.out.println(b);
System.out.println(b.removeFirst());//��ȡ�Ƴ���һ��);
System.out.println(b);
System.out.println(b.removeLast());//�Ƴ����һ��;
b.addFirst("hello");
b.addFirst("hellooooo");
b.addLast(1);
System.out.println(b.getLast());//��ȡ��һ������
System.out.println(b.getFirst());//��ȡ���һ������
for(Iterator b1=b.iterator();b1.hasNext();){//�������������ж�����Ϊa1.hasNext()�Ƿ�Ϊ�գ����¸������Ƿ�Ϊ�ա�
	System.out.println(b1.next());//��ȡ��һ�����϶���
}

}
}
