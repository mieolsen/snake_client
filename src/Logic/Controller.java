package Logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Score;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GUI.Frame;
import GUI.Highscore;

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

		frame.getDeleteUser().addActionListener(new DeleteUserActionListener());

		frame.getStart().addActionListener(new StartActionListener());

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

			//Show the delete user panel, if delete user button is clicked
			else if (e.getSource() == frame.getMenu().getBtnDeleteUser()){
				frame.show(Frame.DELETEUSER);
			}

			//Show the Start panel, if Start button is clicked
			else if (e.getSource() == frame.getMenu().getBtnStart()){
				frame.show(Frame.START);
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

			if (e.getSource() == frame.getJoin().getBtnJoin()) {


				JSONObject json = new JSONObject();
				json.put("opponenetUserId", frame.getJoin().getOpponenetUserId());
				json.put("opponenetControls", frame.getJoin().getOpponenetControls());
				json.put("gameId", frame.getJoin().getGameid());

				System.out.println(frame.getJoin().getOpponenetUserId());
				System.out.println(frame.getJoin().getOpponenetControls());
				System.out.println(frame.getJoin().getGameid());
				WebResource webResource = client.resource("http://localhost:9998/api/game/join/");


				ClientResponse response;
				try {
					response = webResource.
							post(ClientResponse.class,json.toString());

					if(response.getStatus() == 200) {
						frame.show(Frame.MENU);
						JOptionPane.showMessageDialog(frame, "Game was Joined",
								"Succes", JOptionPane.PLAIN_MESSAGE);
					}


					else {// Alt andet than  200
						JOptionPane.showMessageDialog(frame, "Something went wrong",
								"Error", JOptionPane.WARNING_MESSAGE);
						System.out.println("Status:" + response.getStatus());
						System.out.println("Response: " + response.getEntity(String.class).toString());	
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Server not running",
							"Server error", JOptionPane.WARNING_MESSAGE);
				}
			} 


			// If the Back button is clicked, show UserMenu panel in frame.
			if (e.getSource() == frame.getJoin().btnMenuBack()){
				frame.getJoin();
				frame.show(Frame.MENU);
			}
		}	
	}
	private class HighscoreActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == frame.getHighscore().btnHighscore()){

				WebResource webResource = client.resource("http://localhost:9998/api/scores/");


				ClientResponse response;
				try {
					response = webResource.
							get(ClientResponse.class);

					if(response.getStatus() == 200) {

						//System.out.println(response.getEntity(String.class));
						Score[] scores = new Gson().fromJson(response.getEntity(String.class), Score[].class);

						Highscore highscore = frame.getHighscore();
						for(int i = 0 ; i < scores.length ; i++){
							Object[] data = {
									i+1,
									scores[i].getUser().getUserName(),
									scores[i].getScore(),
							};
							highscore.addHighscoreRow(data);
						}


					}


					else {// Alt andet than  200
						JOptionPane.showMessageDialog(frame, "Something went wrong",
								"Error", JOptionPane.WARNING_MESSAGE);

					}
					System.out.println("code: " + response.getStatus());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Server not running",
							"Server error", JOptionPane.WARNING_MESSAGE);
					System.err.println(e1.getMessage());
				}
			} 



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


				WebResource webResource = client.resource("http://localhost:9998/api/game/" + frame.getDelete().getTxtGameId().getText());
				System.out.println("http://localhost:9998/api/game/" + frame.getDelete().getTxtGameId().getText());
				ClientResponse response;
				try {
					response = webResource.
							delete(ClientResponse.class);

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

	private class DeleteUserActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){


			if (e.getSource() == frame.getDeleteUser().getBtnDelete()) {

				JSONObject json = new JSONObject();

				WebResource webResource = client.resource("http://localhost:9998/api/user/" + frame.getDeleteUser().getTxtUserId().getText());

				ClientResponse response;
				try {
					response = webResource.
							delete(ClientResponse.class);

					if(response.getStatus() == 200) {
						frame.show(Frame.MENU);
						JOptionPane.showMessageDialog(frame, "User deleted",
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

			if (e.getSource() == frame.getDeleteUser().btnMenuBack()){
				frame.getDelete();
				frame.show(Frame.MENU);
			} 
		}
	}

	private class StartActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){


			if (e.getSource() == frame.getStart().getBtnStart()) {


				JSONObject json = new JSONObject();


				WebResource webResource = client.resource("http://localhost:9998/api/startgame/" + frame.getStart().getGameid());

				ClientResponse response;
				try {
					response = webResource.
							get(ClientResponse.class);

					if(response.getStatus() == 200) {
						frame.show(Frame.MENU);
						JOptionPane.showMessageDialog(frame, "Game startet",
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

