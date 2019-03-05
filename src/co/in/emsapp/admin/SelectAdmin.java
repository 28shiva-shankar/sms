package co.in.emsapp.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import co.in.emsapp.MainFrame;
import co.in.emsapp.MenuFrame;
import co.in.emsapp.utils.DBConnection;
/**
 * selects the user or admin
 * @author shiva
 *
 */
public class SelectAdmin {
	ResultSet rs = null;

	public void select(Admin a) throws ClassNotFoundException, SQLException {
		String username = a.getUserName();
		String password = a.getPwd();
		try {
			DBConnection.getConnection();
			rs = DBConnection.st.executeQuery(
					"select * from admin where username='" + username + "'and password='" + password + "'");
			if (rs.next()) {
				@SuppressWarnings("unused")
				MenuFrame mf = new MenuFrame();
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect Credentials.", "WARNING", JOptionPane.WARNING_MESSAGE);
				@SuppressWarnings("unused")
				MainFrame mf = new MainFrame();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			rs.close();
			DBConnection.st.close();
			DBConnection.con.close();
		}
	}
}
