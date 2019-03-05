package co.in.emsapp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import co.in.emsapp.admin.Admin;
import co.in.emsapp.admin.SelectAdmin;

/**
 * Login screen for the user
 * 
 * @author shiva
 *
 */
public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 7431841753428259691L;
	JLabel l1, l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2;

	public MainFrame() {
		l1 = new JLabel("Username :");
		t1 = new JTextField(15);
		l2 = new JLabel("Password :");
		t2 = new JPasswordField(15);
		t2.setEchoChar('*');
		b1 = new JButton("Submit");
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b1);
		b1.addActionListener(this);
		setSize(300, 300);
		setVisible(true);
		getRootPane().setDefaultButton(b1);
	}

	public void actionPerformed(ActionEvent ae) {
		Admin admin = new Admin();
		admin.setUserName(t1.getText());
		SelectAdmin sa = new SelectAdmin();
		char p[] = t2.getPassword();
		String sp = new String(p);
		admin.setPwd(sp);
		try {
			sa.select(admin);
			dispose();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainFrame mf = new MainFrame();
	}
}
