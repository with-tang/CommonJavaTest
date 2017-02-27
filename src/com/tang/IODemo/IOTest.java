package com.tang.IODemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest
{
	public static void main(String[] args)throws IOException
	{
		//节点流，直接以A.txt为源数据
		FileOutputStream fileOutputStream =new FileOutputStream("A.txt");
		//处理流，以fileOutputStream为数据源
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
		//过滤流
		DataOutputStream out=new DataOutputStream(bufferedOutputStream);
		out.writeInt(4);
		out.writeBoolean(true);
		out.flush();
		out.close();
		
		//用输出流来输出写入的数据，4，true
		DataInputStream in=new DataInputStream(new BufferedInputStream(new FileInputStream("A.txt")));
		System.out.println(in.readInt());
		System.out.println(in.readBoolean());
		in.close();
		
	}

}
