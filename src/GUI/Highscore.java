package GUI;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class Highscore extends JPanel {
	private JButton btnMenuBack;
	private JButton btnHighscore;
	private JTable list;
	
	
	public Highscore() {
		setLayout(null);
		
		

		btnHighscore = new JButton("highscore");
		btnHighscore.setBounds(30, 242, 153, 29);
		add(btnHighscore);
		
		btnMenuBack = new JButton("Back to menu");
		btnMenuBack.setBounds(205, 242, 200, 29);
		add(btnMenuBack);
		
		
		list = new JTable ();
		list.setBounds(65, 36, 304, 189);
		
		DefaultTableModel model = (DefaultTableModel) list.getModel();

		add(list);
		model.addColumn("");
		model.addColumn("");
		model.addColumn("");
		
	}
	
	public void addHighscoreRow(Object[] data) {
		DefaultTableModel model = (DefaultTableModel) list.getModel();
		model.addRow(data);
		this.updateUI();
	}
	
	public void addActionListener(ActionListener l) {
		btnMenuBack.addActionListener(l);
		btnHighscore.addActionListener(l);
	}
	
	
	public JButton btnMenuBack() {
		return btnMenuBack;
	}
	public JButton btnHighscore() {
		return btnHighscore;
	}
}
