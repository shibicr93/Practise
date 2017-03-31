package implementation;

import java.util.Scanner;

/**
 * Created by sramachandran on 3/30/17
 **/
public class EvenDivisibleDigits {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            String numberStr = in.next();
            Integer number = Integer.parseInt(numberStr);
            int count=0;
            for(char num : numberStr.toCharArray()){
                int digit=Character.digit(num, 10);
                if(digit!=0&& number%digit==0){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
