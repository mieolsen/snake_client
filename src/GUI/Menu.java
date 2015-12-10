package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Menu extends JPanel {

	private JButton btnCreate;
	private JButton btnJoin;
	private JButton btnDelete;
	private JButton btnHighscore;
	private JButton btnLogout;
	private JButton btnDeleteUser;
	private JButton btnStart;
	
	public Menu() {
	
		setLayout(null);
		 
		btnCreate = new JButton("Create Game");
		btnCreate.setBounds(92, 26, 117, 29);
		add(btnCreate);
		
		btnJoin = new JButton("Join Game");
		btnJoin.setBounds(92, 79, 117, 29);
		add(btnJoin);
		
		btnDelete = new JButton("Delete Game");
		btnDelete.setBounds(235, 79, 117, 29);
		add(btnDelete);
		
		btnHighscore = new JButton("Highscore");
		btnHighscore.setBounds(92, 141, 117, 29);
		add(btnHighscore);
		
		btnLogout = new JButton("Log out");
		btnLogout.setBounds(166, 244, 117, 29);
		add(btnLogout);
		
		btnDeleteUser = new JButton("Delete user");
		btnDeleteUser.setBounds(235, 141, 117, 29);
		add(btnDeleteUser);
		
		btnStart = new JButton("Start game");
		btnStart.setBounds(235, 26, 117, 29);
		add(btnStart);
		
	}
	
	public void addActionListener(ActionListener l) {
		btnCreate.addActionListener(l);
		btnJoin.addActionListener(l);
		btnDelete.addActionListener(l);
		btnHighscore.addActionListener(l);
		btnLogout.addActionListener(l);
		btnDeleteUser.addActionListener(l);
		btnStart.addActionListener(l);
	}
	
	public JButton getBtnCreate() {
		return btnCreate;
	}
	public JButton getBtnJoin() {
		return btnJoin;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JButton getBtnHighscore() {
		return btnHighscore;
	}
	public JButton getBtnLogout() {
		return btnLogout;
	}
	public JButton getBtnDeleteUser() {
		return btnDeleteUser;
	}
	public JButton getBtnStart() {
		return btnStart;
	}
}