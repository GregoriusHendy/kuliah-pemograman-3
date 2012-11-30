package belajar.swing.container;

import javax.swing.JFrame;
import javax.swing.JDialog;

public class BelajarDialog {
	public static void main(String[] xx) throws Exception{
		JFrame fr=new JFrame();
		fr.setTitle("Belajar Dialog");
		fr.setSize(800,600);
		
		//frame di tengah layar
		fr.setLocationRelativeTo(null);
		//program selesai ktika tombol exit ditekan
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//tidak terdapat dekorasi(title ,close,minimize dsb)
		//fr.setUndecorated(true);
		
		//method untuk bisa resize atau tidak
		fr.setResizable(false);
		fr.setVisible(true);
		
		JDialog jd = new JDialog(fr);
		jd.setTitle("dialog box");
		jd.setLocationRelativeTo(fr);
		//jika modal true maka prent tidak bisa dioprasikan
		jd.setModal(true);
		
		//delay dulu 5 detik
		Thread.sleep(5*1000);
		//tampilkan dialog
		jd.setVisible(true);
	}
}