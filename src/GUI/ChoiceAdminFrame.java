package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChoiceAdminFrame extends JFrame {

	private JPanel contentPane;
	MenuItemFrame mif=new MenuItemFrame(this);
	WorkerFrame wf=new WorkerFrame(this);
	AdminLoginFrame alf;
	public ChoiceAdminFrame(AdminLoginFrame frame) {
		alf=frame;
		setTitle("Admin Choice Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
	                   dispose(); 
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton menuBtn = new JButton("MENU");
		menuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mif.setVisible(true);
				setVisible(false);
			}
		});
		menuBtn.setBounds(78, 124, 89, 23);
		contentPane.add(menuBtn);
		
		JLabel menuLbl = new JLabel("MENU");
		menuLbl.setBounds(105, 99, 50, 14);
		contentPane.add(menuLbl);
		
		JLabel workerLbl = new JLabel("WORKER");
		workerLbl.setBounds(253, 99, 61, 14);
		contentPane.add(workerLbl);
		
		JButton workerBtn = new JButton("WORKER");
		workerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wf.setVisible(true);
				setVisible(false);
			}
		});
		workerBtn.setBounds(232, 124, 89, 23);
		contentPane.add(workerBtn);
		
		
	}
}
