/**
 * @fileoverview Tash Me recipe
 */
 
PImage mustache;
PImage friend;

void setup() {
  friend = loadImage("face.jpg");
  mustache = loadImage("tash.png");
  size(800, 600);
  friend.resize(width, height);
}

void draw() {
  background(friend);
  if(mousePressed) {
    image(mustache, mouseX - 110, mouseY - 100);
  }
}
