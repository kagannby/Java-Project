package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Worker.WorkerSys;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField emailTF;
	private JLabel msgLbl;
	ChoiceFrame cf;
	ChoiceAdminFrame caf=new ChoiceAdminFrame(this);
	private JTextField passwordTF;
	public AdminLoginFrame(ChoiceFrame frame) {
		cf=frame; 
		setTitle("Admin Login Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel emailLbl = new JLabel("EMAIL:");
		emailLbl.setBounds(50, 104, 68, 14);
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
						if(WorkerSys.adminLogin(emailTF.getText(),passwordTF.getText())) {
							caf.setVisible(true);
							dispose();
						}
						else {
							msgLbl.setText("Wrong password or email!");
						}
					}
				}
			}
		});
		emailTF.setBounds(140, 101, 159, 20);
		contentPane.add(emailTF);
		emailTF.setColumns(10);
		
		JLabel passwordLbl = new JLabel("PASSWORD:");
		passwordLbl.setBounds(50, 148, 99, 14);
		contentPane.add(passwordLbl);
		
		JButton LoginBtn = new JButton("LOGIN");
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emailTF.getText().isEmpty() || passwordTF.getText().isEmpty()) {
					msgLbl.setText("Fill the necessary fields!");
					
				}
				else {
					if(WorkerSys.adminLogin(emailTF.getText(),passwordTF.getText())) {
						caf.setVisible(true);
						dispose();
					}
					else {
						msgLbl.setText("Wrong password or email!");
					}
				}
			}
		});
		LoginBtn.setBounds(124, 194, 89, 23);
		contentPane.add(LoginBtn);
		
		JButton choiceBtn = new JButton("CHOICE");
		choiceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setVisible(true);
				dispose();
			}
		});
		choiceBtn.setBounds(317, 11, 81, 23);
		contentPane.add(choiceBtn);
		
		
		msgLbl = new JLabel("");
		msgLbl.setBounds(10, 232, 199, 14);
		contentPane.add(msgLbl);
		
		JLabel userLbl = new JLabel("Go Back");
		userLbl.setBounds(252, 15, 68, 14);
		contentPane.add(userLbl);
		
		JLabel adminLbl = new JLabel("Admin Login");
		adminLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		adminLbl.setBounds(10, 15, 142, 35);
		contentPane.add(adminLbl);
		
		passwordTF = new JTextField();
		passwordTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(emailTF.getText().isEmpty() || passwordTF.getText().isEmpty()) {
						msgLbl.setText("Fill the necessary fields!");
						
					}
					else {
						if(WorkerSys.adminLogin(emailTF.getText(),passwordTF.getText())) {
							caf.setVisible(true);
							dispose();
						}
						else {
							msgLbl.setText("Wrong password or email!");
						}
					}
				}
			}
		});
		passwordTF.setBounds(140, 145, 159, 20);
		contentPane.add(passwordTF);
		passwordTF.setColumns(10);
	}
}
