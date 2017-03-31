package implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by sramachandran on 3/30/17
 **/
public class BigFactorial {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        BigInteger factorial = fact(n);
        System.out.println(factorial);

    }
    static BigInteger fact (BigInteger num){
        if(num.equals(BigInteger.ONE) || num.equals(BigInteger.ZERO)){
            return num;
        }
        else{
            return num.multiply(fact(num.subtract(BigInteger.ONE)));
        }
    }
}
