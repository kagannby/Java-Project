package Worker;

public class Employer extends Worker{
	private String email;
	private String password;
	
	public Employer() {
		super();
	}
	
	public Employer(int workerId, String workerFirstName, String workerLastName, String workerPosition,
			double workerSalary, String email, String password) {
		super(workerId, workerFirstName, workerLastName, workerPosition, workerSalary);
		this.email=email;
		this.password=password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*@Override
	public String toString() {
		return "Employer" + super.toString() + 
				"\nemail= " + email +
				"\npassword= " + password;
	}*/
	
	
	public int compareTo(Worker w) {
		return this.getWorkerId()-w.getWorkerId();
	}

	
	public static double calculateBaseSalary() {
			return 100000;
		
	}
	public double calculateExtraHour(String pos, double salary, int extraHour) {
		if(pos.equalsIgnoreCase("Employer"))
			 salary+=extraHour*800;
		return salary;
	}
}
