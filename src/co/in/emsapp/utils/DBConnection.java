package co.in.emsapp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * Connecting to a database
 * 
 * @author shiva
 *
 */
public class DBConnection {
	public static Connection con = null;
	public static Statement st = null;
	static String driver = "", uname = "", pwd = "", url = "";

	public static void property() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("application.properties");
			prop.load(input);
			driver = prop.getProperty("Dname");
			url = prop.getProperty("URL");
			uname = prop.getProperty("Uname");
			pwd = prop.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getConnection() throws ClassNotFoundException, SQLException {
		try {
			property();
			Class.forName(driver);
			con = DriverManager.getConnection(url, uname, pwd);
			st = con.createStatement();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
