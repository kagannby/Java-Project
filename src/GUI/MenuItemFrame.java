package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MenuItem.MenuItemSys;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MenuItemFrame extends JFrame {

	private JPanel contentPane;
	private JLabel msgLabel;
	private JTextArea textArea;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	MenuItemSearchFrame sf=new MenuItemSearchFrame(this);
	MenuItemAddFrame af= new MenuItemAddFrame(this);
	MenuItemRemoveFrame rf=new MenuItemRemoveFrame(this);
	ChoiceAdminFrame caf;
	
	public MenuItemFrame(ChoiceAdminFrame frame) {
		caf=frame;
		setTitle("MenuItem Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel menuItemLabel = new JLabel("MenuItem");
		menuItemLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		menuItemLabel.setBounds(20, 12, 237, 45);
		contentPane.add(menuItemLabel);
		
		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				af.setVisible(true);
				setVisible(false);
			}
		});
		addBtn.setBounds(386, 207, 89, 23);
		contentPane.add(addBtn);
		
		JCheckBox byBasePriceChkBx = new JCheckBox("Display By Base Price");
		buttonGroup.add(byBasePriceChkBx);
		byBasePriceChkBx.setBounds(374, 63, 164, 23);
		contentPane.add(byBasePriceChkBx);
		
		JCheckBox byIdChkBx = new JCheckBox("Display By Id");
		buttonGroup.add(byIdChkBx);
		byIdChkBx.setBounds(255, 63, 121, 23);
		contentPane.add(byIdChkBx);
		
		JCheckBox byStockChkBx = new JCheckBox("Display By Stock");
		buttonGroup.add(byStockChkBx);
		byStockChkBx.setBounds(539, 63, 146, 23);
		contentPane.add(byStockChkBx);
		
		JButton removeBtn = new JButton("REMOVE");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rf.setVisible(true);
				setVisible(false);
			}
		});
		removeBtn.setBounds(386, 173, 89, 23);
		contentPane.add(removeBtn);
		
		JButton srcBtn = new JButton("SEARCH");
		srcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sf.getCombobox().setModel(new DefaultComboBoxModel<>(MenuItemSys.getIdArray()));
				sf.setTextArea(MenuItemSys.searchID(Integer.parseInt(sf.getCombobox().getSelectedItem().toString())).toString());
				sf.setVisible(true);
				setVisible(false);
			}
		});
		srcBtn.setBounds(386, 139, 89, 23);
		contentPane.add(srcBtn);
		
		JButton dispBtn = new JButton("DISPLAY");
		dispBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(byIdChkBx.isSelected()){
					textArea.setText(MenuItemSys.DisplayById());
				} else if(byBasePriceChkBx.isSelected()) {
					textArea.setText(MenuItemSys.DisplayByBasePrice());
				} else if(byStockChkBx.isSelected()) {
					textArea.setText(MenuItemSys.DisplayByStockInfo());
				}
			}
		});
		dispBtn.setBounds(386, 105, 89, 23);
		contentPane.add(dispBtn);
		
		msgLabel = new JLabel("");
		msgLabel.setBounds(257, 401, 418, 14);
		contentPane.add(msgLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 67, 227, 334);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton goBackBtn = new JButton("GO BACK");
		goBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caf.setVisible(true);
				dispose();
			}
		});
		goBackBtn.setBounds(557, 12, 108, 23);
		contentPane.add(goBackBtn);
	}
}
