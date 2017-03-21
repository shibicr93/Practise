import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static BigDecimal computeClickThroughRate(Long impression, Long click) {
        BigDecimal computedResponseRate = null;
        if (click != null && impression != null && click > 0) {
            computedResponseRate = new BigDecimal(click);
            computedResponseRate = computedResponseRate.divide(new BigDecimal(impression), 6, RoundingMode.CEILING)
                    .multiply(new BigDecimal(100)).setScale(2, RoundingMode.CEILING);
        } else {
            computedResponseRate = new BigDecimal(0);
            computedResponseRate = computedResponseRate.multiply(new BigDecimal(100)).setScale(2, RoundingMode.CEILING);
        }
        return computedResponseRate;
    }

    public static String convertSecondsToTime(int seconds) {
        int hr = seconds/3600;
        int rem = seconds%3600;
        int mn = rem/60;
        int sec = rem%60;
        String hrStr = (hr<10 ? "0" : "")+hr;
        String mnStr = (mn<10 ? "0" : "")+mn;
        String secStr = (sec<10 ? "0" : "")+sec;
        return hrStr+":"+mnStr+":"+secStr;
    }

    public static int convertToSeconds(String time){
        //String time = "00:02"; //hh:mm:ss
        String[] units = time.split(":");
        int hours = Integer.parseInt(units[0]);
        int minutes = Integer.parseInt(units[1]);
        int seconds = Integer.parseInt(units[2]);
        int totalSeconds =3600*hours+ 60 * minutes + seconds;
        return totalSeconds;
    }

    public static void getNextMonday(){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate nextMon = localDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println(nextMon.toString());
    }

    public static void getDayOfWeek(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);
    }

    public static void main(String[] args) {
       // computeClickThroughRate(0L,5L);
       /* String time = convertSecondsToTime(6000);
        System.out.println("converted"+time);
        int seconds = convertToSeconds(time);
        System.out.println(seconds);*/

        //getNextMonday();

        getDayOfWeek();

    }
}
