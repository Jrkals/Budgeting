import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseWriter implements IDatabase{
	Connection conn;
	
	public DatabaseWriter() {
		conn = IDatabase.connectToDB();
	}
	
	public void writeNewExpenses(ArrayList<Expense> allExpenses) {
		DatabaseReader dr = new DatabaseReader();
		ArrayList<Expense> databaseExpenses = dr.getAllExpenses();
		//List<Expense> expensesToWrite = allExpenses.stream().filter(e -> !listContains(databaseExpenses, e)).
		//		collect(Collectors.toList());
		ArrayList<Expense> expensesToWrite = new ArrayList<Expense>();
		for(Expense e: allExpenses) {
			System.out.println(e);
			if(!listContains(databaseExpenses, e)) {
				expensesToWrite.add(e);
			}
		}
		System.out.println("There are "+expensesToWrite.size()+" new expenses to write to the DB");
		try {
			Statement stmt = conn.createStatement();
			for(Expense e: expensesToWrite) {
				String insert = makeInsertStatement(e);
				try {
				stmt.execute(insert);
				} catch(SQLException f) {
					f.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private String makeInsertStatement(Expense e) {
		String rv = "INSERT INTO global (date, description, category, location, amount,"
				+ "paymentMethod, fixedHuh) VALUES (";
		rv += "\""+e.date+"\",";
		rv += "\""+e.description+"\",";
		rv += "\""+e.category+"\",";
		rv += "\""+e.location+"\",";
		rv += ""+e.amount+",";
		rv += "\""+e.paymentMethod+"\",";
		rv += ""+e.fixedHuh+");";
		System.out.println(rv);
		return rv;
	}

	boolean listContains(ArrayList<Expense> expenses, Expense e) {
		for(Expense exp: expenses) {
			//System.out.println(exp);
			if(exp.date.toString().equals(e.date.toString()) && exp.amount == e.amount 
					&& e.location.equals(exp.location)) {
				return true;
			}
		}
		System.out.println("not here");
		return false;
	}
}
