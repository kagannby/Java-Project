package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Worker.Worker;
import Worker.WorkerSys;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CalculateSalaryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField extraHourTF;
	JComboBox<String> idCB = new JComboBox<String>();
	
	public JComboBox<String> getComboBox(){
		return idCB;
	}

	public CalculateSalaryFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		extraHourTF = new JTextField();
		extraHourTF.setBounds(262, 89, 130, 35);
		contentPane.add(extraHourTF);
		extraHourTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Extra Hours Worked:");
		lblNewLabel.setBounds(51, 89, 190, 35);
		contentPane.add(lblNewLabel);
		
		JLabel dispLbl = new JLabel("");
		dispLbl.setBounds(66, 205, 332, 46);
		contentPane.add(dispLbl);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Worker wrk;
				double newsalary;
				int eh= Integer.parseInt(extraHourTF.getText());
				wrk=WorkerSys.searchID(Integer.parseInt(idCB.getSelectedItem().toString()));
				newsalary=wrk.calculateExtraHour(wrk.getWorkerPosition(), wrk.getWorkerSalary(), eh); 
				wrk.setWorkerSalary(newsalary);
				dispLbl.setText("New Salary: "+newsalary);
				}
		});
		btnNewButton.setBounds(161, 164, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Select ID");
		lblNewLabel_1.setBounds(51, 40, 163, 29);
		contentPane.add(lblNewLabel_1);
		
		idCB.setBounds(262, 42, 130, 27);
		contentPane.add(idCB);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerFrame wf=new WorkerFrame(null);
				wf.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(281, 164, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}
