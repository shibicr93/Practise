package Threads;

/**
 * Created by sramachandran on 2/6/17
 **/
public class Test {

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
        String s;
    }

    public synchronized static void main(StringBuilder stringBuilder) {
        System.out.println("StringBuilder");
    }


    public synchronized static void main(StringBuffer stringBuffer) {
        System.out.println("StringBuffer");
    }



    public static void main() {
        System.out.println("Empty");
    }

}
