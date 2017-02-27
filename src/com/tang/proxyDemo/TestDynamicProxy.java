package com.tang.proxyDemo;

public class TestDynamicProxy
{
	public static void main(String[]args)
	{		
		DynamicProxy proxy=new DynamicProxy();
		IComponent component=(IComponent)proxy.bind(new Component());
		component.business1();
		component.business2();
		component.business3();
		
	}	
}
