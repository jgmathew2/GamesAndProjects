import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class SimpleActionListener implements ActionListener {
		JTextField textField;
		JTextField textField2;
		static String destination;
		static String pieceCurrentPosition;
		JFrame frame;
		
		public SimpleActionListener(String pieceCurrentPosition, String destination, JTextField textField, JTextField textField2, JFrame frame ){
			this.pieceCurrentPosition = pieceCurrentPosition;
			this.destination = destination;
			this.textField = textField;
			this.textField2 = textField2;
			this.frame = frame;
		
			
		}


		public void actionPerformed(ActionEvent event){
			pieceCurrentPosition = textField.getText();
			destination = textField2.getText();
			synchronized(AlertSubmitSynchronizer.getInstance().getAlertSubmitLock()) {
				AlertSubmitSynchronizer.getInstance().setAlertSubmitDone(true);
				AlertSubmitSynchronizer.getInstance().getAlertSubmitLock().notify();
			}
		}

}
