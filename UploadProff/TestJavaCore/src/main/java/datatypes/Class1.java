package datatypes;

public class Class1 {

    // primitive data types
    char a;
    byte b;
    short c;
    int d;
    long e;
    double f;
    float g;
    boolean h;

    // reference data types
    String s;

    public static void main(String[] args) {
        // boolean
        boolean b1 = true;
        b1 = false;
        // b1 = 10;
        // if (1) {}

        byte b;     // 8
        short c;
        int d;
        long e;     // 64

        long l = 100_000_123;   // decimal notation
        long l1 = 0x10AF;       // hex notation
        long l2 = 0b1_000_000;  // bin notation

        float average = 20.1234567890f; // 32bits
        double average2 = 20.1234567890f;   //64bits
        System.out.println(average);
        System.out.println(average2);

        char c1a = 'D';
        System.out.println(c1a);
        c1a = 122;
        System.out.println(c1a);

        c1a = '\u0122';
        System.out.println(c1a);

        // Identifiers rules
        int _AAZa_z123$ = 10;

        String ss = new String("hello");
        String ss1 = "hullo";

        int aa = 10;
    }
}
