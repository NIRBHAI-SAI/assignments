package com.targetready.assignments.day2;


public class CircleAndCylinder {

    public static class Circle{
        private double radius;
        private String color;

        public Circle(){
            this.radius =1.0;
            this.color = "red";
        }
        public Circle(double radius){
            this.radius = radius;
            this.color ="red";
        }
        public Circle(double radius,String color){
            this.radius = radius;
            this.color =color;
        }

        public void setColor(String color) {
            color = color.trim();
            if(color.isEmpty()) {
                throw new Error("Color cannot be empty");
            }
            this.color = color;
        }

        public String getColor() {
            return this.color;
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


        @Override
        public String toString() {
            return "Circle[radius = "+ this.radius+",color = "+this.color+"]";
        }
    }
    
    public static class Cylinder extends Circle{
        private double height=1.0;
        public Cylinder(){
            
        }
        public Cylinder(double radius){
            this.setRadius(radius);
        }
        public Cylinder(double radius,double height){
            this.setRadius(radius);
            this.height = height;
        }
        
        public Cylinder(double radius,double height,String color){
            this.setRadius(radius);
            this.height = height;
            this.setColor(color);
        }

        public void setHeight(double height) {
            if(height<0){
                throw new Error("height can't be negative");
            }
            this.height = height;
        }

        public double getHeight() {
            return this.height;
        }
        public double getVolume(){
            return 2*Math.PI*this.getRadius()*this.getHeight();
        }
    } 
    

    public static void main(String[] args) {
        Circle[] circles = {
                new Cylinder(12.34),
                new Cylinder(12.34, 10.0),
                new Cylinder(12.34, 10.0, "blue")
        };

        for (int i = 0; i < 3; i++) {
            System.out.println();
            Cylinder cylinder = (Cylinder) circles[i];
            System.out.printf("radius of circular region = %f", cylinder.getRadius());
            System.out.println();
            System.out.printf("area of the circular region = %f ", cylinder.getArea());
            System.out.println();
            System.out.printf("height of the cylinder = %f ", cylinder.getHeight());
            System.out.println();
            System.out.printf("Volume of the cylinder = %f ", cylinder.getVolume());
            System.out.println();

        }


    }
}
