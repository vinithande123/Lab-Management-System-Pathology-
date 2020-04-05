
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Menu implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton test,history;
	Menu(){
		frame=new JFrame();
		panel=new JPanel();
		test=new JButton("New Test");
		history=new JButton("History");
		test.addActionListener(this);
		history.addActionListener(this);
		panel.add(test);
		panel.add(history);
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
	}

}
