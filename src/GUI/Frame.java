package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Frame extends JFrame {
	
	/** The Constants. Equal to the CardLayout id-number.*/
	public static final String MENU = "name_0001";
	public static final String LOGIN = "name_0002";
	public static final String JOIN = "name_0003";
	public static final String CREATE = "name_0004";
	public static final String HIGHSCORE = "name_0005";
	public static final String DELETE = "name_0006";
	
	/** Declare private reference variable contentPane of type JPanel. */
	private JPanel contentPane;
	
	/** Declare private reference variable userLogin of type Menu. */
	private Menu menu;
	private Login login;
	private Join join;
	private Create create;
	private Highscore highscore;
	private Delete delete;
	
	/** Declare private reference variable c of type CardLayout.*/
	private CardLayout c;
	
		public Frame() {
			setTitle("Snake");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setLocationRelativeTo(null);

			contentPane = new JPanel();
			
			/*
			 * Runs setContentPane method from JFrame class. 
			 * Gives object contentPane as paramter.
			 */
			setContentPane(contentPane);
			
			// Initializes setLayout method from object. 
			contentPane.setLayout(new CardLayout(0, 0));
			
			
			

			// Initializes login, and adds the panel to object contentPane.
			login = new Login();
			contentPane.add(login, LOGIN);
			
			// Initializes menu, and adds the panel to object contentPane.
			menu = new Menu();
			contentPane.add(menu, MENU);
			
			// Initializes join, and adds the panel to object contentPane.
			join = new Join();
			contentPane.add(join, JOIN);
			
			// Initializes Create, and adds the panel to object contentPane.
			create = new Create();
			contentPane.add(create, CREATE);
			
			// Initializes highscore, and adds the panel to object contentPane.
			highscore = new Highscore();
			contentPane.add(highscore, HIGHSCORE);
						
			// Initializes Delete, and adds the panel to object contentPane.
			delete = new Delete();
			contentPane.add(delete, DELETE);
						
			/*
			 *  Instantiate c as the CardLayout by using
			 *  getLayout method from contentPane.
			 */
			c = (CardLayout) getContentPane().getLayout();
			}
		
	/* gets and return */
		public Login getLogin() {
			return login;
		}
		public Menu getMenu() {
			return menu;
		}
		public Join getJoin() {
			return join;
		}
		public Create getCreate() {
			return create;
		}
		public Highscore getHighscore() {
			return highscore;
		}	
		public Delete getDelete() {
			return delete;
		}
		/**
		 * Show.
		 *
		 * @param card the card
		 */
		public void show(String card) {
			c.show(this.getContentPane(), card);
		}
		
}