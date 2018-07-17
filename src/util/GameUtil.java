package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public class GameUtil {
	/*
	 * ��ȡͼƬ���� imgpathͼƬ�����·�� img����
	 */
	public static Image getImage(String imgPath) {
		// TODO Auto-generated method stub
		URL u = GameUtil.class.getClassLoader().getResource(imgPath);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return img;

	}

}
