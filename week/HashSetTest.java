package week;

import java.util.HashSet;
import java.util.Iterator;

/*
 * 建立一个Oerson类创建对象用于存放如HashSet中
 */
 class Person{
	private String name;
	private int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getname(){
		return this.name;
	}
	public int getage(){
		return this.age;
	}
	/*
	 * 覆写的hashCode方法，会返回元素的hash值。当两个元素hash值相同时，会调用equals方法，不然不会调用、
	 * 
	 */
	public int hashCode(){
		return name.hashCode()+age;
	}
	public boolean equals(Object obj){
		if(!(obj instanceof Person))
			return false;
		Person p=(Person)obj;
		System.out.println(this.name+"equals"+p.name);
		return this.name.equals(p.name) && this.age==p.age;
	}
}
public class HashSetTest{
	/*
	 * 构建一个静态方法sop去输出传进的镀锡。
	 */
	public static void sop(Object obj){
	   System.out.println(obj);
	}
 public static void main(String[] args) {
	HashSet a=new HashSet();
	a.add(new Person("小米",11));
	a.add(new Person("小米",11));
	a.add(new Person("小红",12));
	a.add(new Person("小蓝",13));//建立HashSet集合对象，传入三个Person镀锡
for(Iterator it=a.iterator();it.hasNext();){
	Person p=(Person)it.next();//建立一个Person对象指向it.next，且把it.next强转为person型
	sop(p.getname()+p.getage());
}
}

}