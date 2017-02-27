package com.tang.proxyDemo;

public class Component implements IComponent
{

	@Override
	public void business1()
	{
		// TODO Auto-generated method stub
		System.out.println("业务1.。。");
	}

	@Override
	public void business2()
	{
		System.out.println("业务2.。。");
		// TODO Auto-generated method stub

	}

	@Override
	public void business3()
	{
		System.out.println("业务3.。。");
		// TODO Auto-generated method stub

	}

}
