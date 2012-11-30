package belajar.swing.menu;

import javax.swing.*;
import java.awt.event.*;

public class DemoSwingMenu{
	public static void main(String[] xx){
		JFrame fr=new JFrame("belajar menu");
		JMenuBar menubar = new JMenuBar();
		
		//buat menu file
		JMenu menuFile = new JMenu("file");
		
		//buat anak menu file
		JMenuItem miFileNew = new JMenuItem("new");
		JMenuItem miFileOpen = new JMenuItem("open");
		
		//menu dalam menu yang memiliki anak
		JMenu miMenuRecent = new JMenu("Recent");
		for(int i=0;i<3;i++){
			if(i==2){
				miMenuRecent.addSeparator();
			}
			miMenuRecent.add(new JMenuItem("recent"+(i+1)));
		}
		
		//menambahkan menuitem dan menu kedalam menu fiel
		menuFile.add(miFileNew);
		menuFile.add(miFileOpen);
		
		// menambahkan separator
        menuFile.addSeparator();
		menuFile.add(miMenuRecent);
		
		//menambahkan menu file ke dalam menu bar
		menubar.add(menuFile);
		//menambahkan menu bar kedalam frame
		fr.setJMenuBar(menubar);
		
		//pop up menu
		final JPopupMenu popm = new JPopupMenu();
		JMenuItem miCut = new JMenuItem("cut");
		JMenuItem miCopy = new JMenuItem("copy");
		
		popm.add(miCut);
		popm.add(miCopy);
		
		JPanel panel=new JPanel();
		fr.getContentPane().add(panel);
		
		//pasang pop up menu di menu item
		panel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getButton()!=MouseEvent.BUTTON3){
					return;
				}
				//parent komponen, posisi X, posisi Y
				popm.show(e.getComponent(),e.getX(),e.getY());
			}
		});
		
		
		
		
		fr.setSize(400,400);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
}