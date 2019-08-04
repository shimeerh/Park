import java.io.File;

import javax.swing.JFrame;

public class Main {
	

	public static void main(String[] args) throws InterruptedException {
		ImageToText ob = new ImageToText();

		DBSend db = new DBSend();
		EntryGate eg=new EntryGate();
		eg.setVisible(true);
		eg.setSize(800,500);
		eg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//directory of images
		File Files = new File("C:\\Users\\shime\\eclipse-workspace\\ParkingSpaceAnalyser\\sample images");
		//count number of images(cars)
		int Count = Files.list().length;
//		System.out.println(Count);
		
		for(int i=1; i<=Count; i++) {
			//location for image file
			
			String s = ob.getText("C:\\Users\\shime\\eclipse-workspace\\ParkingSpaceAnalyser\\sample images\\" + i + ".jpeg");
			if(s == null) {
				continue;
			}
			s = s.replaceAll("[^a-zA-Z0-9_-]", "");
			System.out.println(s);
			//insert values into table
			int status = db.entry(s);
			if(status == 1) {
				System.out.println("Inserted");
			}
			//get data from table
			String rowData[][] = db.garage();
//			System.out.println(rowData.length);
			//insert row to table
			eg.model.addRow(rowData[i-1]);
			eg.count++;
			eg.vacantSpace--;
			eg.countLb.setText("Filled->" + Integer.toString( eg.count));
			eg.vacantLb.setText("Vacant->" + Integer.toString( eg.vacantSpace));
			Thread.sleep(2000);
			
		}
	}
}
