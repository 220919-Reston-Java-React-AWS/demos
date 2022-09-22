package com.revature.shapeexample;

public class Circle extends Shape {

    public double radius;

    public Circle(double r) {
        this.radius = r;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

}
