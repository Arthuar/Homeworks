package homeWork8;

public class ShapeTest {
    public static void main(String[] args) {
        Circle cr = new Circle("circle",10);
        Quad q = new Quad("quad",5,5,5);
        Square sq = new Square("square",10, 15);
        Righttriangle rt = new Righttriangle("righttriangle",10,10);
        Rectangle r = new Rectangle("rectangle",6,8);
        ShowName showName = new ShowName();
        showName.showName(cr);
        showName.showName(q);
        showName.showName(sq);
        showName.showName(rt);
        showName.showName(r);
        System.out.println(cr);
        System.out.println(q);
        System.out.println(sq);
        System.out.println(rt);
        System.out.println(r);

    }
}
