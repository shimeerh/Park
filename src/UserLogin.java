import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField namefield;
	private JPasswordField passfield;
	int status;
	private JButton btnok;
	private JLabel lbpass;
	private JLabel lbname;
	
	public static void main(String[] args) {
		UserLogin frame = new UserLogin();
		frame.setVisible(true);
	}

	
	public UserLogin() {
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		namefield = new JTextField();
		namefield.setText("Enter username");
		namefield.setBounds(198, 49, 116, 22);
		contentPane.add(namefield);
		namefield.setColumns(10);
		
		lbname = new JLabel("UserId");
		lbname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbname.setForeground(new Color(255, 255, 255));
		lbname.setBounds(61, 52, 68, 16);
		contentPane.add(lbname);
		
		lbpass = new JLabel("Password");
		lbpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbpass.setForeground(new Color(255, 255, 255));
		lbpass.setBounds(61, 144, 68, 16);
		contentPane.add(lbpass);
		
		passfield = new JPasswordField();
		passfield.setText("Enter Password");
		passfield.setBounds(198, 141, 116, 22);
		contentPane.add(passfield);
		
		btnok = new JButton("Verify");
		btnok.setBackground(new Color(204, 255, 255));
		btnok.setBounds(125, 197, 97, 25);
		contentPane.add(btnok);
		
		btnok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	        	DB_conn db=new DB_conn();
	        	try {
		        	Connection con=db.getConnection();
		    		
		    		String username=null;
		    		username=namefield.getText();
		    		//query to match user name and id password in DB
				    String queryString =" select count(*) as \"exists\" from user_entry where user_name=? and user_pass=?";
				  //set this values using PreparedStatement
				  PreparedStatement   ps1 = con.prepareStatement(queryString);
				  ps1.setString(1,username);
				  ps1.setString(2,String.valueOf((passfield.getPassword())));
				  ResultSet results = ps1.executeQuery(); 
				  //get the status if match occured
				  if (results.next()) {
				    status = results.getInt("exists");
					if(status==1)
					{
						//JOptionPane.showMessageDialog(null,"pass");
						dispose();
						ExitGate Eframe = new ExitGate();
						Eframe.setVisible(true);
						Eframe.setSize(800,500);
					
					}
					else
						//incorrect userid or paasword
 						JOptionPane.showMessageDialog(null,"Incorrect email id or password, Please try again!");
				  } 

            }catch(Exception e1) {
            	System.out.println(e1);
            }
        }
       
	 });
	}
}
