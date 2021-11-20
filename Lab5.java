package Lab5StoreManagementSystemII;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *  <p> Driver class to implement methods from Store class
 * 
 * @author Ngoc Phuong Khanh Le
 * @version 1.0
 */
public class Lab5 {

	/**
	 * main method to read store name, number of employees
	 * and show options which are attached to each method from 
	 * Store class in order to implement functions of reading inputs
	 * from both file and keyboard, run increment, and print the on the
	 * console.
	 * Close the file as needed 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the name of the store: ");
		String storeName = input.next();
		
		int numEmployee = 0;
		boolean continueInput = true;
		while(continueInput) {
			try {
				System.out.print("How many employees do you have? ");
				numEmployee = input.nextInt();
				if (numEmployee > 0)
					continueInput = false;
				else
					System.err.println("Number of employees should be an integer greater than 0. Please try again.");
			} catch (InputMismatchException e) {
				System.err.println("Number of employees should be an integer greater than 0. Please try again.");
				input.nextLine();
			}
			catch (Exception e) {
				System.out.println("Unknown exception: " + e);
			}
		}
		
		var store = new Store(storeName, numEmployee);
		
		int option = 0;
		while (option != 5) {
			try {
				System.out.print("\n1. Read employee details from keyboard \n"
						+ "2. Read employee details from file \n"
						+ "3. Process increment \n"
						+ "4. Print employee details \n"
						+ "5. Exit \n"
						+ "Enter your option: ");
				option = input.nextInt();
				
				if(option == 1)
					store.readEmployeeDetailsFromKeyboard(input);
				
				else if (option == 2)
					store.readEmployeesDetailsFromFile(input);
				
				else if (option == 3) 
					store.runProcessIncrement();
				
				else if (option == 4) 
					store.printEmployee(input);
				
				else if (option > 5 || option < 1)
					System.out.println("\n*** Invalid choice. Choice should be a positive integer from"
							+ "1-5. Please try again. ***");
			} catch (InputMismatchException e) {
					System.err.println("\n*** Please enter an integer from 1 to 5. ***");
					input.nextLine();
			}
			catch (Exception e) {
				System.out.println("Unknown exception: " + e);
			}
		}
		Store.closeFile();
		System.out.println("Have a nice day!");
	}
}
