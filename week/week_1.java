package week;

public class week_1 {

	public static void main(String[] args) {
	boolean a=false;
	int c=1,b=5;
	
     if(!a)
     {
    	 System.out.println(c<=b|c>b++);//�õ���|����&ʱ���������Ϊtrue����false����������|�ұߵ�����ʽ��������||ʱ��ֻ�����Ϊfalseʱ���Ż������ұ���ʽ
    	 a=c>b&&c++<b;//������&ʱ�����Ϊfalse���������ұߵ���ʽ���õ���&ʱ�����ΪfalseʱҲ�������ұ���ʽ
    	 System.out.println(a);//�����������a
    	 System.out.println(c);//���c����ʱc��ֵ��δ�ı�
    	 System.out.println(b);//���b����ʱb��ֵ�Ѿ��Լ�1
     }
     else
    	 System.out.println("...");

	switch(c*b){
	case 10 :
		System.out.println("hello world");
		break;
	case 15 :
		System.out.println("HELLO WORLD");//��c*b=15ʱ�����д������Ȼ��break��
		break;
	}

}
}
