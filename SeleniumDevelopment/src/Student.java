import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Student 
{
	int rollno;
	int id;
	int age;
	
	public Student(int rollno,int id,int age)
	{
		this.rollno=rollno;
		this.id=id;
		this.age=age;
	}

	
}

class Hash
{
	public static void main(String[] args)
	{
		HashMap<Integer,Student> sample=new HashMap<Integer,Student>();
		
	Student s1=new Student(2,3,4);
	Student s2=new Student(4,5,6);
	Student s3=new Student(7,8,9);
	sample.put(3, s1);
	sample.put(2, s2);
	sample.put(1, s3);
	Set<Integer> sort1=sample.keySet();
	
	//**System.out.println(sample.get(1));
	//for(Map.Entry<Integer,Student> entry:sample.entrySet())
	//{
		//int key=entry.getKey();
		//Student details=entry.getValue();
	//	System.out.println(key+":Student details "+details.rollno+" "+details.id+" "+details.age);
	//}
	
	for (Integer valuess : sort1)
	{
		System.out.println(valuess);
		
	}
	}
}