import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class ExitGate extends JFrame {

	private JPanel contentPane;
	private JTable numTable;
	private JTextField licencetext;
	private JTextField textFieldIn;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			
					ExitGate frame = new ExitGate();
					frame.setVisible(true);
					frame.setSize(800,500);
				
	
	}


	public ExitGate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		numTable = new JTable();
		numTable.setBounds(58, 0, 268, 240);
		String[][] data = { 
	            { "1", "KA04DD1444", "08:30" ,"100"}, 
	            { "2", "CG05MA6014", "9:00","200" } 
	        }; 
	  
	 // Column Names 
	 String[] columnNames = {"LicencePlate", "InTime","OutTime","ParkingFee"};
		
		JButton showB = new JButton("show");
		showB.setBounds(327, 84, 97, 25);
		contentPane.add(showB);
		
		JButton exitB = new JButton("Exit");
		exitB.setBounds(289, 388, 97, 25);
		contentPane.add(exitB);
		
		
		
		JLabel LicenceNolb = new JLabel("Licence Number");
		LicenceNolb.setFont(new Font("Stencil", Font.PLAIN, 15));
		LicenceNolb.setBounds(12, 81, 148, 35);
		contentPane.add(LicenceNolb);
		
		licencetext= new JTextField();
		licencetext.setBounds(159, 85, 116, 22);
		contentPane.add(licencetext);
		licencetext.setColumns(10);
		
		JLabel LabelIn = new JLabel("In-Time");
		 LabelIn.setFont(new Font("Stencil", Font.PLAIN, 15));
		 LabelIn.setBounds(53, 226, 85, 16);
		contentPane.add( LabelIn);
		
		textFieldIn = new JTextField();
		textFieldIn.setBounds(180, 221, 116, 22);
		contentPane.add(textFieldIn);
		textFieldIn.setColumns(10);
		
		JLabel outlbl = new JLabel("Out-Time");
		outlbl.setFont(new Font("Stencil", Font.PLAIN, 15));
		outlbl.setBounds(417, 226, 85, 16);
		contentPane.add(outlbl);
		
		JTextField outtime= new JTextField();
		outtime.setBounds(539, 221, 116, 22);
		contentPane.add(outtime);
		outtime.setColumns(10);
		
		JLabel dur= new JLabel("Duration");
		dur.setFont(new Font("Stencil", Font.PLAIN, 15));
		dur.setBounds(53, 319, 85, 16);
		contentPane.add(dur);
		
		JTextField txtdur= new JTextField();
		txtdur.setBounds(180, 313, 116, 22);
		contentPane.add(txtdur);
		txtdur.setColumns(10);
		
		JLabel lblfee= new JLabel("Fee");
		lblfee.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblfee.setBounds(417, 319, 56, 16);
		contentPane.add(lblfee);
		
		JTextField txtfee= new JTextField();
		txtfee.setBounds(539, 316, 116, 22);
		contentPane.add(txtfee);
		txtfee.setColumns(10);
		
		showB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String licence=licencetext.getText();
            DBSend db=new DBSend();
            String[] res=db.exit(licence);
            textFieldIn.setText(res[1]);
            outtime.setText(res[2]);
            txtdur.setText(res[3]);
            txtfee.setText(Integer.parseInt(res[3])*3+"Rs");
            
            	
            }
            	
            });
            
		
	}
}

