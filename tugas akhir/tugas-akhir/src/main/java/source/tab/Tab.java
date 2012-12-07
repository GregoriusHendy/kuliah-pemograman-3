package source.tab;

import javax.swing.*;
import java.awt.*;
import source.produk.TabelProduk;
import source.suplier.TabelSuplier;

public class Tab{
	private JFrame fr;
	private JTabbedPane tabMenu;
	private JPanel tabP;
		private JPanel isiP;
		private JPanel inputP;
	
	private JPanel tabS;
		private JPanel isiS;
		private JPanel inputS;
	
	
	public Tab(){
		fr = new JFrame("inventori mini market ceria");
		tabMenu = new JTabbedPane();
		fr.getContentPane().add(tabMenu);
		
		//untuk tab produk
		JPanel tabP = new JPanel();
		JPanel isiP = new JPanel();
		JPanel inputP = new JPanel();
		
		TabelProduk tabelP = new TabelProduk();
		isiP.add(tabelP.getPanel());
		
		tabP.add(isiP);
		tabMenu.addTab("produk",tabP);
		
		//untuk tab suplier
		JPanel tabS = new JPanel();
		JPanel isiS = new JPanel();
		JPanel inputS = new JPanel();
		
		TabelSuplier tabelS = new TabelSuplier();
		isiS.add(tabelS.getPanel());
		
		tabS.add(isiS);
		tabMenu.addTab("suplier",tabS);
		
		fr.setSize(800,600);
		//fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
	}
	
	public void setTampil(boolean tampil){
		fr.setVisible(tampil);
	}
}