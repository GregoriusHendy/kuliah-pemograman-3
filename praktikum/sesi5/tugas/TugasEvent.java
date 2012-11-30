import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TugasEvent{
	public static void main(String[] args){
		JFrame fr = new JFrame("latihan praktikum 5");
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,70));
		final JButton b1= new JButton("Click me");
		panel.add(b1);
		
		class EventButton implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,"You Click me :D");
			}
		}
		
		EventButton eb = new EventButton();
		b1.addActionListener(eb);
		
		fr.setLocationRelativeTo(null);
		fr.getContentPane().add(panel);
		fr.setSize(200,200);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
}