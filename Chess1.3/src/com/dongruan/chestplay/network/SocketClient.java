package com.dongruan.chestplay.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**    扩展部分 还未加入
 * 每个程序都设置一个客户端和服务器来接收连接，请求连接
 * 局域网通过udp广播来获取局域网客户端的ip地址和端口
 * 然后通过socket客户端和服务器来建立连接通信
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
	      System.out.println("客户端成功连接服务器");
	      while (true) {
	        osw = new OutputStreamWriter(socket.getOutputStream());
	        bw = new BufferedWriter(osw);
	        System.out.print("客户端回复:");
	        str = in.nextLine();
	        if(str.equals("关闭")) {
	        	break;
	        }
	        bw.write(str + "\n");
	        bw.flush();
	        isr = new InputStreamReader(socket.getInputStream());
	        br = new BufferedReader(isr);
	        System.out.println(socket.getInetAddress() + ":" + br.readLine());
	      }
	      
	      socket.close();
	      System.out.println("客户端已关闭");
	      in.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
}

