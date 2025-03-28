package Comparator;

import java.util.Comparator;

import MenuItem.*;

public class MenuItemIdComparator implements Comparator<restMenuItem>{

	public int compare(restMenuItem m1, restMenuItem m2) {
		return m1.getItemId()-m2.getItemId();
	}
	
}
