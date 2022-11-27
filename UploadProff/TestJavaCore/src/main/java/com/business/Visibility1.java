package com.business;

/*
class A {
    private class B {}
}
*/

 public class Visibility1 {

    public int a;
    private int b;
    protected int c;
    int d;

    void m1() {
        b = 90;
    }
}

// 1. istanziazione (new)
// 2. ereditarietà (extends)

class Test {
    public static void main(String[] args) {
        Visibility1 v1 = new Visibility1();
        v1.a = 10;
        // v1.b = 20;
        v1.c = 100;
        v1.d = 200;

    }
}

class Test1 extends Visibility1 {
    void m() {
        a = 100;
        // b = 200;
        c = 300;
        d = 500;
    }
}

// non-access modifiers
abstract class Test4 {

}

final class Test5 {
}

//  abstract final class Class10 {}

class Car {
     String model;
     static String vendor;
}

class TestCar {
     void m1() {
         Car c1 = new Car();
         c1.model = "M3";
         Car c2 = new Car();
         c2.model = "M5";
         Car.vendor = "Vendor1";
     }
}




