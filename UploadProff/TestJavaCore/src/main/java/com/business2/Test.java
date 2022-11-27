package com.business2;

import com.business.Visibility1;

public class Test {
    void m1() {
        Visibility1 v1 = new Visibility1();
        v1.a = 10;


    }
}

class Test2 extends Visibility1 {

    void m1() {
        a = 10;
        c = 20;

    }
}
