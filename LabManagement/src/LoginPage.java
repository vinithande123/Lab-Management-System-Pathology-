import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
	JFrame frame;
	JPanel panel;
	JTextField name,mob; 
	JLabel lname,lmob;
	JButton login,signup,admin;
	String checkname;
	String checkmob;
	LoginPage(){
		frame=new JFrame("Login Page");
		panel=new JPanel();
		name=new JTextField(20);
		mob=new JTextField(20);
		lname=new JLabel("Name: ");
		lmob=new JLabel("Mobile No: ");
		login=new JButton("Login");
		login.addActionListener(this);
		signup=new JButton("sign up");
		signup.addActionListener(this);
		admin=new JButton("Admin ");
		admin.addActionListener(this);
		panel.add(lname);
		panel.add(name);
		panel.add(lmob);
		panel.add(mob);
		panel.add(login);
		panel.add(signup);
		panel.add(admin);
		frame.add(panel);
		frame.setSize(250,250);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==signup) {
			frame.dispose();
			new SignUp();
		}
		if(e.getSource()==login) {
			checkname=name.getText();
			checkmob=mob.getText();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","vinithande4","Swarali123");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from lab");
				while(rs.next()) {
					if(checkname.equals(rs.getString(1))){
						if(checkmob.equals(rs.getString(2))) {
							frame.dispose();
							new Menu();
						}
						else {
							System.out.println("Number entered is incorrect");
						}
						
					}
					else {
						System.out.println("Name not in the directory");
					}
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==admin)
		{
			frame.dispose();
			new Admin1();
		}
	}

}
