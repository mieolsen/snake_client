package GUI;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Create extends JPanel {

	private JButton btnMenuBack;
	private JButton btnCreate;
	private JTextField txtGameName;
	private JTextField txtHost;
	private JTextField txtOpponent;
	private JTextField txtHostControls;
	private JTextField txtMapSize;
	public Create() {
		setLayout(null);
		

		btnMenuBack = new JButton("Back to menu");
		btnMenuBack.setBounds(207, 242, 200, 29);
		add(btnMenuBack);
		

		btnCreate = new JButton("Create");
		btnCreate.setBounds(36, 242, 137, 29);
		add(btnCreate);
		
		txtGameName = new JTextField();
		txtGameName.setText("Game name");
		txtGameName.setBounds(122, 46, 179, 28);
		add(txtGameName);
		
		txtHost = new JTextField();
		txtHost.setText("Host");
		txtHost.setBounds(122, 86, 179, 28);
		add(txtHost);
		
		txtHostControls = new JTextField();
		txtHostControls.setText("Host Controls");
		txtHostControls.setBounds(122, 126, 179, 28);
		add(txtHostControls);
		
		txtOpponent = new JTextField();
		txtOpponent.setText("Opponent");
		txtOpponent.setBounds(122, 166, 179, 28);
		add(txtOpponent);
		
		txtMapSize = new JTextField();
		txtMapSize.setText("Map size");
		txtMapSize.setBounds(122, 206, 179, 28);
		add(txtMapSize);
	}
	
	
	public void addActionListener(ActionListener l) {
		btnMenuBack.addActionListener(l);
		btnCreate.addActionListener(l);
	}
	
	
	public JButton getbtnMenuBack() {
		return btnMenuBack;
	}
	
	public JButton getBtnCreate() {
		return btnCreate;
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
	
	public String getHostControls() {
		return txtHostControls.getText();
	}
	
	public String getTxtMapSize() {
		return txtMapSize.getText();
	}
	
}
