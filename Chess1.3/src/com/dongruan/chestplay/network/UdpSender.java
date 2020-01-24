package com.dongruan.chestplay.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpSender extends Thread{
	InetAddress address;
	
	@Override
	public void run() {
		try {     
			String data = "你好";            
			boolean flag = true;       
			
			DatagramSocket socket = new DatagramSocket();
			
			Scanner scanner = new Scanner(System.in);
			String line;
			
			while(flag) {
				
				line = scanner.nextLine();
				if("手动关闭".equals(line)) {
					flag=false;
				}
				
				DatagramPacket packet = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getByName("255.255.255.255"), 8081); 
				socket.send(packet);
				System.out.println(InetAddress.getLocalHost().getHostAddress().toString()+"   发送了  "+data+"  到  "+"255.255.255.255");
			}
			
			System.out.println(InetAddress.getLocalHost().getHostAddress().toString() + " udpSender已关闭");
			socket.close();
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
