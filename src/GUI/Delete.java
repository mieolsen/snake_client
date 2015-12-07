package GUI;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Delete extends JPanel {
	
	private JButton btnMenuBack;
	private JButton btnDelelte;
	private JTextField txtGameId;
	
	public Delete() {
		setLayout(null);
		
		
		
		btnMenuBack = new JButton("Back to menu");
		btnMenuBack.setBounds(244, 242, 200, 29);
		add(btnMenuBack);
		
		btnDelelte = new JButton("Delete");
		btnDelelte.setBounds(20, 242, 200, 29);
		add(btnDelelte);
		
		txtGameId = new JTextField("Game ID");
		txtGameId.setBounds(133, 83, 200, 29);
		add(txtGameId);
	}
	
	public void addActionListener(ActionListener l) {
		btnMenuBack.addActionListener(l);
		btnDelelte.addActionListener(l);
	}
	
	
	public JButton btnMenuBack() {
		return btnMenuBack;
	}
	public JButton getBtnDelelte() {
		return btnDelelte;
	}
	public JTextField getTxtGameId() {
		return txtGameId;
	}
}
