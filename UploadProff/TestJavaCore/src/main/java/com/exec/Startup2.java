package com.exec;

/*
public static void main(String[] args) {
        System.out.println("another");
        }
*/

// access modifier | non access modifier | class keyword | extends keyword
// implements keyword

interface Inter1 {}
public final class Startup2 extends Object implements Inter1 {

    /*
    public static void main(String[] args) {
        System.out.println("another");
    }
     */
}

// class content
class Phone {

    // class attributes
    String model;   // null
    String company; // null
    double weight; // 0

    // class methods
    void makeCall(String num) {
        int a = 100;
        model = ""; // closure
    }

    void receiveCall(){
        weight=100;
    }


}


