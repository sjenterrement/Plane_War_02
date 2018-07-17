package core;

import java.awt.Graphics;
import java.awt.Image;

import client.PlaneWarClient;
import util.ImageUtil;

public class Explode extends PlaneWarObject{
	
	/*
	 * 敌方爆炸组图
	 */
	public static Image[] imgs = new Image[6];

	static {
		//爆炸
		for (int i = 0; i < 6; i++) {
			imgs[i] = ImageUtil.images.get("explode_01" + "_0" + (i + 1));
		}
	}
	
	public Explode() {
		// TODO Auto-generated constructor stub
	}
	
	public Explode(PlaneWarClient pwc,int x,int y){
		this.pwc=pwc;
		this.x=x;
		this.y=y;
		this.width=imgs[0].getWidth(null);
		this.height=imgs[0].getHeight(null);
	}
	
	public boolean live=true;
	
	int count=0;
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (count >= 3) {
			count = 0;
			live=false;
			pwc.explodes.remove(this);
			return;

		}
		g.drawImage(imgs[count++], x, y, null);
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		//爆炸不需要move
	}
}
