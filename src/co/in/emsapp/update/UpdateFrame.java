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
import co.in.emsapp.student.StudentDetails;

/**
 * Updating a record based on student's id
 * 
 * @author shiva
 *
 */
public class UpdateFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = -8719520669853757544L;
	JLabel l1, l2, l3, l4;
	JTextField t1, t2, t3, t4;
	JButton b1, b2;
	StudentDetails sd = new StudentDetails();

	public UpdateFrame() {
		l1 = new JLabel("SID :");
		l2 = new JLabel("SName :");
		l3 = new JLabel("Age :");
		l4 = new JLabel("EmailId :");
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		b1 = new JButton("Update");
		b2 = new JButton("Back");
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
		t1.setEditable(false);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setVisible(true);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setDefaultButton(b1);
	}

	public void actionPerformed(ActionEvent ae) {
		UpdateStudent is = new UpdateStudent();

		if (ae.getSource() == b1) {
			try {
				getText();
				int n = JOptionPane.showConfirmDialog(null, "Are you sure??", "ALERT", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					is.update(sd);
					dispose();
					@SuppressWarnings("unused")
					MenuFrame mf = new MenuFrame();
				} else if (n == JOptionPane.NO_OPTION) {
					dispose();
					@SuppressWarnings("unused")
					UpdateStudent1 us = new UpdateStudent1();
				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (ae.getSource() == b2) {
			@SuppressWarnings("unused")
			UpdateStudent1 us = new UpdateStudent1();
			dispose();
		}
	}

	public void setText(int sid, String sname, String emailid, int age) {
		String sid1 = Integer.toString(sid);
		String age1 = Integer.toString(age);
		t2.setText(sname);
		t4.setText(emailid);
		t1.setText(sid1);
		t3.setText(age1);
	}

	public void getText() {
		if (t1.getText() == "" || t2.getText() == "" || t3.getText() == "" || t4.getText() == "") {
			JOptionPane.showMessageDialog(null, "Enter valid details", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			sd.setSid(Integer.parseInt(t1.getText()));
			sd.setAge(Integer.parseInt(t3.getText()));
			sd.setSname(t2.getText());
			sd.setEmailid(t4.getText());
		}
	}
}
