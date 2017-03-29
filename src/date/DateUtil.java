package date;

/**
 * Created by sramachandran on 3/29/17
 **/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    public static final String SQL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public DateUtil() {
    }

    public static DateRangeVO getLast7DaysDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        setTimeToEndofDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        toDt = calendar.getTime();
        calendar.add(5, -6);
        resetCalenderToStartOfTheDay(calendar);
        fromDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    public static DateRangeVO getYesterdayDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        resetCalenderToStartOfTheDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        calendar.add(5, -1);
        fromDt = calendar.getTime();
        setTimeToEndofDay(calendar);
        toDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    public static DateRangeVO getDayBeforeYesterdayDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        resetCalenderToStartOfTheDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        calendar.add(5, -2);
        fromDt = calendar.getTime();
        setTimeToEndofDay(calendar);
        toDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    public static DateRangeVO getThisWeekDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        resetCalenderToStartOfTheDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        int todaysNumberInWeek = calendar.get(7) - 1;
        if(todaysNumberInWeek == 0) {
            fromDt = calendar.getTime();
        } else {
            calendar.add(5, -todaysNumberInWeek);
            fromDt = calendar.getTime();
        }

        calendar.add(5, 6);
        setTimeToEndofDay(calendar);
        toDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    public static DateRangeVO getLastWeekDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        resetCalenderToStartOfTheDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        int todaysNumberInWeek = calendar.get(7) - 1;
        calendar.add(5, -(todaysNumberInWeek + 7));
        fromDt = calendar.getTime();
        calendar.add(5, 6);
        setTimeToEndofDay(calendar);
        toDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    public static DateRangeVO getTodayDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        resetCalenderToStartOfTheDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        fromDt = calendar.getTime();
        setTimeToEndofDay(calendar);
        toDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    public static DateRangeVO getLast30DaysDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        setTimeToEndofDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        toDt = calendar.getTime();
        calendar.add(5, -29);
        resetCalenderToStartOfTheDay(calendar);
        fromDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    public static DateRangeVO getLast90DaysDate() throws Exception {
        Calendar calendar = null;
        String timeZoneCode = TimeZoneUtil.getPlatformTimeZone();
        calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        Date fromDt = null;
        calendar.add(5, -89);
        fromDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), (Date)null);
    }

    public static DateRangeVO getThisMonthDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        resetCalenderToStartOfTheDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        int thisMonth = calendar.get(2);
        int thisYear = calendar.get(1);
        setCalendar(calendar, 1, thisMonth, thisYear);
        fromDt = calendar.getTime();
        int lastDayOfMonth = calendar.getActualMaximum(5);
        setCalendar(calendar, lastDayOfMonth, thisMonth, thisYear);
        setTimeToEndofDay(calendar);
        toDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    public static DateRangeVO getLastMonthDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        resetCalenderToStartOfTheDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        int thisMonth = calendar.get(2);
        int thisYear = calendar.get(1);
        if(thisMonth == 0) {
            thisMonth = 12;
            --thisYear;
        }

        setCalendar(calendar, 1, thisMonth - 1, thisYear);
        fromDt = calendar.getTime();
        int lastDayOfMonth = calendar.getActualMaximum(5);
        setCalendar(calendar, lastDayOfMonth, thisMonth - 1, thisYear);
        setTimeToEndofDay(calendar);
        toDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    public static DateRangeVO getThisQuarterDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        resetCalenderToStartOfTheDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        int thisMonth = calendar.get(2);
        ++thisMonth;
        int quarter = (thisMonth - 1) / 3;
        ++quarter;
        int thisYear = calendar.get(1);
        switch(quarter) {
            case 1:
                setCalendar(calendar, 1, 0, thisYear);
                fromDt = calendar.getTime();
                setCalendar(calendar, 31, 2, thisYear);
                break;
            case 2:
                setCalendar(calendar, 1, 3, thisYear);
                fromDt = calendar.getTime();
                setCalendar(calendar, 30, 5, thisYear);
                break;
            case 3:
                setCalendar(calendar, 1, 6, thisYear);
                fromDt = calendar.getTime();
                setCalendar(calendar, 30, 8, thisYear);
                break;
            case 4:
                setCalendar(calendar, 1, 9, thisYear);
                fromDt = calendar.getTime();
                setCalendar(calendar, 31, 11, thisYear);
        }

        setTimeToEndofDay(calendar);
        toDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    public static DateRangeVO getLastQuarterDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        resetCalenderToStartOfTheDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        int thisMonth = calendar.get(2);
        ++thisMonth;
        int quarter = (thisMonth - 1) / 3;
        ++quarter;
        int lastQuarter = quarter - 1;
        int thisYear = calendar.get(1);
        if(lastQuarter == 0) {
            lastQuarter = 4;
            --thisYear;
        }

        switch(lastQuarter) {
            case 1:
                setCalendar(calendar, 1, 0, thisYear);
                fromDt = calendar.getTime();
                setCalendar(calendar, 31, 2, thisYear);
                break;
            case 2:
                setCalendar(calendar, 1, 3, thisYear);
                fromDt = calendar.getTime();
                setCalendar(calendar, 30, 5, thisYear);
                break;
            case 3:
                setCalendar(calendar, 1, 6, thisYear);
                fromDt = calendar.getTime();
                setCalendar(calendar, 30, 8, thisYear);
                break;
            case 4:
                setCalendar(calendar, 1, 9, thisYear);
                fromDt = calendar.getTime();
                setCalendar(calendar, 31, 11, thisYear);
        }

        setTimeToEndofDay(calendar);
        toDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    private static void setCalendar(Calendar calendar, int date, int month, int year) {
        calendar.set(5, date);
        calendar.set(2, month);
        calendar.set(1, year);
    }

    public static DateRangeVO getThisYearDate(String timeZoneCode, Date scheduleDt) throws Exception {
        Calendar calendar = null;
        if(scheduleDt != null) {
            calendar = Calendar.getInstance();
            calendar.setTime(TimeZoneUtil.offsetTimeZoneFromUTC(scheduleDt, timeZoneCode));
            calendar.setTimeZone(TimeZone.getTimeZone(timeZoneCode));
        } else {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneCode));
        }

        resetCalenderToStartOfTheDay(calendar);
        Date fromDt = null;
        Date toDt = null;
        int thisYear = calendar.get(1);
        setCalendar(calendar, 1, 0, thisYear);
        fromDt = calendar.getTime();
        setCalendar(calendar, 31, 11, thisYear);
        setTimeToEndofDay(calendar);
        toDt = calendar.getTime();
        return new DateRangeVO(TimeZoneUtil.offsetTimeZoneFromUTC(fromDt, timeZoneCode), TimeZoneUtil.offsetTimeZoneFromUTC(toDt, timeZoneCode));
    }

    private static void resetCalenderToStartOfTheDay(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    private static void setTimeToEndofDay(Calendar calendar) {
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 0);
    }

    public static Date getScheduleTime(String scheduleType, String timeZoneCode, int hour) throws Exception {
        Calendar scheduleTime = null;
        System.out.println("scheduleType : " + scheduleType + " timezone code: " + timeZoneCode);
        scheduleTime = Calendar.getInstance();
        scheduleTime.setTime(TimeZoneUtil.getStartDateByTimeZoneCode(timeZoneCode));
        scheduleTime.set(10, hour);
        if(scheduleType!= null) {
            if(scheduleType.equalsIgnoreCase("Day")) {
                scheduleTime.add(5, 1);
            } else {
                int nextScheDt;
                if(scheduleType.equalsIgnoreCase("Week")) {
                    nextScheDt = scheduleTime.get(7) - 1;
                    if(nextScheDt != 0) {
                        scheduleTime.add(5, -nextScheDt);
                    }

                    scheduleTime.add(5, 7);
                } else if(scheduleType.equalsIgnoreCase("Month")) {
                    nextScheDt = scheduleTime.get(2);
                    int thisYear = scheduleTime.get(1);
                    scheduleTime.set(5, 1);
                    scheduleTime.set(2, nextScheDt);
                    scheduleTime.set(1, thisYear);
                    int lastDayOfMonth = scheduleTime.getActualMaximum(5);
                    scheduleTime.set(5, lastDayOfMonth);
                    scheduleTime.set(2, nextScheDt);
                    scheduleTime.set(1, thisYear);
                    scheduleTime.add(5, 1);
                }
            }
        }

        Date nextScheDt1 = scheduleTime.getTime();
        System.out.println("Before utc convertion schedule time : " + nextScheDt1);
        nextScheDt1 = TimeZoneUtil.offsetTimeZoneToUTC(nextScheDt1, timeZoneCode);
        System.out.println("After utc convertion schedule time : " + nextScheDt1);
        return nextScheDt1;
    }

    public static String convertDateToDateFormat(Date objDate, String dateFormat) {
        System.out.println("UtiLogic:dateFormatter() -- START");

        try {
            SimpleDateFormat e = new SimpleDateFormat(dateFormat);
            if(objDate == null) {
                return "NA";
            } else {
                System.out.println("UtiLogic:dateFormatter() -- END");
                return e.format(objDate);
            }
        } catch (Exception var3) {
            System.out.println("UtiLogic:dateFormatter()--ParseException"+ var3);
            return "NA";
        }
    }

    public static long getNumberOfMinutesBetweenDates(String startDate, String endDate) {
        System.out.println("UtiLogic:getNumberOfDaysBetweenTwoDates() -- START");
        long numberofMinutesBetweenDays = 0L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDt = null;
        Date endDt = null;

        try {
            startDt = sdf.parse(startDate);
            Calendar e = Calendar.getInstance();
            e.setTime(startDt);
            System.out.println("Start Date : " + startDate);
            System.out.println("End Date : " + endDate);
            System.out.println(" Start Time in Millis : " + e.getTimeInMillis());
            long startTimeMillis = e.getTimeInMillis();
            endDt = sdf.parse(endDate);
            e.setTime(endDt);
            System.out.println("Start Date : " + startDt);
            System.out.println("End Date : " + endDt);
            System.out.println(" End Time in Millis : " + e.getTimeInMillis());
            long endTimeMillis = e.getTimeInMillis();
            numberofMinutesBetweenDays = (endTimeMillis - startTimeMillis) / 60000L;
            System.out.println(" Difference in minutes : " + numberofMinutesBetweenDays);
        } catch (Exception var12) {
            numberofMinutesBetweenDays = 0L;
            System.out.println("UtiLogic:getNumberOfDaysBetweenTwoDates() -- Exception in getting no of days "+ var12);
        }

        System.out.println("UtiLogic:getNumberOfDaysBetweenTwoDates() -- END");
        return numberofMinutesBetweenDays;
    }

    public static Double computeFlightDatePercentage(Date effectiveFromDate, Date effectiveEndDate, String timeZoneCode) {
        Double computedFlightPercent = null;

        try {
            Date ex = TimeZoneUtil.offsetTimeZoneFromUTC(effectiveFromDate, timeZoneCode);
            Date endDate = TimeZoneUtil.offsetTimeZoneFromUTC(effectiveEndDate, timeZoneCode);
            Date todaysDate = TimeZoneUtil.offsetTimeZoneFromUTC(new Date(), timeZoneCode);
            String formattedTodayDate = convertDateToDateFormat(todaysDate, "yyyy-MM-dd HH:mm:ss");
            String formattedStartDate = convertDateToDateFormat(ex, "yyyy-MM-dd HH:mm:ss");
            String formattedEndDate = convertDateToDateFormat(endDate, "yyyy-MM-dd HH:mm:ss");
            System.out.println("formattedTodayDate : " + formattedTodayDate);
            System.out.println("formattedStartDate : " + formattedStartDate);
            System.out.println("formattedEndDate : " + formattedEndDate);
            long currentTime = getNumberOfMinutesBetweenDates(formattedStartDate, formattedTodayDate);
            long totalDuration = getNumberOfMinutesBetweenDates(formattedStartDate, formattedEndDate);
            ++totalDuration;
            if(getNumberOfMinutesBetweenDates(formattedEndDate, formattedTodayDate) > 0L) {
                currentTime = totalDuration;
            }

            computedFlightPercent = Double.valueOf(Double.valueOf((double)currentTime).doubleValue() / Double.valueOf((double)totalDuration).doubleValue() * 100.0D);
            System.out.println("computedFlightPercent : " + computedFlightPercent);
        } catch (Exception var14) {
            System.out.println("Exception occurred in computeExpectedImpressions:"+ var14);
        }

        return computedFlightPercent;
    }

    public static String getCurrentTime() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String todaysDate = String.format("%tH%tM%tS", new Object[]{c, c, c});
        return todaysDate;
    }
}
