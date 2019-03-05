package co.in.emsapp.delete;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import co.in.emsapp.student.StudentDetails;
import co.in.emsapp.utils.DBConnection;

public class DeleteStudent {

	public void delete(StudentDetails sd) throws ClassNotFoundException, SQLException {
		int sid = sd.getSid();
		try {
			DBConnection.getConnection();
			int rs = DBConnection.st.executeUpdate("delete from student where sid=" + sid);
			if (rs != 1) {
				JOptionPane.showMessageDialog(null, "No record found", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Deleted Successfully", "SUCCESS", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBConnection.st.close();
			DBConnection.con.close();
		}
	}
}
