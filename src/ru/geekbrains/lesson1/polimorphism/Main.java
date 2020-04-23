package ru.geekbrains.lesson1.polimorphism;

public class Main {

    public static void main(String[] args) {
	    Rectangle rectangle = new Rectangle(5d,4d);
	    Squire squire = new Squire(4.5d);
	    Circle circle = new Circle(3d);

	    Shape[] shapes = {rectangle,squire,circle};
        for (Shape shape:shapes) {
            System.out.println(shape+" squire is "+shape.squire());
        }
    }
}
