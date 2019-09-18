/**
 * @fileoverview Logical Dot recipe
 */

void setup() {
  size(600, 600);
}

void draw() {
  if(mousePressed) {
    fill(200, 50, 50);
  } else {
    fill(50, 200, 50);
  }
  ellipse(300, 300, 100, 100);
}
