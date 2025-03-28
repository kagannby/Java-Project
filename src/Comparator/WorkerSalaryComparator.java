package Comparator;

import java.util.Comparator;

import Worker.Worker;

public class WorkerSalaryComparator implements Comparator<Worker>{

	@Override
	public int compare(Worker w1, Worker w2) {
		if( (int)(w2.getWorkerSalary()-w1.getWorkerSalary())!=0)
			return (int)(w2.getWorkerSalary()-w1.getWorkerSalary());
		else
			return 1;
	}
	
}
