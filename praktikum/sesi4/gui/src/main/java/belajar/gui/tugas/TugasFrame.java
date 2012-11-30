package belajar.gui.tugas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

import java.awt.*;
import javax.swing.*;


public class TugasFrame{
	private JFrame frame;
	private JLabel lHeader;
	private JLabel lNim;
	private JLabel lNama;
	private JLabel lHobi;
	private JLabel lJekel;
	private JTextField tfNim;
	private JTextField tfNama;
	private JCheckBox cbBola;
	private JCheckBox cbNyanyi;
	private JCheckBox cbBasket;
	private JRadioButton rbPria;
	private JRadioButton rbWanita;
	private JButton bSimpan;
	private JButton bBatal;
	
	
	public TugasFrame(){
		frame = new JFrame("input mahasiswa");
		lHeader = new JLabel("Entry Data");
		lNim = new JLabel("Nim");
		lNama = new JLabel("Nama");
		lHobi = new JLabel("hobi");
		lJekel = new JLabel("Jenis Kelamin");
		tfNim = new JTextField(20);
		tfNama = new JTextField(20);
		cbBola = new JCheckBox("Sepakbola");
		cbNyanyi = new JCheckBox("Menyanyi");
		cbBasket = new JCheckBox("Basket");
		rbPria = new JRadioButton("Pria");
		rbWanita = new JRadioButton("Wanita");
		bSimpan = new JButton("Simpan");
		bBatal = new JButton("Batal");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbPria);
		group.add(rbWanita);
		
		JPanel pGrid1 = new JPanel(new GridLayout(4,1));
		JPanel pGrid2 = new JPanel(new GridLayout(4,1));
		JPanel pflow = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
		JPanel pborder = new JPanel(new BorderLayout());
		
		JPanel pCheck = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		JPanel pRadio = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		JPanel ptf1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel ptf2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pl1 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,8));
		JPanel pl2 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,7));
		JPanel pl3 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));
		JPanel pl4 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,2));
		JPanel pheader = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
		JPanel pfooter = new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
		
		pCheck.add(cbBola);
		pCheck.add(cbNyanyi);
		pCheck.add(cbBasket);
		
		pRadio.add(rbPria);
		pRadio.add(rbWanita);
		
		ptf1.add(tfNim);
		ptf2.add(tfNama);
		
		pl1.add(lNim);
		pl2.add(lNama);
		pl3.add(lHobi);
		pl4.add(lJekel);
		
		pheader.add(lHeader);
		pfooter.add(bSimpan);
		pfooter.add(bBatal);
		
		pGrid1.add(pl1);
		pGrid1.add(pl2);
		pGrid1.add(pl3);
		pGrid1.add(pl4);
		
		pGrid2.add(ptf1);
		pGrid2.add(ptf2);
		pGrid2.add(pCheck);
		pGrid2.add(pRadio);
		
		pflow.add(pGrid1);
		pflow.add(pGrid2);
		
		pborder.add(pheader,"North");
		pborder.add(pfooter,"South");
		pborder.add(pflow,"Center");
		
		frame.getContentPane().add(pborder);
		
		frame.setSize(500,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		new TugasFrame();
	}
}
