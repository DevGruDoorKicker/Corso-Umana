package exercises.com.usage;

import exercises.com.management.Invoice;

public class Test {

    public static void main(String[] args) {
        Invoice i1 = new Invoice();
        i1.id = Invoice.genId();
        i1.description = "a";
        i1.amount = 89.2f;
        i1.print();

        Invoice i2 = new Invoice();
        i2.id = Invoice.genId();
        i2.description = "b";
        i2.amount = 89.2f;
        i2.print();

        Invoice i3 = new Invoice();
        i3.id = Invoice.genId();
        i3.description = "b";
        i3.amount = 89.2f;
        i3.print();



    }
}
