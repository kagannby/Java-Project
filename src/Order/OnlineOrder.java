package Order;

import java.util.ArrayList;
import java.util.Scanner;
import OrderInterface.*;

public class OnlineOrder extends Order{

	public static final int DELIVERYFEE=30;
	
	public OnlineOrder(OrderItem item, int orderId, String orderDate, double orderCharge) {
		super(item, orderId, orderDate,orderCharge);
	}
	
	/*public OnlineOrder () {
		super();
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	
	public void getInput() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter address of the order: ");
		this.orderAddress=scanner.nextLine();
		System.out.println("Enter mayment method: ");
		this.paymentMethod=scanner.nextLine();
	}*/

	@Override
	public double calculateTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean discount() {
		if(getOrderCharge() >= 480) {
			setOrderCharge(this.getOrderCharge()-this.getOrderCharge()*0.1);
			return true;
		}else if(getOrderCharge()>=380) {
			setOrderCharge(getOrderCharge()-getOrderCharge()*0.05);
			return true;
		}
		
		return false;
	}
	
}
