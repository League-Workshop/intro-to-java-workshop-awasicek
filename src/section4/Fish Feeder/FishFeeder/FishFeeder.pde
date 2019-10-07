/**
 * @fileoverview A game where a fish has to catch falling fish food!
 */
 
int winningScore = 10;
int foodSpeed = 2;
 
// 3. At the top of your program (on line 1) create variables for the location of the fish food.
int foodX = 100;
int foodY = 20;

// 10. Above the setup method, add an int variable to hold the score.
int score = 0;

// 1. Start a new sketch with draw and setup methods.
void setup() {
  // 2. In the setup method, set your canvas size:
  size(800, 800);
} // END SETUP

void draw() {
  // 4. In the draw method, make the background the color of water, and draw a some fish food using the variables from step 3.
  background(141, 233, 237);
  
  // 9. Draw the fish in the water by adding this code to the draw method.
  // (Make sure you draw the fish AFTER you paint the background, or you won't see it!)
  if (score < winningScore) { // only draw fish, food, check collisions, and update score if player has not already won
    drawFish();

    // fish food
    fill(200, 200, 20);
    noStroke();
    ellipse(foodX, foodY, 15, 15);
    
      // 11. You need to check whether the fish has caught the food in the draw method.
      // You will need to call the method from the draw method and pass it the x and y of the food.
      checkCatch(foodX, foodY);
      
      // 5. Make the food fall down the screen.
      // HINT: Change the value of the foodY variable in the draw method.
      foodY += foodSpeed;
      
      // 6. When the food falls off the bottom of the canvas, start a new food (ellipse) falling from the top. 
      // HINT: You can use the built-in height variable.
      if (foodY >= height) { 
        foodY = 20;
        // 7. Make the food start at a random position at the top (foodX). The code below will give you a random number between 0 and the width of your sketch. 
        // You want to do this every time the food leaves the screen.
        foodX = (int) random(width - 20);
        
        // If the fish misses the food, decrease the score by 1 (but don’t let the score go negative).
        if (score > 0) { 
          score--;
          foodSpeed -= 1; // difficulty adjusts w/score
        }
      }
  
  } else {
      // 13. Decide how many points the user needs to score to win. 
      // Make the game stop when the winning score is reached, i.e. stop drawing food and put up a message to tell the user they have won.
      textSize(48); //if it’s not big enough
      text("VICTORY!", 300, 400);
  }
  
  // 12. Show the score on the screen.
  fill(0, 0, 0);
  textSize(16);
  text("Score: " + score, 20, 20);
} // END DRAW

// 8. Add this drawFish method at the very bottom of your sketch:
void drawFish(){
     noStroke();
     fill(255,255,255);
     ellipse(mouseX-17,mouseY-17,20,20); //back side eye
     fill(255,200,88);
     ellipse(mouseX,mouseY,90,50); //body
     triangle(mouseX+30,mouseY,mouseX+70,mouseY+30,mouseX+70,mouseY-30); //tail
     stroke(0);
     triangle(mouseX,mouseY,mouseX+15,mouseY+10,mouseX+15,mouseY-10); //side fin
     noStroke();
     fill(255,200,88);
     ellipse(mouseX,mouseY,15,15); //side fin cover
     noStroke();
     fill(255,255,255);
     ellipse(mouseX-25,mouseY-15,20,20); //front eye
     fill(0,0,0);
     ellipse(mouseX-25,mouseY-15,5,5); //pupil
     fill(141,233,237);
     ellipse(mouseX-45,mouseY,25,25); //mouth
}

void checkCatch(int x, int y) {
     if(x > mouseX - 40 && x < mouseX - 20){ // adjusted so collides with fish's mouth
       // If the fish catches the food increase the score by 1 and make more food fall from the top.
          if(y > mouseY-17 && y < mouseY+30){
               score++;
               
               foodSpeed += 1; // difficulty adjusts w/score
               
               foodY = 20; //if the food was eaten, make more food fall from the top
               foodX = (int) random(width-20);
          }
     }
     // You can write your own code to do this, or use this checkCatch method.
}
