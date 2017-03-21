package implementation;

import java.util.Scanner;
/**
 * Created by sramachandran on 3/20/17
 **/
public class MarsExploration {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int length = s.length();
        int count = 0;

        for(int i =0 ;i<length;i+=3){
            String str = s.substring(i,i+3);
            if(!str.equals("SOS")){
                if(str.charAt(0) != 'S'){
                    count++;
                }
                if(str.charAt(1) != 'O'){
                    count++;
                }if(str.charAt(2) != 'S'){
                    count++;
                }

            }
        }

        System.out.println(count);
    }
}


