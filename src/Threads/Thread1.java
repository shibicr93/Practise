package Threads;

/**
 * Created by sramachandran on 2/6/17
 **/
public class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread1");
        try {
            Thread1.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Test.main(new StringBuilder());
    }
}
