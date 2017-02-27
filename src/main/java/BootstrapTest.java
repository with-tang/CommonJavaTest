package main.java;

import java.net.URL;

public class BootstrapTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		URL []url=sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for(int i=0;i<url.length;i++)
		{
			System.out.println(url[i].toExternalForm());
		}
	}
	

}
