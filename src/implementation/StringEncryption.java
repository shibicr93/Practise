package implementation;

import java.util.Scanner;

/**
 * Created by sramachandran on 3/30/17
 **/
public class StringEncryption {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.next();
        int L = input.length();
        int row = (int) Math.floor(Math.sqrt(L));
        int column;
        if (row >= Math.sqrt(L))
            column = row;
        else column = row + 1;
        for(int j=0;j<column;++j) {
            for(int i=j; i<L;i+=column){
                System.out.print(input.charAt(i));
            }
            System.out.println();
        }
    }
}
