package core;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import client.PlaneWarClient;
import constant.Constant;
import util.GameUtil;
import util.ImageUtil;

public class Plane extends PlaneWarObject {

	public static Image[] imgs = new Image[3];

	static {
		imgs[0] = ImageUtil.images.get("myplane_01");
		imgs[1] = ImageUtil.images.get("myplane_02");
		imgs[2] = ImageUtil.images.get("myplane_03");
	}

	public int speed = 10;
	
	public int type_2;

	public boolean left, right, up, down;

	public Plane() {
		// TODO Auto-generated constructor stub
	}

	public Plane(PlaneWarClient pwc, boolean good, int type, int x, int y,int type_2) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.fire = false;
		this.pwc = pwc;
		this.img = util.ImageUtil.images.get("myplane_0" + type);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.good = good;
		this.type_2=type_2;
//		System.out.println(type_2);
	}

	// public Plane(PlaneWarClient pwc, boolean good, int type, int x, int y,int
	// speed) {
	// this(pwc, good, type, x, y);
	// this.speed=speed;
	// }

	// public Plane(int x, int y, String imgName) {
	// // TODO Auto-generated constructor stub
	// this.x = x;
	// this.y = y;
	// this.img = GameUtil.getImage(Constant.IMG_PRE + imgName);
	// this.width = img.getWidth(null);
	// this.height = img.getHeight(null);
	// }

	public void Plane(int x, int y, Image img, int width, int height) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
		this.img = img;
		this.width = width;
		this.height = height;

	}

	public Plane(int x, int y, String key) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.img = util.ImageUtil.images.get(key);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		// 真正的移动
//		System.out.println(type_2);
		switch (type_2) {
		case 1:
			if (left) {
				x -= speed;
			}
			if (up) {
				y -= speed;
			}
			if (right) {
				x += speed;
			}
			if (down) {
				y += speed;
			}

			break;
			
		case 2:
			if (this.y<599) {
				y+=speed;
			}
			if (left) {
				x -= speed;
			}
			if (up) {
				y -= speed;
			}
			if (right) {
				x += speed;
			}
			if (down) {
				y += speed;
			}

			break;

		case 3:
			
			if (this.y<623) {
				y+=speed;
			}
			
			if (left) {
				x -= speed;
			}
			if (up) {
				y -= speed;
			}
			if (right) {
				x += speed;
			}
			if (down) {
				y += speed;
			}
			break;
			
		}

		// if (left) {
		// x -= speed;
		// }
		// if (up) {
		// y -= speed;
		// }
		// if (right) {
		// x += speed;
		// }
		// if (down) {
		// y += speed;
		// }

//		outOfBounds();

		if (fire) {
			fire();
		}

		if (superfire) {
			if (r.nextInt(100) > 50) {
				superfire();
			}
		if (superfireplus) {
			superfireplus();
		}

		}
	}

	public static Random r = new Random();

	public boolean fire;
	public boolean superfire;
	public boolean superfireplus;

	/*
	 * 按下键盘 e 键盘事件
	 */
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(e.getKeyCode());
		if (type_2==1) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				left = true;
				// x-=speed;
				break;
			case KeyEvent.VK_W:
				up = true;
				// y-=speed;
				break;
			case KeyEvent.VK_D:
				// x+=speed;
				right = true;
				break;
			case KeyEvent.VK_S:
				down = true;
				// y+=speed;
				break;
			case KeyEvent.VK_J:
				// 发射01子弹
				fire = true;

				break;
//			case KeyEvent.VK_K:
//				// 发射02子弹
//				superfire = true;
//
//				break;

			}
		}
		 if (type_2==2) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				left = true;
				// x-=speed;
				break;
			case KeyEvent.VK_W:
				up = true;
				// y-=speed;
				break;
			case KeyEvent.VK_D:
				// x+=speed;
				right = true;
				break;
			case KeyEvent.VK_S:
				down = true;
				// y+=speed;
				break;
			case KeyEvent.VK_J:
				// 发射01子弹
				fire = true;

				break;
			case KeyEvent.VK_K:
				// 发射02子弹
				superfire = true;

				break;

			}
		}
		 if (type_2==3) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				left = true;
				// x-=speed;
				break;
			case KeyEvent.VK_W:
				up = true;
				// y-=speed;
				break;
			case KeyEvent.VK_D:
				// x+=speed;
				right = true;
				break;
			case KeyEvent.VK_S:
				down = true;
				// y+=speed;
				break;
			case KeyEvent.VK_J:
				// 发射01子弹
				fire = true;

				break;
			case KeyEvent.VK_K:
				// 发射02子弹
				superfire = true;

				break;
			case KeyEvent.VK_1:
				// 发射03子弹
				superfireplus = true;

				break;
			}
		}
	}

	/*
	 * 我方飞机发子弹方法/* fire 1 小型射击
	 */
	public void fire() {
		// 发射子弹
		Missile myplane_bullet_01_01 = new Missile(pwc, this.x - 5, this.y - height, "myplane_bullet_01_01", good, 'J');

		// 向管家的missile添加子弹
		pwc.missiles.add(myplane_bullet_01_01);

	}

	/*
	 * fire 2大型射击
	 */
	public void superfire() {
		// TODO Auto-generated method stub
		// 发射子弹
		Missile myplane_bullet_01_21 = new Missile(pwc, this.x + 54, this.y - 47, "myplane_bullet_01_02", good, 'K', 1);
		Missile myplane_bullet_01_22 = new Missile(pwc, this.x + 54, this.y - 47, "myplane_bullet_01_02", good, 'K', 2);
		Missile myplane_bullet_01_23 = new Missile(pwc, this.x + 54, this.y - 47, "myplane_bullet_01_02", good, 'K', 3);
		Missile myplane_bullet_01_24 = new Missile(pwc, this.x + 54, this.y - 47, "myplane_bullet_01_02", good, 'K', 4);
		Missile myplane_bullet_01_25 = new Missile(pwc, this.x + 54, this.y - 47, "myplane_bullet_01_02", good, 'K', 5);
		// 向管家的missile添加子弹
		pwc.missiles.add(myplane_bullet_01_21);
		pwc.missiles.add(myplane_bullet_01_22);
		pwc.missiles.add(myplane_bullet_01_23);
		pwc.missiles.add(myplane_bullet_01_24);
		pwc.missiles.add(myplane_bullet_01_25);

	}
	public void superfireplus() {
		// 发射子弹
		Missile myplane_bullet_01_31 = new Missile(pwc, this.x - 5, this.y - height, "myplane_bullet_01_03", good,'L',6);
		Missile myplane_bullet_01_32 = new Missile(pwc, this.x , this.y - height, "myplane_bullet_01_03", good,'L',7);
		Missile myplane_bullet_01_33 = new Missile(pwc, this.x + 5, this.y - height, "myplane_bullet_01_03", good,'L',8);

		// 向管家的missile添加子弹
		pwc.missiles.add(myplane_bullet_01_31);
		pwc.missiles.add(myplane_bullet_01_32);
		pwc.missiles.add(myplane_bullet_01_33);

	}

	/*
	 * 判断我方飞机出界
	 * 
	 */
	private void outOfBounds_1() {
		if (this.x <= 0) {
			this.x = 0;
		}
		if (this.x >= Constant.GAME_WIDTH - width) {
			x = Constant.GAME_WIDTH - width;
		}
		 if (y <= 0) {
		 y = 0;
		 }
		 if (y >= Constant.GAME_HEIGHT - height) {
		 y = Constant.GAME_HEIGHT - height;
		 }
	}
	
