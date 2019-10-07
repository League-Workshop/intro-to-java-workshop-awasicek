package section4;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URI;

import javax.swing.JOptionPane;

//import org.teachingextensions.logo.ImageBackground;
//import org.teachingextensions.logo.Paintable;
//import org.teachingextensions.logo.robot;
import org.jointheleague.graphical.robot.Robot;

public class RobotTreasureHunt implements KeyEventDispatcher{

	// 1. Create a new mini robot (type "mini" inside the parentheses)
	Robot miniBot = new Robot("mini");
	
	private void goUp() throws InterruptedException {
		// 2. Make the robot move up the screen (use setAngle(angle) and microMove(distance))
		miniBot.setAngle(0);
		miniBot.microMove(3);
	}

	private void goDown() throws InterruptedException{
		// 3. make the robot move down the screen (use setAngle(angle) and microMove(distance))
		miniBot.setAngle(180);
		miniBot.microMove(3);
	}

	private void turnLeft() throws InterruptedException{
		// 4. Make the robot turn to the left (use setAngle(angle) and microMove(distance))
		miniBot.setAngle(-90);
		miniBot.microMove(3);
	}

	private void turnRight() throws InterruptedException{
		// 5. make the robot turn to the right (use setAngle(angle) and microMove(distance))
		miniBot.setAngle(90);
		miniBot.microMove(3);
	}

	private void spaceBarWasPressed() {

		// 5. Change ROBOTNAME below to match the name of the robot you created in step 1.  
		// THEN, remove the slashes at the beginning of the next two lines
		//int robotXLocation = ROBOTNAME.getX();
		//int robotYLocation = ROBOTNAME.getY();
		int robotXLocation = miniBot.getX();
		int robotYLocation = miniBot.getY();
		
		// 6. Print the robotXLocation and robotYLocation variables to the console 
		System.out.println("x: " + robotXLocation + "\ny: " + robotYLocation + "\n");
		
		// 7. If robot is at same location as the little girl
		//      --make a pop-up tell the robot where to go next
		if ((robotXLocation > 700 && robotXLocation < 750) && (robotYLocation > 390 && robotYLocation < 480)) {
			JOptionPane.showMessageDialog(null, "Go to the pirate robot!");
		}
		
		// 8. Give the user subsequent clues at different locations on the image
		// (pirate robot, swamp, parrots, etc.)
		if ((robotXLocation > 540 && robotXLocation < 640) && (robotYLocation > 300 && robotYLocation < 475)) { // robot
			JOptionPane.showMessageDialog(null, "Go to the swamp!");
		}
		
		if ((robotXLocation > 0  && robotXLocation < 900) && (robotYLocation > 515 && robotYLocation < 600)) { // swamp
			JOptionPane.showMessageDialog(null, "Go to the parrot!");
		}
		
		if ((robotXLocation > 570 && robotXLocation < 670) && (robotYLocation > 110 && robotYLocation < 180)) { // parrot
			JOptionPane.showMessageDialog(null, "Go to the skull's nose!");
		}
		
		if ((robotXLocation > 230 && robotXLocation < 280) && (robotYLocation > 90 && robotYLocation < 140)) { // skull's nose
			// 9.  If the robot is in the final location
			//     --call the treasureFound() method
			treasureFound();
			JOptionPane.showMessageDialog(null, "You found the treasure!");
			System.exit(0);
		}

	}

	private void go() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
		Robot.setWindowImage("section4/treasure_hunt.jpg");
	
		JOptionPane.showMessageDialog(null, "Ask the girl for help with your quest. Press the space bar to ask.");

	}

	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				try {
					turnRight();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT)
				try {
					turnLeft();
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
			else if (e.getKeyCode() == 38)
				try {
					goUp();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				try {
					goDown();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			else if (e.getKeyCode() == KeyEvent.VK_SPACE)
				spaceBarWasPressed();
		}
		return false;
	}
	
	static void treasureFound() {
		try {
			URI uri = new URI("https://www.youtube.com/watch?v=G0aIg4N6aro");
			java.awt.Desktop.getDesktop().browse(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main (String[] args) throws MalformedURLException {
		new RobotTreasureHunt().go();
	}
}
