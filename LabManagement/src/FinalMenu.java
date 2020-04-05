import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FinalMenu implements ActionListener {
	JFrame frame;
	JPanel panel;
	JTextField id,age,refer,dater;          //
	JLabel lid,lage,lrefer,lwtest,ldater,ltest;    //lname,lgender
	JComboBox city;
	JCheckBox c,cpp,java;
	JButton submit;
	
	FinalMenu(){
		frame=new JFrame();
		panel=new JPanel();
		id=new JTextField(5);
		age=new JTextField(10);
		refer=new JTextField(20);
		dater=new JTextField(10);
//		fname=new JTextField(l.name.getText());		
		lid=new JLabel("ID: ");
		lage=new JLabel("Age: ");
		lrefer=new JLabel("Reference: ");
		lwtest=new JLabel("Tests: ");
		ldater=new JLabel("Date: ");
		ltest=new JLabel("Tests to be conducted");
		c=new JCheckBox("B12");
		cpp=new JCheckBox("Urine Test");
		java=new JCheckBox("TB test");
		submit=new JButton("Submit");
		submit.addActionListener(this);
		panel.add(lid);
		panel.add(id);
		panel.add(lage);
		panel.add(age);
		panel.add(ldater);
		panel.add(dater);
		panel.add(lrefer);
		panel.add(refer);
		panel.add(ltest);
		panel.add(c);
		panel.add(cpp);
		panel.add(java);
		panel.add(submit);
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(250,250);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FinalMenu();
		
	}
	@Override
	public void actionPerformed(ActionEvent fm) {
		// TODO Auto-generated method stub
		String sid="",sage = "",sdater = "",srefer = "",sb12="",suri="",stb="",smain="";
		if(fm.getSource()==submit) {
			sid=id.getText();
			sage=age.getText();
			sdater=dater.getText();
			srefer=refer.getText();
			if(c.isSelected())
				smain="B12";
			if(cpp.isSelected()) {
				suri="Urine Test";
				smain=smain.concat(","+suri);//suri="C++";
			}
				
			if(java.isSelected()) {
				stb="TB Test";
				smain=smain.concat(","+stb);
			}
			System.out.println(smain);
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
			PreparedStatement pr=con.prepareStatement("insert into labtest values(?,?,?,?,?)");
			pr.setString(1, sid);
			pr.setString(2, sage);
			pr.setString(3, sdater);
			pr.setString(4, srefer);
			pr.setString(5, smain);
			pr.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
