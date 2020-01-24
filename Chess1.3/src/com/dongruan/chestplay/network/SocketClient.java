package com.dongruan.chestplay.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**    ��չ���� ��δ����
 * ÿ����������һ���ͻ��˺ͷ��������������ӣ���������
 * ������ͨ��udp�㲥����ȡ�������ͻ��˵�ip��ַ�Ͷ˿�
 * Ȼ��ͨ��socket�ͻ��˺ͷ���������������ͨ��
 * @author Class 3 Group 2 
 *
 */

public class SocketClient extends Thread{	
		
	@Override
	public void run() {
		InputStreamReader isr;
	    BufferedReader br;
	    OutputStreamWriter osw;
	    BufferedWriter bw;
	    String str;
	    Scanner in = new Scanner(System.in);
	    try {
	      Socket socket = new Socket("localhost", 8080);
	      System.out.println("�ͻ��˳ɹ����ӷ�����");
	      while (true) {
	        osw = new OutputStreamWriter(socket.getOutputStream());
	        bw = new BufferedWriter(osw);
	        System.out.print("�ͻ��˻ظ�:");
	        str = in.nextLine();
	        if(str.equals("�ر�")) {
	        	break;
	        }
	        bw.write(str + "\n");
	        bw.flush();
	        isr = new InputStreamReader(socket.getInputStream());
	        br = new BufferedReader(isr);
	        System.out.println(socket.getInetAddress() + ":" + br.readLine());
	      }
	      
	      socket.close();
	      System.out.println("�ͻ����ѹر�");
	      in.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
}

