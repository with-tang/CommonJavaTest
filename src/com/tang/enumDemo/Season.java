package com.tang.enumDemo;

public class Season
{
	private String name;
	private String desc;
	
	public Season(String name,String desc)
	{
		this.name=name;
		this.desc=desc;
	}
     final static Season SPRING=new Season("spring","green grass and red flower !");
	 final static Season SUMMER=new Season("summer","lotus and hot hot weather!");
	 final static Season AUTUMN=new Season("autumn","yellow ginkgo leaf and harvest!");
	 final static Season WINTER=new Season("winter","white snow and cold!");
	public Season getSeason(int num)
	{
		switch (num){
			case 1:return SPRING;
			case 2:return SUMMER;
			case 3:return AUTUMN;
			case 4:return WINTER;
			default:return null;
		}
	}
	public String getName()
	{
		return name;
	}
	public String getDesc()
	{
		return desc;
	}
}
	