package co.in.emsapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import co.in.emsapp.MenuFrame;
import co.in.emsapp.utils.DBConnection;

/**
 * Displays student details
 * 
 * @author shiva
 *
 */

class ListFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = -8723043923849828017L;
	JButton b1;
	ResultSet rs2 = null;

	public ListFrame() {
		b1 = new JButton("Back");
		add(b1);
		setLayout(null);
		setSize(300, 300);
		setVisible(true);
		b1.addActionListener(this);
		b1.setBounds(100, 30, 80, 30);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			@SuppressWarnings("unused")
			MenuFrame mf = new MenuFrame();
			dispose();
		}
	}

	@SuppressWarnings("unchecked")
	public void displayTable(String string, int y) throws SQLException {
		@SuppressWarnings("rawtypes")
		Vector columnNames2 = new Vector();
		@SuppressWarnings("rawtypes")
		Vector data2 = new Vector();
		try {
			DBConnection.getConnection();
			rs2 = DBConnection.st.executeQuery("select * from student");
			ResultSetMetaData md2 = rs2.getMetaData();
			int columns2 = md2.getColumnCount();
			for (int j = 1; j < columns2; j++) {
				columnNames2.addElement(md2.getColumnName(j));
			}
			while (rs2.next()) {
				@SuppressWarnings("rawtypes")
				Vector row2 = new Vector(columns2);
				for (int k = 1; k < columns2; k++) {
					row2.addElement(rs2.getObject(k));
				}
				data2.addElement(row2);
			}
			JTable table2 = new JTable(data2, columnNames2);
			JTableHeader header = table2.getTableHeader();
			header.setBackground(Color.yellow);
			JScrollPane scrollPane = new JScrollPane(table2);
			add(scrollPane);
			scrollPane.setBounds(10, 90, 260, 100);
			table2.setFont(new Font("Dialog", Font.BOLD, 12));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			rs2.close();
			DBConnection.st.close();
			DBConnection.con.close();
		}
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		ListFrame tabletest = new ListFrame();
	}

}
