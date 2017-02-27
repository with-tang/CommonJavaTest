package com.tang.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CompileClassLoader extends ClassLoader
{
	//��ȡ�ļ�
	private byte[] getByte(String fileName) throws IOException
	{
		File file=new File(fileName);
		long len=file.length();
		byte[] raw=new byte[(int)len];
		FileInputStream fin=new FileInputStream(file);
		int r=fin.read(raw);
		if(r!=len)throw new IOException("�޷���ȡ��ȫ���ļ�");
		fin.close();
		return raw;
		
	}
	//�������ָ��java�ļ��ķ���
	private boolean compile(String javaFile)throws IOException
	{
		System.out.println("CompileClassLoader:���ڱ���"+javaFile+"...");
		Process p=Runtime.getRuntime().exec("javac "+javaFile);
		try
		{
			p.waitFor();
		}
		catch(InterruptedException ie)
		{
			System.out.println(ie);
		}
		//get the value of javac thread
		int ret=p.exitValue();
		return ret==0;
		
	}
	//��дclassloader��findclass����
	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		Class clazz=null;
		String fileStub=name.replace(".", "/");
		String javaFileName=fileStub+".java";
		String classFileName=fileStub+".class";
		File javaFile=new File(javaFileName);
		File classFile=new File(classFileName);		
		if(javaFile.exists()&&(!classFile.exists()||
				javaFile.lastModified()>classFile.lastModified()))
		{
			try
			{
				if(!compile(javaFileName)||!classFile.exists())
				{
					throw new ClassNotFoundException("ClassNotFoundException:"+javaFileName);
				}
			}catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		if(clazz==null)
		{
			throw new ClassNotFoundException(name);
		}
		return clazz;
	}
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		// TODO Auto-generated method stub
		if(args.length<1)
		{
			System.out.println("ȱ������ʱ��Ŀ���࣬�밴���¸�ʽ����javaԴ�ļ���\n java CompileClassLoader ClassName");			
		}
		String progClass=args[0];
		String progArgs[]=new String[args.length-1];
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		CompileClassLoader ccl=new CompileClassLoader();
		Class<?> clazz=ccl.loadClass(progClass);
		Method main=clazz.getMethod("main",(new String[0]).getClass());
		Object argsArray[]={progArgs};
		main.invoke(null, argsArray);
	}

}
