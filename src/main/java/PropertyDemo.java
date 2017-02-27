package main.java;

import java.util.Enumeration;
import java.util.Map;

public class PropertyDemo
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Map<Object,Object> map=System.getProperties();
		Enumeration<?> str=System.getProperties().propertyNames();
		getN();
		//System.out.println("0.001+0.002="+0.001+0.002);
		while(str.hasMoreElements())
		{
			System.out.println(str.nextElement());
		}
	
	}/*
	*1!+2!+3!+...n!<10000, get n=?
	*/
	public static void getN()
	{	int j=0;
		int n=1;
		int num=0;
		for(int i=1;num<10000;i++)
		{
			n*=i;
			num+=n;
			j=i;
		}
		System.out.println(j);
	}
	
}
