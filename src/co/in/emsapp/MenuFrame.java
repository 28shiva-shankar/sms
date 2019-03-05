package co.in.emsapp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.in.emsapp.delete.DeleteFrame;
import co.in.emsapp.insert.InsertFrame;
import co.in.emsapp.update.UpdateStudent1;

/**
 * Menu screen
 * 
 * @author shiva
 *
 */
public class MenuFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = -1486250094128110323L;
	JButton b1, b2, b3, b4;

	public MenuFrame() {
		b1 = new JButton("Student List");
		b2 = new JButton("Insert Student");
		b3 = new JButton("Update Student");
		b4 = new JButton("Delete Student");
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		setSize(300, 300);
		setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		setSize(300, 300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == b1) {
			try {
				ListFrame lf = new ListFrame();
				lf.displayTable("Student_Details", 130);
				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ae.getSource() == b2) {
			try {
				@SuppressWarnings("unused")
				InsertFrame ifr = new InsertFrame();
				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		else if (ae.getSource() == b3) {
			try {
				@SuppressWarnings("unused")
				UpdateStudent1 us = new UpdateStudent1();
				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ae.getSource() == b4) {
			try {
				@SuppressWarnings("unused")
				DeleteFrame df = new DeleteFrame();
				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
