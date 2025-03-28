package Worker;

import java.util.*;
import java.io.*;
import Comparator.*;

public class WorkerSys {
	private static HashSet<Worker>workers=new HashSet<Worker>();
	
	/*public static String assignBranchToEmployee() {
		int id = (int) (Math.floor(Math.random()* Restaurant.getNumOfBranches())+1);
		Restaurant rest = RestaurantSys.searchRestaurant(id);
		return rest.getRestaurantName();
	}*/
	
	public static void readFromFile() {
		Scanner s;
		File file;
		String fName, lName, position, branchName, email, password;
		int supId, workerId;
		Worker w=null;
		try {
			file=new File("worker.txt");
			s=new Scanner(file);
			while(s.hasNext()) {
				fName=s.next();
				lName=s.next();
				position=s.next();
				if(position.equalsIgnoreCase("Employer")) {
					workerId=s.nextInt();
					email=s.next();
					password=s.next();
					w = new Employer(workerId, fName, lName, position, Employer.calculateBaseSalary(), email, password);
				} else {
					workerId=s.nextInt();
					supId=s.nextInt();
					//extraHour=s.nextInt();
					branchName=s.next();
					//branchName="Bilkent";
					w = new Employee(workerId, fName, lName, position, Employee.calculateBaseSalary(position), supId,branchName);
				}
				workers.add(w);
				Worker.setNumOfWorker(Worker.getNumOfWorker()+1);
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found!");
		}
		System.out.println("file found!");
	}
	
	public static int getLastEmpId() {
		Iterator<Worker> it = workers.iterator();
		Worker tmp=null;
		while(it.hasNext())
			tmp = it.next();
		return tmp.getWorkerId();
	}
	
	public static boolean addEmployee(int id, String fname, String lname,String pos,double salary,int supId,int extraHour,String branch) {
		Worker employee = new Employee(id,fname,lname,pos,salary,supId,branch);
		return workers.add(employee);
	}
	
	public static String displayAll() {
		String out = "";
		for(Worker temp: workers) {
			out+=temp.toString();
		}
		return out;
	}
	
	
	public static String DisplayByPosition() {
		String out="Display by Position\n\n";
		WorkerPositionComparator pc= new WorkerPositionComparator();
		TreeSet<Worker> ts= new TreeSet<>(pc);
		ts.addAll(workers);
		for(Worker temp: ts) {
			out+=temp.toString();
		}
		return out;
	}
	
	public static String DisplayByID() {
		String out="Display by ID\n\n";
		WorkerIdComparator ic= new WorkerIdComparator();
		TreeSet<Worker> ts= new TreeSet<>(ic);
		ts.addAll(workers);
		for(Worker temp: ts) {
			out+=temp.toString();
		}
		return out;
	}
	
	public static String DisplayBySalary() {
		String out="Display by Salary\n\n";
		WorkerSalaryComparator sc= new WorkerSalaryComparator();
		TreeSet<Worker> ts= new TreeSet<Worker>(sc);
		ts.addAll(workers);
		for(Worker temp: ts) {
			out+=temp.toString();
		}
		return out;
	}
	
	public static String[] getIdArray() {
		String[] arr= new String[workers.size()];
		int i =0;
		for(Worker tmp: workers) {
			arr[i]=tmp.getWorkerId()+"";
			i++;
		}
		return arr;
	}
	
	public static Worker searchID(int id) {
		for(Worker tmp: workers) {
			if(tmp.getWorkerId()==id)
				return tmp;
		}
		return null;
	}
	
	public static String getSupervisor(int supId) {
		for(Worker tmp: workers) {
			if(tmp.getWorkerId()==supId)
				return tmp.getWorkerFirstName()+" "+tmp.getWorkerLastName();
		}
		return null;

	}
	
	public static boolean adminLogin(String email, String password) {
		for(Worker w:workers) {
			if(w.getWorkerId()<200) {
				Employer emp=(Employer) w;
				if(emp.getEmail().equals(email) && emp.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
