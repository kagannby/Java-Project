package Comparator;

import java.util.Comparator;

import MenuItem.*;

public class MenuItemBasePriceComparator implements Comparator<restMenuItem>{

	@Override
	public int compare(restMenuItem m1, restMenuItem m2) {
		if((int) (m2.getItemBasePrice()-m1.getItemBasePrice())>=0) {
			return 1;
		}else
			return -1;
	}

	

}
