package com.tang.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CompileClassLoader extends ClassLoader
{
	//读取文件
	private byte[] getByte(String fileName) throws IOException
	{
		File file=new File(fileName);
		long len=file.length();
		byte[] raw=new byte[(int)len];
		FileInputStream fin=new FileInputStream(file);
		int r=fin.read(raw);
		if(r!=len)throw new IOException("无法读取出全部文件");
		fin.close();
		return raw;
		
	}
	//定义编译指定java文件的方法
	private boolean compile(String javaFile)throws IOException
	{
		System.out.println("CompileClassLoader:正在编译"+javaFile+"...");
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
	//重写classloader的findclass方法
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
			System.out.println("缺少运行时的目标类，请按如下格式运行java源文件：\n java CompileClassLoader ClassName");			
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
