package chatGUI;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;

/** StartClientActivity class, a predecessor for clientActivity
 * 
 * @author Nicky
 *
 */
public class StartClientActivity extends Activity {

	private JTextField tf1,tf2;
	private JLabel e1;
	
	/** Constructor for the predecessor of clientActivity, determines basic information 
	 * 
	 */
	public StartClientActivity() {
		super("login:");
		// "super" Frame sets initial size
	    this.setSize(265, 225); 
		// Add label and textBox
		this.setLabel("Screen Name:");
		tf1 = this.setTextField("",20);
		// Customize text field to limit characters to 16
		tf1.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(tf1.getText().length()>=16&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		// Add label and textBox
		this.setLabel("Chat Server:");
		tf2 = this.setTextField("127.0.0.1:3500",20);
		// Add buttons
		this.setButton("Start", "Start", "Start current selected mode");
		this.setButton("Exit", "Exit", "Exit the program");
		// Add error label
		e1 = this.setLabel("");
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start")) {
			if(tf1.getText().length()==0|tf2.getText().length()==0) {
				e1.setText("Screen name and/or Chat server is empty.");
			}
			else {
				String screenName = tf1.getText();
				String chatServer = tf2.getText();
				
				// Run the GUI construction in the Event-Dispatching thread for thread-safety
			      SwingUtilities.invokeLater(new Runnable() {
			         @Override
			         public void run() {
			            new ClientActivity(screenName,chatServer); // Let the constructor do the job
			         }
			      });
			      // hacky way to close
			      this.setVisible(false);
			}
		}
		if(e.getActionCommand().equals("Exit")) {
			// exit program
			System.exit(0);
		}
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
