package belajar.swing.container;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class BelajarInternalFrame {
	public static void main(String[] xx){
		JFrame fr=new JFrame();
		
		fr.setTitle("Belajar Internal Frame");
		fr.setSize(800,600);
		
		//frame di tengah layar
		fr.setLocationRelativeTo(null);
		//program selesai ktika tombol exit ditekan
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane jdp = new JDesktopPane();
		
		JInternalFrame ifr = new JInternalFrame();
		ifr.setTitle("hello word swing");
		ifr.setSize(200,200);
		ifr.add(new JLabel("hello world"));
		ifr.setClosable(true);
		ifr.setIconifiable(true);
		ifr.setMaximizable(true);
		jdp.add(ifr);
		ifr.setVisible(true);
		
		fr.setContentPane(jdp);
		fr.setVisible(true);
	}
}