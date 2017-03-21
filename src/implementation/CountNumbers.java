package implementation;

/**
 * Created by sramachandran on 3/21/17
 **/
public class CountNumbers {

    static void countNumbers(int[][] arr) {
        int count = 0;
        int total=0;
        int row = arr.length;
        int col = arr[0].length;
        total=row*col;

        for(int i=0;i<row;i++){
            for(int j =0;j<arr[i].length;j++){
                int num = arr[i][j];
                if(isEqual(num)){
                    count++;
                }

            }
        }
        System.out.println(total-count);

    }

    private static boolean isEqual(final int num) {
        String s = String.valueOf(num);
        String rev = new StringBuffer(s).reverse().toString();
        return s.equals(rev);
    }

    public static void main(String[] args) {

    }
}
