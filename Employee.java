package Lab5StoreManagementSystemII;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <code>Employee<code> Object
 * 
 * <p> Purpose of this class is to read and print employee's 
 * personal information but still depending on the type of employee
 * 
 * @author Ngoc Phuong Khanh Le
 * @version 1.0
 */
public abstract class Employee extends Person {
	/** Employee's number*/
	protected int empNumber;
	
	/**
	 * Default constructor
	 * 
	 * Inehrit from super class constructor
	 */
	Employee() {
		super();
	}
	
	/**
	 * overloading constructor 
	 * 
	 * Inherit from super class overloading constructor
	 * 
	 * @param firstName employee's first name
	 * @param lastName employee's last name
	 * @param email employee's email
	 * @param phoneNumber employee's phone number
	 * @param empNumber employee's unique ID
	 */
	Employee(String firstName, String lastName, String email, long phoneNumber, int empNumber) {
		super(firstName, lastName, email, phoneNumber);
		this.empNumber = empNumber;
	}
	
	public void readEmployeesFromFile(Scanner input) {
		empNumber = input.nextInt();
		firstName = input.next();
		lastName = input.next();
		email = input.next();
		phoneNumber = input.nextLong();
	}
	
	/**
	 * Read information of employees by prompting users to type in 
	 * their personal details inheriting from Person class 
	 * and their number.
	 *
	 * @param input scan inputs from users
	 */
	public void readEmployeeFromKeyboard(Scanner input) {
		while (empNumber <= 0) {
			try {
				System.out.print("Enter employee number: ");
				empNumber = input.nextInt();
				if (empNumber > 0)
					break;
				else
					System.err.println("Input must be an integer larger than 0.");
			}
			catch (InputMismatchException e) {
				System.err.println("Input must be an integer larger than 0.");
				input.nextLine();
			}
			catch (Exception e) {
				System.err.println("Unknown exception: " + e);
				input.nextLine();
			}
		}
		System.out.print("Enter first name: ");
		firstName = input.next();
		System.out.print("Enter last name: ");
		lastName = input.next();
		System.out.print("Enter email: ");
		email = input.next();
		while (phoneNumber <= 0) {
			try {
				System.out.print("Enter phone number: ");
				phoneNumber = input.nextLong();
				if (phoneNumber > 0)
					break;
				else
					System.err.println("Input must be an integer larger than 0");
			}
			catch (InputMismatchException e) {
				System.err.println("Input must be number larger than 0");
				input.nextLine();
			}
			catch (Exception e) {
				System.err.println("Unknown exception: " + e);
				input.nextLine();
			}
		}
	}
	
	/**
	 * Print employee's personal information depending on their type
	 */
	public abstract void printEmployee();
	
	/**
	 * Run method whenever user want to increment salary for 
	 * Regular and Contractor class. Being overridden in sub classes
	 */
	public abstract void processIncrement();
}
