package core;

import java.util.List;

import client.PlaneWarClient;
import constant.Constant;
import util.ImageUtil;

public class Missile extends PlaneWarObject {

	// �ӵ�������
	public boolean live;
	// �з��ӵ�����
	public int type;
	// �ҷ��ӵ�����
	public int missile_type;
	//�ҷ��ӵ����
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
	 * ���ӵ�����
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
		// �ҷ��ӵ�
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
	 * �ж��ӵ�����
	 */
	private void outOfBounds() {
		// TODO Auto-generated method stub
		if (this.x <= 0 || this.x >= Constant.GAME_WIDTH - width || y <= 0 || y >= Constant.GAME_HEIGHT - height) {
			this.live = false;
			// �Ƴ������е�Ԫ��
			pwc.missiles.remove(this);
		}

	}

	/*
	 * �ӵ�����ɻ��ķ���
	 */
	public boolean hitPlane(Plane p) {
		if (this.getRectangle().intersects(p.getRectangle()) && this.good != p.isGood()) {
			// System.out.println("dadaole");
			this.live = false;
			// �ɻ���
			p.live = false;
			pwc.enemyplanes.remove(p);

			// ������ը
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
	 * �ж��ҷ��������ǵз�����
	 */

	public boolean good;

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}

}
