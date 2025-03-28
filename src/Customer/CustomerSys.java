package Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

import Worker.Employee;
import Worker.Employer;
import Worker.Worker;

public class CustomerSys {
	private static HashSet<Customer>customerSet=new HashSet<Customer>();
	
	public static void readFromFile() {
		Scanner s;
		File file;
		String fName, lName, email, password;
		int id;
		Customer c=null;
		try {
			file=new File("customer.txt");
			s=new Scanner(file);
			while(s.hasNext()) {
				id=s.nextInt();
				fName=s.next();
				lName=s.next();
				email=s.next();
				password=s.next();
				c = new Customer(id, fName, lName, email, password);
				customerSet.add(c);
				Customer.setNumOfCustomer(Customer.getNumOfCustomer()+1);
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found!");
		}
		System.out.println("file found!");
	}
	
	public static boolean userLogin(String email, String password) {
		for(Customer c:customerSet) {
				if(c.getCustomerEmail().equals(email) && c.getCustomerPassword().equals(password)) {
					return true;
				}
			}
		return false;
	}
}
