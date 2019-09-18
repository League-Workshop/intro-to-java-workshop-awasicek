/**
 * @fileoverview Unicorns on Rainbow recipe
 */

PImage rainbow;
PImage unicorn;

void setup() {
  rainbow = loadImage("rainbow_.jpg");
  unicorn = loadImage("unicorn.png");
  size(800, 600);
  rainbow.resize(width, height);
}

void draw() {
  background(rainbow);
  if (mousePressed) {
    image(unicorn, mouseX - 175, mouseY - 125);
  }
}
