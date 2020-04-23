package ru.geekbrains.lesson1.polimorphism;

public class Squire extends Shape {

    private double side;

    public Squire(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double squire() {
        return side*side;
    }

    @Override
    public String toString() {
        return "Squire{" +
                "side=" + side +
                '}';
    }
}
