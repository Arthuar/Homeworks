package homeWork8;

public class Quad extends Shape{
    private  int a;
    private int b;
    private int h;

    public Quad(String name, int a, int b, int h) {
        super(name);
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getH() {
        return h;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public Quad(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Plocha Quad " + plocha() +
                "\n a = " + a +
                "\n b = " + b +
                "\n h = " + h;
    }

    @Override
    public  int plocha(){
        if(a == 0 && b == 0 || h == 0){
            System.out.println("wrong number");
            return 0;
        }
        int s =((getA() + getB()) / 2) * getH();
        return s;//plochaTrapecii
    }
}
