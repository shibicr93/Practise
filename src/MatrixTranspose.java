/**
 * Created by sramachandran on 3/2/17
 **/
public class MatrixTranspose {

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4},{5,6},{7,8}};
        printArr(arr);
        int [][] arrTranspose = transposeArr(arr);
        System.out.println("-----------Transpose--------");
        printArr(arrTranspose);

    }

    private static int[][] transposeArr(final int[][] arr) {
        int arrNew[][] = new int[2][4];

        for(int i = 0;i<arr.length;i++){
            for(int j= 0; j<2 ; j++) {
                arrNew[j][i] = arr[i][j];
            }
        }
        return arrNew;
    }

    private static void printArr(int[][] arr){
        for (final int[] anArr : arr) {
            for (int j = 0; j < anArr.length; j++) {
                System.out.print(anArr[j] + "\t");
            }
            System.out.println("");
        }
    }

}
