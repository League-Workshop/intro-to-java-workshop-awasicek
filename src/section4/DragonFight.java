package section4;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class DragonFight {
	// 1. Put all of the game code inside the main method (below) 
	public static void main(String[] args) {
		
		ImageIcon dragon = new ImageIcon("src/section4/dragonPicture.jpg");		
		
		JOptionPane.showMessageDialog(null, "Defeat the dragon to take its treasure!", "Dragon Fighter", 0, dragon);
		// 2. Create a variable called "playerHealth" to store your health (set it equal to 100)
		int playerHealth = 100;
	
		// 3. Create a variable called "dragonHealth" to store the dragon's health (set it equal to 100)
		int dragonHealth = 100;
		
		// 4. Create a variable to hold the damage the player's attack does each round
		int playerDamage = 0;
		
		// 5. Create a variable to hold the damage the dragon's attack does each round
		int dragonDamage = 0;
		
		// 6.  Delete the slashes at the beginning of the next line.  
		//while(playerHealth>0 && dragonHealth>0) {    //this line of code keeps the battle going until someone's health reaches 0 
		while(playerHealth > 0 && dragonHealth > 0) {
			// 7. Add a closing mustache at the very bottom of this program (since we just added an opening mustache on the previous step).
	
			// 8. Ask the player in a pop-up if they want to attack the dragon with a yell or a kick
			String userInput = JOptionPane.showInputDialog("Do you want to attack with a yell or a kick?");
	
			if (userInput == null) { // canceled
				System.exit(0);
			} else if (userInput.equalsIgnoreCase("yell")) {
				// 9. If they typed in "yell":
				//-- Find a random number between 0 and 10 and store it in dragonDamage
				//-- Subtract that number from the dragon's health variable 
				dragonDamage = new Random().nextInt(11);
				dragonHealth -= dragonDamage;
			} else if (userInput.equalsIgnoreCase("kick")) {
				// 10. If they typed in "kick":
				//-- Find a random number between 0 and 25 and store it in dragonDamage
				//-- Subtract that number from the dragon's health variable
				dragonDamage = new Random().nextInt(26);
				dragonHealth -= dragonDamage;
			} else if (userInput.equalsIgnoreCase("secret combo")) {
				dragonDamage = new Random().nextInt(31) + 20;
				dragonHealth -= dragonDamage;
			} else {
				throw new Error("Oops! That isn't a yell or a kick.");
			}
	
			// 11.  Find a random number between 0 and 35 and store it in playerDamage
			playerDamage = new Random().nextInt(36);
	
			// 12. Subtract this number from the player's health
			playerHealth -= playerDamage;
	
			if(playerHealth <= 0) {
				// 13. If the user's health is less than or equal to 0
				//-- Tell the user that they lost
				JOptionPane.showMessageDialog(null, "You died.");
			} else if (dragonHealth <= 0) {
				// 14. Else if the dragon's health is less than or equal to 0
				//-- Tell the user that the dragon is dead and they took a ton of gold!
				JOptionPane.showMessageDialog(null, "You killed the dragon and looted 1000 gold coins and 50 rubies.");
			} else {
				//  15.  Else
				//-- Pop up a message that tells the their current health and the dragon's currently health (Bonus: Also display the amount of health that was lost for each player this round)
				JOptionPane.showMessageDialog(null, 
						"Player Health: " + playerHealth + 
						"\nThe player took " + playerDamage + " points of damage this round." +
						"\n\nDragon Health: " + dragonHealth + 
						"\nThe dragon took " + dragonDamage + " points of damage this round."
						);
			}
		}
		
		System.exit(0);
		
	}
}

