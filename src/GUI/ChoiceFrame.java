package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChoiceFrame extends JFrame {

	private JPanel contentPane;
	
	AdminLoginFrame alf=new AdminLoginFrame(this);
	UserLoginFrame ulf=new UserLoginFrame(this);
	
	public ChoiceFrame() {
		setTitle("Choice Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel adminLbl = new JLabel("Admin Panel");
		adminLbl.setBounds(86, 93, 110, 23);
		contentPane.add(adminLbl);
		
		JButton adminBtn = new JButton("ADMIN");
		adminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alf.setVisible(true);
				setVisible(false);
			}
		});
		adminBtn.setBounds(68, 128, 89, 23);
		contentPane.add(adminBtn);
		
		JLabel userLbl = new JLabel("User Panel");
		userLbl.setBounds(256, 97, 110, 14);
		contentPane.add(userLbl);
		
		JButton userBtn = new JButton("USER");
		userBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ulf.setVisible(true);
				setVisible(false);
			}
		});
		userBtn.setBounds(236, 128, 89, 23);
		contentPane.add(userBtn);
	}
}
