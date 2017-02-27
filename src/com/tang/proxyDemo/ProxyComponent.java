package com.tang.proxyDemo;

public class ProxyComponent implements IComponent
{

	private IComponent component;
	public ProxyComponent(IComponent component)
	{
		this.component=component;
	}
	public  void validateUser()
	{		
		System.out.println("用户验证服务！");
	}
	
	@Override
	public void business1()
	{
		validateUser();
		component.business1();// TODO Auto-generated method stub

	}

	@Override
	public void business2()
	{
		// TODO Auto-generated method stub
		validateUser();
		component.business2();
	}

	@Override
	public void business3()
	{
		// TODO Auto-generated method stub
		validateUser();
		component.business3();
	}

}
