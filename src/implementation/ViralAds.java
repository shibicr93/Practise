package implementation;

/**
 * Created by sramachandran on 3/21/17
 **/
public class ViralAds {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        System.out.println(findTotalLikes(10,5));
    }

    private static double findTotalLikes(double n, double sum){
        for(double i=0;i<n;i++){
            sum += findTotalLikes(Math.floor(sum/2),sum);
        }
        return sum;
    }
}

