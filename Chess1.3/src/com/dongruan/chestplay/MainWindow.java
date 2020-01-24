package com.dongruan.chestplay;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.dongruan.chestplay.listener.MyButtonsActionListener;


/**
 * detail  五子棋对战  
 * include 单人游戏 ，人机对战，局域网对战（待扩展）swing开发
 * @author Class 3 Group 2
 * @address 川师计算机科学学院
 * @version 1.0
 * @LastChangeDate 2019.12.26
 * 
 * 
 */

//程序的入口，请运行此界面
//主界面
public class MainWindow extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	public static final int W = 1180;
	public static final int H = 900;
	
	private JFrame frame;

	/**
	 * Launch the application.     程序的入口
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		
		frame=new JFrame("五子棋游戏中心");
		frame.setSize(1012,850);
		frame.setLocation(270,10);       //设置窗口位置
		setLayout(new FlowLayout());
		
		
		JLabel lable=new JLabel(new ImageIcon("src\\img\\chest.jpg"));
		lable.setBounds(0,0,1012,900);
		
		 ImageIcon button1 = new ImageIcon("src/img/单机游戏3.png");
		 ImageIcon button2 = new ImageIcon("src/img/人机游戏2.png");
		 ImageIcon button3 = new ImageIcon("src/img/局域网游戏2.png");
		 ImageIcon button4 = new ImageIcon("src/img/游戏说明2.png");
  
		frame.setLayout(null);
		JButton jb1 = new JButton("单机游戏", button1);
		jb1.addActionListener(this);
		jb1.setBounds(410,420,170,64);
		
		JButton jb2=new JButton("人机对战",button2);
		jb2.addActionListener(this);
		jb2.setBounds(410,500,168,63);
		
		JButton jb3=new JButton("局域网对战",button3);
		jb3.addActionListener(this);
		jb3.setBounds(410,580,170,63);
		
		JButton jb4=new JButton("游戏说明",button4);
		jb4.setBounds(410,660,170,64);
		
		MyButtonsActionListener buttons = new MyButtonsActionListener(this);
		frame.add(jb4);
		frame.add(jb3);
		frame.add(jb2);
		frame.add(jb1);
		frame.add(lable);
		frame.setVisible(true);
		jb1.addActionListener(buttons);
		jb2.addActionListener(buttons);
		jb3.addActionListener(buttons);
		jb4.addActionListener(buttons);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	public void dispose() {
		frame.dispose();
	}


}
