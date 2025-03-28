package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Worker.Employee;
import Worker.WorkerSys;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class WorkerAddFrame extends JFrame {

	private JPanel contentPane;
	private JLabel msgLabel;
	private JTextField fnameTF;
	private JTextField lnameTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JTextArea textArea;
	
	public WorkerAddFrame() {
		setTitle("Add Worker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton closeBtn = new JButton("CLOSE");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerFrame wf = new WorkerFrame(null);
				wf.setVisible(true);
				dispose();
			}
		});
		closeBtn.setBounds(308, 253, 85, 21);
		contentPane.add(closeBtn);
		
		msgLabel = new JLabel("");
		msgLabel.setBounds(10, 257, 274, 13);
		contentPane.add(msgLabel);
		
		JComboBox posCB = new JComboBox();
		posCB.setModel(new DefaultComboBoxModel(new String[] {"Chef", "Accountant", "Waiter", "Waitress"}));
		posCB.setBounds(254, 80, 139, 27);
		contentPane.add(posCB);
		
		JComboBox supCB = new JComboBox();
		supCB.setModel(new DefaultComboBoxModel(new String[] {"101", "102", "103"}));
		supCB.setBounds(254, 109, 139, 27);
		contentPane.add(supCB);
		
		JComboBox branchCB = new JComboBox();
		branchCB.setModel(new DefaultComboBoxModel(new String[] {"Bilkent", "Kecioren", "Bahcelievler"}));
		branchCB.setBounds(254, 140, 139, 27);
		contentPane.add(branchCB);
		
		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id,supId;
				String fname,lname,branch,pos;
				double salary;
				fname=fnameTF.getText();
				lname=lnameTF.getText();
				pos=posCB.getSelectedItem().toString();
				branch=branchCB.getSelectedItem().toString();
				supId=Integer.parseInt(supCB.getSelectedItem().toString());
				Employee emp;
				if(WorkerSys.addEmployee(Employee.calculateId(),fname,lname,pos,Employee.calculateBaseSalary(pos),supId,0,branch))
					textArea.setText("Employee Added");

			}
		});
		addBtn.setBounds(308, 222, 85, 21);
		contentPane.add(addBtn);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 10, 139, 264);
		contentPane.add(textArea);
		
		JLabel fnameLabel = new JLabel("First Name:");
		fnameLabel.setBounds(159, 24, 73, 13);
		contentPane.add(fnameLabel);
		
		fnameTF = new JTextField();
		fnameTF.setBounds(254, 17, 139, 26);
		contentPane.add(fnameTF);
		fnameTF.setColumns(10);
		
		JLabel lnameBtn = new JLabel("Last Name:");
		lnameBtn.setBounds(159, 54, 73, 13);
		contentPane.add(lnameBtn);
		
		lnameTF = new JTextField();
		lnameTF.setColumns(10);
		lnameTF.setBounds(254, 47, 139, 26);
		contentPane.add(lnameTF);
		
		JLabel posLabel = new JLabel("Position:");
		posLabel.setBounds(161, 86, 78, 13);
		contentPane.add(posLabel);
		
		JLabel supervisorLabel = new JLabel("SupervisorID:");
		supervisorLabel.setBounds(161, 115, 85, 13);
		contentPane.add(supervisorLabel);
		
		JLabel branchNameLabel = new JLabel("Branch Name:");
		branchNameLabel.setBounds(161, 146, 100, 13);
		contentPane.add(branchNameLabel);
		
	
	}
}
