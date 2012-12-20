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
	private JScrollPane scrTabP;
	private JPanel tabP;
		private JPanel isiP;
		private JPanel inputP;
	
	private JScrollPane scrTabS;
	private JPanel tabS;
		private JPanel isiS;
		private JPanel inputS;
	
	
	public Tab(){
		fr = new JFrame("inventori mini market ceria");
		tabMenu = new JTabbedPane();
		fr.getContentPane().add(tabMenu);
		
		//untuk tab produk
		JPanel isiP = new JPanel();
		JPanel inputP = new JPanel();
		
		JPanel tabP = new JPanel();
		GridBagLayout gBagP = new GridBagLayout();
		tabP.setLayout(gBagP);
		GridBagConstraints gbcP = new GridBagConstraints();
		gbcP.insets = new Insets(5,10,5,10);
		gbcP.fill= GridBagConstraints.BOTH;
		
		
		//untuk tab suplier
		JPanel isiS = new JPanel();
		JPanel inputS = new JPanel();
		
		JPanel tabS = new JPanel();	
		GridBagLayout gBagS = new GridBagLayout();
		tabS.setLayout(gBagS);
		GridBagConstraints gbcS = new GridBagConstraints();
		gbcS.insets = new Insets(5,10,5,10);
		gbcS.fill= GridBagConstraints.BOTH;
		
		//isi table produk
		TabelProduk tabelP = new TabelProduk();
		TabelProduk obTP = tabelP.getObject();
		isiP.add(tabelP.getPanel());
		
		//isi table suplier
		TabelSuplier tabelS = new TabelSuplier();
		isiS.add(tabelS.getPanel());
		TabelSuplier obTS= tabelS.getObject();
		
		//input produk
		MainInput mi = new MainInput(obTP,obTS);
		inputP.add(mi.getPanel());
		
		//input suplier
		InputSuplier is = new InputSuplier(obTS);
		inputS.add(is.getPanel());
		
		
		//memasukkan panel kedalam tab produk
		// tabP.add(isiP);
		gbcP.gridwidth=1;
		gbcP.gridheight=2;
		gbcP.gridy=0;
		gbcP.gridx=0;
		gBagP.setConstraints(isiP,gbcP);
		tabP.add(isiP,gbcP);
		
		// tabP.add(inputP);
		gbcP.gridwidth=1;
		gbcP.gridheight=1;
		gbcP.gridy=0;
		gbcP.gridx=1;
		gBagP.setConstraints(inputP,gbcP);
		tabP.add(inputP,gbcP);
		
		//memasukkan panel tabP ke scroll pane
		scrTabP = new JScrollPane(tabP);
		tabMenu.addTab("produk",scrTabP);
		
		
		//memasukkan panel kedalam tab suplier
		// tabS.add(isiS);
		gbcS.gridwidth=1;
		gbcS.gridheight=2;
		gbcS.gridy=0;
		gbcS.gridx=0;
		gBagS.setConstraints(isiS,gbcS);
		tabS.add(isiS,gbcS);
		
		// tabS.add(inputS);
		gbcS.gridwidth=1;
		gbcS.gridheight=1;
		gbcS.gridy=0;
		gbcS.gridx=1;
		gBagS.setConstraints(inputS,gbcS);
		tabS.add(inputS,gbcS);
		
		//masukkan tabS ke dalam scroll
		scrTabS = new JScrollPane(tabS);
		tabMenu.addTab("suplier",scrTabS);
		
		fr.setSize(1000,600);
		//fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
	}
	
	public void setTampil(boolean tampil){
		fr.setVisible(tampil);
	}
}
