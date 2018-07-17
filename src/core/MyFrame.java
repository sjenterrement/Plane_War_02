package core;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import constant.Constant;



public class MyFrame extends Frame {
	public void launchGame() {
		// TODO Auto-generated method stub
		this.setTitle("·É»ú´óÕ½");
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.enableInputMethods(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	//	this.setBackground(Color.WHITE);

		new MyThread().start();

	}

	class MyThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}
	
	Image backImag = null;

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if (backImag==null) {
			backImag=createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
			
		}
		
		Graphics backg=backImag.getGraphics();
		Color c=backg.getColor();
		backg.setColor(Color.WHITE);
		backg.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		backg.setColor(c);
		paint(backg);
		g.drawImage(backImag, 0, 0, null);
	}

	
}
