import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


@SuppressWarnings("serial")
public class EntryGate extends JFrame{

	private JTable numTable;
	private JLabel heading;
	DBSend db = new DBSend();
	int count= db.instance(),vacantSpace =db.total - count;
	DefaultTableModel model;
	JLabel countLb;
	JLabel vacantLb;
//	public static void main(String[] args) {
//		
//				try {
//				EntryGate eg=new EntryGate();
//				eg.setVisible(true);
//				eg.setSize(800,500);
//				eg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
	
	public EntryGate() {
		super("Entry");
		getContentPane().setBackground(new Color(0, 51, 51));
		setType(Type.POPUP);
		setResizable(false);
		getContentPane().setLayout(null);
		

		//to store data in table
		 String[][] data = {};
		  
//		 // Column Names 
		 String[] columnNames = { "SerialNo.", "LicencePlate", "InTime"}; 
		 numTable=new JTable(new DefaultTableModel(data,columnNames));
		 model = (DefaultTableModel) numTable.getModel();
		 model.addRow(columnNames);
		 numTable.setBounds(15,120, 448,140);
		 numTable.getPreferredSize();
		 
		 //heading
		 heading=new JLabel();
		 heading.setForeground(new Color(255, 255, 255));
		 heading.setText("Car Entry Check");
		 heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
		 heading.setBounds(133, 23,  263, 40);
		 getContentPane().add(heading);

		getContentPane().add(numTable);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(204, 255, 255));
		btnExit.setBounds(186, 288, 97, 25);
		getContentPane().add(btnExit);
		
		 //vacant space counter
		vacantLb = new JLabel("Vacant->" + vacantSpace);
		vacantLb.setForeground(new Color(0, 255, 51));
		vacantLb.setBounds(559, 144, 171, 29);
		getContentPane().add(vacantLb);
		vacantLb.setBackground(new Color(204, 255, 255));
		vacantLb.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		//filled space counter
		countLb = new JLabel("Filled->" + count);
		countLb.setForeground(new Color(255, 0, 0));
		countLb.setBounds(559, 211, 155, 29);
		getContentPane().add(countLb);
		countLb.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            	dispose();	
            }	
        });   
		
	
		
		
    } 
}

	
	
	
	
