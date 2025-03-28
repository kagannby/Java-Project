package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Worker.WorkerSys;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkerFrame extends JFrame {

	//protected static String[]  DefaultComboBoxModel = null;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel msgLabel;
	
	ChoiceAdminFrame caf;
	
	
	public WorkerFrame(ChoiceAdminFrame frame) {
		
		caf=frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(); 
		scrollPane.setBounds(10, 41, 245, 359); 
		contentPane.add(scrollPane); 
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 41, 245, 359);
		//contentPane.add(textArea);
		scrollPane.setViewportView(textArea);
		
		JLabel workerLabel = new JLabel("WORKER");
		workerLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		workerLabel.setBounds(10, 10, 132, 35);
		contentPane.add(workerLabel);
		
		JButton addBtn = new JButton("ADD WORKER");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerAddFrame af= new WorkerAddFrame();
				af.setVisible(true);
				dispose();
			}
		});
		addBtn.setBounds(267, 315, 101, 21);
		contentPane.add(addBtn);
		
		JCheckBox dispByIdCB = new JCheckBox("Display By Id");
		dispByIdCB.setSelected(true);
		buttonGroup.add(dispByIdCB);
		dispByIdCB.setBounds(267, 82, 214, 21);
		contentPane.add(dispByIdCB);
		
		JCheckBox dispbySalCB = new JCheckBox("Display By Salary");
		buttonGroup.add(dispbySalCB);
		dispbySalCB.setBounds(267, 115, 214, 21);
		contentPane.add(dispbySalCB);
		
		JCheckBox dispByPosCB = new JCheckBox("Display By Position");
		buttonGroup.add(dispByPosCB);
		dispByPosCB.setBounds(267, 148, 214, 21);
		contentPane.add(dispByPosCB);
		
		JButton dispBtn = new JButton("DISPLAY");
		dispBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textArea.setText(WorkerSys.displayAll());
				if(dispByIdCB.isSelected())
					textArea.setText(WorkerSys.DisplayByID());
				else if(dispByPosCB.isSelected())
					textArea.setText(WorkerSys.DisplayByPosition());
				else
					textArea.setText(WorkerSys.DisplayBySalary());
			}
		});
		dispBtn.setBounds(493, 315, 113, 21);
		contentPane.add(dispBtn);
		
		JButton searchBtn = new JButton("SEARCH");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WorkerSearchFrame sf= new WorkerSearchFrame();
				sf.getCombobox().setModel(new DefaultComboBoxModel<>(WorkerSys.getIdArray()));
				sf.setTextArea(WorkerSys.searchID(Integer.parseInt(sf.getCombobox().getSelectedItem().toString())).toString());
				sf.setVisible(true);
				dispose();
			}
		});
		searchBtn.setBounds(380, 315, 101, 21);
		contentPane.add(searchBtn);
		
		JButton calcBtn = new JButton("CALCULATE SALARY");
		calcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculateSalaryFrame csf= new CalculateSalaryFrame();
				csf.getComboBox().setModel(new DefaultComboBoxModel<>(WorkerSys.getIdArray()));
				csf.setVisible(true);
				dispose();

			}		});
		calcBtn.setBounds(429, 354, 177, 21);
		contentPane.add(calcBtn);
		
		JButton changePosBtn = new JButton("CHANGE POSITION");
		changePosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePositionFrame cpf= new ChangePositionFrame();
				cpf.getComboBox().setModel(new DefaultComboBoxModel<>(WorkerSys.getIdArray()));
				cpf.setVisible(true);
				dispose();
			}
		});
		changePosBtn.setBounds(264, 354, 155, 21);
		contentPane.add(changePosBtn);
		
		msgLabel = new JLabel("");
		msgLabel.setBounds(243, 387, 376, 13);
		contentPane.add(msgLabel);
		
		JButton goBackBtn = new JButton("GO BACK");
		goBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caf.setVisible(true);
				dispose();
			}
		});
		goBackBtn.setBounds(498, 10, 108, 23);
		contentPane.add(goBackBtn);
	}
}
