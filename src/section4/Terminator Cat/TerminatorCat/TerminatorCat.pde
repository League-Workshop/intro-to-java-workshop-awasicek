/**
 * @fileoverview Make a cat that shoots lasers out of its eyes when you press the spacebar.
 */
 
// 3.  Add the following code to the very top of your sketch:
PImage catPic;
final int INITIAL_X = 447;
final int INITIAL_Y = 291;
// 9. Create variables for the x and y location of the ellipse at the top of your sketch, and set them equal to the values you found in step 6.  Replace the numbers for x and y in your ellipse command with these variables.  
// Completing this step should not change the look of your sketch.
int catEyeX = INITIAL_X;
int catEyeY = INITIAL_Y;
final int CAT_EYE_DIAMETER = 35;

int laserSpeed = 0;
int redValue = 255;
boolean isLaserActive = false;
 
// 1. Start a new sketch with setup() and draw() methods.
void setup() {
  // 2. Set the size of your sketch in the setup() method.
  size(800, 600);
  // 4. Find an image of a cat on google.  Find one with BIG eyes.
  // 5. Drag the image you saved from your desktop and drop it onto your sketch. Load it like this in the setup method:
  catPic = loadImage("kitten.jpg");
  catPic.resize(width, height);
  background(catPic);
  
} // END SETUP

void draw() {
  // 6. Copy and paste the following code to your draw method to find the location of your cat’s eyes:
  // 7. Now when you run your sketch and click on the cat’s eye, the position of the eye will appear at the bottom of your processing window.  
  if(mousePressed) println("Mouse’s x-position: " + mouseX + "\n" + "Mouse’s y-position: " + mouseY + "\n");
  
  // 12. Adding noStroke()on the line before you draw your ellipse will make it look more like a laser beam.
  noStroke();
  // 10. Give the ellipse a color with the fill command (this will be the color of the laser).
  fill(redValue, 10, 10);
  // 8. Place an ellipse over one of the cat’s eyes in the draw() method using the x-position and y-position that you just found in the previous step.
  ellipse(catEyeX, catEyeY, CAT_EYE_DIAMETER, CAT_EYE_DIAMETER);
  // 14. Make the cat shoot lasers from both eyes.  Use an offset so that you don’t need to make a second set of coordinates.
  ellipse(catEyeX + 88, catEyeY - 37, CAT_EYE_DIAMETER, CAT_EYE_DIAMETER);
  
  // 13. Accelerate the movement of the ellipse.
  if (isLaserActive) { 
    laserSpeed = 5;
    redValue -= 2;
  } else {
    laserSpeed = 0;
    redValue = 255;
  }
  catEyeX += laserSpeed;
  catEyeY += laserSpeed;
  
  // 15. Set the laser back to the beginning when it goes off the screen.
  if (
  (catEyeX > width + CAT_EYE_DIAMETER || catEyeX > width + CAT_EYE_DIAMETER - 88) 
  && (catEyeY > height + CAT_EYE_DIAMETER || catEyeY > height + CAT_EYE_DIAMETER + 37)
  ) {
    catEyeX = INITIAL_X;
    catEyeY = INITIAL_Y;
    background(catPic);
    isLaserActive = false;
  }
} // END DRAW

// 11. Add a keyPressed() method outside of the draw method and increase the x and/or y variables inside it.
void keyPressed() {
  isLaserActive = !isLaserActive;
}
