package GUI;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;

public class Create extends JPanel {

	
	private JButton btnMenuBack;
	
	public Create() {
		setLayout(null);
		

		btnMenuBack = new JButton("Back to menu");
		btnMenuBack.setBounds(207, 242, 200, 29);
		add(btnMenuBack);
		
	}
	
	public void addActionListener(ActionListener l) {
		btnMenuBack.addActionListener(l);
		
	}
	
	
	public JButton btnMenuBack() {
		return btnMenuBack;
	}
	
	
}
