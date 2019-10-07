package section3;

import javax.swing.JOptionPane;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class SpeakAndSpell {

	public static void main(String[] args) {
		// 1. Use the speak method to say the word. "e.g. spell mandlebrot"
		speak("Spell mandlebrot");

		// 2. Catch the user's answer in a String
		String userInput = JOptionPane.showInputDialog("Enter your answer.");

		if (userInput == null) { // if canceled
			speak("Ok. See you later.");
			System.exit(0);
		} else if (userInput.equalsIgnoreCase("mandlebrot")) {
			// 3. If the user spelled the word correctly, speak "correct"
			speak("Correct");
		} else {
			// 4. Otherwise say "wrong"
			speak("Wrong");
		}

		// 5. repeat the process for other words
		
		System.exit(0);
	}

	static void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}


