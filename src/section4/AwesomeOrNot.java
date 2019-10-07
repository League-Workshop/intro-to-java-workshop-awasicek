package section4;

import java.util.Random;

import javax.swing.JOptionPane;

public class AwesomeOrNot {

	// 1. Make a main method that includes all the steps below…
	public static void main(String[] args) {
		// 2. Make a variable that will hold a random number and put a random number into this variable using "new Random().nextInt(4)"
		int ranNum = new Random().nextInt(4); // random integer between 0 and 3 inclusive
		
		// 3. Print out this variable
		System.out.println(ranNum);

		// 4. Get the user to enter something that they think is awesome
		JOptionPane.showInputDialog("Enter something that you think is awesome.");

		String message;
		switch(ranNum) {
			case 0: 
				// 5. If the random number is 0
				// -- tell the user whatever they entered is awesome!
				message = "That is awesome!";
				break;
			case 1: 
				// 6. If the random number is 1
				// -- tell the user whatever they entered is ok.
				message = "That is ok...";
				break;
			case 2:
				// 7. If the random number is 2
				// -- tell the user whatever they entered is boring.
				message = "That is boring.";
				break;
			case 3:
				// 8. If the random number is 3
				// -- write your own answer
				message = "I don't even know what that is!!!!";
				break;
			default:
				throw new Error("oops something went wrong..");
		}
		JOptionPane.showMessageDialog(null, message);
		System.exit(0);
	}

}


