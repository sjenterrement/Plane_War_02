package util;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import constant.Constant;

/*
 * ����Ŀ�����е�ͼƬ��br��
 * ʹ��map�ṹ��ţ�ʹ�þ�̬�����
 * ��̬��ʼ��
 * 
 */

public class ImageUtil {
	public static Map<String, Image> images=new HashMap<>();
	
	static {
		/*
		 * �ҷ�010203�ŷɻ�
		 */
		images.put("myplane_01", GameUtil.getImage(Constant.IMG_PRE+"plane/myplane/myplane_01.png"));
		images.put("myplane_02", GameUtil.getImage(Constant.IMG_PRE+"plane/myplane/myplane_02.png"));
		images.put("myplane_03", GameUtil.getImage(Constant.IMG_PRE+"plane/myplane/myplane_03.png"));
		
		/**
		 * �ҷ�01�ŷɻ��ӵ�01
		 */
		images.put("myplane_bullet_01_01", GameUtil.getImage(Constant.IMG_PRE+"missile/myplane/myplane_bullet_01_01.png"));
		/**
		 * �ҷ�01�ŷɻ��ӵ�02
		 */
		images.put("myplane_bullet_01_02", GameUtil.getImage(Constant.IMG_PRE+"missile/myplane/myplane_bullet_01_02.png"));
		/**
		 * �ҷ�01�ŷɻ��ӵ�02
		 */
		images.put("myplane_bullet_01_03", GameUtil.getImage(Constant.IMG_PRE+"missile/myplane/myplane_bullet_01_03.png"));
		/**
		 * �з�01��monster�ӵ�
		 */
		images.put("enemymonster_bullet_01_01", GameUtil.getImage(Constant.IMG_PRE+"missile/enemy/monster/enemymonster_bullet_01_01.png"));
		images.put("enemymonster_bullet_01_02", GameUtil.getImage(Constant.IMG_PRE+"missile/enemy/monster/enemymonster_bullet_01_02.png"));
		/*
		 * �ط��ɻ�
		 */
		images.put("enemyplane_01", GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_01.png"));
		images.put("enemyplane_02", GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_02.png"));
		images.put("enemyplane_02", GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_03.png"));
		images.put("enemyplane_02", GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_04.png"));
		images.put("enemyplane_02", GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_05.png"));
		
		
		/*
		 * 01�ű�ը��ͼ
		 */
		for (int i = 1; i <= 6; i++) {
			images.put("explode_01"+"_0"+i, GameUtil.getImage(Constant.IMG_PRE+"effects/explode_01"+"_0"+i+".png"));
			
		}
		
		/**
		 * ����010203
		 */
		images.put("background_01", GameUtil.getImage(Constant.IMG_PRE+"background/background_01.png"));
		images.put("background_02", GameUtil.getImage(Constant.IMG_PRE+"background/background_02.png"));
		images.put("background_03", GameUtil.getImage(Constant.IMG_PRE+"background/background_03.png"));
		
		
		//��bass
		for (int i = 1; i <= 4; i++) {
			images.put("enemyplane_06"+"_"+i, GameUtil.getImage(Constant.IMG_PRE+"plane/enemyplane/enemyplane_06"+"_"+i+".png"));
		}
		
	}
}
