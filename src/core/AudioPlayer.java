package core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
/*
 * ���ֲ�����
 */
public class AudioPlayer {
	Player player;
	File music;

	// ���췽�� ������һ��.mp3��Ƶ�ļ�
	public AudioPlayer(File file) {
		this.music = file;
	}

	// ���ŷ���
	public void play() throws FileNotFoundException, JavaLayerException {
		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
		player = new Player(buffer);
		player.play();
	}
}
