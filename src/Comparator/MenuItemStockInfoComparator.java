package Comparator;

import java.util.Comparator;

import MenuItem.*;

public class MenuItemStockInfoComparator implements Comparator<restMenuItem>{

	@Override
	public int compare(restMenuItem m1, restMenuItem m2) {
		if(m2.getStockInfo()-m1.getStockInfo()>=0) {
			return 1;
		}else
			return -1;
	}

}
