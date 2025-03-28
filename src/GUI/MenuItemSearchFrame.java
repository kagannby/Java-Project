package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MenuItem.MenuItemSys;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuItemSearchFrame extends JFrame {

	private JPanel contentPane;
	JComboBox<String>comboBox = new JComboBox<String>();
	JTextArea textArea = new JTextArea();
	public void setTextArea(String res) {
		textArea.setText(res);
	}
	public JComboBox<String> getCombobox(){
		return comboBox;
	}
	MenuItemFrame mif;
	
	public MenuItemSearchFrame(MenuItemFrame frame) {
		mif=frame;
		setTitle("Search Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.setText(MenuItemSys.searchID(Integer.parseInt(comboBox.getSelectedItem().toString())).toString());
			}
		});
		
		
		comboBox.setBounds(187, 27, 177, 22);
		contentPane.add(comboBox);
		
		
		textArea.setBounds(10, 58, 552, 302);
		contentPane.add(textArea);
		
		JButton closeBtn = new JButton("CLOSE");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mif.setVisible(true);
				dispose();
			}
		});
		closeBtn.setBounds(243, 371, 89, 23);
		contentPane.add(closeBtn);
	}

}
