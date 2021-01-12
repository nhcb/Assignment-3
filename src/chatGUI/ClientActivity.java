package chatGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

/** ClientActivity class
 * 
 * @author Nicky
 *
 */
public class ClientActivity extends Activity {

	private JLabel lblShowStatus;
	private JTextArea textArea;
	private JTextField txtInput;
	private JButton connect;
	private JButton disconnect;
	private JButton exit;
	private JButton send;
	private String chatServer;
	private String screenName;
	
	/** Constructor for clientActivity, or the chat functionality screen
	 * 
	 * @param screenName the userName
	 * @param chatServer the server to be connected to
	 */
	public ClientActivity(String screenName,String chatServer) {
		super("Chatting - " + screenName);
			this.setSize(650,500);
			this.screenName = screenName;
			this.chatServer = chatServer;
			// Create scrollPane and textArea, otherwise known as the chatBox
		 	JScrollPane scrollPane = this.setScrollPane();
		    textArea = this.setTextArea(false,10,5,"");
		    textArea.setSize(600,300);
		    // Connect scrollPane with textArea
		    scrollPane.setViewportView(textArea);
		    
		    // Create 4 buttons, Connect, Disconnect , Send and Exit
		    connect = this.setButton("Connect", "Connect", "Start connecting to the server!");
		    disconnect = this.setButton("Disconnect", "Disconnect", "Disconnect from the server!");
		    send = this.setButton("Send (Press Enter)", "Send", "Press to send your message");
		    exit = this.setButton("Exit", "Exit", "Exit the application!");
		    
		    
		    // Create label for status, connected or disconnected
		    JLabel lblStatus = this.setLabel("Status: ");
		    lblShowStatus = this.setLabel("Disconnected");
		    lblShowStatus.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		    lblShowStatus.setForeground(new Color(255, 51, 51));
		    
		    // Create txtInput
		    txtInput = this.setTextField("", 20);
		    // Add a key listener to textInput, in case enter is pressed.
		    txtInput.addKeyListener(this);

		    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		    getContentPane().setLayout(layout);
		    layout.setHorizontalGroup(
		        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(layout.createSequentialGroup()
		            .addContainerGap()
		            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addComponent(scrollPane)
		                .addGroup(layout.createSequentialGroup()
		                    .addComponent(connect)
		                    .addGap(18, 18, 18)
		                    .addComponent(disconnect)
		                    .addGap(18,18,18)
		                    .addComponent(exit)
		                    .addGap(42, 42, 42)
		                    .addComponent(lblStatus)
		                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                    .addComponent(lblShowStatus)
		                    .addGap(0, 42, Short.MAX_VALUE))
		                .addComponent(txtInput))
		            	.addGap(18,18,18)
		            	.addComponent(send)
		            .addContainerGap())
		    );
		    layout.setVerticalGroup(
		        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(layout.createSequentialGroup()
		            .addContainerGap()
		            .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
		            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
		            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				            .addComponent(txtInput)
		            		.addComponent(send))
		            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                .addComponent(connect)
		                .addComponent(disconnect)
		                .addComponent(exit)
		                .addComponent(lblStatus)
		                .addComponent(lblShowStatus))
		            .addContainerGap())
		    );
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Connect to server
		if(e.getActionCommand().equals("Connect")) {
			serverConnect();
		}
		if(e.getActionCommand().equals("Disconnect")) {
			serverDisconnect();
		    
		}
		if(e.getActionCommand().equals("Send")) {
			// Send message if connected and message is not empty
			if(lblShowStatus.getText().equals("Connected")&&!txtInput.getText().equals("")) {
				textArea.append(screenName + ": " + txtInput.getText() + "\n");
				// Clear text
				txtInput.setText("");
			}
			else if(!txtInput.getText().equals("")){
				// Not yet connected
				String temp = "-On " + currentDate() +
						" received- \n System message: Not connected to " +
						chatServer +
						", try connecting. \n -End-"
						;
				textArea.append(temp + "\n");
			}
		}
		
		if(e.getActionCommand().equals("Exit")) {
			// exit program
			System.exit(0);
		}
	}
	/** Method that recreates disconnecting from a server
	 * 
	 */
	private void serverDisconnect() {
		// Show a nice status
	    lblShowStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	    // Show red color
	    lblShowStatus.setForeground(new java.awt.Color(255, 51, 51));
	    lblShowStatus.setText("Disconnected");
	    
		String temp = "-On " + currentDate() +
				" received- \n System message: Disconnect to " +
				chatServer + "\n -End-"
				;
		textArea.append(temp + "\n");
		
	}
	/** Method that recreates connecting to a server
	 * 
	 */
	private void serverConnect() {
		// Show a nice status
	    lblShowStatus.setFont(new Font("Tahoma", 1, 11)); // NOI18N
	    // Show green color
	    lblShowStatus.setForeground(new Color(0, 204, 51));
	    lblShowStatus.setText("Connected");
	    
		String temp = "-On " + currentDate() +
				" received- \n System message: Connect to " +
				chatServer + "\n -End-"
				;
		textArea.append(temp + "\n");
		
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
	/** Method to determine if enter key is pressed and sends message accordingly
	 * 
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			// Send message if connected and not empty
			if(lblShowStatus.getText().equals("Connected") && !txtInput.getText().equals("")) {
				textArea.append(screenName + ": " + txtInput.getText() + "\n");
				// Clear text
				txtInput.setText("");
			}
			else if(!txtInput.getText().equals("")){
				// Not yet connected
				String temp = "- On " + currentDate() +
						" received- \n System message: Not connected to " +
						chatServer +
						", try connecting. \n -End-"
						;
				textArea.append(temp + "\n");
			}
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/** Method to return current date in string format
	 * 
	 * @return current date in string format
	 */
	public String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
}
