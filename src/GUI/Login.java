package GUI;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JPanel {
	
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	
	public Login() {
		setLayout(null);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(207, 242, 79, 29);
		add(btnLogin);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(98, 85, 62, 16);
		add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(98, 129, 59, 16);
		add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(228, 79, 179, 28);
		add(txtUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(228, 123, 179, 28);
		add(passwordField);
	}
	public void addActionListener(ActionListener l) {
		btnLogin.addActionListener(l);
		
	}
	
	public JButton getbtnLogin() {
		return btnLogin;
	}
	
}
