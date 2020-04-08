
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Menu implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton test,history,logout;
	Menu(){
		frame=new JFrame("Menu");
		panel=new JPanel();
		test=new JButton("New Test");
		history=new JButton("History");
		logout=new JButton("Logout");
		test.addActionListener(this);
		history.addActionListener(this);
		logout.addActionListener(this);
		panel.add(test);
		panel.add(history);
		panel.add(logout);
		frame.add(panel);
		frame.setSize(250,250);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Menu();
	}

	@Override
	public void actionPerformed(ActionEvent m) {
		// TODO Auto-generated method stub
		if(m.getSource()==test) {
			System.out.println("Final test");
			frame.dispose();
			new FinalMenu();
		}
		if(m.getSource()==history) {
			System.out.println("History");
			frame.dispose();
			new Sampleid();
		}
		if(m.getSource()==logout) {
			int a=JOptionPane.showConfirmDialog(frame, "Do you want Logout");
			if(a==JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(frame, "Logged out successfully!!!");
				frame.dispose();
				new LoginPage();
			}
			
		}
	}

}
