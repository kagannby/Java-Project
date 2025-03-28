package Comparator;

import java.util.Comparator;

import Worker.Worker;

public class WorkerIdComparator implements Comparator<Worker>{

	@Override
	public int compare(Worker o1, Worker o2) {
		return o1.getWorkerId()-o2.getWorkerId();
	}

}
