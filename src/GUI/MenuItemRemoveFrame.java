package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MenuItem.MenuItemSys;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuItemRemoveFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel msgLabel;
	
	MenuItemFrame mif;
	
	public MenuItemRemoveFrame(MenuItemFrame frame) {
		mif=frame;
		setTitle("Remove Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLbl = new JLabel("Enter id:");
		idLbl.setBounds(110, 92, 67, 13);
		contentPane.add(idLbl);
		
		textField = new JTextField();
		textField.setBounds(187, 89, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton removeBtn = new JButton("REMOVE");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MenuItemSys.remove(Integer.parseInt(textField.getText()))==null) {
					msgLabel.setText("remove cannot be performed");
				}else {
					msgLabel.setText("remove done successfully");
				}
			}
		});
		removeBtn.setBounds(92, 178, 85, 21);
		contentPane.add(removeBtn);
		
		JButton closeBtn = new JButton("CLOSE");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mif.setVisible(true);
				dispose();
			}
		});
		closeBtn.setBounds(246, 178, 85, 21);
		contentPane.add(closeBtn);
		
		msgLabel = new JLabel("");
		msgLabel.setBounds(69, 240, 297, 13);
		contentPane.add(msgLabel);
	}
}
