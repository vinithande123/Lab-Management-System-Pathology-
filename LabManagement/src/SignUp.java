import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp implements ActionListener{
	JFrame frame;
	JPanel panel;
	JTextField name,mob,email;
	JLabel lname,lmob,lemail,lgender;
	JRadioButton male,female;
	JButton signup,clear,login;
	
	SignUp()
	{
		frame=new JFrame("Sign Up");
		panel=new JPanel();
		name=new JTextField(10);
		mob=new JTextField(10);
		email=new JTextField(10);
		male=new JRadioButton("Male");
		female=new JRadioButton("Female");
		ButtonGroup bg=new ButtonGroup();
		bg.add(male);
		bg.add(female);
		lname=new JLabel("Name: ");
		lmob=new JLabel("Mobile No: ");
		lemail=new JLabel("Email Id: ");
		lgender=new JLabel("Gender: ");
		signup=new JButton("Sign Up!!");
		login=new JButton("Login Page");
		clear=new JButton("Reset");
		clear.addActionListener(this);
		clear.addActionListener(this);
		login.addActionListener(this);
		signup.addActionListener(this);
		panel.add(lname);
		panel.add(name);
		panel.add(lmob);
		panel.add(mob);
		panel.add(lemail);
		panel.add(email);
		panel.add(lgender);
		panel.add(male);
		panel.add(female);
		panel.add(signup);
		panel.add(login);
		panel.add(clear);
		frame.add(panel);
		frame.setSize(250,250);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUp();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==clear) {
			name.setText("");
			mob.setText("");
			email.setText("");
		}
		if(arg0.getSource()==login) {
			frame.dispose();
			new LoginPage();
		}
		String sname = null,smob = null,semail = null,sgender = null;
		if(arg0.getSource()==signup) {
			if(name.getText()!="" && mob.getText()!="") {
				sname=name.getText();
				smob=mob.getText();
				semail=email.getText();
				if(male.isSelected())
						sgender="Male";
				if(female.isSelected())
						sgender="Female";
				
				System.out.println(sname);	
			}
			else {
				System.out.println("Pls enter all fields");
			}
			
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
			PreparedStatement pr=con.prepareStatement("insert into lab values(?,?,?,?)");
			pr.setString(1, sname);
			pr.setString(2, smob);
			pr.setString(3, semail);
			pr.setString(4, sgender);
			pr.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
