package com.tang.proxyDemo;

public class TestStaticProxy
{
	public static void main(String[] args)
	{
		IComponent proxy=new ProxyComponent(new Component());
		proxy.business1();
		proxy.business2();
		proxy.business3();
	}
}
