package ticTacToc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/** Class for tic tac toc game
 * 
 * @author Nicky
 *
 */
public class TicTacToc extends JFrame implements ActionListener {

	private JButton[][] grid;
	private JButton restart;
	private boolean user;
	private JLabel userLabel;
	private int moves;
	private JLabel score1Tag;
	private int scoreX;
	private JLabel score2Tag;
	private int scoreO;
	
	/** Constructor for tic tac toc game
	 * 
	 */
	public TicTacToc() {
		// Create frame
		super("Tic Tac Toc");
		this.setSize(400,400);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
	    this.setVisible(true);   // "super" Frame shows
	    this.setLocationRelativeTo(null); // Set location on middle of screen
	    // Initalize
	    this.initializeGraphics();
	    
	}

	/** Method which creates the tic tac toc grid, labels, buttons and layout
	 * 
	 */
	public void initializeGraphics() {
		// Initalize tic tac toc grid
		grid = new JButton[3][3];
		for(int r = 0; r < 3; r++ ) {
			for(int c = 0; c < 3; c++) {
				grid[r][c] = new JButton();
				// Add actionListener
				grid[r][c].addActionListener(this);
			}
		}
		// Initalize labels that keep track of score and user
		userLabel = new JLabel();
		userLabel.setText("O's turn");
		userLabel.setFont(new Font("Tahoma", 1, 11)); // TAHOMA
		userLabel.setForeground(new Color(0, 204, 51));
		
		score1Tag = new JLabel("Score X: 0");
		
		score2Tag = new JLabel("Score O: 0");
	    // Initialize restart button
		restart = new JButton("Restart");
		restart.addActionListener(this);
	    
	    // Initialize above in nice buttonLayout
	    GroupLayout buttonLayout = new GroupLayout(getContentPane());
	    setLayout(buttonLayout);
	    
        buttonLayout.setHorizontalGroup(
                buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(buttonLayout.createSequentialGroup()
                    .addComponent(grid[0][0], javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(grid[0][1], javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(grid[0][2], javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                	.addComponent(userLabel)
                	.addComponent(score1Tag)
                	.addComponent(score2Tag)
                	.addComponent(restart)
                
                .addGroup(buttonLayout.createSequentialGroup()
                    .addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonLayout.createSequentialGroup()
                            .addComponent(grid[1][0], javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(grid[1][1], javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(grid[1][2], javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(buttonLayout.createSequentialGroup()
                            .addComponent(grid[2][0], javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(grid[2][1], javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(grid[2][2], javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        		)
                    		
                    		)
                    .addGap(0, 0, Short.MAX_VALUE))
                
            );
            buttonLayout.setVerticalGroup(
                buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(buttonLayout.createSequentialGroup()
                	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(grid[0][0], javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grid[0][1], javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grid[0][2], javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(grid[1][0], javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grid[1][1], javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grid[1][2], javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(grid[2][0], javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grid[2][1], javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grid[2][2], javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    	.addComponent(userLabel)
                    	.addComponent(score1Tag)
                    	.addComponent(score2Tag)
                    	.addComponent(restart)
                		)
            );
            
	}
	
	/** Method which resets the tic tac toc grid and if neccesary the scores
	 * 
	 * @param completeReset a boolean that determines whether scores should be reset
	 */
	public void resetGraphics(boolean completeReset)  {
		// Build grid again
		for(int r = 0; r < 3; r++ ) {
			for(int c = 0; c < 3; c++) {
				grid[r][c].setText("");
			}
		}
		// Reset moves
		moves =0;
		if(completeReset) {
			scoreX = 0;
			scoreO = 0;
			score1Tag.setText("Score X: 0");
			score2Tag.setText("Score O: 0");
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// Get source button
		JButton source = (JButton) e.getSource();
		// Check if restart
		if(source.getText().equals("Restart")) {
			resetGraphics(true);
			// Exit the method
			return;
		}
		if(source.getText().equals("")) {
			// Obtain user
			if(user) {
				source.setText("X");
				source.setFont(new Font("Tahoma", 1, 20)); // TAHOMA
				source.setForeground(new Color(255, 51, 51)); // Red
				
				// Alternate user
				alternate();
			}
			else  {
				source.setText("O");
				source.setFont(new Font("Tahoma", 1, 20)); // TAHOMA
			    source.setForeground(new Color(0, 204, 51)); // Green
			    
				// Alternate user
				alternate();
			}
			
			if(checkWin()) {
				// Game over, just alternated hence opposite of user wins
				if(!user) {
					scoreX ++;
					score1Tag.setText("Score X: " + scoreX);
					// Show message
					JOptionPane.showMessageDialog(this, "X won!","Game result",JOptionPane.PLAIN_MESSAGE);
					
				}
				else {
					scoreO ++;
					score2Tag.setText("Score O: " + scoreO);
					// Show message
					JOptionPane.showMessageDialog(this, "O won!","Game result",JOptionPane.PLAIN_MESSAGE);
				}
				resetGraphics(false);
			}
			else {
				// Add moves
				moves ++;
				if(moves>=9) {
					// Game resulted in tie
					// Show message
					JOptionPane.showMessageDialog(this, "Game resulted in a tie!","Game result",JOptionPane.PLAIN_MESSAGE);
					resetGraphics(false);
				}
			}
		}
	}

	/** Method that alternates user and adapts labels accordingly
	 * 
	 */
	public void alternate() {
		user =!user;
		if(!user) {
			userLabel.setText("O's turn");
			userLabel.setFont(new Font("Tahoma", 1, 11)); // TAHOMA
			userLabel.setForeground(new Color(0, 204, 51));
		}
		else {
			userLabel.setText("X's turn");
			userLabel.setFont(new Font("Tahoma", 1, 11)); // TAHOMA
			userLabel.setForeground(new Color(255, 51, 51)); // Red
		}
		
	}

	/** Methods that returns a boolean if action is winning play
	 * 
	 * @return boolean that determines win
	 */
	public boolean checkWin() {
		
		for(int i=0;i<3;i++) {
			// Check every row
			if(!grid[i][0].getText().equals("") && grid[i][0].getText().equals(grid[i][1].getText()) && grid[i][1].getText().equals(grid[i][2].getText())) {
				return true;
			}
			// Check every col
			else if(!grid[0][i].getText().equals("") && grid[0][i].getText().equals(grid[1][i].getText()) && grid[1][i].getText().equals(grid[2][i].getText())) {
				return true;
			}
		}
		// Finally check diagonals
		if(!grid[0][0].getText().equals("") && (
				(grid[0][0].getText().equals(grid[1][1].getText())) &&
				 grid[1][1].getText().equals(grid[2][2].getText()))) {
			return true;
		}
		else if(!grid[0][2].getText().equals("") && 
				(grid[0][2].getText().equals(grid[1][1].getText())) &&
				 grid[1][1].getText().equals(grid[2][0].getText())
				) {
			return true;
		}
		// no win found
		return false;
	}
	
	public static void main(String[] args) {
		// Run GUI codes in the Event-Dispatching thread for thread safety
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
			    new TicTacToc(); // Let the constructor do the job
			}
		    });
	    }
}
