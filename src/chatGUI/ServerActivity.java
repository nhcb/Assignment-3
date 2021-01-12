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
/** Server activity frame
 * 
 * @author Nicky
 *
 */
public class ServerActivity extends Activity {

	private JTextField serverAdress;
	private JLabel serverLabel;
	private JTextArea serverLog;
	private JTextArea chatBox;
	private JLabel serverLogLabel;
	private JLabel chatBoxLabel;
	private JButton start;
	private JButton stop;
	private JButton exit;
	private JLabel statusServer;
	private JLabel status;
	
	/**Constructor for serverActivity, creates the serverActivity frame
	 * 
	 */
	public ServerActivity() {
		super("Server");
	    this.setSize(800, 650);
	    //this.setResizable(false);
	    this.setLocationRelativeTo(null);
		// Add label
		serverLabel = this.setLabel("Listen adress:");
		 // Create txtInput
	    serverAdress = this.setTextField("127.0.0.1:3500", 20);
	    // Add server status
	    statusServer = this.setLabel("Disconnected");
	    statusServer.setFont(new Font("Tahoma", 1, 11)); // NOI18N
	    statusServer.setForeground(new Color(255, 51, 51)); //Red
	    status = this.setLabel("Server status:");
	    
		// Add buttons
		start = this.setButton("Start server", "Start", "Start current server");
		stop = this.setButton("Stop server", "Stop", "Stop current server");
		exit = this.setButton("Exit", "Exit", "Exit the program");
		// Add textArea
		serverLog = this.setTextArea(false, 10, 5, "");
		chatBox = this.setTextArea(false, 10, 5, "");
		// Add scrollPanes
		JScrollPane scrollServer = this.setScrollPane();
		JScrollPane scrollChat = this.setScrollPane();
		// Connect scrollPane with textAreas
	    scrollServer.setViewportView(serverLog);
	    scrollChat.setViewportView(chatBox);
	    // Add labels for textArea
	    serverLogLabel = this.setLabel("Server log");
	    chatBoxLabel = this.setLabel("Chat box");
	    
	    // Construct layout
	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(
	        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(layout.createSequentialGroup()
	            .addContainerGap()
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            	.addGroup(layout.createSequentialGroup()
	            			.addComponent(serverLabel)
		                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	            			.addComponent(serverAdress))
	            	.addComponent(chatBoxLabel)
	            	.addGap(5,5,5)
	                .addComponent(scrollChat)
	                .addGap(5,5,5)
	                .addComponent(serverLogLabel)
	                .addGap(5,5,5)
	                .addComponent(scrollServer)
	                .addGroup(layout.createSequentialGroup()
	                    .addComponent(start)
	                    .addGap(18, 18, 18)
	                    .addComponent(stop)
	                    .addGap(18,18,18)
	                    .addComponent(exit)
	                    .addGap(42, 42, 42)
	                    .addComponent(status)
	                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                    .addComponent(statusServer)))
	            .addContainerGap())
	    );
	    layout.setVerticalGroup(
	        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(layout.createSequentialGroup()
		        .addContainerGap()
	        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	        				.addComponent(serverLabel)
	        				.addComponent(serverAdress))
			    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
	        	.addComponent(chatBoxLabel)
		        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
	            .addComponent(scrollChat, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
	            .addComponent(serverLogLabel)
		        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
	            .addComponent(scrollServer, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
	            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                .addComponent(start)
	                .addComponent(stop)
	                .addComponent(exit)
	                .addComponent(status)
	                .addComponent(statusServer))
	            .addContainerGap())
	    );
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Start server
		if(e.getActionCommand().equals("Start")) {
			startServer(serverAdress.getText());
		}
		// Stop server
		else if (e.getActionCommand().equals("Stop")) {
			stopServer();
		}
		else if(e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		
	}
	/** Method that recreates stopping a server
	 * 
	 */
	private void stopServer() {
		// Connecting server
				String temp = "-On " + currentDate() +
						" received- \n System message: Closing connection... \n -End-"
						;
				serverLog.append(temp + "\n");
				statusServer.setText("Disconnected");
				// Show a nice status
			    statusServer.setFont(new Font("Tahoma", 1, 11)); // NOI18N
			    // Show red color
			    statusServer.setForeground(new java.awt.Color(255, 51, 51));
		
	}
	/** Method that recreates hosting to a server
	 * 
	 * @param server the server ip from where to be connected
	 */
	private void startServer(String server) {
		// Connecting server
		String temp = "-On " + currentDate() +
				" received- \n System message: Opening connection from " +
				server +
				"... \n -End-"
				;
		serverLog.append(temp + "\n");
		// Sleep...
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		serverLog.append("Connection open: " + server + "\n");
		statusServer.setText("Connected");
		// Show a nice status
	    statusServer.setFont(new Font("Tahoma", 1, 11)); // NOI18N
	    // Show green color
	    statusServer.setForeground(new Color(0, 204, 51));
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
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
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
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