//	private void outOfBounds_2() {
//		if (this.x <= 0) {
//			this.x = 0;
//		}
//		if (this.x >= Constant.GAME_WIDTH - width) {
//			x = Constant.GAME_WIDTH - width;
//		}
//		 if (y >= -108-(Constant.GAME_MAX-1)*868-Constant.GAME_HEIGHT) {
//		 y = -108-(Constant.GAME_MAX-1)*868-Constant.GAME_HEIGHT;
//		 }
//		 if (y <= -108-(Constant.GAME_MAX-1)*868 - height) {
//		 y = -108-(Constant.GAME_MAX-1)*868 - height;
//		 }
//	}
//	
//	private void outOfBounds_3() {
//		if (this.x <= 0) {
//			this.x = 0;
//		}
//		if (this.x >= Constant.GAME_WIDTH - width) {
//			x = Constant.GAME_WIDTH - width;
//		}
//		 if (y <= 0) {
//		 y = 0;
//		 }
//		 if (y >= Constant.GAME_HEIGHT - height) {
//		 y = Constant.GAME_HEIGHT - height;
//		 }
//	}

	/*
	 * 松开键盘
	 */
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (type_2==1) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				left = false;
				// x-=speed;
				break;
			case KeyEvent.VK_W:
				up = false;
				// y-=speed;
				break;
			case KeyEvent.VK_D:
				// x+=speed;
				right = false;
				break;
			case KeyEvent.VK_S:
				down = false;
				// y+=speed;
				break;
			case KeyEvent.VK_J:

				fire = false;
//			case KeyEvent.VK_K:
//				superfire = false;
			}
		}
		 if (type_2==2) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				left = false;
				// x-=speed;
				break;
			case KeyEvent.VK_W:
				up = false;
				// y-=speed;
				break;
			case KeyEvent.VK_D:
				// x+=speed;
				right = false;
				break;
			case KeyEvent.VK_S:
				down = false;
				// y+=speed;
				break;
			case KeyEvent.VK_J:

				fire = false;
			case KeyEvent.VK_K:
				superfire = false;
			}
		}
		 if (type_2==3) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				left = false;
				// x-=speed;
				break;
			case KeyEvent.VK_W:
				up = false;
				// y-=speed;
				break;
			case KeyEvent.VK_D:
				// x+=speed;
				right = false;
				break;
			case KeyEvent.VK_S:
				down = false;
				// y+=speed;
				break;
			case KeyEvent.VK_J:

				fire = false;
			case KeyEvent.VK_K:
				superfire = false;
			case KeyEvent.VK_1:
				// 发射02子弹
				superfireplus = false;

	
			}
		}
	}

	public boolean live = true;

	/*
	 * 好坏飞机
	 */
	public boolean good;

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}

	public void Dispear(int type) {
		// TODO Auto-generated method stub
		// System.out.println();
		if (pwc.background.get((Constant.GAME_MAX - 1)).y > 0
				|| pwc.background.get((Constant.GAME_MAX - 1)).y == 0 && type == 1) {
			// p.live = false;
			pwc.myplane_1.clear();
		}
		if (pwc.background.get((Constant.GAME_MAX * 2 - 1)).y > 0
				|| pwc.background.get((Constant.GAME_MAX * 2 - 1)).y == 0 && type == 2) {
			pwc.myplane_2.clear();
		}
		// if (pwc.background.get((Constant.GAME_MAX * 3 - 1)).y > 0
		// || pwc.background.get((Constant.GAME_MAX * 3 - 1)).y == 0 && type == 3) {
		// pwc.myplane_3.clear();
		// }
	}
}
