package com.dongruan.chestplay.windows;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.dongruan.chestplay.listener.MyButtonsActionListener;
import com.dongruan.chestplay.pojo.ChessInf;
/**
 *      ������Ϸ����
 * @author Class 3 Group 2
 * @LastChangeDate :2019.12.24
 */

public class PlayChessWindows {
	
	private JFrame frame;
	private boolean flag = false;             //�жϺڰ� falseΪ��
	private int[][] chessMatrix = new int[20][18];    //���Ӷ�ά����
	private int chessPieces = 0;               //��ǰ����������
	private List<ChessInf> list = new LinkedList<ChessInf>();
	private Graphics graphics;
	
	/**
	 *     ���캯����ʼ��
	 * Create the application.
	 * @throws IOException 
	 */
	public PlayChessWindows() throws IOException {
		initialize();
	}

	
	/**
	 *     ��ʼ���������
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	public void initialize() throws IOException {
		String whiteChessPath = "src/img/white.png";
		String blackChessPath = "src/img/black.png";
		
		//��ͼƬ
		Image whileChess = ImageIO.read(new File(whiteChessPath));
		Image blackChess = ImageIO.read(new File(blackChessPath));
		
		//��Ĵ�С
		int chessSize = 36;
		
		//���ô���
		frame = new JFrame("�������ս");
		frame.setBounds(100, 100, 1400, 930);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(3);
		frame.setLayout(null);
		frame.setLocation(100,-10);
		
		frame.setVisible(true);
		//��������
		
		JLabel l1 = new JLabel(new ImageIcon("src/img/qipan.png"));
		l1.setBounds(0, -50, 1000, 1000);
		//�������̱���
		
		JLabel chessBackground = new JLabel(new ImageIcon("src/img/qipan_background.JPG"));
		chessBackground.setBounds(1000,-50,400,1000);
		
		ImageIcon button1 = new ImageIcon("src/img/��������Ϸ.png");
		ImageIcon button2 = new ImageIcon("src/img/����.png");
		ImageIcon button3 = new ImageIcon("src/img/�������˵�.png");
		
		//����ѡ�ť
		JButton btn1=new JButton("��������Ϸ1",button1);//��������Ϸ
		JButton btn2=new JButton("����1",button2);//����
		JButton btn3=new JButton("�������˵�2",button3);//�������˵�
		btn1.setBounds(1100, 50, 200, 76);
		btn2.setBounds(1100, 150, 200, 76);
		btn3.setBounds(1100, 250, 200, 76);
		
		
		MyButtonsActionListener btn = new MyButtonsActionListener(this);
		btn1.addActionListener(btn);
		btn2.addActionListener(btn);
		btn3.addActionListener(btn);
		
		frame.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				int Xchess,Ychess;//��������
				int Xmatrix,Ymatrix;//���Ӷ�ά����洢�±�
				if(x>=30 && y>=50 && x<=975 && y<=900) {//���ӱ߽��ж�
					//�������������Ӷ�Ӧ�����ת��
					if(x%50>25) 
						Xchess=x+(50-x%50)-17;
					else Xchess=x-x%50-17;
					if((y-30)%50>25) Ychess=y-y%50+30-17;
					else Ychess=y-y%50+30-17;
					Xmatrix=Xchess/50;
					Ymatrix=Ychess/50-1;
					if(chessMatrix[Xmatrix][Ymatrix]==0) {
						//�ڴ����л�������
						graphics= frame.getGraphics();
						if(flag) {
							graphics.drawImage(whileChess, Xchess, Ychess, chessSize, chessSize,null);
							chessMatrix[Xmatrix][Ymatrix]=1;//��Ϊ���壬����ֵ��Ϊ1
						}else {
							graphics.drawImage(blackChess, Xchess, Ychess, chessSize, chessSize,null);
							chessMatrix[Xmatrix][Ymatrix]=2;//��Ϊ���壬����ֵ��Ϊ2
						}
						System.out.println("�����±�Ϊ"+Xmatrix+","+Ymatrix);
						chessPieces++;
						list.add(new ChessInf(Xchess, Ychess, flag));
						if(chessPieces>=9) {
							if(isWin(Xmatrix, Ymatrix)) {
								if(flag) {
									System.out.println("����ʤ");
									JOptionPane.showMessageDialog(frame, "����ʤ��", "��������",JOptionPane.WARNING_MESSAGE);  
								}else {
									System.out.println("����ʤ");
									JOptionPane.showMessageDialog(frame, "����ʤ��", "��������",JOptionPane.WARNING_MESSAGE);  
								}
								btn1.doClick();
							}
						}
						flag=!flag;
					}
				}
			}
		});
		
		
		//text.setBounds(1000,450,100,50); ��ʾ�������λ�õĿ��
		//frame.add(text);
		frame.add(l1);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(chessBackground);
		
	}
	
	public boolean isWin(int x,int y) {
		//�Ե�ǰ��������Ϊ���ģ��ڲ������߽緶Χ���ж�����ֱ����ˮƽ�������Խ��߷��򡢸��Խ��߷���ĸ�10�����ӡ�
		int sum=1;
		int Xup,Yup,Xdown,Ydown;            //X��Y������жϱ߽�
		int Xincrement,Yincrement;       //�Խ����ж�ʱ��x.y����߽��ԭ�������
		//��ֱ
		Yup = (y-4)>0?(y-4):0;
		Ydown = (y+4)<17?(y+4):17;
		for(int i=Yup;i<Ydown;i++) {
			if(chessMatrix[x][i]!=0 && chessMatrix[x][i]==chessMatrix[x][i+1]) {
				sum++;
			}else {
				sum=1;
			}
			if(sum==5) {
				return true;
			}
		}
		
		//ˮƽ
		sum=1;
		Xup = (x-4)>0?(x-4):0;
		Xdown = (x+4)<19?(x+4):19;
		for(int i=Xup;i<Xdown;i++) {
			if(chessMatrix[i][y]!=0 && chessMatrix[i][y]==chessMatrix[i+1][y]) {
				sum++;
			}else {
				sum=1;
			}
			if(sum==5) {
				return true;
			}
		}
		
		//���Խ���
		sum=1;
		
		//���Ͻ�
		Xincrement = (x-4)>0?4:x;
		Yincrement = (y-4)>0?4:y;
		Xup = x - ((Xincrement>Yincrement)?Yincrement:Xincrement);
		Yup = y - ((Xincrement>Yincrement)?Yincrement:Xincrement);
		
		//���½�
		Xincrement = (x+4)<19?4:(19-x);
		Yincrement = (y+4)<17?4:(17-y);
		Xdown = x + ((Xincrement>Yincrement)?Yincrement:Xincrement);
		Ydown = y + ((Xincrement>Yincrement)?Yincrement:Xincrement);
		for(int i=Xup,j=Yup;i<Xdown && j<Ydown;i++,j++) {
			if(chessMatrix[i][j]!=0 && chessMatrix[i][j]==chessMatrix[i+1][j+1]) {
				sum++;
			}else {
				sum=1;
			}
			if(sum==5) {
				return true;
			}
		}
		
		//���Խ���
		sum=1;
		
		//���Ͻ�
		Xincrement = (x+4)<19?4:(19-x);
		Yincrement = (y-4)>0?4:y;
		Xdown = x + ((Xincrement>Yincrement)?Yincrement:Xincrement);
		Yup = y - ((Xincrement>Yincrement)?Yincrement:Xincrement);
		
		//���½�
		Xincrement = (x-4)>0?4:x;
		Yincrement = (y+4)<17?4:(17-y);
		Xup = x - ((Xincrement>Yincrement)?Yincrement:Xincrement);
		Ydown = y + ((Xincrement>Yincrement)?Yincrement:Xincrement);
		for(int i=Xdown,j=Yup;i>Xup && j<Ydown;i--,j++) {
			if(chessMatrix[i][j]!=0 && chessMatrix[i][j]==chessMatrix[i-1][j+1]) {
				sum++;
			}else {
				sum=1;
			}
			if(sum==5) {
				return true;
			}
		}
		return false;
	}
	
	public void dispose() {
		frame.dispose();
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public List<ChessInf> getList() {
		return list;
	}

	public void setList(List<ChessInf> list) {
		this.list = list;
	}

	public Graphics getGraphics() {
		return graphics;
	}

	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}
}
