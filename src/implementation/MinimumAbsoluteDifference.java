package implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sramachandran on 3/30/17
 **/
public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        Arrays.sort(a);
        int min =Math.abs(a[0]-a[1]);
        for (int i = 0,j=i+1; i < a.length-1&&j<a.length; i++,j++) {
            if(Math.abs(a[i]-a[j])<min){
                min=Math.abs(a[i]-a[j]);
            }
        }
        System.out.println(min);
    }
}
