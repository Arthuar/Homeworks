package homeWork8;

public class Circle extends Shape {

    @Override
    public String getName() {
        return super.getName();
    }

    private final double chusloPi = 3.14;
    private int r;

    @Override
    public String toString() {
        return "DovzhynKola Circle " + dovzhynKola() +
                "\n chusloPi = " + chusloPi +
                "\n r = " + r;
    }

    public double getChusloPi() {
        return chusloPi;
    }

    public int getR() {
        return r;
    }

    public Circle(String name, int r) {
        super(name);
        this.r = r;
    }

    @Override
    public double dovzhynKola() {
        if(r==0){
            System.out.println("wrong radius");
            return 0;
        }
        double c = 2.0*getChusloPi()*r;
        return c;

    }
}
