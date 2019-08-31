import java.util.ArrayList;

/*
 * Main class for budgeting
 */
public class run {

	public static void main(String[] args) {
		DatabaseReader dr = new DatabaseReader();
		ArrayList<Expense> expenses = dr.getAllExpenses();
		System.out.println("There are "+expenses.size()+" expenses in the database");
		/*for(Expense e: expenses) {
			System.out.println(e);
		}
		System.out.println("---------------------------------");*/
		
		// read all input from csv
		CSVReader csvr = new CSVReader("/Users/justin/eclipse-workspace/Budgeting/bin/input.csv");
		ArrayList<Expense> allExpenses;
		allExpenses = csvr.getExpenses();
		//System.out.println("There are "+allExpenses.size()+" expenses in the csv");

		
		//write to DB
		DatabaseWriter dw = new DatabaseWriter();
		dw.writeNewExpenses(allExpenses);
		//do calculations
		//TODO

	}

}
