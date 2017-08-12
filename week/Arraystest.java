package week;

import java.util.Arrays;

public class Arraystest {

	public static void main(String[] args) {
		String a[]={"ab","d","ef"};
		int b[][]={{1,2},{2,3},{3,4}};
		System.out.println("用foreach遍历结果为");
		for(String e:a){
			System.out.println(e);
		}//foreach遍历一维数组
		System.out.println("用foreach遍历二维数组结果为");
		for(int x[]:b){
			for(int m:x){
				System.out.println(m);
			}
		}//foreach遍历二维数组
		String s=Arrays.toString(a);
		System.out.println("用toString方法遍历结果为");
		System.out.println(s);
		System.out.println("用foreach遍历二维数组结果为");
		for(int i=0;i<b.length;i++){
			System.out.println(Arrays.toString(b[i]));
		}
		Arrays.fill(a,0,2,"ss");//将a[0]到a[2]的元素替换为ss，包括a[0]但是不包括a[2]
		System.out.println("用Arrays.fill方法替换后结果为");
		for(String e:a){
			System.out.println(e);
		}//再次输出数组a查看替换结果
		for(int i=0;i<b.length;i++){
			Arrays.fill(b[i],0,2,3);//将数组b的每一个子数组中的0到1的元素替换为3
		}
		System.out.println("用Arrays.fill方法替换二维数组后结果为");
		for(int x[]:b){
			for(int m:x){
				System.out.println(m);//输出数组b检查替换
			}
		}
		String[] c=new String[3];
		c=(String[])a.clone();//用clone方法复制数组a
		System.out.println("clone a到c得到的结果为");
		for(String e:c){
			System.out.println(e);
		}//再次输出查看复制结果
		System.arraycopy(a,0,c,0,3);//把数组a复制并放入数组c中
		System.out.println("用arraycopy方法复制a到c得到的结果为");
		for(String e:c){
			System.out.println(e);
		}//再次输出查看复制结果
		String o[]={"a","c","d"};
		int w=Arrays.binarySearch(o,"d");//查询d在w数组中的位置
		System.out.println("查询的结果为"+w);
		int k[]={2,6,1,5};
		Arrays.sort(k);
		System.out.println("k排序后的结果为");
		for(int i=0;i<k.length;i++){
			System.out.println(k[i]);
		}
	}
}
