package com.tang.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		//获取系统类加载器的路径
		ClassLoader systemLoader=ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器："+systemLoader);
		Enumeration <URL> emr=systemLoader.getResources("");
		while(emr.hasMoreElements())
		{
			System.out.println(emr.nextElement());
		}
		//获得系统类加载器的父加载器--应该是扩展类加载器
		ClassLoader extensionLoader=systemLoader.getParent();
		System.out.println("扩展类加载器："+extensionLoader);
		System.out.println("extension class loader dir:"+System.getProperty("java.ext.dirs"));
		System.out.println("extension classloader's parent:"+extensionLoader.getParent());
		
	}

}
