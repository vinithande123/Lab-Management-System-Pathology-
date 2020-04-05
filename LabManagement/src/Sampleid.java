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

public class Sampleid implements ActionListener{
	JFrame frame;
	JPanel panel;
	JTextField tsid;
	JLabel lsid;
	JButton button;
	Sampleid()
	{
		frame=new JFrame();
		panel=new JPanel();
		tsid=new JTextField(5);
		lsid=new JLabel("Enter your sample ID: ");
		button=new JButton("Proceed!!");
		button.addActionListener(this);
		panel.add(lsid);
		panel.add(tsid);
		panel.add(button);
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(250,250);
	}
	public static void main(String[] args) {
		new Sampleid();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sid="",dsid="";
		sid=tsid.getText();
		
		if(e.getSource()==button)
		{	System.out.println("kkkk");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Connection con;
            try {
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vinithande4", "Swarali123");
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from admin");
                String db12="",durine="",dtb="";
                while (rs.next())
                {
                    dsid=rs.getString(1);
                    db12=rs.getString(2);
                    durine=rs.getString(3);
                    dtb=rs.getString(4);
                    if(dsid==sid) {
                    	frame.dispose();
                    	new HistoryMenu(dsid,db12,durine,dtb);
                    }
                }
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}
	}
	
}
