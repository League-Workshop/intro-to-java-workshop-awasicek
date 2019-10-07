package section4;

import javax.swing.JOptionPane;

public class QuizGame {
	
	public static void main(String[] args) {
		
		// 1.  Create a variable to hold the user's score 
		int userScore = 0;
		
		// 2.  Ask the user a question 
		String userInput = JOptionPane.showInputDialog("What is the capital of New York?");
		
		// 3.  Use an if statement to check if their answer is correct
		if (userInput == null) {
			System.exit(0);
		} else if (userInput.equalsIgnoreCase("Albany")) {
			// 4.  if the user's answer was correct, add one to their score 
			userScore++;
		}
		
		// 5.  Create more questions by repeating steps 1, 2, and 3 below. 
		userInput = JOptionPane.showInputDialog("Who was the first president?");
		if (userInput == null) {
			System.exit(0);
		} else if (userInput.equalsIgnoreCase("George Washington") || userInput.equalsIgnoreCase("Washington")) {
			userScore++;
		}
		
		// 6.  After all the questions have been asked, print the user's score 
		JOptionPane.showMessageDialog(null, "Final Score: " + userScore);
		System.exit(0);
	}
}
