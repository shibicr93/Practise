package implementation;

import java.util.Scanner;

/**
 * Created by sramachandran on 3/30/17
 **/
public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        int primarySum=0;
        int secondarySum=0;

        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
                //Primary diagonal
                if(a_i==a_j ) {primarySum += a[a_i][a_j];}
                //Secondary diagonal
                if(a_i==((n-1)-a_j))secondarySum += a[a_i][a_j];
            }
        }
        System.out.println(Math.abs(primarySum-secondarySum));

    }
}
