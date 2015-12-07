package Logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GUI.Frame;

public class Controller {

	

	private Frame frame;
	Client client = Client.create();

	public Controller()  {

		frame = new Frame();
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

		frame.getAdd().addActionListener(new AddActionListener());

	
		
		/* Makes the object, frame, show the Login panel,
		 * as referenced in the CardLayout.
		 */
		frame.show(Frame.LOGIN);
	}

	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == frame.getLogin().getbtnLogin()) {

				JSONObject json = new JSONObject();
				json.put("userName", frame.getLogin().getUsername());
				json.put("password", frame.getLogin().getPassword());
				WebResource webResource = client.resource("http://localhost:9998/api/login/");


				ClientResponse response;
				try {
					response = webResource.accept("application/json").
							post(ClientResponse.class,json.toString());

					if(response.getStatus() == 200) {
						frame.show(Frame.MENU);
					}
					else if(response.getStatus() == 400) {

						JOptionPane.showMessageDialog(frame, "Wrong username or password",
								"Wrong login", JOptionPane.WARNING_MESSAGE);
					}

					else {// Alt andet than 400 & 200
						JOptionPane.showMessageDialog(frame, "Something went wrong",
								"Error", JOptionPane.WARNING_MESSAGE);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Server not running",
							"Server error", JOptionPane.WARNING_MESSAGE);
				}
			} 
			
			
			//Show the add panel, if add button is clicked
			if (e.getSource() == frame.getLogin().getbtnAddUser()){
				frame.show(Frame.ADD);
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
			else if (e.getSource() == frame.getMenu().getBtnJoin()){
				frame.show(Frame.JOIN);
			}
			//Show the create panel, if create button is clicked
			else if (e.getSource() == frame.getMenu().getBtnCreate()){
				frame.show(Frame.CREATE);
			}

			//Show the highscore panel, if highscore button is clicked
			else if (e.getSource() == frame.getMenu().getBtnHighscore()){
				frame.show(Frame.HIGHSCORE);
			}

			//Show the delete panel, if delete button is clicked
			else if (e.getSource() == frame.getMenu().getBtnDelete()){
				frame.show(Frame.DELETE);
			}

			
		}
	}


	private class CreateActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){


			if (e.getSource() == frame.getCreate().getBtnCreate()) {


				JSONObject json = new JSONObject();
				json.put("gameName", frame.getCreate().getGameName());
				json.put("host", frame.getCreate().getHost());
				json.put("opponent", frame.getCreate().getOpponent());
				json.put("hostControls", frame.getCreate().getHostControls());
				json.put("mapSize", frame.getCreate().getTxtMapSize());
				
				WebResource webResource = client.resource("http://localhost:9998/api/game/");


				ClientResponse response;
				try {
					response = webResource.accept("application/json").
							post(ClientResponse.class,json.toString());

					if(response.getStatus() == 201) {
						frame.show(Frame.MENU);
						JOptionPane.showMessageDialog(frame, "Game was created",
								"Succes", JOptionPane.PLAIN_MESSAGE);
					}
				
				
					else {// Alt andet than  201
						JOptionPane.showMessageDialog(frame, "Something went wrong",
								"Error", JOptionPane.WARNING_MESSAGE);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Server not running",
							"Server error", JOptionPane.WARNING_MESSAGE);
				}
			} 


			// If the Back button is clicked, show UserMenu panel in frame.
			if (e.getSource() == frame.getCreate().getbtnMenuBack()){
				frame.getCreate();
				frame.show(Frame.MENU);
			} 
		}	
	}
	private class JoinActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){


			
			
			// If the Back button is clicked, show UserMenu panel in frame.
			if (e.getSource() == frame.getJoin().btnMenuBack()){
				frame.getJoin();
				frame.show(Frame.MENU);
			}
		}	
	}
	private class HighscoreActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			// If the Back button is clicked, show UserMenu panel in frame.
			if (e.getSource() == frame.getHighscore().btnMenuBack()){
				frame.getHighscore();
				frame.show(Frame.MENU);
			}
		}	
	}



	private class AddActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){


			if (e.getSource() == frame.getAdd().getbtnAdd()) {

				JSONObject json = new JSONObject();
				
				json.put("firstName", frame.getAdd().getfirstName());
				json.put("lastName", frame.getAdd().getlastName());
				json.put("userName", frame.getAdd().getuserName());
				json.put("password", frame.getAdd().getpassword());
				json.put("email", frame.getAdd().getemail());
				
				WebResource webResource = client.resource("http://localhost:9998/api/user/");


				ClientResponse response;
				try {
					response = webResource.accept("application/json").
							post(ClientResponse.class,json.toString());

					if(response.getStatus() == 200) {
						frame.show(Frame.LOGIN);
						JOptionPane.showMessageDialog(frame, "user added",
								"Succes", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(response.getStatus() == 400) {
					System.out.println(response.getEntity(String.class).toString());
					} 
				
				
				
					else {// Alt andet than  200
						System.out.println("Omg omg omg, jeg mangler en label i koden til at give user feedback ;)");
						System.out.println("Status:" + response.getStatus());
						System.out.println("Response: " + response.getEntity(String.class).toString());	
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Server not running",
							"Server error", JOptionPane.WARNING_MESSAGE);
				}
			} 

			if (e.getSource() == frame.getAdd().getbtnMenuBack()){
				frame.getAdd();
				frame.show(Frame.MENU);
			}
		}	
	}
	
	private class DeleteActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){


			if (e.getSource() == frame.getDelete().getBtnDelelte()) {

				
				JSONObject json = new JSONObject();
				
				json.put("gameId", frame.getDelete().getTxtGameId());
				
				
				WebResource webResource = client.resource("http://localhost:9998/api/game/");
				ClientResponse response;
				try {
					response = webResource.accept("application/json").
							delete(ClientResponse.class,json.toString());

					if(response.getStatus() == 200) {
						frame.show(Frame.MENU);
						JOptionPane.showMessageDialog(frame, "Game deleted",
								"Succes", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(response.getStatus() == 400) {
					System.out.println(response.getEntity(String.class).toString());
					} 
				
					else {// Alt andet than  200
						System.out.println("Omg omg omg, jeg mangler en label i koden til at give user feedback ;)");
						System.out.println("Status:" + response.getStatus());
						System.out.println("Response: " + response.getEntity(String.class).toString());	
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Server not running",
							"Server error", JOptionPane.WARNING_MESSAGE);
				}
			} 

			if (e.getSource() == frame.getDelete().btnMenuBack()){
				frame.getDelete();
				frame.show(Frame.MENU);
			}
		}	
	}
	
	
}




