package core;

import java.awt.Graphics;
import java.awt.Image;

import client.PlaneWarClient;
import constant.Constant;
import util.ImageUtil;

public class BackGround extends PlaneWarObject{
	
	//int i = 0;
	
	public static Image[] imgs = new Image[ Constant.GAME_MAX*3];

	static {
		for (int i = 0; i < Constant.GAME_MAX; i++) {
			imgs[i] = ImageUtil.images.get("background_01");
		}
		for (int i = 2; i < Constant.GAME_MAX; i++) {
			imgs[i] = ImageUtil.images.get("background_02");
		}
		for (int i = 4; i < Constant.GAME_MAX; i++) {
			imgs[i] = ImageUtil.images.get("background_03");
		}
	}
	public BackGround() {
		// TODO Auto-generated constructor stub
	}
	
	public BackGround(PlaneWarClient pwc,int x,int y,int num){
		this.pwc=pwc;
		this.img=ImageUtil.images.get("background_0"+num);
//		for (; i < Constant.GAME_MAX; i++) {
//			this.x=0+i*1024;
//		    this.y=0+i*320;
//		   // break;
//		}
		this.x=x;
	    this.y=y;
	    this.width = imgs[0].getWidth(null);
		this.height = imgs[0].getHeight(null);
		this.speed=10;
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		this.y+=speed;
//		if (this.y>=0) {
//			this.y=0;
//		}
	}
	
//	public void Dispear(Plane p) {
//		// TODO Auto-generated method stub
//		if (imgs[1].) {
//			p.live = false;
//			pwc.myplane.remove(p);
//		}
//	}
}
