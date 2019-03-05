package co.in.emsapp.delete;

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
 * deleting a student record based on his id
 * 
 * @author shiva
 *
 */
public class DeleteFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JLabel l1;
	JTextField t1;
	JButton b1, b2;

	public DeleteFrame() {
		l1 = new JLabel("Enter SID :");
		t1 = new JTextField(20);
		b1 = new JButton("Delete");
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
			if (t1.getText() == "") {
				JOptionPane.showMessageDialog(null, "Enter a valid id", "ALERT", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					DeleteStudent ds = new DeleteStudent();
					StudentDetails sd = new StudentDetails();
					sd.setSid(Integer.parseInt((t1.getText())));
					int n = JOptionPane.showConfirmDialog(null, "Are you sure??", "ALERT", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						ds.delete(sd);
						dispose();
						@SuppressWarnings("unused")
						MenuFrame mf = new MenuFrame();
					} else if (n == JOptionPane.NO_OPTION) {
						dispose();
						@SuppressWarnings("unused")
						DeleteFrame df = new DeleteFrame();
					}
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
