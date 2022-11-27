package exercises.com.management;

public class Invoice {

    public int id;
    private double internalRatio;
    public String description;
    public float amount;
    private static int nid=100;

    public void print() {
        internalRatio = Math.random();
        System.out.println(id + " " + internalRatio + " " + description + " " + amount);
    }

    static public int genId() {
        nid = nid + 1;
        return nid;
    }

}
