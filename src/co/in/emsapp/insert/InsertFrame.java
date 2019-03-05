package co.in.emsapp.insert;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import co.in.emsapp.MenuFrame;
import co.in.emsapp.student.StudentDetails;
import co.in.emsapp.utils.DBConnection;

/**
 * Inserting a student record
 * 
 * @author shiva
 *
 */
public class InsertFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 8841269414600865888L;
	JLabel l1, l2, l3, l4;
	JTextField t1, t2, t3, t4;
	JButton b1, b2;

	public InsertFrame() throws ClassNotFoundException, SQLException {
		l1 = new JLabel("SID :");
		l2 = new JLabel("SName :");
		l3 = new JLabel("Age :");
		l4 = new JLabel("EmailId :");
		t1 = new JTextField(20);
		t1.setEditable(false);
		DBConnection.getConnection();
		String query = "select max(sid) as sid from student";
		ResultSet res = DBConnection.st.executeQuery(query);
		int sid = 0;
		if (res.next()) {
			sid = res.getInt("sid");
		}
		System.out.println(sid);
		t1.setText(String.valueOf(sid + 1));
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		b1 = new JButton("Save");
		b2 = new JButton("back");
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
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
		setSize(300, 300);
		setVisible(true);
		getRootPane().setDefaultButton(b1);
	}

	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			InsertStudent is = new InsertStudent();
			StudentDetails sd = new StudentDetails();
			if (t2.getText() == "" || t3.getText() == "" || t4.getText() == "") {
				JOptionPane.showMessageDialog(null, "Enter valid data", "WARNING", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					sd.setSid(Integer.valueOf(t1.getText()));
					sd.setSname(t2.getText());
					sd.setAge(Integer.parseInt((t3.getText())));
					sd.setEmailid(t4.getText());
					is.insert(sd);
					dispose();
					@SuppressWarnings("unused")
					MenuFrame mf = new MenuFrame();
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

	public static void main(String a[]) throws ClassNotFoundException, SQLException {
		@SuppressWarnings("unused")
		InsertFrame ifr = new InsertFrame();
	}
}
