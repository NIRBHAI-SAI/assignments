package com.targetready.assignments.day2;


public class Shapes{
    public static class Shape {
        private String Color;
        private boolean filled;
        public Shape(){
            this.Color = "red";
            this.filled = true;
        }

        public Shape(String color, boolean filled){
            this.Color = color;
            this.filled = filled;
        }

        public String getColor() {
            return this.Color;
        }

        public void setColor(String color) {
            this.Color = color;
        }

        public boolean isFilled() {
            return this.filled;
        }

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        @Override
        public String toString() {
            String s = "A Shape with color " + this.Color + " and ";
            if(this.filled){
                return s+"filled.";
            }

            return s+"not filled.";
        }
    }
    public static class Circle extends Shape {
        private double radius;

        public Circle(){
            this.radius =1.0;
        }
        public Circle(double radius){
            this.radius = radius;
        }
        public Circle(double radius,String color,boolean filled){
            this.radius = radius;
            this.setColor(color);
            this.setFilled(filled);
        }

        public double getRadius() {
            return this.radius;
        }

        public void setRadius(double radius) {
            if(radius < 0){
                throw new RuntimeException("Radius cannot be negative");
            }
            this.radius = radius;
        }
        public double getArea(){
            double radius = this.getRadius();
            return 3.14*radius*radius;
        }
        public double getPerimeter(){
            double radius = this.getRadius();
            return 2.0*radius*3.14;
        }

        @Override
        public String toString() {
            return "A circle with radius = "  + radius  + " is a subclass of"+ super.toString();
        }

    }

    public static class Rectangle extends Shape {
        private double width;
        private double length;
        public Rectangle(){
            this.width = 1.0;
            this.length =1.0;
        }

        public Rectangle(double width,double length){
            if (width<=0){
                throw new Error("Width should be greater than zero");
            }
            else if(length<=0){
                throw new Error("Length should be greater than zero");
            }

            this.length = length;
            this.width = width;
        }

        public Rectangle(double width,double length,String color,boolean filled){
            if (width<=0){
                throw new Error("Width should be greater than zero");
            }
            else if(length<=0){
                throw new Error("Length should be greater than zero");
            }

            this.length = length;
            this.width = width;
            this.setColor(color);
            this.setFilled(filled);
        }

        public double getWidth() {
            return width;
        }

        public double getLength() {
            return length;
        }

        public void setWidth(double width) {
            if(width<=0){
                throw new Error("Width should be greater than 0") ;
            }
            this.width = width;
        }

        public void setLength(double length) {
            if(length <=0 ){
                throw new Error("Length should be greater than 0");
            }
            this.length = length;
        }
        public double getArea(){
            return length*width;
        }

        public double getperimeter(){
            return 2*(length+width);
        }

        @Override
        public String toString() {
            return "A Rectangle with width = "+
                    width+ " and length = "+length+
                    " ,Which is a subclass of "+ super.toString();
        }
    }

    public static class Square extends Rectangle{
        public Square(){
            this.setLength(1.0);
            this.setWidth(1.0);
        }
        public Square(double side){
            if(side <=0){
                throw new Error("side must be positive");
            }
            this.setWidth(side);
            this.setLength(side);
        }

        public Square(double side,String color,boolean filled){
            this.setLength(side);
            this.setWidth(side);
            this.setColor(color);
            this.setFilled(filled);
        }
        public double getSide(){
            return this.getLength();
        }
        public void setSide(double side){
            this.setWidth(side);
            this.setLength(side);
        }

        @Override
        public void setWidth(double width) {
                super.setWidth(width);
                super.setLength(width);
        }

        @Override
        public void setLength(double length) {
            super.setWidth(length);
            super.setLength(length);
        }

        @Override
        public String toString() {
            return "A Square with side = "+ this.getSide() +
                    " ,which is a subclass of "+ super.toString();
        }
    }
    public static void main(String[] args) {

            Shape[] shapes = {
                    new Circle(),
                    new Rectangle(),
                    new Square(),
                    new Circle(25.25),
                    new Rectangle(23.02,58.35),
                    new Square(2),
                    new Rectangle(54.0,9.08),
                    new Circle(3.14,"grey",false),
                    new Square(8.0,"light blue",false),
                    new Square(75)
            };


        for (int i = 0; i < 10; i++) {
            if(shapes[i] instanceof Circle c1){
                System.out.printf("radius of the Circle is = %f",c1.getRadius());
                System.out.println();
                System.out.printf("Area of the Circle is = %f",c1.getArea());
                System.out.println();
                System.out.printf("Perimeter of the Circle is = %f",c1.getPerimeter());
                System.out.println();
                System.out.println(c1);
            }
            if(shapes[i] instanceof Rectangle r1){
                System.out.printf("Length of the Rectangle is = %f",r1.getLength());
                System.out.println();
                System.out.printf("Width of the Rectangle is = %f",r1.getWidth());
                System.out.println();
                System.out.printf("Area of the Rectangle is = %f",r1.getArea());
                System.out.println();
                System.out.printf("Perimeter of the Rectangle is = %f",r1.getperimeter());
                System.out.println();
                System.out.println(r1);
            }
            else if(shapes[i] instanceof Square s1){
                System.out.printf("Side of the Square is = %f",s1.getLength());
                System.out.println();
                System.out.printf("Area of the Rectangle is = %f",s1.getArea());
                System.out.println();
                System.out.printf("Perimeter of the Rectangle is = %f",s1.getperimeter());
                System.out.println();
                System.out.println(s1);
            }

            System.out.println();
        }

    }
}
