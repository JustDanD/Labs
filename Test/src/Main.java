import java.util.Date;

public class Main {
    public static void main(String[] args) {
        A a = new B();
        System.out.print(a.test);
        System.out.print(a.testM());
        System.out.print(a.testM2());
        a = null;
       // System.out.print(a.test);
        //System.out.print(a.testM());
        System.out.print(a.testM2());
    }

}
class A {
    public int test = 4;
    public int testM() { return 1;}
    public static  int testM2() { return 3;}
}
class B extends A {
    public int test = 6;
    public int testM() { return 2;}
    public static int testM2() { return 5;}
}

