package implementation;

import java.util.Scanner;

/**
 * Created by sramachandran on 3/30/17
 **/
public class AppleOrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();//house loc
        int t = in.nextInt();//house loc
        int a = in.nextInt();//apple loc
        int b = in.nextInt();//orange loc
        int m = in.nextInt();//apple dist arr size
        int n = in.nextInt();//orange dist arr size
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        int applecount=0;
        for(int i=0;i<m;i++){
            int dapple = a+apple[i];
            if(dapple>=s && dapple<=t){
                applecount++;
            }
        }
        int orangecount=0;
        for(int i=0;i<n;i++){
            int dorange = b+orange[i];
            if(dorange>=s && dorange<=t){
                orangecount++;
            }
        }
        System.out.println(applecount);
        System.out.println(orangecount);

    }
}
