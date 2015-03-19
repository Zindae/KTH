import java.awt.event.ActionListener;

/**
 * This interface defines the methods available for interacting
 * with a slot machine simulator.
 * 
 * @author fki@kth.se
 *
 */
public interface SlotControl {
	
	/**
	 * Returns information about the wheel model provided by the
	 * simulator. The returned matrix contains one row for each wheel,
	 * starting with the leftmost wheel. Each column assigns an integer
	 * to each unique symbol on the wheel. For example, if this method
	 * returns the following matrix:
	 *   {
	 *     {0, 1, 2, 3, 2, 1},  // left wheel
	 *     {0, 1, 2, 3, 2, 1}   // right wheel
	 *   }
	 * then it describes a slot machine with two identical wheels.
	 * On each wheel, the symbols 1 and 2 occur two times, while symbols
	 * 0 and 3 only occur once.
	 * 
	 * @return A matrix describing the wheel model
	 */
	public int [][] getWheelModel();
	

	/**
	 * Returns the next event from the slot machine simulator. 
	 * Events are reported as strings.
	 * All slot machine simulators must report at least the following
	 * two events:
	 * 
	 *   creditbutton - the player has inserted a coin
	 *   rollbutton - the player has clicked the ROLL button
	 *   
	 * @return A string describing the next event
	 */
	public String getNextEvent();
	
	/**
	 * Sets the amount to be displayed in the credit field of the simulator's
	 * display.
	 * @param n The new credit.
	 */
	public void setCredit(int n);
	
	/**
	 * Activates or deactivates the WIN sign in the display. An amount of
	 * zero will deactivate the sign. Any positive amount activates the sign.
	 * 
	 * @param amount Zero to deactivate, positive to activate
	 */
	public void win(int amount);
	
	/**
	 * Animates the display of symbol wheels by rolling them and then
	 * stopping them in sequence from left to right. When stopped, the
	 * symbols under the payline corresponds to the content of the parameter
	 * array.
	 * 
	 * Index 0 of the parameter array corresponds to the leftmost wheel,
	 * symbols for the next wheel is read from the next index for as many
	 * as are needed by the simulator.
	 * 
	 * The elements in the array are column indexes in the simulator's 
	 * wheel model. Thus, if the simulator has the following wheel model:
	 *   {
	 *     {0, 1, 2, 3, 2, 1},  // left wheel
	 *     {0, 1, 2, 3, 2, 1}   // right wheel
	 *   }
	 * then the parameter array {4, 5} would cause the simulator to display
	 * symbol 3 on the left wheel and symbol 1 on the right wheel.
	 * 
	 * @param ar Array of symbol to show on the payline.
	 */
	public void roll(int [] ar);
}
