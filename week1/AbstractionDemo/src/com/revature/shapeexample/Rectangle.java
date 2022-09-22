package com.revature.shapeexample;

public class Rectangle extends Shape {

    public double length;
    public double width;

    public Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }

    @Override
    public double getArea() {
        return this.length * this.width;
    }

}
