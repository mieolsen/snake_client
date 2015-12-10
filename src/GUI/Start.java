package GUI;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
	

public class Start extends JPanel {
	

private JTextField gameId;
private JButton btnMenuBack;
private JButton btnStart;
	
public Start() {
		setLayout(null);
		

		btnMenuBack = new JButton("Back to menu");
		btnMenuBack.setBounds(229, 242, 200, 29);
		add(btnMenuBack);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(17, 242, 200, 29);
		add(btnStart);
	
		
		gameId = new JTextField("Game ID");
		gameId.setBounds(131, 161, 200, 29);
		add(gameId);
		
	}
	
	public void addActionListener(ActionListener l) {
		btnMenuBack.addActionListener(l);
		btnStart.addActionListener(l);
	}
	
	public JButton btnMenuBack() {
		return btnMenuBack;
	}
	
	public JButton getBtnStart() {
		return btnStart;
	}
	
	public String getGameid() {
		return gameId.getText();
	}
}