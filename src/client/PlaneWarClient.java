package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import constant.Constant;
import core.BackGround;
import core.EnemyPlane;
import core.Explode;
import core.Missile;
import core.MyFrame;
import core.Plane;
import util.MusicUtil;

public class PlaneWarClient extends MyFrame {

	// ±³¾°ÈÝÆ÷
	public List<BackGround> background = new ArrayList<>();

	{
		for (int i = 0; i < Constant.GAME_MAX; i++) {
			BackGround background_01 = new BackGround(this, 0, -108 - i * 868, 1);
			background.add(background_01);
			//System.out.println(background.lastIndexOf(background_01));
		}

		for (int i = 0; i < Constant.GAME_MAX; i++) {
			BackGround background_02 = new BackGround(this, 0, -2406 - i * 1430, 2);
			background.add(background_02);
			System.out.println(background.lastIndexOf(background_02));
		}

		for (int i = 0; i < Constant.GAME_MAX; i++) {
			BackGround background_03 = new BackGround(this, 0, -5156 - i * 1320, 3);
			background.add(background_03);
		}
	}
	

	// ÎÒ·½·É»úÈÝÆ÷
	public List<Plane> myplane_1 = new ArrayList<>();
	public List<Plane> myplane_2 = new ArrayList<>();
	public List<Plane> myplane_3 = new ArrayList<>();

	{
	
		Plane myplane_01 = new Plane(this, true, 1,250-150/2,760-151,1);
		myplane_1.add(myplane_01);
		Plane myplane_02 = new Plane(this, true, 2,250-150/2,-108-(Constant.GAME_MAX-1)*868-161,2);
		myplane_2.add(myplane_02);
		Plane myplane_03 = new Plane(this, true, 3,250-150/2,-108-(Constant.GAME_MAX-1)*868-Constant.GAME_MAX*1430-137,3);
		myplane_3.add(myplane_03);
	}
//	Plane myplane_02 = new Plane(this, true, 2,250-150/2,-17360-150);
//	Plane myplane_01 = new Plane(this, true, 1,250-150/2,760-150);
	

	// ×Óµ¯ÈÝÆ÷
	public List<Missile> missiles = new ArrayList<>();

	// // ´æ·ÅµÐ·½·É»úµÄÈÝÆ÷
	public List<EnemyPlane> enemyplanes = new ArrayList<>();

	
	{
		
		EnemyPlane enemyplane_01 = new EnemyPlane(this, 100, -100, 1, false);
		enemyplanes.add(enemyplane_01);
		EnemyPlane enemyplane_02 = new EnemyPlane(this, 100, 100, 1, false);
		enemyplanes.add(enemyplane_02);
		EnemyPlane enemyplane_03 = new EnemyPlane(this, 100, -500,1 , false);
		enemyplanes.add(enemyplane_03);
		EnemyPlane enemyplane_04 = new EnemyPlane(this, 100, -200,5, false);
		enemyplanes.add(enemyplane_04);
		EnemyPlane enemyplane_05 = new EnemyPlane(this, 100, -700, 5, false);
		enemyplanes.add(enemyplane_05);
		
		
	}
	
	
	@Override
	public void launchGame() {
		// TODO Auto-generated method stub
		super.launchGame();
		// Ìí¼Ó¼üÅÌ¼àÌýÆ÷
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
			//	 myplane_01.keyReleased(e);
				for (int i = 0; i < myplane_1.size(); i++) {
					Plane myplane_01 = myplane_1.get(i);
					 myplane_01.keyReleased(e);
				}
				
				for (int i = 0; i < myplane_2.size(); i++) {
					Plane myplane_01 = myplane_2.get(i);
					 myplane_01.keyReleased(e);
				}
				
				for (int i = 0; i < myplane_3.size(); i++) {
					Plane myplane_01 = myplane_3.get(i);
					 myplane_01.keyReleased(e);
				}
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				for (int i = 0; i < myplane_1.size(); i++) {
					Plane myplane_01 = myplane_1.get(i);
					 myplane_01.keyPressed(e);;
				}
				for (int i = 0; i < myplane_2.size(); i++) {
					Plane myplane_01 = myplane_2.get(i);
					 myplane_01.keyPressed(e);;
				}
				for (int i = 0; i < myplane_3.size(); i++) {
					Plane myplane_01 = myplane_3.get(i);
					 myplane_01.keyPressed(e);;
				}
			//	myplane.keyPressed(e);
			}
		});
		// Ìí¼Ó±³¾°ÒôÀÖ
		new MusicUtil("src/music/bgm_01.mp3", true).start();

	}

	// public Explode e=new Explode(this, 500, 500);

	public List<Explode> explodes = new ArrayList<>();

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

		for (int i = 0; i < background.size(); i++) {
			BackGround background_01 = background.get(i);
			background_01.draw(g);
		}

		// ·É»ú
		for (int i = 0; i < myplane_1.size(); i++) {
			Plane myplane_01 = myplane_1.get(i);
			myplane_01.draw(g);
			myplane_01.Dispear(1);
			
		}
		for (int i = 0; i < myplane_2.size(); i++) {
			Plane myplane_02 = myplane_2.get(i);
			myplane_02.draw(g);
			myplane_02.Dispear(2);
			
		}
		for (int i = 0; i < myplane_3.size(); i++) {
			Plane myplane_03 = myplane_3.get(i);
			myplane_03.draw(g);
			myplane_03.Dispear(3);
			
		}
		
		// µÐ·½×Óµ¯
		for (int i = 0; i < missiles.size(); i++) {
			Missile missile = missiles.get(i);
			missile.draw(g);
			missile.hitPlanes(enemyplanes);
			// missile.hitPlane(myplane);
		}
		//µÐ·½·É»ú
		for (int i = 0; i < enemyplanes.size(); i++) {
			EnemyPlane enemy = enemyplanes.get(i);
			enemy.draw(g);
		}
		
		for (int i = 0; i < explodes.size(); i++) {
			Explode explode = explodes.get(i);
			explode.draw(g);
		}

		g.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 30));

	
	}
	
	public static void main(String[] args) {
		new PlaneWarClient().launchGame();
	}
}
