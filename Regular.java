package Lab5StoreManagementSystemII;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <code>Regular<code> Object
 * 
 * <p> Purpose of this class is to read salary of regular employee
 * besides their general personal information from Employee class
 * and print them with formatted pattern
 * 
 * @author Ngoc Phuong Khanh Le
 * @version 1.0
 */
public class Regular extends Employee {
	/** Salary for Regular employees, typed yearly but displayed monthly */
	private double salary;
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public void readEmployeesFromFile(Scanner input) {
		super.readEmployeesFromFile(input);
		salary = input.nextDouble() / 12;
	}
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public void readEmployeeFromKeyboard(Scanner input) {
		super.readEmployeeFromKeyboard(input);
		while (salary <= 0) {
			try {
				System.out.print("Enter your annual salary: ");
				salary = input.nextDouble();
				if (salary >= 0) {
					salary = salary / 12;
					break;
				}
				else
					System.err.println("Input must be an double larger than 0");
				}
			catch (InputMismatchException e) {
				System.err.println("Input must be an double larger than 0");
				input.nextLine();
			}
			catch (Exception e) {
				System.err.println("Unknown exception: " + e);
				input.nextLine();
			}
		}
	}
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public void processIncrement() {
		salary = salary + salary * 0.03;
	}
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public void printEmployee() {
		System.out.printf("%12d | %12s | %15s | %12d | %10.2f |\n",
				empNumber, firstName + " " + lastName, email, phoneNumber, salary);
	}
	
}