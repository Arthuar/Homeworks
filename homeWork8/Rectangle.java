package homeWork8;

public class Rectangle extends Shape{
    private int a;
    private int b;

    public Rectangle(String name, int a, int b) {
        super(name);
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public Rectangle(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Plocha Rectangle" + plocha() +
                "\n a = " + a +
                "\n b = " + b;
    }

    @Override
    public int plocha() {
        int s = getA()*getB();
        return s;
    }
}
