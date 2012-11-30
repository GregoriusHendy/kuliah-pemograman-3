//kelas berada pada paket com.artivisi.project
package com.artivisi.project;

/*
import javax.swing.Jframe
import javax.swing.JPanel
import javax.swing.JOptionPane
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class BelajarFrame{
	// method utama
	public static void main(String[] args){
		//membuat objek fr terhadap kelas JFrame
		JFrame fr = new JFrame();
		//memanggil method setTitle dengan mengirimkan string Hello swing
		fr.setTitle("Hello swing");
		
		//membanggil method showMessegaDialog dengan menirimkan nilai null dan string "hallo doalog"
		JOptionPane.showMessageDialog(null,"hallo dialog");
		
		//set ukuran frame 200 x 200
		fr.setSize(200,200);
		//menamilkan frame
		fr.setVisible(true);
		
		//membuat objek pnl terhadap kelas JPanel
		JPanel pnl= new JPanel();
		//menambahkan objek objek pnl ke dalam objek fr
		fr.add(pnl);
	}
}