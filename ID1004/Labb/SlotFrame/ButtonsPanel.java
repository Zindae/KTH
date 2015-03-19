import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
/**
 * This class implements a panel of buttons and labels for the slot machine.
 * In particular it holds the following elements:
 * Insert Coin - button
 * Credit display - label
 * Win display - label
 * Roll - button
 * 
 * @author fki@kth.se
 *
 */
public class ButtonsPanel extends JPanel {
	
	/**
	 * The unlit color of the win label
	 */
	protected Color winDarkColor = new Color(30, 40, 30);
	
	/**
	 * The credit label displays the player's remaining credit.
	 */
	protected JLabel creditLabel = new JLabel("CREDIT: 000");
	
	/**
	 * The win label can be lit up after a win.
	 */
	protected JLabel winLabel = new JLabel("WIN");
	
	/**
	 * The roll button is what the player clicks to play one round.
	 */
	protected JButton rollButton = new JButton("ROLL");
	
	/**
	 * The credit button simulates the player inserting coins into the
	 * slot machine.
	 */
	protected JButton creditButton = new JButton("Insert coin");

	/**
	 * Adds an ActionListener to the credit and roll buttons.
	 * @param al The ActionListener to add.
	 */
	public void addListener(ActionListener al) {
		creditButton.addActionListener(al);
		rollButton.addActionListener(al);
	}
	
	/**
	 * Sets the credit amount to be displayed in the credit label.
	 * @param n The credit to display.
	 */
	public void setCredit(int n) {
		creditLabel.setText(String.format("CREDIT: %03d", n));
	}
	
	/**
	 * Sets the state of the win label. A zero amount sets it to its
	 * inactive color, a positive amount to its activated, or lit up, color.
	 * @param amount
	 */
	public void win (int amount) {
		if (0 < amount) {
			winLabel.setForeground(Color.RED);
		}
		else {
			winLabel.setForeground(winDarkColor);
		}
	}
	
	public ButtonsPanel() {
		
		// Set the background of the whole button panel to dark green.
		setBackground(new Color(0, 64, 0));
		
		// Arrange font and color on the credit label
		creditLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
		creditLabel.setForeground(Color.GREEN);
		
		// Arrange font, border and color on the win label
		winLabel.setFont(new Font("Serif", Font.BOLD, 38));
		winLabel.setBorder(new EtchedBorder());
		winLabel.setForeground(winDarkColor);
		
		// Action commands for the credit and roll buttons.
		creditButton.setActionCommand("credit");
		rollButton.setActionCommand("roll");
		
		// Add the components to this panel.
		add(creditButton);
		add(creditLabel);
		add(winLabel);
		add(rollButton);
	}
}
