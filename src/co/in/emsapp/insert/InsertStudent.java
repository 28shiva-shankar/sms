package co.in.emsapp.insert;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import co.in.emsapp.student.StudentDetails;
import co.in.emsapp.utils.DBConnection;

public class InsertStudent {

	public static void insert(StudentDetails sd) throws ClassNotFoundException, SQLException {
		int sid = sd.getSid();
		String sname = sd.getSname();
		int age = sd.getAge();
		String emailid = sd.getEmailid();

		try {
			DBConnection.getConnection();
			int y = DBConnection.st.executeUpdate("insert into student(sid,sname,age,emailid) values('" + sid + "' ,'"
					+ sname + "'," + age + ",'" + emailid + "')");

			if (y == 1) {
				JOptionPane.showMessageDialog(null, "Student Record Inserted Successfully.", "SUCCESS",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "unable to insert", "WARNING", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBConnection.st.close();
			DBConnection.con.close();
		}
	}

}
