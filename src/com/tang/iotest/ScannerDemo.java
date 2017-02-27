package com.tang.iotest;

import java.util.Scanner;

public class ScannerDemo
{

	public static void main(String[] args)
	{
		
		// TODO Auto-generated method stub
		/*Scanner sc=new Scanner(System.in);
		//sc.useDelimiter("\n");
		
		while(sc.hasNext())
		{
			System.out.println("您输入的内容是："+sc.next());
		}
		*/
		testDel();
	}
	public static  void testDel()
	{
		String text1="i am a boy ,iam fd 223 45  21  high graduated student 34 5";
		Scanner sc=new Scanner(text1).useDelimiter("\\d\\s*");
		while(sc.hasNext())
		{
			System.out.println(sc.next());
		}
		sc.close();
	}

}
