package homeWork8;


public class Square extends Shape{
    private int a;
    private int b;

    @Override
    public String toString() {
        return "Plocha Square : " + plocha() +
                "\n a = " + a +
                "\n b = " + b;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public Square(String name) {
        super(name);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public Square(String name, int a, int b) {
        super(name);
        this.a = a;
        this.b = b;
    }


    @Override
    public int plocha() {
        if(a == 0 || b == 0){
            System.out.println("wrong number");
            return 0;
        }
        int s = getA()*getB();
        return s;

    }
}
