package GUI;
import Order.*;
import MenuItem.*;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddOrderFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JComboBox beverageComboBox;
	JComboBox foodComboBox;
	JComboBox extraComboBox;

	
	public  JComboBox getFoodCB() {
		return foodComboBox;
	}
	
	public  JComboBox getBevgCB() {
		return beverageComboBox;
	}
	
	public  JComboBox getExtraCB() {
		return extraComboBox;
	}
	
	CustomerFrame cf;
	public AddOrderFrame(CustomerFrame frame) {
		cf=frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 25, 241, 397);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setEditable(false);
		
		
		JRadioButton onlineRadioBtn = new JRadioButton("Online");
		onlineRadioBtn.setSelected(true);
		buttonGroup.add(onlineRadioBtn);
		onlineRadioBtn.setBounds(345, 25, 103, 21);
		contentPane.add(onlineRadioBtn);
		
		JRadioButton dineInRadioBtn = new JRadioButton("dineIn");
		buttonGroup.add(dineInRadioBtn);
		dineInRadioBtn.setBounds(469, 25, 103, 21);
		contentPane.add(dineInRadioBtn);
		
		JLabel foodChoiceLabel = new JLabel("food choice ");
		foodChoiceLabel.setBounds(299, 64, 94, 13);
		contentPane.add(foodChoiceLabel);
		
		JLabel beverageChoiceLabel = new JLabel("beverage choice");
		beverageChoiceLabel.setBounds(299, 95, 137, 13);
		contentPane.add(beverageChoiceLabel);
		
		 foodComboBox = new JComboBox();
		foodComboBox.setBounds(402, 60, 103, 21);
		contentPane.add(foodComboBox);
		
		 beverageComboBox = new JComboBox();
		beverageComboBox.setBounds(402, 91, 103, 21);
		contentPane.add(beverageComboBox);
		
		JLabel extraChoiceLabel = new JLabel("extra choice");
		extraChoiceLabel.setBounds(299, 125, 94, 13);
		contentPane.add(extraChoiceLabel);
		
		 extraComboBox = new JComboBox();
		extraComboBox.setBounds(402, 121, 103, 21);
		contentPane.add(extraComboBox);
		
		JLabel foodSizeLabel = new JLabel("food size");
		foodSizeLabel.setBounds(515, 64, 70, 13);
		contentPane.add(foodSizeLabel);
		
		JComboBox foodSizeComboBox = new JComboBox();
		foodSizeComboBox.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L"}));
		foodSizeComboBox.setBounds(604, 60, 70, 21);
		contentPane.add(foodSizeComboBox);
		
		JLabel beverageSizeLabel = new JLabel("beverage size");
		beverageSizeLabel.setBounds(515, 95, 103, 13);
		contentPane.add(beverageSizeLabel);
		
		JComboBox beverageSizeComboBox = new JComboBox();
		beverageSizeComboBox.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L"}));
		beverageSizeComboBox.setBounds(604, 91, 70, 21);
		contentPane.add(beverageSizeComboBox);
		
		JButton addOrderBtn = new JButton("ADD");
		addOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restMenuItem item= new restMenuItem();
				
				
				int itemId=Integer.parseInt(foodComboBox.getSelectedItem().toString());
				item=MenuItemSys.searchID(itemId);		
				String size=foodSizeComboBox.getSelectedItem().toString();
				OrderItem orderIt= new OrderItem(item,size);
				
				if(onlineRadioBtn.isSelected()) {
					OrderSys.addOrder(orderIt, "Online");
				}
				else {
					OrderSys.addOrder(orderIt, "dineIn");
				}
				
				restMenuItem bevg= new restMenuItem();
				int bevgId=Integer.parseInt(beverageComboBox.getSelectedItem().toString());
				bevg=MenuItemSys.searchID(bevgId);		
				String bsize=beverageSizeComboBox.getSelectedItem().toString();
				OrderItem bevgOrderIt= new OrderItem(bevg,bsize);
				
				if(onlineRadioBtn.isSelected()) {
					OrderSys.addOrder(bevgOrderIt, "Online");
				}
				else {
					OrderSys.addOrder(bevgOrderIt, "dineIn");
				}
				
				restMenuItem ext= new restMenuItem();
				int extId=Integer.parseInt(extraComboBox.getSelectedItem().toString());
				ext=MenuItemSys.searchID(extId);		
				OrderItem extraIt= new OrderItem(ext,"S");
				
				if(onlineRadioBtn.isSelected()) {
					OrderSys.addOrder(extraIt, "Online");
				}
				else {
					OrderSys.addOrder(extraIt, "dineIn");
				}
				textPane.setText("Order Added");
			}		});
		addOrderBtn.setBounds(330, 207, 118, 21);
		contentPane.add(addOrderBtn);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(513, 203, 117, 29);
		contentPane.add(btnNewButton);
		

	}
}
