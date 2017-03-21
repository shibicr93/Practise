/**
 * Created by sramachandran on 3/2/17
 **/
public class SubStringFirstLast {

    public static void main(String[] args) {

        String testStr = "test";
        for(int i=0; i<testStr.length()/2 ;i++) {
            for(int j=testStr.length() -1;j>testStr.length()/2 -1;j--){
                if(isFirstLastMatch(testStr,i,j)){
                    System.out.println(testStr.substring(i,j+1));
                }
            }
        }
    }

    private static boolean isFirstLastMatch(String string,int i ,int j) {
        if(string.charAt(i) == string.charAt(j)){
            return true;
        }
        return false;
    }
}
