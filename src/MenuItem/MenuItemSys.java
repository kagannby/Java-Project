package MenuItem;

import java.awt.MenuItem;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import Comparator.MenuItemBasePriceComparator;
import Comparator.MenuItemIdComparator;
import Comparator.MenuItemStockInfoComparator;
import MenuItem.restMenuItem;

public class MenuItemSys {
	private static HashSet<restMenuItem>menuItems=new HashSet<restMenuItem>();
	private static int countFood=0;
	private static int countBeverage=0;
	private static int countExtra=0;
	
	
	public static void readFromFile() {
		Scanner s;
		File file;
		String name, type;
		int stockInfo, id;
		double basePrice;
		restMenuItem mi=null;
		try {
			file=new File("menuItem.txt");
			s=new Scanner(file);
			while(s.hasNext()) {
				id=s.nextInt();
				name=s.next();
				type=s.next();
				basePrice=s.nextDouble();
				stockInfo=s.nextInt();
				mi=new restMenuItem(id, name, type, basePrice, stockInfo);
				menuItems.add(mi);
				restMenuItem.setNumOfMenuItem(restMenuItem.getNumOfMenuItem()+1);
				if(type.equalsIgnoreCase("Food")) {
					countFood++;
				}else if(type.equalsIgnoreCase("Beverage")) {
					countBeverage++;
				}else if(type.equalsIgnoreCase("Extra")) {
					countExtra++;
				}
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found!");
		}
		System.out.println("file found!");
	}
	
	public static boolean addMenuItem(String name, String type, double basePrice,int stockInfo) {
		int id=0;
		if(!(type.equalsIgnoreCase("Food") || type.equalsIgnoreCase("Beverage") || type.equalsIgnoreCase("Extra"))) {
			return false;
		}else if(type.equalsIgnoreCase("Food")) {
			id=5000+countFood+1;
			countFood++;
		}else if(type.equalsIgnoreCase("Beverage")) {
			id=6000+countBeverage+1;
			countBeverage++;
		}else if(type.equalsIgnoreCase("Extra")) {
			id=7000+countExtra+1;
			countExtra++;
		}
		restMenuItem mi = new restMenuItem(id, name, type, basePrice, stockInfo);
		return menuItems.add(mi);
	}
	
	public static String displayAll() {
		String out = "";
		for(restMenuItem temp: menuItems) {
			out+=temp.toString();
		}
		return out;
	}
	
	public static String DisplayById() {
		String out="Display by Id\n\n";
		MenuItemIdComparator miic= new MenuItemIdComparator();
		TreeSet<restMenuItem> ts= new TreeSet<>(miic);
		ts.addAll(menuItems);
		for(restMenuItem temp: ts) {
			out+=temp.toString();
		}
		return out;
	}
	
	public static String DisplayByBasePrice() {
		String out="Display by Base Price\n\n";
		MenuItemBasePriceComparator mibpc= new MenuItemBasePriceComparator();
		TreeSet<restMenuItem> ts= new TreeSet<>(mibpc);
		ts.addAll(menuItems);
		for(restMenuItem temp: ts) {
			out+=temp.toString();
		}
		return out;
	}
	
	public static String DisplayByStockInfo() {
		String out="Display by Base Price\n\n";
		MenuItemStockInfoComparator misic= new MenuItemStockInfoComparator();
		TreeSet<restMenuItem> ts= new TreeSet<>(misic);
		ts.addAll(menuItems);
		for(restMenuItem temp: ts) {
			out+=temp.toString();
		}
		return out;
	}
	
	public static String[] getFoodIdArray() {
		TreeSet<restMenuItem>set=new TreeSet<restMenuItem>();
		set.addAll(menuItems);
		String[] arr= new String[set.size()];
		int i =0;
		for(restMenuItem tmp: set) {
			if(tmp.getItemId()<6000) {
				arr[i]=tmp.getItemId()+"";
				i++;
			}
		}
		return arr;
	}
	
	public static String[] getBevgIdArray() {
		TreeSet<restMenuItem>set=new TreeSet<restMenuItem>();
		set.addAll(menuItems);
		String[] arr= new String[set.size()];
		int i =0;
		for(restMenuItem tmp: set) {
			if(tmp.getItemId()<7000 && tmp.getItemId()>=6000) {
				arr[i]=tmp.getItemId()+"";
				i++;
			}
		}
		return arr;
	}
	
	public static String[] getExtraIdArray() {
		TreeSet<restMenuItem>set=new TreeSet<restMenuItem>();
		set.addAll(menuItems);
		String[] arr= new String[set.size()];
		int i =0;
		for(restMenuItem tmp: set) {
			if(tmp.getItemId()>=7000) {
				arr[i]=tmp.getItemId()+"";
				i++;
			}
		}
		return arr;
	}
	
	public static String[] getIdArray() {
		TreeSet<restMenuItem>set=new TreeSet<restMenuItem>();
		set.addAll(menuItems);
		String[] arr= new String[set.size()];
		int i =0;
		for(restMenuItem tmp: set) {
			arr[i]=tmp.getItemId()+"";
			i++;
		}
		return arr;
	}
	
	public static restMenuItem searchID(int id) {
		for(restMenuItem tmp: menuItems) {
			if(tmp.getItemId()==id)
				return tmp;
		}
		return null;
	}
	
	public static restMenuItem remove(int id) {
		if(searchID(id)!=null) {
			for(restMenuItem tmp: menuItems) {
				if(tmp.getItemId()==id) {
					menuItems.remove(tmp);
					return tmp;
				}
			}
		}
		return null;
	}
}
