package GUI;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
	

public class Join extends JPanel {
	
private JButton btnMenuB;
	
	public Join() {
		setLayout(null);
		

		btnMenuB = new JButton("Back to menu");
		btnMenuB.setBounds(207, 242, 200, 29);
		add(btnMenuB);
		
	}
	
	public void addActionListener(ActionListener l) {
		btnMenuB.addActionListener(l);
		
	}
	
	
	public JButton btnMenuB() {
		return btnMenuB;
	}
	}


