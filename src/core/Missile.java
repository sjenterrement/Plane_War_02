package core;

import java.util.List;

import client.PlaneWarClient;
import constant.Constant;
import util.ImageUtil;

public class Missile extends PlaneWarObject {

	// 子弹的生死
	public boolean live;
	// 敌方子弹类型
	public int type;
	// 我方子弹类型
	public int missile_type;
	//我方子弹编号
	public int missile_type_type;

	public Missile() {
		// TODO Auto-generated constructor stub
	}

	public Missile(PlaneWarClient pwc, int x, int y, String key, boolean good) {
		this.pwc = pwc;
		this.live = true;
		this.x = x;
		this.y = y;
		this.img = ImageUtil.images.get(key);
		this.speed = 25;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.good = good;
	}

	/**
	 * 加子弹类型
	 * 
	 * @param pwc
	 * @param x
	 * @param y
	 * @param key
	 */
	public Missile(PlaneWarClient pwc, int x, int y, String key, int type, boolean good) {
		this(pwc, x, y, key, good);
		this.type = type;
	}
	
	public Missile(PlaneWarClient pwc, int x, int y, String key, boolean good, char missile_type) {
		this(pwc, x, y, key, good);
		this.missile_type = missile_type;
	}
	public Missile(PlaneWarClient pwc, int x, int y, String key, boolean good, char missile_type,int missile_type_type) {
		this(pwc, x, y, key, good, missile_type);
		this.missile_type_type=missile_type_type;
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		// System.out.println("d");
		if (type==8) {
			this.y += speed;
		}
		if (type==1) {
			this.y += speed;
		}
		if (type == 6) {
			
			this.y += speed;
		} else if (type == 7) {
			this.y += speed;
		}
		// 我方子弹
		else {

			if (missile_type == 'J') {
				this.y -= speed;
			} else if(missile_type == 'K'){
				switch (missile_type_type) {
				case 1:
					this.x-=speed*Math.cos((Math.PI/6)*1);
					this.y-=speed*Math.sin((Math.PI/6)*1);
					break;
                case 2:
                	this.x-=speed*Math.cos(Math.PI/3);
					this.y-=speed*Math.sin(Math.PI/3);
					break;
                case 3:
					this.y-=speed;
					break;
                case 4:
                	this.x-=speed*Math.cos((Math.PI/3)*2);
					this.y-=speed*Math.sin((Math.PI/3)*2);
	                break;
				default:
					this.x-=speed*Math.cos((Math.PI/6)*5);
					this.y-=speed*Math.sin((Math.PI/6)*5);
					break;
				}
			}else {
				switch (missile_type_type) {
				case 6:
					this.y -= speed;
					break;
                case 7:
                	this.y -= speed;
					break;

				default:
					this.y -= speed;
					break;
				}
				}
			}

		}
	//	outOfBounds();
	

	/*
	 * 判断子弹出界
	 */
	private void outOfBounds() {
		// TODO Auto-generated method stub
		if (this.x <= 0 || this.x >= Constant.GAME_WIDTH - width || y <= 0 || y >= Constant.GAME_HEIGHT - height) {
			this.live = false;
			// 移除容器中的元素
			pwc.missiles.remove(this);
		}

	}

	/*
	 * 子弹击打飞机的方法
	 */
	public boolean hitPlane(Plane p) {
		if (this.getRectangle().intersects(p.getRectangle()) && this.good != p.isGood()) {
			// System.out.println("dadaole");
			this.live = false;
			// 飞机死
			p.live = false;
			pwc.enemyplanes.remove(p);

			// 创建爆炸
			Explode e = new Explode(pwc, p.x - width / 2, p.y - height / 2);
			pwc.explodes.add(e);
			return true;
		}
		return false;
	}

	public boolean hitPlanes(List<EnemyPlane> es) {
		for (int i = 0; i < es.size(); i++) {
			EnemyPlane enemyPlane = es.get(i);

			if (this.hitPlane(enemyPlane)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * 判断我方发出还是敌方发出
	 */

	public boolean good;

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}

}
