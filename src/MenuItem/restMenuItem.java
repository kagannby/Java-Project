package MenuItem;

public class restMenuItem implements Comparable<restMenuItem>{
	private int itemId;
	private String itemName;
	private String itemType;
	private double itemBasePrice;
	private int stockInfo;
	private static int numOfMenuItem=0;
	private static final int MENUITEMLIMIT=50;
	
	public restMenuItem() {
		this.itemId=5000;
		this.itemName="No menu item name";
		this.itemType="No menu item type";
		this.itemBasePrice=0;
		this.stockInfo=0;
	}
	
	public restMenuItem(int itemId, String itemName,  String itemType, double itemBasePrice, int stockInfo) {
		this.itemId=itemId;
		this.itemName=itemName;
		this.itemType=itemType;
		this.itemBasePrice=itemBasePrice;
		this.stockInfo=stockInfo;
	}
	
	public boolean checkId(int id) {
		if(this.itemId==id) {
			return true;
		}
		return false;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public double getItemBasePrice() {
		return itemBasePrice;
	}

	public void setItemBasePrice(double itemBasePrice) {
		this.itemBasePrice = itemBasePrice;
	}

	public int getStockInfo() {
		return stockInfo;
	}

	public void setStockInfo(int stockInfo) {
		this.stockInfo = stockInfo;
	}

	public static int getNumOfMenuItem() {
		return numOfMenuItem;
	}

	public static void setNumOfMenuItem(int numOfMenuItem) {
		restMenuItem.numOfMenuItem = numOfMenuItem;
	}

	public static int getMenuitemlimit() {
		return MENUITEMLIMIT;
	}
	
	public String toString() {
		return "MenuItem Info" +
				"\nItem id= " + this.itemId +
				"\nItem Name= " + this.itemName +
				"\nItem Type= " + this.itemType +
				"\nItem base price= " + this.itemBasePrice +
				"\nItem stock info= " + this.stockInfo + "\n\n";
	}

	@Override
	public int compareTo(restMenuItem m1) {
		// TODO Auto-generated method stub
		return this.itemId-m1.itemId;
	}
}

