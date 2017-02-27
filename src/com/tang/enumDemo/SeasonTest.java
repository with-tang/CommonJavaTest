package com.tang.enumDemo;

public class SeasonTest
{

	public SeasonTest(Season a)
	{
		System.out.println(a.getName()+" "+a.getDesc());
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new SeasonTest(Season.SPRING);		
	}

}
