import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JTextField age,refer,dater;          //
	JLabel lage,lrefer,lwtest,ldater,ltest;    //lname,lgender
	JComboBox city;
	JCheckBox c,cpp,java;
	JButton submit;
	
	FinalMenu(){
		frame=new JFrame();
		panel=new JPanel();

		age=new JTextField(10);
		refer=new JTextField(20);
		dater=new JTextField(10);
//		fname=new JTextField(l.name.getText());		
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
		//new FinalMenu();
		
	}
	@Override
	public void actionPerformed(ActionEvent fm) {
		// TODO Auto-generated method stub
		if(fm.getSource()==submit) {
			String sge = null,sdater = null,srefer = null,sgender = null;
		}
	}

}
