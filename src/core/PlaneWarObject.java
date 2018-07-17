package core;

import java.awt.*;

import client.PlaneWarClient;


public abstract class PlaneWarObject implements Moveable,Drawable {
	
	//������ϵ
	//��ͣ�����ģʽ
	public PlaneWarClient pwc;
	public int x;
	public int y;
	public Image img;
	public int width;
	public int height;
	public int speed;
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, null);
		move();
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * ��ȡͼƬ���Ӧ��ͼƬ��С
	 */
	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}

	
}
