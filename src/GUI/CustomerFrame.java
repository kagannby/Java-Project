package GUI;
import MenuItem.*;
import Order.OrderSys;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	AddOrderFrame aof=new AddOrderFrame(this);
	UserLoginFrame ulf;
	public CustomerFrame(UserLoginFrame frame) {
		ulf=frame;
		//clf = frame;
		setTitle("Customer Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 33, 321, 351);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton displayMenuBtn = new JButton("Display Menu");
		displayMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(MenuItemSys.displayAll());
			}
		});
		displayMenuBtn.setBounds(402, 33, 159, 32);
		contentPane.add(displayMenuBtn);
		
		JButton addOrderBtn = new JButton("Add Order");
		addOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] foodArr = MenuItemSys.getFoodIdArray();
				String[] bevgArr = MenuItemSys.getBevgIdArray();
				String[] extraArr = MenuItemSys.getExtraIdArray();
				
				aof.getFoodCB().setModel(new DefaultComboBoxModel(foodArr));
				aof.getBevgCB().setModel(new DefaultComboBoxModel(bevgArr));
				aof.getExtraCB().setModel(new DefaultComboBoxModel(extraArr));
				
				aof.setVisible(true);
				dispose();
			}
		});
		addOrderBtn.setBounds(402, 92, 159, 32);
		contentPane.add(addOrderBtn);
		
		JButton getReceiptBtn = new JButton("Get Receipt");
		getReceiptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(OrderSys.display());
			}
		});
		getReceiptBtn.setBounds(402, 145, 159, 32);
		contentPane.add(getReceiptBtn);
	}
}
