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

	// 10¸ö01Ð¡¹ÖÊÞ·É»ú
	{
		for (int i = 0; i < 100; i++) {
			EnemyPlane enemymonster_01_1 = new EnemyPlane(this,  - (i * 120 + 20) - 120, 200, 6, false);
			enemyplanes.add(enemymonster_01_1);
		}
	

	// 10¸ö02ºÅÐ¡¹ÖÊÞ
	
		for (int i = 0; i < 100; i++) {
			EnemyPlane enemymonster_02_2 = new EnemyPlane(this, 200 + (i * 200 + 20), 26, 7, false);
			enemyplanes.add(enemymonster_02_2);
		}
		
//		EnemyPlane enemyplane_06 = new EnemyPlane(this, 200, 200, 8, false);
//		enemyplanes.add(enemyplane_06);
		
	
	
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
	
	

//	 public EnemyPlane enemyplane_01 = new EnemyPlane(this, 100, 200, 3, false);
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

		// background_01.draw(g);
		// background
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
//		myplane.draw(g);
//		myplane.draw(g);
		
		
		
//		 enemyplane_01.draw(g);

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

		// g.drawString("missile's size:"+missiles.size(), 100, 180);
		// g.drawString("enemyplanes's size:"+enemyplanes.size(), 100, 130);
	}
	
//	static JFrame frame = new JFrame();
//	public static void main(String[] args) {
//		
//		//frame.getContentPane().setBackground(Color.BLUE);
//		frame.setSize(500,760);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
//		
//		
//		 /*Container c =frame.getContentPane();
//		  c.setLayout(null);*/
//		 //frame.setIconImage((new ImageIcon("img/start.png")).getImage());
//		  JButton a = new JButton();
//		  JButton b = new JButton();
//		  JButton d = new JButton();
//		  ImageIcon aa = new ImageIcon("src/img/a.png");
//	        ImageIcon bb= new ImageIcon("src/img/b.png");
//	        ImageIcon dd = new ImageIcon("src/img/d.png");
//	        a.setIcon(aa);
//	        b.setIcon(bb);
//	        d.setIcon(dd);
//
//      	 a.setSize(230, 63);
//       	b.setSize(230, 63);
//    	d.setSize(230, 63);
//    	a.setBackground(Color.BLACK);
//    	b.setBackground(Color.BLACK);
//    	d.setBackground(Color.black);
//       	a.setLocation(147, 397);
//       	b.setLocation(147, 502);
//       	d.setLocation(147, 605);
//       	frame.add(a);
//    	frame.add(b);
//    	frame.add(d);
//		  b.setToolTipText("A¼ü·É»úÏò×óÒÆ¶¯"
//				 +"  "+ "W¼ü·É»úÏòÉÏÒÆ¶¯"
//				  +"  "+"D¼ü·É»úÏòÓÒÒÆ¶¯"
//				 +"  "+"S¼ü·É»úÏòÏÂÒÆ¶¯"+"  "+"J¼ü·¢Éä×Óµ¯");
//		a.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			closeThis();
//			new	PlaneWarClient().launchGame();
//				
//		}
//		});
//		d.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			closeThis();
//				
//		}
//		});
//		
//}
//	
//
//	public static void closeThis() {
//		frame.dispose();
//	}
//	
	
	public static void main(String[] args) {
		new PlaneWarClient().launchGame();
	}
}
