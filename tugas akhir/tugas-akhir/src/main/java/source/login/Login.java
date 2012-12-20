package source.login;

import source.tab.Tab;
import source.koneksi.Koneksi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends Koneksi{
	private final JFrame fr;
	private final JTextField tfUsername;
	private final JPasswordField pfPass;
	private JButton bLogin;
	private JPanel panelUtama;
		private JPanel panelPesan;
			private final JLabel lPesan;
		private JPanel panelLog;
	
	public Login(){
		fr = new JFrame("login");		
		tfUsername = new JTextField(20);
		pfPass = new JPasswordField(20);
		bLogin = new JButton("login");
		panelUtama = new JPanel(new BorderLayout());
			panelPesan = new JPanel();				
				lPesan = new JLabel();
			panelLog = new JPanel();
	
		panelUtama.add(panelPesan,"North");
		panelUtama.add(panelLog,"Center");
		
		//panel pesan
		panelPesan.add(lPesan);
		
		//panel log
		GridBagLayout gBag = new GridBagLayout();
		panelLog.setLayout(gBag);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,10,5,10);
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.gridy =0;
		gbc.gridx =0;
		panelLog.add(new JLabel("username"),gbc);
		
		gbc.gridy =1;
		panelLog.add(new JLabel("password"),gbc);
		
		gbc.gridwidth=2;
		gbc.gridy =0;
		gbc.gridx =1;
		gBag.setConstraints(tfUsername,gbc);
		panelLog.add(tfUsername,gbc);
		
		gbc.gridy =1;
		gbc.gridx =1;
		gBag.setConstraints(pfPass,gbc);
		panelLog.add(pfPass,gbc);
		
		gbc.gridwidth=1;
		gbc.gridy =2;
		gbc.gridx =1;
		gBag.setConstraints(bLogin,gbc);
		panelLog.add(bLogin,gbc);
		
		class loginListener implements ActionListener{
			public void actionPerformed(ActionEvent ev){
				String username = tfUsername.getText();
				String pass = pfPass.getText();
				try{										
					String query="SELECT * FROM admin WHERE username='"+username+"' AND password='"+pass+"'";
					ResultSet rs = stm.executeQuery(query);
					if(rs.next()){
						fr.setVisible(false);
						Tab t= new Tab();
						t.setTampil(true);
						JOptionPane.showMessageDialog(null,"selamat datang "+username);
					}else{						
						lPesan.setText("maaf, kombinasi username dan password salah");
					}
				}catch(SQLException SQLerr){
					SQLerr.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		bLogin.addActionListener(new loginListener());
		
		
		fr.getContentPane().add(panelUtama);
		fr.setLocationRelativeTo(null);
		fr.setSize(400,200);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public void setTampil(boolean tampil){
		fr.setVisible(tampil);
	}
	
}