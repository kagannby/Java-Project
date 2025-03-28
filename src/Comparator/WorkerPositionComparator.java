package Comparator;

import java.util.Comparator;

import Worker.Worker;

public class WorkerPositionComparator implements Comparator<Worker>{
	

	@Override
	public int compare(Worker w1, Worker w2) {
		int comp1=0,comp2=0;
		
		String pos1=w1.getWorkerPosition().toLowerCase();
		switch(pos1) {
		case "employer": comp1=5; break;
		case "chef": comp1=4; break;
		case "accountant": comp1=3; break;
		case "waitress": case "waiter": comp1=2; break;
		}
		
		String pos2=w2.getWorkerPosition().toLowerCase();
		switch(pos2) {
		case "employer": comp2=5; break;
		case "chef": comp2=4; break;
		case "accountant": comp2=3; break;
		case "waitress": case "waiter": comp2=2; break;
		}
		if(comp1-comp2!=0)
			return comp2-comp1;
		else return 1;
		
	}
	}
	
	

