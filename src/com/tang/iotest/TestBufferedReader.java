package com.tang.iotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBufferedReader
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String bufferLine=null;
		while((bufferLine=br.readLine())!=null)
		{
			System.out.println(bufferLine);
		}
	}

}
