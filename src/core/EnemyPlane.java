package core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import client.PlaneWarClient;
import util.ImageUtil;

public class EnemyPlane extends Plane {

	public int type;

	/*
	 * 多张图片组
	 */
	// public static Image[] imgs1 = { ImageUtil.images.get("enemyplane_1"),
	// ImageUtil.images.get("enemyplane_2"),
	// ImageUtil.images.get("enemyplane_3"), };

	/*
	 * 地方怪兽组图
	 */
	public static Image[] imgs = new Image[8];

	static {

		for (int i = 0; i < 3; i++) {
			imgs[i] = ImageUtil.images.get("enemymonster_01" + "_0" + (i + 1));
		}

		for (int i = 3; i < 5; i++) {
			imgs[i] = ImageUtil.images.get("enemymonster_02" + "_0" + (i - 2));
		}
//		for (int i = 8; i < 12; i++) {
//			imgs[i] = ImageUtil.images.get("enemyplne_06" + "_" + (i -7));
//		}

	}

	/*
	 * 无参数
	 */
	public EnemyPlane() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 敌方飞机带参数的构造发给发
	 */
	public EnemyPlane(int x, int y, String key) {
		this.x = x;
		this.y = y;
		this.img = ImageUtil.images.get(key);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.speed = 5;
	}

	public EnemyPlane(PlaneWarClient pwc, int x, int y, int type, boolean good) {
		this.pwc = pwc;
		// System.out.println(type);
		this.x = x;
		this.y = y;
		this.type = type;
		this.img = ImageUtil.images.get("enemyplane_0" + type);
		// System.out.println(img);
		this.width = imgs[0].getWidth(null);
		this.height = imgs[0].getHeight(null);
		this.speed = 10;
		this.good = good;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println(type);
		// this.x -= speed;
		switch (type) {
		case 1:
			this.y += speed;
			break;
		case 2:
			// this.x -= speed;
			this.y += speed;

			break;
		case 3:
			this.y += speed;

			break;
		case 4:
			this.y += speed;

			break;
		case 5:
			this.y += speed;

		case 6:
			if (x>500) {
				x=0;
			}
			this.x += speed;

			break;
		case 7:
			if (x<0) {
				x=500;
			}
			this.x -= speed;

			break;
		case 8:
			this.y += speed;

			break;
		default:
			break;
		}
		// 加判断
		if (r.nextInt(1000) > 980) {
			fire();
		}

	}

	public static Random r = new Random();

	@Override
	public void fire() {
		switch (type) {
		case 8:
			Missile enemyplane_bullet_01_03 = new Missile(pwc, this.x + this.width, this.y - 5,
					"enemyplane_missile_05", type, good);
			pwc.missiles.add(enemyplane_bullet_01_03);
			break;
		case 6:
			// 发射子弹
			Missile enemyplane_bullet_01_01 = new Missile(pwc, this.x + this.width, this.y - 5,
					"enemymonster_bullet_01_01", type, good);
			// 向管家的missile添加子弹
			pwc.missiles.add(enemyplane_bullet_01_01);
			break;
		case 7:
			// 发射子弹
			Missile enemyplane_bullet_01_02 = new Missile(pwc, this.x + this.width, this.y - 5,
					"enemymonster_bullet_01_02", type, good);
			// 向管家的missile添加子弹
			pwc.missiles.add(enemyplane_bullet_01_02);

		default:
			break;
		}
	}

	int count_1 = 0;
	int count_2 = 3;
	int count_8 = 8;
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		// System.out.println(type);
		switch (type) {
		case 6:
			if (count_1 >= 3) {
				count_1 = 0;

			}
			g.drawImage(imgs[count_1], x, y, null);
			count_1++;
			break;
		case 7:
			if (count_2 >= 5) {
				count_2 = 0;
			}
			g.drawImage(imgs[count_2 + 3], x, y, null);
			count_2++;
			break;
		case 8:
			if (count_8 >= 12) {
				count_8 = 0;
			}
			g.drawImage(imgs[count_8 + 4], x, y, null);
			count_2++;
			break;

		case 1:
			g.drawImage(img, x, y, null);
			break;
		case 2:
			g.drawImage(img, x, y, null);
			break;
		case 3:
			g.drawImage(img, x, y, null);
			break;
		case 4:
			g.drawImage(img, x, y, null);
			break;
		case 5:
			g.drawImage(img, x, y, null);
			break;
			

		default:
			break;
		}

		move();
	}

}
