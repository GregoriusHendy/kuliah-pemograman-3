package belajar.swing.container;

import javax.swing.JFrame;

public class BelajarFrame {
	public static void main(String[] xx){
		JFrame fr=new JFrame();
		fr.setTitle("Belajar Frame");
		fr.setSize(800,600);
		
		//frame di tengah layar
		fr.setLocationRelativeTo(null);
		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//tidak terdapat dekorasi(title ,close,minimize dsb)
		fr.setUndecorated(true);
		
		//method untuk bisa resize atau tidak
		fr.setResizable(false);
		fr.setVisible(true);
	}
}