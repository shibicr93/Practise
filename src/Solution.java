import java.util.*;



public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] array = new double[n];

        for(int i = 0; i<n; i++){
            array[i]=in.nextInt();
        }
        System.out.printf("%.1f", getMean(array,n));
        System.out.println("");
        System.out.printf("%.1f", getMedian(array,n));
        System.out.println("");
        System.out.printf("%.1f", getMode(array,n));
        System.out.println("");


    }

    private static double scale(double value){
        return Math.round(value * 10) / 10;
    }

    private static double getMean(double[] array, int n){
        double sum = 0;
        for(double ip : array){
            sum+=ip;
        }
        return sum/n;
    }

    private static double getMedian(double[] array, int n){

        Arrays.sort(array);

        if(n%2 == 0){
            return ((double)array[n/2] + (double)array[n/2 - 1])/2;
        }else return array[(n/2)];

    }

    private static double getMode(double[] numbers, int num){

        final List<Double> modes = new ArrayList<Double>();
        final Map<Double, Integer> countMap = new HashMap<Double, Integer>();

        int max = -1;

        for (final double n : numbers) {
            int count = 0;

            if (countMap.containsKey(n)) {
                count = countMap.get(n) + 1;
            } else {
                count = 1;
            }

            countMap.put(n, count);

            if (count > max) {
                max = count;
            }
        }

        for (final Map.Entry<Double, Integer> tuple : countMap.entrySet()) {
            if (tuple.getValue() == max) {
                modes.add(tuple.getKey());
            }
        }

        return Collections.min(modes);

    }



}