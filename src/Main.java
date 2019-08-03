import javax.swing.JFrame;

public class Main {
	

	public static void main(String[] args) throws InterruptedException {
		ImageToText ob = new ImageToText();
//		String s = ob.getText("C:\\Users\\shime\\eclipse-workspace\\ParkingSpaceAnalyser\\sample images\\" + "2.jpeg");
//		s = s.replaceAll("[^a-zA-Z0-9_-]", "");
//		System.out.println(s);
		DBSend db = new DBSend();
		EntryGate eg=new EntryGate();
		eg.setVisible(true);
		eg.setSize(800,500);
		eg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i=1; i<=4; i++) {
			String s = ob.getText("C:\\Users\\shime\\eclipse-workspace\\ParkingSpaceAnalyser\\sample images\\" + i + ".jpeg");
			if(s == null) {
				continue;
			}
			s = s.replaceAll("[^a-zA-Z0-9_-]", "");
			System.out.println(s);
			int status = db.entry(s);
			System.out.println(status);
			String rowData[][] = db.garage();
			Thread.sleep(2000);
			eg.model.addRow(rowData[i]);
			eg.count++;
			eg.vacantSpace--;
			eg.lblCount.setText("Count->" + Integer.toString( eg.count - 1));
			eg.lblVacant.setText("Vacant->" + Integer.toString( eg.vacantSpace +1));
			
		}
	}
}
