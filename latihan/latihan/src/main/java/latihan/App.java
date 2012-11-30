package latihan;

import javax.swing.*;
import java.awt.*;


public class App {
	private JComboBox cbNama = new JComboBox() ;
	
	
    public static void main( String[] args ){
        JFrame fr= new JFrame("latihan");
		
		JPanel panel = new JPanel();
		JTabbedPane tab = new JTabbedPane();
		tab.setTabPlacement(JTabbedPane.BOTTOM);
		fr.getContentPane().add(tab);
		
		JMenuBar menubar = new JMenuBar();
		JMenu menuFile = new JMenu("file");
		menubar.add(menuFile);
		JMenuItem miNew = new JMenuItem("new");
		JMenuItem miOpen = new JMenuItem("open");
		menuFile.add(miNew);
		menuFile.add(miOpen);
		fr.setJMenuBar(menubar);
		
		JPanel p2 = new JPanel(new BorderLayout());
		tab.addTab("text component",p2);
		
		JPanel p1= new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		p2.add(p1,"Center");
		JPasswordField pfPass = new JPasswordField(20);
		pfPass.setEchoChar('*');
		JButton bOk = new JButton("oke");
		JTextArea taAlamat= new JTextArea(10,10);
		taAlamat.setLineWrap(true); //ganti baris klau sudah mentok kanan
		p1.add(pfPass);
		p1.add(bOk);
		p1.add(taAlamat);
		
		JPanel p3 = new JPanel();
		tab.addTab("Tabel",p3);
		
		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setSize(800,400);
		fr.setVisible(true);
    }
}