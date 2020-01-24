package com.dongruan.chestplay.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.dongruan.chestplay.MainWindow;
import com.dongruan.chestplay.windows.AIBattleWindows;
import com.dongruan.chestplay.windows.GameRuleWindow;
import com.dongruan.chestplay.windows.PlayChessWindows;


/**
 *       ����ÿ����ť�ļ����¼�
 * @author Class 3 Group 2
 *
 */
public class MyButtonsActionListener implements ActionListener{
	public PlayChessWindows playChessWindows;
	public PlayChessWindows newwindows;
	public MainWindow mainForm;
	public MainWindow newmainform;
	public AIBattleWindows machineConfrontationWindows;
	public AIBattleWindows newmachineWindows;
	public GameRuleWindow gameRuleWindow;
	public GameRuleWindow newrulewindows;

	public MyButtonsActionListener(PlayChessWindows playChessWindows) {
		this.playChessWindows = playChessWindows;
	}
	
	public MyButtonsActionListener(MainWindow mainForm) {
		this.mainForm = mainForm;
	}
	
	public MyButtonsActionListener(AIBattleWindows machineConfrontationWindows) {
		this.machineConfrontationWindows = machineConfrontationWindows;
	}
	
	public MyButtonsActionListener(GameRuleWindow gameRuleWindow) {
		this.gameRuleWindow = gameRuleWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getActionCommand().equals("��������Ϸ1")) {
			try {
				newwindows = new PlayChessWindows();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			playChessWindows.dispose();
		}
		
		else if(e.getActionCommand().equals("��������Ϸ2")) {
			try {
				newmachineWindows = new AIBattleWindows();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			machineConfrontationWindows.dispose();
		}	
		
		else if(e.getActionCommand().equals("����1")) {
			if(!playChessWindows.isFlag()) {
				JOptionPane.showMessageDialog(playChessWindows.getFrame(), "����ʤ��", "��������",JOptionPane.WARNING_MESSAGE); 
			}else {
				JOptionPane.showMessageDialog(playChessWindows.getFrame(), "����ʤ��", "��������",JOptionPane.WARNING_MESSAGE); 
			}
			try {
				newwindows = new PlayChessWindows();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			playChessWindows.dispose();
		}
		
		else if(e.getActionCommand().equals("����2")) {
			JOptionPane.showMessageDialog(machineConfrontationWindows.getFrame(), "����ʤ��", "��������",JOptionPane.WARNING_MESSAGE); 
			try {
				newmachineWindows = new AIBattleWindows();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			machineConfrontationWindows.dispose();
		}
		
		else if(e.getActionCommand().equals("�������˵�1")){
			
			newmainform = new MainWindow();
			gameRuleWindow.dispose();
			
		}
		
		else if(e.getActionCommand().equals("�������˵�2")){
			newmainform = new MainWindow();
			playChessWindows.dispose();
		}
		
		else if(e.getActionCommand().equals("�������˵�3")){
			newmainform = new MainWindow();
			machineConfrontationWindows.dispose();
		}
		
		else if (e.getActionCommand().equals("������Ϸ")) {
			try {
				newwindows = new PlayChessWindows();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			mainForm.dispose();
		}
		
		else if (e.getActionCommand().equals("�˻���ս")) {
			try {
				newmachineWindows = new AIBattleWindows();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			mainForm.dispose();
		}
		
		else if (e.getActionCommand().equals("��Ϸ˵��")) {
			newrulewindows = new GameRuleWindow();
			mainForm.dispose();
		}
		
		else {
			System.out.println(11);
		}
	}

	
	
	
}
