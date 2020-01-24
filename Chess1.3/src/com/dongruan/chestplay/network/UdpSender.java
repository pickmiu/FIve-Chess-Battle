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
			String data = "���";            
			boolean flag = true;       
			
			DatagramSocket socket = new DatagramSocket();
			
			Scanner scanner = new Scanner(System.in);
			String line;
			
			while(flag) {
				
				line = scanner.nextLine();
				if("�ֶ��ر�".equals(line)) {
					flag=false;
				}
				
				DatagramPacket packet = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getByName("255.255.255.255"), 8081); 
				socket.send(packet);
				System.out.println(InetAddress.getLocalHost().getHostAddress().toString()+"   ������  "+data+"  ��  "+"255.255.255.255");
			}
			
			System.out.println(InetAddress.getLocalHost().getHostAddress().toString() + " udpSender�ѹر�");
			socket.close();
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
