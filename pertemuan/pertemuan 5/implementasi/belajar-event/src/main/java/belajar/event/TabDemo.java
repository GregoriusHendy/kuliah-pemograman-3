package belajar.event;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class TabDemo {
    public static void main(String[] xx){
        // 0. Bikin Frame
        JFrame fr = new JFrame("Demo Tab");
        
        // 1. Set size
        fr.setSize(400,400);
        
        // 2. Tambahkan panel
        JTabbedPane isi = new JTabbedPane();
        isi.setTabPlacement(JTabbedPane.BOTTOM);
        fr.getContentPane().add(isi);
                
        // 3. Tambahkan komponen
        final JRadioButton rbPria = new JRadioButton("Pria");
        final JRadioButton rbWanita = new JRadioButton("Wanita");
        
        // dalam satu group harus pilih salah satu
        ButtonGroup bgJenis = new ButtonGroup();
        bgJenis.add(rbPria);
        bgJenis.add(rbWanita);
        
        JPanel pnlJenis = new JPanel();
        pnlJenis.add(new JLabel("Jenis Kelamin : "));
        pnlJenis.add(rbPria);
        pnlJenis.add(rbWanita);
        isi.addTab("Jenis Kelamin",pnlJenis);
		
		class EventGender implements ActionListener{
			public void actionPerformed(ActionEvent e){
				String nama = e.getValue();
				JOptionPane.showMessageDialog(null, "Terjadi even pada radio button"+nama);
			}
		}
		//pasang listener
		EventGender eg = new EventGender();
		rbPria.addActionListener(eg);
		rbWanita.addActionListener(eg);
		
        //akhir dari tab pertama
		
        JCheckBox cbMembaca = new JCheckBox("Membaca");
        JCheckBox cbBerenang = new JCheckBox("Berenang");
        JPanel pnlHobi = new JPanel();
        pnlHobi.add(new JLabel("Hobi"));
        pnlHobi.add(cbMembaca);
        pnlHobi.add(cbBerenang);
        isi.addTab("Hobi",pnlHobi);
        //akhit tab 2
		
        JButton btnSimpan = new JButton("Simpan");
        JButton btnBatal = new JButton("Batal");
        btnBatal.setEnabled(false); // enable/disable
        JPanel pnlTombol = new JPanel();
        pnlTombol.add(btnSimpan);
        pnlTombol.add(btnBatal);
        isi.addTab("Proses",pnlTombol);
		//ahkit tab 3
        
        JSlider slider = new JSlider(
            JSlider.HORIZONTAL,
            0, // minimum
            100, // maksimum
            10 // posisi awal
        );
        
        JPanel pnlSlider = new JPanel();
        pnlSlider.add(new JLabel("Volume : "));
        pnlSlider.add(slider);
        isi.addTab("Slider", pnlSlider);
		
		//akhit tab 4
        
        int tahun = 2012;
        SpinnerModel spTahun = new SpinnerNumberModel(
            tahun,          // posisi awal
            tahun - 100,    // minimum
            tahun + 100,    // maksimum
            1               // increment/decrement
        );
        JSpinner spinner = new JSpinner(spTahun);
        spinner.setEditor(new JSpinner
                    .NumberEditor(spinner,"####"));
        JPanel pnlSpin = new JPanel();
        pnlSpin.add(new JLabel("Tahun : "));
        pnlSpin.add(spinner);
        isi.addTab("Spinner", pnlSpin);
        //akhir tab 5
		
		// class ListerMouse
		
        // 4. Tampilkan
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
