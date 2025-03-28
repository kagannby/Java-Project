package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MenuItem.* ;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuItemAddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField typeTF;
	private JTextField priceTF;
	private JTextField stockTF;
	private JLabel msgLabel;
	MenuItemFrame mif;
	
	public MenuItemAddFrame(MenuItemFrame frame) {
		mif = frame;
		setTitle("Add Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setBounds(10, 47, 46, 14);
		contentPane.add(nameLbl);
		
		JLabel typeLbl = new JLabel("Type:");
		typeLbl.setBounds(10, 86, 46, 14);
		contentPane.add(typeLbl);
		
		JLabel priceLbl = new JLabel("basePrice:");
		priceLbl.setBounds(10, 131, 89, 14);
		contentPane.add(priceLbl);
		
		JLabel stockLbl = new JLabel("Stock Info:");
		stockLbl.setBounds(10, 180, 89, 14);
		contentPane.add(stockLbl);
		
		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stockInfo;
				String name, type;
				double basePrice;
				type=typeTF.getText();
				stockInfo=Integer.parseInt(stockTF.getText());
				name=nameTF.getText();
				basePrice=Double.parseDouble(priceTF.getText());
				if(MenuItemSys.addMenuItem(name, type, basePrice, stockInfo)) {
					msgLabel.setText(name + " added successfully!");
				}else
				{
					msgLabel.setText("add operation not successful!");
				}
			}
		});
		addBtn.setBounds(118, 264, 89, 23);
		contentPane.add(addBtn);
		
		nameTF = new JTextField();
		nameTF.setBounds(93, 44, 86, 20);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		typeTF = new JTextField();
		typeTF.setColumns(10);
		typeTF.setBounds(93, 83, 86, 20);
		contentPane.add(typeTF);
		
		priceTF = new JTextField();
		priceTF.setColumns(10);
		priceTF.setBounds(93, 128, 86, 20);
		contentPane.add(priceTF);
		
		stockTF = new JTextField();
		stockTF.setColumns(10);
		stockTF.setBounds(93, 177, 86, 20);
		contentPane.add(stockTF);
		
		JButton closeBtn = new JButton("CLOSE");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mif.setVisible(true);
				dispose();
			}
		});
		closeBtn.setBounds(367, 265, 85, 21);
		contentPane.add(closeBtn);
		
		msgLabel = new JLabel("");
		msgLabel.setBounds(34, 347, 438, 13);
		contentPane.add(msgLabel);
		
		JButton clearBtn = new JButton("CLEAR");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTF.setText("");
				typeTF.setText("");
				priceTF.setText("");
				stockTF.setText("");
			}
		});
		clearBtn.setBounds(231, 265, 85, 21);
		contentPane.add(clearBtn);
	}
}
