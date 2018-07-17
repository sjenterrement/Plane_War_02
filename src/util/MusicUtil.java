package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import constant.Constant;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicUtil extends Thread {
	private Player player;
	private File music;
	private boolean loop;

	/**
	 * ���췽����Ĭ�ϲ�ѭ�����ţ�
	 * 
	 * @param musicpath
	 */
	public MusicUtil(String musicpath) {
		this.music = new File(musicpath);
	}

	/**
	 * ���췽��(�Ƿ�ѭ��)
	 * 
	 * @param musicpath
	 *            �����ļ�����·��
	 */
	public MusicUtil(String musicpath, boolean loop) {
		this(musicpath);
		this.loop = loop;
	}

	/**
	 * ��дrun����
	 */
	@Override
	public void run() {
		super.run();
		try {
			if (loop) {
				while (true) {
					play();
				}
			} else {
				play();
			}
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ŷ���
	 * 
	 * @throws FileNotFoundException
	 * @throws JavaLayerException
	 */
	private void play() throws FileNotFoundException, JavaLayerException {
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
		player = new Player(buffer);
		player.play();
	}

	/**
	 * ������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MusicUtil mu = new MusicUtil("src/music/bgm_01.mp3", true);
		mu.start();
	}
}
