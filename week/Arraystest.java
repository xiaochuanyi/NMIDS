package week;

import java.util.Arrays;

public class Arraystest {

	public static void main(String[] args) {
		String a[]={"ab","d","ef"};
		int b[][]={{1,2},{2,3},{3,4}};
		System.out.println("��foreach�������Ϊ");
		for(String e:a){
			System.out.println(e);
		}//foreach����һά����
		System.out.println("��foreach������ά������Ϊ");
		for(int x[]:b){
			for(int m:x){
				System.out.println(m);
			}
		}//foreach������ά����
		String s=Arrays.toString(a);
		System.out.println("��toString�����������Ϊ");
		System.out.println(s);
		System.out.println("��foreach������ά������Ϊ");
		for(int i=0;i<b.length;i++){
			System.out.println(Arrays.toString(b[i]));
		}
		Arrays.fill(a,0,2,"ss");//��a[0]��a[2]��Ԫ���滻Ϊss������a[0]���ǲ�����a[2]
		System.out.println("��Arrays.fill�����滻����Ϊ");
		for(String e:a){
			System.out.println(e);
		}//�ٴ��������a�鿴�滻���
		for(int i=0;i<b.length;i++){
			Arrays.fill(b[i],0,2,3);//������b��ÿһ���������е�0��1��Ԫ���滻Ϊ3
		}
		System.out.println("��Arrays.fill�����滻��ά�������Ϊ");
		for(int x[]:b){
			for(int m:x){
				System.out.println(m);//�������b����滻
			}
		}
		String[] c=new String[3];
		c=(String[])a.clone();//��clone������������a
		System.out.println("clone a��c�õ��Ľ��Ϊ");
		for(String e:c){
			System.out.println(e);
		}//�ٴ�����鿴���ƽ��
		System.arraycopy(a,0,c,0,3);//������a���Ʋ���������c��
		System.out.println("��arraycopy��������a��c�õ��Ľ��Ϊ");
		for(String e:c){
			System.out.println(e);
		}//�ٴ�����鿴���ƽ��
		String o[]={"a","c","d"};
		int w=Arrays.binarySearch(o,"d");//��ѯd��w�����е�λ��
		System.out.println("��ѯ�Ľ��Ϊ"+w);
		int k[]={2,6,1,5};
		Arrays.sort(k);
		System.out.println("k�����Ľ��Ϊ");
		for(int i=0;i<k.length;i++){
			System.out.println(k[i]);
		}
	}
}
