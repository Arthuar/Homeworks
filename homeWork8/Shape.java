package homeWork8;

public abstract class Shape implements Inface {
    @Override
    public double dovzhynKola() {
        return 0;
    }


    @Override
    public int plocha() {
        return 0;
    }

    private String name;

    public String getName() {
        return name;
    }

    public Shape(String name){
        this.name = name;
    }
}
