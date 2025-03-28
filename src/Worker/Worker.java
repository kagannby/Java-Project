package Worker;

import java.util.Objects;

public abstract class Worker implements Comparable<Worker>{
	private int workerId;
	private String workerFirstName;
	private String workerLastName;
	private String workerPosition;
	private double workerSalary;
	private static int numOfWorker=0;
	private static int WORKERLIMIT=99;
	
	public Worker() {
	}
	
	public Worker(int workerId, String workerFirstName, String workerLastName, String workerPosition,
			double workerSalary) {
		this.workerId = workerId;
		this.workerFirstName = workerFirstName;
		this.workerLastName = workerLastName;
		this.workerPosition = workerPosition;
		this.workerSalary = workerSalary;
	}
	
	public boolean checkId(int id) {
		if(workerId==id) {
			return true;
		}
		return false;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getWorkerFirstName() {
		return workerFirstName;
	}

	public void setWorkerFirstName(String workerFirstName) {
		this.workerFirstName = workerFirstName;
	}

	public String getWorkerLastName() {
		return workerLastName;
	}

	public void setWorkerLastName(String workerLastName) {
		this.workerLastName = workerLastName;
	}

	public String getWorkerPosition() {
		return workerPosition;
	}

	public void setWorkerPosition(String workerPosition) {
		this.workerPosition = workerPosition;
	}

	public double getWorkerSalary() {
		return workerSalary;
	}

	public void setWorkerSalary(double workerSalary) {
		this.workerSalary = workerSalary;
	}

	public static int getNumOfWorker() {
		return numOfWorker;
	}

	public static void setNumOfWorker(int numOfWorker) {
		Worker.numOfWorker = numOfWorker;
	}

	public static int getWORKERLIMIT() {
		return WORKERLIMIT;
	}

	public static void setWORKERLIMIT(int wORKERLIMIT) {
		WORKERLIMIT = wORKERLIMIT;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(workerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return workerId == other.workerId;
	}

	public abstract double calculateExtraHour(String pos,double salary,int extraHour);
	
	public String toString() {
		return "\n\nWorkerId= " + this.workerId +
				"\nWorker First Name= " + this.workerFirstName +
				"\nWorker Last Name= " + this.workerLastName +
				"\nWorker Position= " + this.workerPosition +
				"\nWorker Salary= " + this.workerSalary;
	}
}
