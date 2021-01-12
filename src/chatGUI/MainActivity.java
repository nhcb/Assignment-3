package chatGUI;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;

/** The mainActivity class, the main class for the chatGUI
 * 
 * @author Nicky
 *
 */
public class MainActivity extends Activity {
	ButtonGroup group;
	
	/** Constructor for the main activity
	 * 
	 */
	public MainActivity() {
		super("Choose mode:");
		// Add label
		this.setLabel("Choose a work mode:");
		// Add radioButtons
		group = this.setRadioButtons(1,0,"Run as Server", "Run as Client");
		// Add buttons
		this.setButton("Start", "Start", "Start current selected mode");
		this.setButton("Exit", "Exit", "Exit the program");
		// Pack method to create nice layout
		pack();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start")) {
			String selection = group.getSelection().getActionCommand();
			if(selection.equals("Run as Client")) {
				 // Run the GUI construction in the Event-Dispatching thread for thread-safety
			      SwingUtilities.invokeLater(new Runnable() {
			         @Override
			         public void run() {
			            new StartClientActivity(); // Let the constructor do the job
			         }
			      });
			      // hacky way to close
			      this.setVisible(false);
			}
			else if(selection.equals("Run as Server")){
				// Run the GUI construction in the Event-Dispatching thread for thread-safety
			      SwingUtilities.invokeLater(new Runnable() {
			         @Override
			         public void run() {
			            new ServerActivity(); // Let the constructor do the job
			         }
			      });
			      // hacky way to close
			      this.setVisible(false);
			}
		} if(e.getActionCommand().equals("Exit")) {
			// exit program
			System.exit(0);
		}
		
	}
	

	   // The entry main() method
	   public static void main(String[] args) {
	      // Run the GUI construction in the Event-Dispatching thread for thread-safety
	      SwingUtilities.invokeLater(new Runnable() {
	         @Override
	         public void run() {
	            new MainActivity(); // Let the constructor do the job
	         }
	      });
	   }


	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
