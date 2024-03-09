package com.targetready.assignments.day2;

public class School {

    public static class Person{
        private String name;
        private String address;

        public Person(String name,String address){
            this.name =name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            address = address.trim();
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person[name="+ this.name+",address="+this.address+"]";
        }
    }
    public static class Student extends Person{
        private String program;
        private int year;
        private double fee;

        public Student(String name,String address,String program,int year,double fee){
            super(name, address);
            this.program = program;
            this.year = year;
            this.fee = fee;
        }

        public double getFee() {
            return fee;
        }

        public String getProgram() {
            return program;
        }

        public int getYear() {
            return year;
        }

        public void setProgram(String program) {
            program = program.trim();
            if(program.isEmpty()){
                throw new Error("Program can't be empty");
            }
            this.program = program;
        }

        public void setFee(double fee) {
            if(fee<0){
                throw new Error("Fee can't be negative");
            }
            this.fee = fee;
        }

        public void setYear(int year) {
            if(year<0){
                throw new Error("Year can't be negative");
            }
            this.year = year;
        }

        @Override
        public String toString() {
            return "Student["+ super.toString()+" program="+ this.program+" year="+this.year+" fee="+this.year+"]";
        }
    }
    public static class Staff extends Person{
        private String school;
        private double pay;

        public Staff(String name,String address,String school,double pay){
            super(name,address);
            this.pay = pay;
            this.school = school;
        }

        public String getSchool() {
            return school;
        }

        public double getPay() {
            return pay;
        }

        public void setSchool(String school) {
            school = school.trim();
            if(school.isEmpty()) {
                throw new Error("school can't be empty");
            }
            this.school = school;
        }

        public void setPay(double pay) {
            if(pay<0){
                throw new Error("pay can't be negative");
            }
            this.pay = pay;
        }

        @Override
        public String toString() {
            return "Staff["+super.toString()+" school="+this.school+" pay= "+this.pay+"]";
        }
    }

    public static void main(String[] args) {
        Person[] people = {
                new Student("Shyam", "Bangalore, Karnataka", "Java fundamentals", 2010, 4500.0),
                new Staff("Anand", "Bangalore, Karnataka", "Delhi Public school", 35000.0),
                new Staff("Umesh", "Bangalore, Karnataka", "National Public school", 42000.0),
                new Student("Suresh", "Hassan, Karnataka", "Java fundamentals", 2012, 4750.0),
                new Student("Kiran", "Vasco, Goa", "ReactJS", 2017, 12500.0)
        };

        for (int i = 0; i < 5; i++) {
            if(people[i] instanceof Student s){
                System.out.printf(s.toString());
            }
            if(people[i] instanceof Staff s){
                System.out.printf(s.toString());
            }
            System.out.println();
        }
    }



}
