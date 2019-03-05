package co.in.emsapp.update;

import java.sql.SQLException;
import javax.swing.JOptionPane;

import co.in.emsapp.student.StudentDetails;
import co.in.emsapp.utils.DBConnection;

public class UpdateStudent {
	public void update(StudentDetails sd) throws ClassNotFoundException, SQLException {

		int sid = sd.getSid();
		String sname = sd.getSname();
		int age = sd.getAge();
		String emailid = sd.getEmailid();

		try {
			DBConnection.getConnection();
			int y = DBConnection.st.executeUpdate("update student set sname='" + sname + "',age=" + age + ",emailid='"
					+ emailid + "' where sid=" + sid + "");
			if (y != 1) {
				JOptionPane.showMessageDialog(null, "Failed", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Updated Successfully", "SUCCESS", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBConnection.st.close();
			DBConnection.con.close();
		}

	}

}
