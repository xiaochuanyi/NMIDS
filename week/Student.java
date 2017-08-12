package week;
/*
 * student类，属性为数据库表中的属性，有set和get方法
 */
public class Student {
private int id;
private String name;
private int grade;
public Student(){
	
}
public Student(int id,String name,int grade){
	super();
	this.id=id;
	this.name=name;
	this.grade=grade;
}
public void setid(int id){

	this.id=id;
}
public int getid(){
	return this.id;
}
public void setname(String name){
	this.name=name;
}
public String getname(){
	return this.name;
}
public void setgrade(int grade){

	this.grade=grade;
}
public int getgrade(){
	return this.grade;
}
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", grade=" + grade + "]";
}

}
