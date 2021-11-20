package Lab5StoreManagementSystemII;

import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <code>Store<code> Object
 * 
 * <p> Purpose of this class is to read information of 2 types of employees 
 * from file (open, read, close) and from keyboard and prompt them to the correct class 
 * to read and print their information.
 * This class also print the title and information using formatted output from 
 * Employee class
 * 
 * @author Ngoc Phuong Khanh Le
 * @version 1.0
 * @param <T>
 */
public class Store {
	/** An array to keep track of employee's order */
	private ArrayList<Employee> employees;
	/** Name of the store */
	private static String nameStore;
	/** Number of employees that are going to be typed in */
	private static Scanner input;
	private int numEmployee;
	/** A condition to check if there is any information in the ArrayList or not*/
	private boolean isAccountSaved = false;
	
	/** 
	 * default constructor
	 */
	Store() {}
	/**
	 * overloading constructor
	 * 
	 * @param nameStore name of the store
	 * @param numEmployee number of employees that are entered by users
	 */
	Store(String name, int numEmployee) {
		nameStore = name;
		employees = new ArrayList<Employee>(numEmployee);
	}
	
	/**
	 * Open the file, checking if their information is suitable with the 
	 * conditions of each employees type. Assign it to an object and add
	 * that object to the ArrayList.
	 * 
	 * @param input scan input from file
	 */
	public void readEmployeesDetailsFromFile(Scanner input) {
		try {
			input = new Scanner(Paths.get("src\\lab5StoreManagementSystemII\\emp.txt"));
		} 
		catch (NoSuchFileException e) {
			System.out.println("File not found");
		} 
		catch (Exception e) {
			System.out.println("Unknown exception: " + e.getMessage());
		}
		
		if (input != null) {
			try {
				while (input.hasNext()) {
					int option = input.nextInt();
					if (option == 1) {
						employees.add(new Regular());
						employees.get(employees.size() - 1).readEmployeesFromFile(input);
					}	
					else if (option == 2) { 
						employees.add(new Contractor());
						employees.get(employees.size() - 1).readEmployeesFromFile(input);
					}
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Input mismatch exception while reading the file");
			} 
			catch (IllegalStateException e) {
				System.out.println("Scanner closed");
			}
			catch (Exception e) {
				System.out.println("Unknown exception: " + e);
			}
			isAccountSaved = true;
		}
	}
	
	/**
	 * Read employees' type and prompt them to the correct class
	 * to read their personal information
	 * 
	 * @param input scan inputs from users
	 */
	public void readEmployeeDetailsFromKeyboard(Scanner input) {
		int option = 0;
		isAccountSaved = false;
		while (!isAccountSaved) {
			try {
				System.out.println("Enter details of employee " + (employees.size() + 1));
				System.out.printf("1. Regular \n2. Contractor \n"
						+ "Enter type of employees: ");
				option = input.nextInt();
				if (option == 1) {			
					employees.add(new Regular());
					break;
				}
				else if (option == 2) {
					employees.add(new Contractor()) ;
					break;
				}
				else 
					System.err.println("\n*** Type should be 1 or 2. Please try again. *** \n");
			}
			catch (InputMismatchException e) {
				System.err.println("\n*** Type should be 1 or 2. Please try again. *** \n");
				input.nextLine();
			}
			catch (Exception e) {
				System.err.println("Unknown exception " + e);
				input.nextLine();
			}
		}
		employees.get(employees.size() - 1).readEmployeeFromKeyboard(input);
		isAccountSaved = true;
	}
	
	/**
	 * Close the file after finishing all needed implementations
	 */
	public static void closeFile() {
		if (input != null)
			input.close();
	}
		
	/**
	 * Print a line of equal sign 
	 */
	public static void printLine() {
		for (int i = 0; i < 75; i++)
			System.out.print("=");
	}
	
	/**
	 * Print name store and title using formatted pattern
	 */
	public static void printTitle() {
		printLine();
		System.out.printf("\n%50s", nameStore + " Store Management System\n");
		printLine();
		System.out.printf("\n%12s | %12s | %15s | %12s | %9s |\n", 
				"Emp#", "Name", "Email", "Phone Number", "Salary");
		printLine();
		System.out.println();
	}
	
	/**
	 * Using employees ArrayList to print stored information 
	 * in every object of that ArrayList
	 * @param input scan input from  
	 */
	public void printEmployee(Scanner input) {
		if (!isAccountSaved)
			System.out.println("\n*** No employees to print ***");
		
		else {
			printTitle();
			for (int i = 0; i < employees.size(); i++)
				if(employees.get(i) != null)
					employees.get(i).printEmployee();
		}
	}
	
	/**
	 * Run process increment every time this option is being chosen
	 * with condition overridden in sub classes
	 */
	public void runProcessIncrement() {
		if (!isAccountSaved)
			System.out.println("\n*** No employees to process ***");
		
		else {
			for (int i = 0; i < employees.size(); i++) {
				employees.get(i).processIncrement();
			}
		}
	}
}
