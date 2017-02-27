package com.tang.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		//��ȡϵͳ���������·��
		ClassLoader systemLoader=ClassLoader.getSystemClassLoader();
		System.out.println("ϵͳ���������"+systemLoader);
		Enumeration <URL> emr=systemLoader.getResources("");
		while(emr.hasMoreElements())
		{
			System.out.println(emr.nextElement());
		}
		//���ϵͳ��������ĸ�������--Ӧ������չ�������
		ClassLoader extensionLoader=systemLoader.getParent();
		System.out.println("��չ���������"+extensionLoader);
		System.out.println("extension class loader dir:"+System.getProperty("java.ext.dirs"));
		System.out.println("extension classloader's parent:"+extensionLoader.getParent());
		
	}

}
