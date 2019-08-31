import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseReader implements IDatabase {
	Connection conn;
	public DatabaseReader() {
		conn = IDatabase.connectToDB();
	}
	
	ArrayList<Expense> getAllExpenses(){
		ArrayList<Expense> expenses = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			String query = "Select * from global;";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Expense e = parseExpenseFromRow(rs);
				expenses.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expenses;
	}

	private Expense parseExpenseFromRow(ResultSet rs) {
		Expense e = null;
		try {
			String date = rs.getString(1);
			String description = rs.getString(2);
			String category = rs.getString(3);
			String location = rs.getString(4);
			double amount = rs.getDouble(5);
			String paymentMethod = rs.getString(6);
			boolean fixedHuh = rs.getBoolean(7);
			int ID = rs.getInt(8);
			e = new Expense(date, description, category, location, amount, paymentMethod, fixedHuh, ID);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return e;
	}

}
