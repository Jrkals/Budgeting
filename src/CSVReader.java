import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
	File file;
	Scanner scan;
	public CSVReader(String filename) {
		file = new File(filename);
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getLines(){
		ArrayList<String> lines = new ArrayList<>();
		scan.nextLine(); // skip first line
		while(scan.hasNext()) {
			String line = scan.nextLine();
			lines.add(line);
		}
		scan.close();
		return lines;
	}
	
	public ArrayList<Expense> getExpenses(){
		ArrayList<Expense> expenses = new ArrayList<Expense>();
		ArrayList<String> lines = getLines();
		for(String line: lines) {
			Expense e = parseExpenseFromLine(line);
			expenses.add(e);
		}
		return expenses;
	}

	private Expense parseExpenseFromLine(String line) {
		String[] parts = line.split(",");
		String date = parts[0];
		String description = parts[1];
		String category = parts[2];
		String location = parts[3];
		double amount = Double.parseDouble(parts[4]);
		String paymentMethod = parts[5];
		boolean fixedHuh = Boolean.parseBoolean(parts[6]);
		
		Expense e = new Expense(date, description, category, location, amount, paymentMethod, fixedHuh);
		return e;
	}
	
	

}
