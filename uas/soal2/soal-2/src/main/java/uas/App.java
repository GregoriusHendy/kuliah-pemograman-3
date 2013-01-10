package uas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class App extends Koneksi{
	private JFrame fr;
	private JTextField tfUname;
	private JPasswordField pfPass;
	private JButton bLogin;
	private JButton bClose;
	
	private JPanel panelUtama;
	private JPanel panelLog;
	
	public App(){
		fr = new JFrame("logins");
		tfUname = new JTextField(20);
		pfPass = new JPasswordField(20);
		bLogin = new JButton("login");
		bClose = new JButton("close");
		
		panelUtama = new JPanel(new BorderLayout());
		panelLog = new JPanel();
		
		panelUtama.add(panelLog,"Center");
		panelUtama.add(new JLabel("Copyright(c) sidratul 2013"),"South");
		
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
		gBag.setConstraints(tfUname,gbc);
		panelLog.add(tfUname,gbc);
		
		gbc.gridy =1;
		gbc.gridx =1;
		gBag.setConstraints(pfPass,gbc);
		panelLog.add(pfPass,gbc);
		
		gbc.gridwidth=1;
		gbc.gridy =2;
		gbc.gridx =1;
		gBag.setConstraints(bLogin,gbc);
		panelLog.add(bLogin,gbc);
		
		gbc.gridwidth=1;
		gbc.gridy =2;
		gbc.gridx =2;
		gBag.setConstraints(bClose,gbc);
		panelLog.add(bClose,gbc);
		
		class loginListener implements ActionListener{
			public void actionPerformed(ActionEvent ev){
				String username = tfUname.getText();
				String pass = pfPass.getText();
				try{										
					String query="SELECT * FROM login WHERE username='"+username+"' AND password='"+pass+"'";
					ResultSet rs = stm.executeQuery(query);
					if(rs.next()){
						fr.setVisible(false);
						/* Tab t= new Tab();
						t.setTampil(true); */
						JOptionPane.showMessageDialog(null,"selamat datang "+username);
					}else{						
						JOptionPane.showMessageDialog(null,"kombinasi username dan password anda salah");
					}
				}catch(SQLException SQLerr){
					SQLerr.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				} 
			}
		}
		
		bLogin.addActionListener(new loginListener());
		
		class CloseListener implements ActionListener{
			public void actionPerformed(ActionEvent ev){
				
			}
		
		}
		
		bClose.addActionListener(new CloseListener());
		
		
		fr.getContentPane().add(panelUtama);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setSize(400,200);
		fr.setResizable(false);
		fr.setVisible(true);
	}
	
    public static void main( String[] args ){
        new App();
    }
}
