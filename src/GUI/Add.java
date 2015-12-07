package GUI;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Add extends JPanel {

	private JButton btnMenuBack;
	private JButton btnAdd;
	
	private JTextField txtfirstName;
	private JTextField txtlastName;
	private JTextField txtuserName;
	private JTextField txtpassword;
	private JTextField txtemail;
	


	public Add() {
		setLayout(null);


		btnMenuBack = new JButton("Back to menu");
		btnMenuBack.setBounds(207, 242, 200, 29);
		add(btnMenuBack);


		btnAdd = new JButton("Sign up");
		btnAdd.setBounds(36, 242, 137, 29);
		add(btnAdd);

		txtfirstName = new JTextField();
		txtfirstName.setText("First name");
		txtfirstName.setBounds(115, 27, 179, 28);
		add(txtfirstName);

		txtlastName = new JTextField();
		txtlastName.setText("Last name");
		txtlastName.setBounds(115, 67, 179, 28);
		add(txtlastName);

		txtuserName = new JTextField();
		txtuserName.setText("Username");
		txtuserName.setBounds(115, 107, 179, 28);
		add(txtuserName);

		txtpassword = new JTextField();
		txtpassword.setText("Password");
		txtpassword.setBounds(115, 147, 179, 28);
		add(txtpassword);


		txtemail = new JTextField();
		txtemail.setText("Email");
		txtemail.setBounds(115, 187, 179, 28);
		add(txtemail);
		
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
	public String getfirstName() {
		return txtfirstName.getText();
	}

	public String getlastName() {
		return txtlastName.getText();
	}
	public String getuserName() {
		return txtuserName.getText();
	}

	public String getpassword() {
		return txtpassword.getText();
	}

	public String getemail() {
		return txtemail.getText();
	}
	
}



