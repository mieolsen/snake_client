package GUI;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
	

public class Join extends JPanel {
	
private JTextField gameid;
private JTextField opponenetUserId;
private JTextField opponenetControls;
private JButton btnMenuBack;
private JButton btnJoin;
	public Join() {
		setLayout(null);
		

		btnMenuBack = new JButton("Back to menu");
		btnMenuBack.setBounds(229, 242, 200, 29);
		add(btnMenuBack);
		
		btnJoin = new JButton("Join");
		btnJoin.setBounds(17, 242, 200, 29);
		add(btnJoin);
		
		gameid = new JTextField("Game Id");
		gameid.setBounds(131, 27, 200, 29);
		add(gameid);
		
		opponenetUserId = new JTextField("Your User Id");
		opponenetUserId.setBounds(131, 90, 200, 29);
		add(opponenetUserId);
		
		opponenetControls = new JTextField("Controls");
		opponenetControls.setBounds(131, 161, 200, 29);
		add(opponenetControls);
		
	}
	
	public void addActionListener(ActionListener l) {
		btnMenuBack.addActionListener(l);
		btnJoin.addActionListener(l);
	}
	
	public JButton btnMenuBack() {
		return btnMenuBack;
	}
	
	public JButton getBtnJoin() {
		return btnJoin;
	}
	
	public String getGameid() {
		return gameid.getText();
	}
	public String getOpponenetUserId() {
		return opponenetUserId.getText();
	}
	
	public String getOpponenetControls() {
		return opponenetControls.getText();
	}
	}


