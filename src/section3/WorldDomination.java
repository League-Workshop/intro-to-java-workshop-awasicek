package section3;

import javax.swing.JOptionPane;

public class WorldDomination {
	
	public static void main(String[] args) {
		// 1. Ask the user if they know how to write code.
		String userInput = JOptionPane.showInputDialog("Do you know how to write code?");

		if(userInput == null) { // if canceled
			System.exit(0);
		} else if (userInput.equalsIgnoreCase("yes")) { // 2. If they say "yes", tell them they will rule the world.
			JOptionPane.showMessageDialog(null, "You will rule the world.");
		} else { // 3. Otherwise, wish them good luck washing dishes.
			JOptionPane.showMessageDialog(null, "Good luck washing the dishes.");
		}
	
		System.exit(0);
	}
}

