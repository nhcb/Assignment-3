package chatGUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

/** Abstract class that represents an activity frame
 * 
 * @author Nicky
 *
 */
public abstract class Activity extends JFrame implements ActionListener, DocumentListener, KeyListener {

	/** Abstract constructor to create JFrame
	 * 
	 */
	public Activity(String title) {
		// Create frame
		super(title);
		// Set layout to be FlowLayout, buttons and labels created will be from left to right.
		FlowLayout lo = new FlowLayout();
		lo.setAlignment(FlowLayout.LEADING);
		this.setLayout(lo);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
	    this.setVisible(true);   // "super" Frame shows
	    this.setLocationRelativeTo(null); // Set location on middle of screen
	}

	/** Abstract method to create a click-able button
	 * 
	 * @param title The text that the button displays
	 * @param action The action a button performs
	 * @param tooltip The tooltip the button shows
	 * @return JButton s.t. the button can be adjusted to layout
	 */
	public JButton setButton(String title, String action,String tooltip) {
		JButton b1 = new JButton(title);
		// Set action
		b1.setActionCommand(action);
		// Set tooltip
		b1.setToolTipText(tooltip);
		// Set action listener
		b1.addActionListener(this);
		// Add to JPanel
		this.add(b1);
		// Return
		return b1;
	}
	/** Abstract method to create radio-buttons
	 * 
	 * @param rows the rows in the group that holds the radio-buttons
	 * @param cols the columns in the group that hold the radio-buttons
	 * @param buttonActions A string array that holds both the actions and the text that the button should display
	 * @return the buttonGroup that holds the radio-buttons
	 */
	public ButtonGroup setRadioButtons(int rows,int cols,String ... buttonActions) {
		// Create a group for radioButtons
		ButtonGroup group = new ButtonGroup();
		// Create panel for radioButtons
		JPanel radioPanel = new JPanel(new GridLayout(rows,cols));
		// Loop to create radioButtons
		for(String action : buttonActions) {
			JRadioButton rb = new JRadioButton(action);
			// Set action
			rb.setActionCommand(action);
			// Add to group
			group.add(rb);
			// Register a listener for the radioButton
			rb.addActionListener(this);
			// Add to panel
			radioPanel.add(rb);
		}
		this.add(radioPanel);
		return group;
	}

	/** Abstract method to create a label that displays text
	 * 
	 * @param text to display by label
	 * @return the JLabel
	 */
	public JLabel setLabel(String text) {
		JLabel l1 = new JLabel(text);
		// Add to JPanel
		this.add(l1);
		return l1;
	}
	
	/** Abstract method to create interactable textField
	 * 
	 * @param defaultText the text that is to be displayed by default
	 * @param nCol the amount of columns that the textField should hold
	 * @return the JTextField s.t. layout can be adjusted
	 */
	public JTextField setTextField(String defaultText,int nCol) {
		JTextField tf1 = new JTextField(defaultText);
		tf1.setColumns(nCol);
		// Set action listener
		tf1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tf1.getText();
			}
			});
		// Add to JPanel
		this.add(tf1);
		return tf1;
	}
	
	/** Abstract method to create a ScrollPane
	 * 
	 * @return JScrollPane
	 */
	public JScrollPane setScrollPane() {
		JScrollPane sp = new JScrollPane();
		this.add(sp);
		return sp;
	}
	
	/** Abstract method to create a text area that keeps for instance chat boxes
	 * 
	 * @param editable determines if this textArea editable
	 * @param ncol the amount of columns in textArea
	 * @param nrow the amount of rows in textArea
	 * @param text the default text to be displayed
	 * @return a JTextArea s.t. layout can be adjusted
	 */
	public JTextArea setTextArea(boolean editable, int ncol, int nrow, String text) {
		JTextArea ta = new JTextArea();
		ta.setEditable(editable);
		ta.setColumns(ncol);
		ta.setRows(nrow);
		ta.setText(text);
	    ta.setWrapStyleWord(true);
	    // Caret position
	    ta.setCaretPosition(ta.getDocument().getLength());
	    this.add(ta);
	    return ta;
	    
	}
}
