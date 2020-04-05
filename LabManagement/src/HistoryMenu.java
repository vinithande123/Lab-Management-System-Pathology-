import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistoryMenu implements ActionListener{
	JFrame frame;
	JPanel panel;
	JLabel lsid,sid,lb12,b12,lurine,urine,ltb,tb;
	HistoryMenu(String x,String y,String z,String a)
	{
		frame=new JFrame();
		panel=new JPanel();
		lsid=new JLabel("Sample ID: ");
		lb12=new JLabel("B12 result ");
		lurine=new JLabel("Urine test result ");
		ltb=new JLabel("Tb result ");
		sid=new JLabel(x);
		b12=new JLabel(y);
		urine=new JLabel(z);
		tb=new JLabel(a);
		panel.add(lsid);
		panel.add(sid);
		panel.add(lb12);
		panel.add(b12);
		panel.add(lurine);
		panel.add(urine);
		panel.add(ltb);
		panel.add(tb);
	}
	public static void main(String[] args) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
