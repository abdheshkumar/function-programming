package parkar;

/**
 * Created by Abdhesh.Kumar on 27-08-2016.
 */
public class Simple {

    public static void foo(/*final*/ int a) {
        System.out.println(a);
        a = 20;
        System.out.println(a);
    }

    public static void main(String arg[]) {
        foo(5);
    }
}
