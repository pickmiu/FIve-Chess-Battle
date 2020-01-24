package com.dongruan.chestplay.windows;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.dongruan.chestplay.listener.MyButtonsActionListener;

/**
 *         ��Ϸ���򴰿�
 * @author Class 3 Group 2
 *
 */
public class GameRuleWindow{
	
	private JFrame frame;
	
	public GameRuleWindow(){
		initialize();
		
	}	
	
	void initialize() {	
		
		frame=new JFrame("��������Ϸ��ս");
		frame.setBounds(400,100,1012,850);
		JLabel lable=new JLabel(new ImageIcon("src\\img\\����˵��.jpg"));
		lable.setBounds(0,0,1012,900);
		
		ImageIcon button = new ImageIcon("src\\img\\�������˵�.png");
		frame.setLayout(null);
		JButton jb=new JButton("�������˵�1",button);
		jb.setBounds(410,600,200,76);
		frame.setLocation(270,10);
		
		MyButtonsActionListener buttons = new MyButtonsActionListener(this);
		frame.add(jb);
		frame.add(lable);
		jb.addActionListener(buttons);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);

		
	}
	
	public void dispose() {
		frame.dispose();
	}
}
