package com.dongruan.chestplay.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UdpReceiver extends Thread{
	
	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(8081);
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
			
			while(true) {
				socket.receive(packet);
				byte[] arr = packet.getData();                      //��ȡ����
				int len = packet.getLength();                       //��ȡ��Ч���ֽڸ���
			    String sourceIP = packet.getAddress().getHostAddress();
			    
			    System.out.println("sourcIP  "+sourceIP);
			    System.out.println("����IP    "+InetAddress.getLocalHost().getHostAddress().toString());

			    int port = packet.getPort();
			    System.out.println(InetAddress.getLocalHost().getHostAddress().toString()+"   �յ���   "+sourceIP + ":" + port + ":" + "  ���͵�    "+ new String(arr,0,len));
			    if(new String(arr,0,3).equals("000")) {
			    	System.out.println(InetAddress.getLocalHost().getHostAddress() + "   udpReceiver �ѹر�");
			    	break;
			    }
			}
			
			socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		
	}
}