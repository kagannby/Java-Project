package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Customer.CustomerSys;
import Worker.WorkerSys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserLoginFrame extends JFrame {

	private JPanel contentPane;
	private JLabel msgLbl;
	private JTextField emailTF;
	
	ChoiceFrame cf;
	CustomerFrame cuf=new CustomerFrame(this);
	private JTextField passwordTF;
	public UserLoginFrame(ChoiceFrame frame) {
		cf=frame;
		setTitle("User Login Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		msgLbl = new JLabel("");
		msgLbl.setBounds(10, 236, 310, 14);
		contentPane.add(msgLbl);
		
		JLabel custLbl = new JLabel("Customer Login");
		custLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		custLbl.setBounds(21, 11, 138, 29);
		contentPane.add(custLbl);
		
		JLabel emailLbl = new JLabel("EMAIL:");
		emailLbl.setBounds(43, 65, 76, 14);
		contentPane.add(emailLbl);
		
		emailTF = new JTextField();
		emailTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(emailTF.getText().isEmpty() || passwordTF.getText().isEmpty()) {
						msgLbl.setText("Fill the necessary fields!");
						
					}
					else {
						if(CustomerSys.userLogin(emailTF.getText(),passwordTF.getText())) {
							cuf.setVisible(true);
							dispose();
						}
						else {
							msgLbl.setText("Wrong password or email!");
						}
					}
				}
			}
		});
		emailTF.setBounds(146, 62, 153, 20);
		contentPane.add(emailTF);
		emailTF.setColumns(10);
		
		JLabel passwordLbl = new JLabel("PASSWORD:");
		passwordLbl.setBounds(43, 98, 86, 14);
		contentPane.add(passwordLbl);
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emailTF.getText().isEmpty() || passwordTF.getText().isEmpty()) {
					msgLbl.setText("Fill the necessary fields!");
					
				}
				else {
					if(CustomerSys.userLogin(emailTF.getText(),passwordTF.getText())) {
						cuf.setVisible(true);
						dispose();
					}
					else {
						msgLbl.setText("Wrong password or email!");
					}
				}
			}
		});
		loginBtn.setBounds(120, 142, 89, 23);
		contentPane.add(loginBtn);
		
		JLabel backLbl = new JLabel("Go Back");
		backLbl.setBounds(355, 0, 79, 14);
		contentPane.add(backLbl);
		
		JButton choiceBtn = new JButton("CHOICE");
		choiceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setVisible(true);
				dispose();
			}
		});
		choiceBtn.setBounds(335, 16, 89, 23);
		contentPane.add(choiceBtn);
		
		passwordTF = new JTextField();
		passwordTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(emailTF.getText().isEmpty() || passwordTF.getText().isEmpty()) {
						msgLbl.setText("Fill the necessary fields!");
						
					}
					else {
						if(CustomerSys.userLogin(emailTF.getText(),passwordTF.getText())) {
							cuf.setVisible(true);
							dispose();
						}
						else {
							msgLbl.setText("Wrong password or email!");
						}
					}
				}
			}
		});
		passwordTF.setColumns(10);
		passwordTF.setBounds(146, 95, 153, 20);
		contentPane.add(passwordTF);
	}

}
