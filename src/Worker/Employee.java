package Worker;

public class Employee extends Worker{
	private int supervisorId;
	private int extraHourWorked;
	private String branchName;

	public Employee() {
		super();
	}

	public Employee(int workerId, String workerFirstName, String workerLastName, String workerPosition,
			double workerSalary, int supervisorId, String branchName) {
		super(workerId, workerFirstName, workerLastName, workerPosition, workerSalary);
		this.supervisorId=supervisorId;
		
		this.branchName=branchName;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public int getExtraHourWorked() {
		return extraHourWorked;
	}

	public void setExtraHourWorked(int extraHourWorked) {
		this.extraHourWorked = extraHourWorked;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String toString() {
		return "\n\nEmployee" + super.toString() +
				"\nSupervisorId= " + WorkerSys.getSupervisor(this.supervisorId) +
				//"\nExtra hour worked= " + this.extraHourWorked +
				"\nBranch Name= " + this.branchName;
	}

	public static int calculateId() {
		return WorkerSys.getLastEmpId()+1;
	}
	
	
	public static double calculateBaseSalary(String pos) {
		double salary=0;
		if(pos.equalsIgnoreCase("Chef")) {
			salary=75000;
		}
		
		else if(pos.equalsIgnoreCase("Accountant")) {
			salary=48000;
		}
		else if(pos.equalsIgnoreCase("Waiter") || pos.equalsIgnoreCase("Waitress"))
		{
			salary=30000;
		}	
		return salary;
	}
	
	
	public double calculateExtraHour(String pos,double salary,int extraHour) {
		
		 if(pos.equalsIgnoreCase("Chef")) {
			salary+=500*extraHour;
		}
		
		else if(pos.equalsIgnoreCase("Accountant")) {
			salary+=300*extraHour;
		}
		else if(pos.equalsIgnoreCase("Waiter") || pos.equalsIgnoreCase("Waitress"))
		{
			salary+=150*extraHour;
		}	
		return salary;
	}
	
	public int compareTo(Worker w) {
		return this.getWorkerId()-w.getWorkerId();
	}
	
	
}
