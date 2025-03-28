package Order;

import java.util.ArrayList;
import java.util.Scanner;
import OrderInterface.*;
public class dineInOrder extends Order{

	public dineInOrder(OrderItem item, int orderId, String orderDate, double OrderCharge) {
		super(item, orderId, orderDate, OrderCharge);
	
	}


	/*public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public boolean isHasReservation() {
		return hasReservation;
	}

	public void setHasReservation(boolean hasReservation) {
		this.hasReservation = hasReservation;
	}
	
	public boolean checkTableId(int id) {
		if(tableId==id) {
			System.out.println("Table in use or reserved!");
			return true;
		}
		return false;
	}*/
	
	public void getInput() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter table id: ");
	}

	@Override
	public double calculateTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean discount() {
		if(getOrderCharge() >= 450) {
			setOrderCharge(getOrderCharge()-(getOrderCharge()*0.1));
			return true;
		}else if(getOrderCharge()>=350) {
			setOrderCharge(getOrderCharge()- (getOrderCharge()*0.05));
			return true;
		}
		
		return false;
	}
}
