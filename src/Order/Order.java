package Order;

import java.util.ArrayList;
import java.util.Scanner;
import OrderInterface.*;

public abstract class Order implements OrderInterface{
	private OrderItem item;
	private int orderId;
	private String orderDate;
	private double orderCharge;
	
	public Order(OrderItem item, int orderId, String orderDate, double orderCharge) {
		this.item=item;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderCharge = orderCharge;
	}

	
	public boolean checkId(int id) {
		if(id==orderId) {
			System.out.println("Id exists!");
			return true;
		}
		return false;
	}
	
	public abstract double calculateTotalPrice();

	/*public ArrayList<OrderItem> getItemArr() {
		return itemArr;
	}

	public void setItemArr(ArrayList<OrderItem> itemArr) {
		this.itemArr = itemArr;
	}*/
	public OrderItem getItem() {
		return item;
	}
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderCharge() {
		return orderCharge;
	}

	public void setOrderCharge(double orderCharge) {
		this.orderCharge = orderCharge;
	}
	
	public void getInput() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter order Date: ");
		this.orderDate=scanner.nextLine();
	}
	
	public String toString() {
		return "\nOrder id: " + this.orderId +
				"\nItem Name: "+ this.item.getItem().getItemName()+
				"\nItem Quantity: "+this.item.getQuantity()+
				"\nItem Size: "+this.item.getSize()+
				"\nOrder Charge: " + this.orderCharge +"\n";
	}
}
