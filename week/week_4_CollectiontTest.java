package week;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;



public class week_4_CollectiontTest {
public static void main(String[] args) {
ArrayList a=new ArrayList();	//建立集合对象a
 a.add("nihao");
 a.add(1);
 a.add("帅哥");//往集合中添加不同的对象
for(Iterator a1=a.iterator();a1.hasNext();){
	System.out.println(a1.next());
}
LinkedList b=new LinkedList();
b.addFirst("hello");
b.addFirst("hellooooo");//从首部添加元素，第二次从首部添加时，第一个会变成第二个
b.addLast(1);//从尾部添加元素
System.out.println(b);
System.out.println(b.removeFirst());//获取移除第一个);
System.out.println(b);
System.out.println(b.removeLast());//移除最后一个;
b.addFirst("hello");
b.addFirst("hellooooo");
b.addLast(1);
System.out.println(b.getLast());//获取第一个对象
System.out.println(b.getFirst());//获取最后一个对象
for(Iterator b1=b.iterator();b1.hasNext();){//建立迭代器，判断条件为a1.hasNext()是否为空，即下个对象是否为空。
	System.out.println(b1.next());//获取下一个集合对象
}

}
}
