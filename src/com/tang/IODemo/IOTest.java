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
		//�ڵ�����ֱ����A.txtΪԴ����
		FileOutputStream fileOutputStream =new FileOutputStream("A.txt");
		//����������fileOutputStreamΪ����Դ
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
		//������
		DataOutputStream out=new DataOutputStream(bufferedOutputStream);
		out.writeInt(4);
		out.writeBoolean(true);
		out.flush();
		out.close();
		
		//������������д������ݣ�4��true
		DataInputStream in=new DataInputStream(new BufferedInputStream(new FileInputStream("A.txt")));
		System.out.println(in.readInt());
		System.out.println(in.readBoolean());
		in.close();
		
	}

}
