package date;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by sramachandran on 3/29/17
 **/
public class MetricsUtil {
    public static Double computeExpectedImpressions(Date effectiveFromDate, Date effectiveEndDate, BigInteger impressionGoal, String timeZoneCode, Date reportLastLoadDate) {
        double expectedImpressions = 0.0D;

        try {
            Date ex = TimeZoneUtil.offsetTimeZoneFromUTC(effectiveFromDate, timeZoneCode);
            Date endDate = TimeZoneUtil.offsetTimeZoneFromUTC(effectiveEndDate, timeZoneCode);
            Date reportDate = TimeZoneUtil.offsetTimeZoneFromUTC(reportLastLoadDate, timeZoneCode);
            String formattedReportDate = DateUtil.convertDateToDateFormat(reportDate, "yyyy-MM-dd HH:mm:ss");
            String formattedStartDate = DateUtil.convertDateToDateFormat(ex, "yyyy-MM-dd HH:mm:ss");
            String formattedEndDate = DateUtil.convertDateToDateFormat(endDate, "yyyy-MM-dd HH:mm:ss");
            System.out.println("formattedReportDate : " + formattedReportDate);
            System.out.println("formattedStartDate : " + formattedStartDate);
            System.out.println("formattedEndDate : " + formattedEndDate);
            long currentTime = DateUtil.getNumberOfMinutesBetweenDates(formattedStartDate, formattedReportDate);
            long totalDuration = DateUtil.getNumberOfMinutesBetweenDates(formattedStartDate, formattedEndDate);
            ++totalDuration;
            if(DateUtil.getNumberOfMinutesBetweenDates(formattedEndDate, formattedReportDate) > 0L) {
                currentTime = totalDuration;
            }

            System.out.println("NumberOfMinutesBetweenTwoDates Numerator: " + currentTime);
            System.out.println("NumberOfMinutesBetweenTwoDates Denominator: " + totalDuration);
            System.out.println("ImpressionGoal : " + impressionGoal);
            expectedImpressions += (new BigDecimal(impressionGoal)).multiply(new BigDecimal(Double.valueOf((double)currentTime).doubleValue() / Double.valueOf((double)totalDuration).doubleValue())).doubleValue();
            System.out.println("Numerator/Denominator : " + Double.valueOf((double) currentTime).doubleValue() / Double.valueOf((double) totalDuration).doubleValue());
            System.out.println("(Numerator/Denominator)*ImpressionGoal : " + expectedImpressions);
        } catch (Exception var17) {
            System.out.println("Exception occurred in computeExpectedImpressions:" + var17);
        }

        return Double.valueOf(expectedImpressions);
    }

    public static void main(String[] args) {


    }
}
