package source.produk.input;

import source.produk.TabelProduk;
import source.suplier.TabelSuplier;
import source.produk.input.baru.InputProduk;
import source.produk.input.masuk.InputMasuk;
import source.produk.input.keluar.InputKeluar;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainInput{
	private JButton bBaru;
	private JButton bMasuk;
	private JButton bKeluar;
	
	private JPanel panelUtama;	
	private JPanel panelButton;	
	private final JPanel panelIsi;	
	
	public MainInput(final TabelProduk tp,final TabelSuplier ts){	
		
		panelUtama = new JPanel(new BorderLayout());
		panelButton = new JPanel();
		panelIsi = new JPanel();
		
		
		//button
		bBaru = new JButton("input produk");
		bMasuk =  new JButton("input pemasukkan");
		bKeluar =  new JButton("input pengeluaran");
		panelButton.add(bBaru);
		panelButton.add(bMasuk);
		panelButton.add(bKeluar);
		panelUtama.add(panelButton,"North");
		
		InputProduk ip = new InputProduk(tp,ts);
		panelIsi.add(ip.getPanel());
		setIsiPanelIsi();
		
		class ButtonListener implements MouseListener{
			public void mouseClicked(MouseEvent me){
				Component c = me.getComponent();
				JButton bKlik = (JButton) c;
				String labelB = bKlik.getText();
				
				if(labelB.equals("input produk")){
					InputProduk ip = new InputProduk(tp,ts);
					panelIsi.removeAll();
					panelIsi.add(ip.getPanel());
					setIsiPanelIsi();
				}else if(labelB.equals("input pemasukkan")){
					InputMasuk im = new InputMasuk(tp);
					panelIsi.removeAll();
					panelIsi.add(im.getPanel());
					setIsiPanelIsi();
				}else if(labelB.equals("input pengeluaran")){
					InputKeluar ik = new InputKeluar(tp);
					panelIsi.removeAll();
					panelIsi.add(ik.getPanel());
					setIsiPanelIsi();
				}
			}
			public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
		}
		
		ButtonListener li = new ButtonListener();
		bBaru.addMouseListener(li);
		bMasuk.addMouseListener(li);
		bKeluar.addMouseListener(li);		
	}
	
	public void setIsiPanelIsi(){
		panelUtama.add(panelIsi,"Center");
	}
	
	public JPanel getPanel(){
		return panelUtama;
	}
}