package homeWork8;

public class Righttriangle extends Shape{
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public Righttriangle(String name, int a, int b) {
        super(name);
        this.a = a;
        this.b = b;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public Righttriangle(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Plocha Righttriangle{" + plocha() +
                "\n a = " + a +
                "\n b = " + b;
    }

    @Override
    public int plocha() {
        if(a == 0 || b == 0){
            System.out.println("wrong number");
            return 0;
        }
        int s = (1/2)*getA()*getB();
        return s;
    }
}
