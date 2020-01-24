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
 *       设置每个按钮的监听事件
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
		
		if(e.getActionCommand().equals("开启新游戏1")) {
			try {
				newwindows = new PlayChessWindows();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			playChessWindows.dispose();
		}
		
		else if(e.getActionCommand().equals("开启新游戏2")) {
			try {
				newmachineWindows = new AIBattleWindows();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			machineConfrontationWindows.dispose();
		}	
		
		else if(e.getActionCommand().equals("认输1")) {
			if(!playChessWindows.isFlag()) {
				JOptionPane.showMessageDialog(playChessWindows.getFrame(), "白棋胜利", "比赛结束",JOptionPane.WARNING_MESSAGE); 
			}else {
				JOptionPane.showMessageDialog(playChessWindows.getFrame(), "黑棋胜利", "比赛结束",JOptionPane.WARNING_MESSAGE); 
			}
			try {
				newwindows = new PlayChessWindows();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			playChessWindows.dispose();
		}
		
		else if(e.getActionCommand().equals("认输2")) {
			JOptionPane.showMessageDialog(machineConfrontationWindows.getFrame(), "机器胜利", "比赛结束",JOptionPane.WARNING_MESSAGE); 
			try {
				newmachineWindows = new AIBattleWindows();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			machineConfrontationWindows.dispose();
		}
		
		else if(e.getActionCommand().equals("返回主菜单1")){
			
			newmainform = new MainWindow();
			gameRuleWindow.dispose();
			
		}
		
		else if(e.getActionCommand().equals("返回主菜单2")){
			newmainform = new MainWindow();
			playChessWindows.dispose();
		}
		
		else if(e.getActionCommand().equals("返回主菜单3")){
			newmainform = new MainWindow();
			machineConfrontationWindows.dispose();
		}
		
		else if (e.getActionCommand().equals("单机游戏")) {
			try {
				newwindows = new PlayChessWindows();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			mainForm.dispose();
		}
		
		else if (e.getActionCommand().equals("人机对战")) {
			try {
				newmachineWindows = new AIBattleWindows();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			mainForm.dispose();
		}
		
		else if (e.getActionCommand().equals("游戏说明")) {
			newrulewindows = new GameRuleWindow();
			mainForm.dispose();
		}
		
		else {
			System.out.println(11);
		}
	}

	
	
	
}
