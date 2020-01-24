package com.dongruan.chestplay.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer extends Thread{
	public SocketServer() {
	
	}
	
	@Override
	public void run() {
		InputStreamReader isr;
	    BufferedReader br;
	    OutputStreamWriter osw;
	    BufferedWriter bw;
	    String str;
	    Scanner in = new Scanner(System.in);
	    try {
	      ServerSocket server = new ServerSocket(8080);
	      Socket socket = server.accept();
	      System.out.println(socket.getInetAddress());
	      System.out.println("建立了一个连接！");
	      
	      while (true) {
	        isr = new InputStreamReader(socket.getInputStream());
	        br = new BufferedReader(isr);
	        System.out.println(socket.getInetAddress() + ":" + br.readLine());
	        osw = new OutputStreamWriter(socket.getOutputStream());
	        bw = new BufferedWriter(osw);
	        System.out.print("服务端回复:");
	        str = in.nextLine();
	        if (str.equals("关闭")) {
				break;
			}
	        bw.write(str + "\n");
	        bw.flush();
	      }
	      server.close();
	      System.out.println("服务器已关闭");
	      
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    in.close();
	   
	}
	public static void main(String[] args) {
		//SocketClient socketClient = new SocketClient();
		SocketServer socketServer = new SocketServer();
		//socketClient.start();
		socketServer.start();
	}
}

