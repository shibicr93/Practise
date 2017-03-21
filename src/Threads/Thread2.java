package Threads;

/**
 * Created by sramachandran on 2/6/17
 **/
public class Thread2 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread2");

        Test.main(new StringBuffer());
    }
}
