package Main;

import MenuItem.MenuItemSys;
import Worker.WorkerSys;
import Customer.CustomerSys;
import GUI.ChoiceAdminFrame;
import GUI.ChoiceFrame;

public class Main {
	public static void main(String[] args) {
		MenuItemSys.readFromFile();
		WorkerSys.readFromFile();
		CustomerSys.readFromFile();
		ChoiceFrame cf=new ChoiceFrame ();
		cf.setVisible(true);
	}
}
