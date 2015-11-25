package GUI;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Highscore extends JPanel {
	private JButton btnMenuBa;
	
	public Highscore() {
		setLayout(null);
		
		
		
		btnMenuBa = new JButton("Back to menu");
		btnMenuBa.setBounds(207, 242, 200, 29);
		add(btnMenuBa);
		
	}
	
	public void addActionListener(ActionListener l) {
		btnMenuBa.addActionListener(l);
		
	}
	
	
	public JButton btnMenuBa() {
		return btnMenuBa;
	}
}
