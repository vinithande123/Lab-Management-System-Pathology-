import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Admin1 implements ActionListener{
	JFrame frame;
	JPanel panel;
	JTextField tsid,tb12,turine,ttb;
	JLabel lsid,lb12,lurine,ltb;
	JButton button;
	Admin1()
	{
		frame=new JFrame("Admin");
		panel=new JPanel();
		tsid=new JTextField(5);
		tb12=new JTextField(5);
		turine=new JTextField(5);
		ttb=new JTextField(5);
		lsid=new JLabel("Enter sample ID: ");
		lb12=new JLabel("B12 result ");
		lurine=new JLabel("Urine test result ");
		ltb=new JLabel("Tb result ");
		button=new JButton("Proceed!!");
		button.addActionListener(this);
		panel.add(lsid);
		panel.add(tsid);
		panel.add(lb12);
		panel.add(tb12);
		panel.add(lurine);
		panel.add(turine);
		panel.add(ltb);
		panel.add(ttb);
		panel.add(button);
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(240,240);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	@Override
	public void actionPerformed(ActionEvent obj) {
		String dsid="",db12="",durine="",dtb="";
		// TODO Auto-generated method stub
		
		if(obj.getSource()==button)
		{
			dsid=tsid.getText();
			db12=tb12.getText();
			durine=turine.getText();
			dtb=ttb.getText();
			frame.dispose();
			new LoginPage();
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
				PreparedStatement pr=con.prepareStatement("insert into admin values(?,?,?,?)");
				pr.setString(1, dsid);
				pr.setString(2, db12);
				pr.setString(3, durine);
				pr.setString(4, dtb);
				pr.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
