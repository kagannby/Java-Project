package Order;
import java.util.ArrayList;
import java.time.*;
import Order.*;


import java.util.Scanner;
public class OrderSys {
	private static ArrayList<Order> orderArr= new ArrayList<>();
		private static Scanner scanner = new Scanner(System.in);
		
		
		public static int generateOrderId() {
			int id=10001;
			if(orderArr.isEmpty())
				return id;
			else
			{
				for(Order tmp: orderArr) {
					id=tmp.getOrderId()+1;
				}
			}
			return id;
		}
		
		public static String getDate() {
			return LocalDate.now().toString();
		}
		
		public static double calculateOrderItemPrice(OrderItem item) {
			double price=0;
			price=item.getItem().getItemBasePrice();
			if(item.getSize().equalsIgnoreCase("S")) {
				price+=0;
			}
			else if(item.getSize().equalsIgnoreCase("M")){
				price+=price*0.15;
			}
			else
				price+=price*0.30;
			
			return price;
		}
		public static Order searchOrder(int id) {
			for(Order temp: orderArr) {
				if(temp.checkId(id))
				{
					System.out.println("Order " + id + " found!");
					return temp;
				}
			}
			System.out.println("Order " + id + " not found!");
			return null;
		}
		
		
		public static Order removeOrder(int id) {
			for(int i=0;i<orderArr.size();i++) {
				Order temp=orderArr.get(i);
				if(temp.checkId(id)) {
					orderArr.remove(i);
					System.out.println("Order " + id + "removed!");
					return temp;
				}
			}
			return null;
		}
		
		
		public static boolean isOrderExists(int id) {
			for(Order temp: orderArr) {
				if(temp.checkId(id))
					return true;
			}
			return false;
		}
		
		public static boolean addOrder(OrderItem item, String type) {
			Order ord=null;
			int id=OrderSys.generateOrderId();
			String date=OrderSys.getDate();
			double price=OrderSys.calculateOrderItemPrice(item);
			 item.setQuantity(item.getQuantity() + 1); 
			if(type.equalsIgnoreCase("Online")) {
				price+=OnlineOrder.DELIVERYFEE; //delivery fee
				ord = new OnlineOrder(item,id,date,price);
				ord.discount();
			}
			else if(type.equalsIgnoreCase("dineIn")){
				ord=new dineInOrder(item,id,date,price);
				ord.discount();
			}
			
			return orderArr.add(ord);
		
		}
		
	
		public static String display() {
			double total=0;
			int ct=0;
			String result="";
			for(Order temp: orderArr) {
				ct++;
				total+=temp.getOrderCharge();
				result += temp.toString();
			}
			result+="\nOrder  Date is: "+ OrderSys.getDate()+"\n\nTotal "+ct+" Items\nTotal Price :" + total+ " TL\n";
			return result;
		}
	}

