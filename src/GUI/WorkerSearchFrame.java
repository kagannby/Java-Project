package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Worker.WorkerSys;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkerSearchFrame extends JFrame {

	private JPanel contentPane;
	JComboBox<String> searchCB = new JComboBox<String>();
	JTextArea textArea = new JTextArea();
	public void setTextArea(String res) {
		textArea.setText(res);
	}
	public JComboBox<String> getCombobox(){
		return searchCB;
	}
	
	public WorkerSearchFrame() {
		
		
		
		setTitle("Search Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		searchCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.setText(WorkerSys.searchID(Integer.parseInt(searchCB.getSelectedItem().toString())).toString());
				
			}
		});
		
		 
		searchCB.setBounds(16, 41, 249, 21);
		contentPane.add(searchCB);
		
		
		textArea.setBounds(16, 74, 364, 321);
		contentPane.add(textArea);
		
		JButton closeBtn = new JButton("CLOSE");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerFrame wf= new WorkerFrame(null);
				wf.setVisible(true);
				dispose();
			}
		});
		closeBtn.setBounds(148, 401, 85, 21);
		contentPane.add(closeBtn);
	}
}
