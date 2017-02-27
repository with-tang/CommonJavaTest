package main.java;

public class StaticTest
{
	static int i=50;
	void get()
	{
		System.out.println("this.i="+this.i);
		System.out.println("StaticTest.i="+StaticTest.i);
			
	}
	public static void main(String[] args)
	{
		StaticTest obj=null;
		new StaticTest().get();
		System.out.println(new StaticTest().i);
		System.out.println(obj.i);
	}
}
