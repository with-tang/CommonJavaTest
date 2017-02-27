package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class SystemDemo
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		File file=new File("systemProps.txt");
		FileWriter fw=new FileWriter(file,true);
		PrintWriter pw=new PrintWriter(fw);
		Map<Object, Object> props=System.getProperties();
		String str1="";
		System.out.println(System.getProperty("os.name"));
		for(Object prop:props.keySet())
		{
			String str=prop+":"+props.get(prop);
			str1+=str;
			System.out.println(str);
		}
		char []ccc=str1.toCharArray();
		for(char c:ccc)
		{
			pw.append(c);
		}
		pw.flush();
	}

}
