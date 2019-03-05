package co.in.emsapp.update;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import co.in.emsapp.MenuFrame;
import co.in.emsapp.student.SelectStudent;
import co.in.emsapp.student.StudentDetails;

public class UpdateStudent1 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2371109706621183686L;
	JLabel l1;
	JTextField t1;
	JButton b1, b2;

	public UpdateStudent1() {
		l1 = new JLabel("Enter SID :");
		t1 = new JTextField(20);
		b1 = new JButton("Get");
		b2 = new JButton("Back");
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(300, 300);
		setVisible(true);
		getRootPane().setDefaultButton(b1);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			SelectStudent is = new SelectStudent();
			StudentDetails sd = new StudentDetails();
			if (t1.getText() == "") {
				JOptionPane.showMessageDialog(null, "Enter a valid id", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					sd.setSid(Integer.parseInt((t1.getText())));
					is.select(sd);
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (ae.getSource() == b2) {
			@SuppressWarnings("unused")
			MenuFrame mf = new MenuFrame();
			dispose();
		}
	}
}
