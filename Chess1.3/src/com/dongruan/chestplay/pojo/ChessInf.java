package com.dongruan.chestplay.pojo;

/**
 *         ���Ӹ�����Ϣ��ʵ����
 * @author Class 3 Group 2
 *
 */
public class ChessInf {
	private int x;
	private int y;
	private boolean flag;
	
	public ChessInf(int x,int y,boolean flag) {
		this.x = x;
		this.y = y;
		this.flag = flag;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}
