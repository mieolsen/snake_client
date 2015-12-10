package GUI;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteUser extends JPanel {

	private JButton btnMenuBack;
	private JButton btnDelete;
	private JTextField txtUserId;
	
	public DeleteUser() {
		setLayout(null);
		
		
		
		btnMenuBack = new JButton("Back to menu");
		btnMenuBack.setBounds(244, 242, 200, 29);
		add(btnMenuBack);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(20, 242, 200, 29);
		add(btnDelete);
		
		txtUserId = new JTextField("User ID");
		txtUserId.setBounds(133, 83, 200, 29);
		add(txtUserId);
	}
	
	public void addActionListener(ActionListener l) {
		btnMenuBack.addActionListener(l);
		btnDelete.addActionListener(l);
	}
	
	
	public JButton btnMenuBack() {
		return btnMenuBack;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JTextField getTxtUserId() {
		return txtUserId;
	}
}
	

