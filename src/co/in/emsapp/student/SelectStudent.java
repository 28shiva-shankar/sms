package co.in.emsapp.student;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import co.in.emsapp.update.UpdateFrame;
import co.in.emsapp.update.UpdateStudent1;
import co.in.emsapp.utils.DBConnection;

/**
 * Selecting a student based on his id
 * 
 * @author shiva
 *
 */
public class SelectStudent {
	public void select(StudentDetails a) throws ClassNotFoundException, SQLException {
		String sname = null;
		String emailid = null;
		int age;

		int sid = a.getSid();

		try {
			DBConnection.getConnection();
			ResultSet rs = DBConnection.st.executeQuery("select * from student where sid=" + sid + "");
			if (rs.next()) {
				@SuppressWarnings("unused")
				StudentDetails sd = new StudentDetails();
				UpdateFrame uf = new UpdateFrame();
				sname = rs.getString(2);
				emailid = rs.getString(4);
				age = rs.getInt(3);
				uf.setText(sid, sname, emailid, age);
			} else {
				JOptionPane.showMessageDialog(null, "No record found", "Error", JOptionPane.ERROR_MESSAGE);
				@SuppressWarnings("unused")
				UpdateStudent1 us = new UpdateStudent1();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
