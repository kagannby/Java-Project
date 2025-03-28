package Order;
import java.util.Scanner;

import MenuItem.*;
public class OrderItem {
		private restMenuItem item;
		private int quantity;
		private String size;
		Scanner input = new Scanner(System.in);
		
		public OrderItem() {
			this.item=null;
			this.quantity=0;
			this.size="";
		}

		public OrderItem(restMenuItem item, String size) {
			this.item = item;
			this.size = size;
		}

		public restMenuItem getItem() {
			return item;
		}

		public void setItem(restMenuItem item) {
			this.item = item;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public void getInput() {
			System.out.printf("PLease enter the quantity of item: ");
			this.quantity=input.nextInt();
			System.out.println("Please enter the size of the item");
			this.size=input.nextLine();
		}
		@Override
		public String toString() {
			return "item: " + item + 
					"\nquantity: " + quantity + 
					"\nsize: " + size + 
					"\n";
		}
		
		
}