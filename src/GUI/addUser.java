package GUI;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class addUser extends JFrame {
	private JButton btnMenuBack;
	private JButton btnAdd;
	private JTextField txtGameName;
	private JTextField txtHost;
	private JTextField txtOpponent;
	
	public addUser() {
		setLayout(null);
		

		btnMenuBack = new JButton("Back to menu");
		btnMenuBack.setBounds(207, 242, 200, 29);
		add(btnMenuBack);
		

		btnAdd = new JButton("Add User");
		btnAdd.setBounds(36, 242, 137, 29);
		add(btnAdd);
		
		txtGameName = new JTextField();
		txtGameName.setBounds(122, 46, 179, 28);
		add(txtGameName);
		
		txtHost = new JTextField();
		txtHost.setBounds(122, 112, 179, 28);
		add(txtHost);
		
		txtOpponent = new JTextField();
		txtOpponent.setBounds(122, 182, 179, 28);
		add(txtOpponent);
	}
	
	public void addActionListener(ActionListener l) {
		btnMenuBack.addActionListener(l);
		btnAdd.addActionListener(l);
	}
	
	
	public JButton getbtnMenuBack() {
		return btnMenuBack;
	}
	
	public JButton getbtnAdd() {
		return btnAdd;
	}
	public String getGameName() {
		return txtGameName.getText();
	}
	
	public String getHost() {
		return txtHost.getText();
	}
	public String getOpponent() {
		return txtOpponent.getText();
	}
	
}


