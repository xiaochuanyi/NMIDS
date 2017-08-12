package week;

public class week_3_duotai {
	public static void main(String args[]){
		Building a=new House();
		Building b=new Bridge();//子类应用父类的对象地实例化两个对象，方便讲对象传入调用的类中、
		Function c=new Function();//实例化调用向上转型对象的那个类
		c.Use(a);
		c.Use(b);//将向上转型的对象传入调用的类中。
	}

}
abstract class Building{
	public abstract void height();
	public abstract void material();//建立一个抽象父类，原型为建筑，有两个抽象方法，一个是建筑高度一个是建筑的材料
}
/*
 * 子类房屋，继承的父类，并重写了父类的抽象方法，
 */
class House extends Building{
    public void height(){
    	System.out.println("房屋高20米");
    }
    public void material(){
    	System.out.println("房屋用混泥土建造");
    }
}
/*
 * 子类桥梁，继承父类并重写了父类方法
 */
class Bridge extends Building{
	public void height(){
		System.out.println("桥梁高50米");
	}
	public void material(){
		System.out.println("桥梁用钢筋建造");
	}
	public void role(){
		System.out.println("桥梁的作用是用于通行");
	}
}
/*
 * 建立一个类用于接受向上转型的对象并调用其方法
 */
class Function{
	public void Use(Building a){
		a.height();
		a.material();//这是抽象类的两个方法，传入抽象类的子类并不可以调用，但是传入向上转型的两个子类就可以调用
	}
}