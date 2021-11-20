package Lab5StoreManagementSystemII;

import java.util.InputMismatchException;
import java.util.Scanner;

	/**
	 * <code>Contractor<code> Object
	 * 
	 * <p> Purpose of this class is to read hourly rate and number of hours of contract employee
	 * besides their general personal information from Employee class
	 * and print them with formatted pattern
	 * 
	 * @author Ngoc Phuong Khanh Le
	 * @version 1.0
	 */
public class Contractor extends Employee {
	/** Wage for each hour an employee works */
	private double hourlyRate;
	/** Number of hours employees work*/
	private double numHours;
	
	/**
	 *{@inheritDoc}
	 */
	public void readEmployeeFromFile(Scanner input) {
		super.readEmployeesFromFile(input);
		hourlyRate = input.nextDouble();
		numHours = input.nextDouble();
	}
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public void readEmployeeFromKeyboard(Scanner input) {
		super.readEmployeeFromKeyboard(input);
		while (hourlyRate <= 0) {
			try {
				System.out.print("Enter your hourly rate: ");
				hourlyRate = input.nextDouble();
				if (hourlyRate > 0)
					break;
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
		
		while (numHours <= 0) {
			try {
				System.out.print("Enter your number hours: ");
				numHours = input.nextDouble();
				if (numHours > 0)
					break;
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
		hourlyRate+=1;
	}
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public void printEmployee() {
		System.out.printf("%12d | %12s | %15s | %12d | %10.2f |\n",
				empNumber, firstName + " " + lastName, email, phoneNumber, hourlyRate * numHours);
	}
	
}
