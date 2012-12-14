package source.tab;

import javax.swing.*;
import java.awt.*;
import source.produk.TabelProduk;
import source.produk.input.MainInput;
import source.suplier.TabelSuplier;
import source.suplier.input.InputSuplier;

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
 
		//isi table produk
		TabelProduk tabelP = new TabelProduk();
		TabelProduk obTP = tabelP.getObject();
		
		//input produk
		MainInput mi = new MainInput(obTP);
		
		//memasukkan isi tabel dan input kedalam panel
		isiP.add(tabelP.getPanel());
		inputP.add(mi.getPanel());
		
		//memasukkan panel kedalam tab produk
		tabP.add(isiP);
		tabP.add(inputP);
		tabMenu.addTab("produk",tabP);
		
		//untuk tab suplier
		JPanel tabS = new JPanel();
		JPanel isiS = new JPanel();
		JPanel inputS = new JPanel();
		
		//isi table suplier
		TabelSuplier tabelS = new TabelSuplier();
		isiS.add(tabelS.getPanel());
		TabelSuplier obTS= tabelS.getObject();
		
		//input suplier
		InputSuplier is = new InputSuplier(obTS);
		inputS.add(is.getPanel());
		
		tabS.add(isiS);
		tabS.add(inputS);
		tabMenu.addTab("suplier",tabS);
		
		fr.setSize(1000,600);
		//fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
	}
	
	public void setTampil(boolean tampil){
		fr.setVisible(tampil);
	}
}
