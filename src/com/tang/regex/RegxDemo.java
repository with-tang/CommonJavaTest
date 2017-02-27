package com.tang.regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxDemo
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		//getMails();
		//showFileContent("RegxDemo.txt");
		getMails_net();
		
	}
	public static void getMails_net()throws Exception
	{
		URL url=new URL("https://www.baidu.com/");
		URLConnection conn=url.openConnection();
		BufferedReader bufr= new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line=null;
		String reg=null;		
		reg="Best";
		//reg="\\w+\\@\\w+(\\.\\w+)+";
		Pattern patt=Pattern.compile(reg);
		while ((line=bufr.readLine())!=null)
		{
			System.out.println(line);
			Matcher m=patt.matcher(line);
			while(m.find())
			{	
				System.out.println(m.group());
			}
		}
		bufr.close();
		
	}
	public static void getMails()throws Exception
	{
		BufferedReader bufr=new BufferedReader(new FileReader("RegxDemo.txt"));
		String line=null;
		String reg=null;
		//reg="\\w+\\@\\w+(\\.w+)+";
		reg="\\w+\\@\\w+(\\.\\w+)+";
		Pattern patt=Pattern.compile(reg);
		while ((line=bufr.readLine())!=null)
		{
			Matcher m=patt.matcher(line);
			while(m.find())
			{	
				System.out.println(m.group());
			}
		}
		bufr.close();
		
	}
	 public static void showFileContent(String string) throws Exception  
	    {  
	        BufferedReader br = new BufferedReader(new FileReader(string));  
	  
	        StringBuffer contentHolder = new StringBuffer();  
	  
	        String lineContent = null;  
	  
	        while ((lineContent = br.readLine()) != null)  
	        {  
	            contentHolder.append(lineContent+";");  
	        }  
	  
	        br.close();  
	        String ssss=contentHolder.toString();
	        System.out.println("content=");
	        String[] strs=ssss.split("\\;");
	        for(int i=0;i<strs.length;i++)
	        	System.out.println(strs[i]);
	       
	  
	    }  
}
