package util;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import constant.Constant;

/*
 * 有项目中所有的图片《br》
 * 使用map结构存放，使用静态代码块
 * 静态初始化
 * 
 */

public class ImageUtil {
	public static Map<String, Image> images=new HashMap<>();
	
	static {
		/*
		 * 我方010203号飞机
		 */
		images.put("myplane_01", GameUtil.getImage(Constant.IMG_PRE+"plane/myplane/myplane_01.png"));
		images.put("myplane_02", GameUtil.getImage(Constant.IMG_PRE+"plane/myplane/myplane_02.png"));
		images.put("myplane_03", GameUtil.getImage(Constant.IMG_PRE+"plane/myplane/myplane_03.png"));
		
		/**
		 * 我方01号飞机子弹01
		 */
		images.put("myplane_bullet_01_01", GameUtil.getImage(Constant.IMG_PRE+"missile/myplane/myplane_bullet_01_01.png"));
		/**
		 * 我方01号飞机子弹02
		 */
		images.put("myplane_bullet_01_02", GameUtil.getImage(Constant.IMG_PRE+"missile/myplane/myplane_bullet_01_02.png"));
		/**
		 * 我方01号飞机子弹02
		 */
		images.put("myplane_bullet_01_03", GameUtil.getImage(Constant.IMG_PRE+"missile/myplane/myplane_bullet_01_03.png"));
		/**
		 * 敌方01号monster子弹
		 */
		images.put("enemymonster_bullet_01_01", GameUtil.getImage(Constant.IMG_PRE+"missile/enemy/monster/enemymonster_bullet_01_01.png"));
		images.put("enemymonster_bullet_01_02", GameUtil.getImage(Constant.IMG_PRE+"missile/enemy/monster/enemymonster_bullet_01_02.png"));
		/*
		 * 地方飞机
		 */
		images.put("enemyplane_01", GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_01.png"));
		images.put("enemyplane_02", GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_02.png"));
		images.put("enemyplane_02", GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_03.png"));
		images.put("enemyplane_02", GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_04.png"));
		images.put("enemyplane_02", GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_05.png"));
		
		
		/*
		 * 01号爆炸组图
		 */
		for (int i = 1; i <= 6; i++) {
			images.put("explode_01"+"_0"+i, GameUtil.getImage(Constant.IMG_PRE+"effects/explode_01"+"_0"+i+".png"));
			
		}
		
		/**
		 * 背景010203
		 */
		images.put("background_01", GameUtil.getImage(Constant.IMG_PRE+"background/background_01.png"));
		images.put("background_02", GameUtil.getImage(Constant.IMG_PRE+"background/background_02.png"));
		images.put("background_03", GameUtil.getImage(Constant.IMG_PRE+"background/background_03.png"));
		
		
		//大bass
		for (int i = 1; i <= 4; i++) {
			images.put("enemyplane_06"+"_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_06"+"_"+i+".png"));
		}
		
	}
}
