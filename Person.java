package Lab5StoreManagementSystemII;

/**
 * <code>Person<code> Object
 * 
 * <p> Purpose of this class is to store personal information
 * such as first name, last name, email and phone number of employees.
 * 
 * @author Ngoc Phuong Khanh Le
 * @version 1.0
 */
public class Person {
	/** employee's first name */
	protected String firstName;
	/** employee's last name */
	protected String lastName;
	/** employee's email */
	protected String email;
	/** employee's phone number */
	protected long phoneNumber;
	
	/**
	 * default constructor
	 */
	Person() {}
	/**
	 * overloading constructor
	 * 
	 * @param firstName employee's first name
	 * @param lastName employee's last name
	 * @param email employee's last name
	 * @param phoneNumber employee's phone number
	 */
	Person(String firstName, String lastName, String email, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Get student's name
	 * @return this student's first name and last name
	 */
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * Get student's email
	 * @return this student's email 
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Get student's phone number
	 * @return this student's phone number
	 */
	public long getPhoneNumber() {
		return this.phoneNumber;
	}
}
