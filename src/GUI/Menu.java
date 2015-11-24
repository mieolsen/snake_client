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
	
	
	public Menu() {
	
		setLayout(null);
		 
		btnCreate = new JButton("Create Game");
		btnCreate.setBounds(166, 26, 117, 29);
		add(btnCreate);
		
		btnJoin = new JButton("Join Game");
		btnJoin.setBounds(166, 79, 117, 29);
		add(btnJoin);
		
		btnDelete = new JButton("Delete Game");
		btnDelete.setBounds(166, 135, 117, 29);
		add(btnDelete);
		
		btnHighscore = new JButton("Highscore");
		btnHighscore.setBounds(166, 188, 117, 29);
		add(btnHighscore);
		
		btnLogout = new JButton("Log out");
		btnLogout.setBounds(166, 244, 117, 29);
		add(btnLogout);
		
	}
	
	public void addActionListener(ActionListener l) {
		btnCreate.addActionListener(l);
		btnJoin.addActionListener(l);
		btnDelete.addActionListener(l);
		btnHighscore.addActionListener(l);
		btnLogout.addActionListener(l);
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
	
}