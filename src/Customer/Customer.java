package Customer;

	public class Customer {
		private int customerId;
		private String customerFirstName;
		private String customerLastName;
		private String customerEmail;
		private String customerPassword;
		private static int numOfCustomer=0;
		private static final int CUSTOMERLIMIT=100;
		
		public Customer() {
			this.customerId=10000;
			this.customerFirstName="No customer first name";
			this.customerLastName="No customer last name";
			this.customerEmail="No customer email";
			this.customerPassword="No customer password";
		}

		public Customer(int customerId, String customerFirstName, String customerLastName, String customerEmail,
				String customerPassword) {
			super();
			this.customerId = customerId;
			this.customerFirstName = customerFirstName;
			this.customerLastName = customerLastName;
			this.customerEmail = customerEmail;
			this.customerPassword = customerPassword;
		}
		
		public boolean checkId(int id) {
			if(this.customerId==id) {
				return true;
			}
			return false;
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getCustomerFirstName() {
			return customerFirstName;
		}

		public void setCustomerFirstName(String customerFirstName) {
			this.customerFirstName = customerFirstName;
		}

		public String getCustomerLastName() {
			return customerLastName;
		}

		public void setCustomerLastName(String customerLastName) {
			this.customerLastName = customerLastName;
		}

		public String getCustomerEmail() {
			return customerEmail;
		}

		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}

		public String getCustomerPassword() {
			return customerPassword;
		}

		public void setCustomerPassword(String customerPassword) {
			this.customerPassword = customerPassword;
		}

		public static int getNumOfCustomer() {
			return numOfCustomer;
		}

		public static void setNumOfCustomer(int numOfCustomer) {
			Customer.numOfCustomer = numOfCustomer;
		}

		public static int getCustomerlimit() {
			return CUSTOMERLIMIT;
		}
		
		public String toString() {
			return "Customer Info" +
					"\nCustomer id= " + this.customerId +
					"\nCustomer first name= " + this.customerFirstName +
					"\nCustomer last name= " + this.customerLastName +
					"\nCustomer email= " + this.customerEmail +
					"\nCustomer password= " + this.customerPassword;
		}
	}
