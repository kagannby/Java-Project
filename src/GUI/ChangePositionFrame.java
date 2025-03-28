package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Worker.Employee;
import Worker.Worker;
import Worker.WorkerSys;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePositionFrame extends JFrame {
	JComboBox posCB = new JComboBox();
	JComboBox idCB = new JComboBox();
	private JPanel contentPane;

	public JComboBox<String> getComboBox(){
		return idCB;
	}

	public ChangePositionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select ID");
		lblNewLabel.setBounds(67, 40, 127, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select New Position");
		lblNewLabel_1.setBounds(67, 91, 127, 16);
		contentPane.add(lblNewLabel_1);
		
		posCB.setModel(new DefaultComboBoxModel(new String[] {"Chef", "Accountant", "Waiter", "Waitress"}));
		posCB.setBounds(230, 87, 151, 27);
		contentPane.add(posCB);
		
		idCB.setBounds(230, 36, 151, 27);
		contentPane.add(idCB);
		
		JLabel dispLbl = new JLabel("");
		dispLbl.setBounds(67, 193, 314, 40);
		contentPane.add(dispLbl);
		
		JButton btnNewButton =  new JButton("Change Position");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Worker wrk=WorkerSys.searchID(Integer.parseInt(idCB.getSelectedItem().toString()));
				wrk.setWorkerPosition(posCB.getSelectedItem().toString());
				wrk.setWorkerSalary(Employee.calculateBaseSalary(wrk.getWorkerPosition()));
				dispLbl.setText("Position of "+wrk.getWorkerFirstName()+" "+wrk.getWorkerLastName()+" has been changed!");
			}
		});
		btnNewButton.setBounds(67, 140, 138, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerFrame wf= new WorkerFrame(null);
				wf.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(264, 140, 117, 29);
		contentPane.add(btnNewButton_1);
	}

}
