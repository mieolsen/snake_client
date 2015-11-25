package Logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.Frame;


public class Controller {
	
	
	
	
/** 
	 * Declares a private reference variable to Frame class
	 * called frame.
	 */
	private Frame frame;
	
	
public Controller()  {
		
		/*
		 * Initializes referenced variables as objects.
		 */
		frame = new Frame();
		
		/*
		 * Sets visible for frame object to true,
		 * which means it will show.
		 */
		frame.setVisible(true);
		
}

/**
 * Public method run.
 * The method is called by the main class, and it 
 * initializes the action-listeners, and runs the
 * application.
 */
public void run(){
	
	frame.getLogin().addActionListener(new LoginActionListener());
	
	frame.getMenu().addActionListener(new MenuActionListener());
	
	frame.getCreate().addActionListener(new CreateActionListener());
	
	frame.getJoin().addActionListener(new JoinActionListener());
	
	frame.getHighscore().addActionListener(new HighscoreActionListener());
	
	frame.getDelete().addActionListener(new DeleteActionListener());
	 
	/* Makes the object, frame, show the Login panel,
	 * as referenced in the CardLayout.
	 */
	frame.show(Frame.LOGIN);
}

	private class LoginActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
			 if (e.getSource() == frame.getLogin().getbtnLogin()){
				frame.show(Frame.MENU);
			} 
			
	}
}



/**
 * The listener interface for receiving MenuAction events.
 */
	private class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		
		//Show the Login panel, if LogOut button is clicked
		if (e.getSource() == frame.getMenu().getBtnLogout()){
			frame.show(Frame.LOGIN);
		}
		//Show the Join panel, if Join button is clicked
		if (e.getSource() == frame.getMenu().getBtnJoin()){
			frame.show(Frame.JOIN);
		}
		//Show the create panel, if create button is clicked
		if (e.getSource() == frame.getMenu().getBtnCreate()){
			frame.show(Frame.CREATE);
		}
		
		//Show the highscore panel, if highscore button is clicked
			if (e.getSource() == frame.getMenu().getBtnHighscore()){
			frame.show(Frame.HIGHSCORE);
		}
				
		//Show the delete panel, if delete button is clicked
			if (e.getSource() == frame.getMenu().getBtnDelete()){
			frame.show(Frame.DELETE);
		}
			
	}
}

	
	private class CreateActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
					
					// If the Back button is clicked, show UserMenu panel in frame.
					if (e.getSource() == frame.getCreate().btnMenuBack()){
						frame.getCreate();
						frame.show(frame.MENU);
						}
			}	
		}
	private class JoinActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
			
					// If the Back button is clicked, show UserMenu panel in frame.
					if (e.getSource() == frame.getJoin().btnMenuB()){
						frame.getJoin();
						frame.show(frame.MENU);
						}
	}	
}
	private class HighscoreActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
				
				// If the Back button is clicked, show UserMenu panel in frame.
				if (e.getSource() == frame.getHighscore().btnMenuBa()){
					frame.getHighscore();
					frame.show(frame.MENU);
					}
		}	
	}
	private class DeleteActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
				
				// If the Back button is clicked, show UserMenu panel in frame.
				if (e.getSource() == frame.getDelete().btnMenuBack()){
					frame.getDelete();
					frame.show(frame.MENU);
					}
		}	
	}
	
	
	
	}
	



