package date;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sramachandran on 3/27/17
 **/
public class TimeZoneUtil {
    private static final String NY_TZ_ID = "America/New_York";
    private static final char QUOTE = '\'';
    private static String SEP = ",";
    private static final char CLOSE_BRACKET = ')';
    private static final char OPEN_BRACKET = '(';
    private static final String ESCAPE_SEQUENCE = "\\";
    private static final String DEFAULT_HEADER = "Time_zone_name, Time_zone_display,Offset,Daylight_savings";
    private static final String NEW_LINE = "\n";
    public static final String IN_OUT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public TimeZoneUtil() {
    }

   public static String getPlatformTimeZone() {
        String platformTimeZone = System.getProperty("PLATFORM_TIME_ZONE_CODE");
        if(platformTimeZone == null) {
            platformTimeZone = "UTC";
        }

        return platformTimeZone;
    }

    public static Date offsetTimeZoneFromUTC(Date date, String targetTimeZone) {
        return getDatewithOffset("UTC", targetTimeZone, date);
    }

    public static Date offsetTimeZoneToUTC(Date date, String sourceTimeZone) {
        return getDatewithOffset(sourceTimeZone, "UTC", date);
    }

    public static Date offsetTimeZone(Date date, String sourceTimeZone, String targetTimeZone) {
        return getDatewithOffset(sourceTimeZone, targetTimeZone, date);
    }

    public static Date getCurrentTimeInEST() {
        String sourceTzId = TimeZone.getDefault().getID();
        Date defaultDate = new Date();
        Date outGoingDate = getDatewithOffset(sourceTzId, "America/New_York", defaultDate);
        return outGoingDate;
    }

    public static Date getCurrentTimeInUTC() {
        String sourceTzId = TimeZone.getDefault().getID();
        Date defaultDate = new Date();
        Date outGoingDate = getDatewithOffset(sourceTzId, "UTC", defaultDate);
        return outGoingDate;
    }

    public static Date getCurrentDatewithOffset(String sourceTimeZoneId, String targetTimeZoneId) {
        Date defaultDate = new Date();
        Date outGoingDate = getDatewithOffset(sourceTimeZoneId, targetTimeZoneId, defaultDate);
        return outGoingDate;
    }

    public static Date getDatewithOffset(String sourceTimeZoneId, String targetTimeZoneId, Date incomingDate) {
        System.out.println("START SOURCE TIME_ZONE CODE:" + sourceTimeZoneId + " DESTINATION TIME ZONE CODE:" + targetTimeZoneId + " DATE:" + incomingDate);
        if(incomingDate == null) {
            incomingDate = new Date();
        }

        long currentTimeInMillis = incomingDate.getTime();
        Date outGoingDate = new Date(currentTimeInMillis);
        System.out.println("Date before offSet applied:" + outGoingDate);

        try {
            if(sourceTimeZoneId != null && targetTimeZoneId != null && incomingDate != null) {
                SimpleDateFormat ex = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                TimeZone sourceTz = TimeZone.getTimeZone(sourceTimeZoneId);
                TimeZone targetTz = TimeZone.getTimeZone(targetTimeZoneId);
                System.out.println("Source Time Zone :" + sourceTimeZoneId);
                System.out.println("Target Time Zone :" + targetTimeZoneId);
                Calendar incomingDateCaledar = Calendar.getInstance();
                incomingDateCaledar.setTime(incomingDate);
                int year = incomingDateCaledar.get(1);
                int month = incomingDateCaledar.get(2);
                int day = incomingDateCaledar.get(5);
                int hour = incomingDateCaledar.get(11);
                int minute = incomingDateCaledar.get(12);
                int second = incomingDateCaledar.get(13);
                Calendar calendar = Calendar.getInstance(sourceTz);
                ex.setCalendar(calendar);
                calendar.set(year, month, day, hour, minute, second);
                incomingDate = ex.getCalendar().getTime();
                System.out.println("Date Before converting :" + incomingDate);
                ex.setTimeZone(targetTz);
                String formattedDate = ex.format(incomingDate);
                outGoingDate = formatter.parse(formattedDate);
                System.out.println("Date After offSet applied:" + outGoingDate);
                return outGoingDate;
            }

            System.out.println("END   SOURCE TIME_ZONE CODE:" + sourceTimeZoneId + " DESTINATION TIME ZONE CODE:" + targetTimeZoneId + " DATE:" + incomingDate);
        } catch (Exception var19) {
            System.out.println("TimeZoneUtil:getDatewithOffset :::: Exception while converting timezone" + var19);
        }

        return outGoingDate;
    }

    public static Date getDatewithDefaultTzOffset(String targetTimeZoneId, Date incomingDate) {
        String sourceTzId = TimeZone.getDefault().getID();
        Date outGoingDate = getDatewithOffset(sourceTzId, targetTimeZoneId, incomingDate);
        return outGoingDate;
    }

    public static String getDatewithDisplayTzOffset(Date incomingDate, String displayTimeZone) {
        return getDatewithDisplayTzOffset(incomingDate, displayTimeZone, "MMMM dd, yyyy HH:mm a z");
    }

    public static String getDatewithDisplayTzOffset(Date incomingDate, String displayTimeZone, String convertToFormat) {
        try {
            SimpleDateFormat e = new SimpleDateFormat(convertToFormat);
            if(displayTimeZone != null && displayTimeZone.length()>0) {
                displayTimeZone = "UTC";
            }

            TimeZone tz = TimeZone.getTimeZone(displayTimeZone);
            if(incomingDate == null) {
                return "NA";
            } else {
                e.setTimeZone(tz);
                return e.format(incomingDate);
            }
        } catch (Exception var5) {
            return "NA";
        }
    }

    public static String[] getAllTimezoneIds() {
        String[] availableTimeZoneArr = TimeZone.getAvailableIDs();
        return availableTimeZoneArr;
    }

    public static String dumptoSQLFile(String outputPath, String headerAsCsv) {
        StringBuilder builder = new StringBuilder();
        if(headerAsCsv != null && headerAsCsv.trim().length() > 0 && headerAsCsv.contains(SEP)) {
            System.out.println("Looks like  a valid header" + headerAsCsv);
            builder.append("INSERT INTO java_tz_data (").append(headerAsCsv).append(") VALUES");
        } else {
            builder.append("INSERT INTO java_tz_data (").append("Time_zone_name, Time_zone_display,Offset,Daylight_savings").append(") VALUES");
        }

        Map tzViewMap = getTzdata();
        int i = 0;

        for(Iterator output = tzViewMap.values().iterator(); output.hasNext(); ++i) {
            TimeZoneUtil.TzView actualPath = (TimeZoneUtil.TzView)output.next();
            int returnValue = actualPath.getDstSavings();
            int rawOffset = actualPath.getRawOffset();
            String displayName = actualPath.getDisplayName();
            String tzId = actualPath.getTzId();
            if(displayName.contains("\'")) {
                displayName = displayName.replaceAll("\'", "\\\\\'");
                System.out.println("[escapeString] input has special character needed escaping, escaped value =" + displayName);
            }

            builder.append('(').append('\'').append(tzId).append('\'').append(SEP).append('\'').append(displayName).append('\'').append(SEP).append(rawOffset).append(SEP).append(returnValue).append(')').append(SEP);
        }

        builder.deleteCharAt(builder.length() - 1);
        String var11 = builder.toString();
        String var12 = writetoFile(var11, outputPath);
        String var13 = "Total timezones=" + i + ", output file =" + var12;
        return var13;
    }

    public static String dumptoCSVFile(String outputPath, String headerAsCsv) {
        StringBuilder builder = new StringBuilder();
        if(headerAsCsv != null && headerAsCsv.trim().length() > 0 && headerAsCsv.contains(SEP)) {
            System.out.println("Looks like  a valid header" + headerAsCsv);
            builder.append(headerAsCsv).append("\n");
        } else {
            builder.append("Time_zone_name, Time_zone_display,Offset,Daylight_savings").append("\n");
        }

        Map tzViewMap = getTzdata();
        int i = 0;

        for(Iterator output = tzViewMap.values().iterator(); output.hasNext(); ++i) {
            TimeZoneUtil.TzView actualPath = (TimeZoneUtil.TzView)output.next();
            int returnValue = actualPath.getDstSavings();
            int rawOffset = actualPath.getRawOffset();
            String displayName = actualPath.getDisplayName();
            String tzId = actualPath.getTzId();
            if(displayName.contains("\'")) {
                displayName = displayName.replaceAll("\'", "\\\\\'");
                System.out.println("[escapeString] input has special character needed escaping, escaped value =" + displayName);
            }

            builder.append('\'').append(tzId).append('\'').append(SEP).append('\'').append(displayName).append('\'').append(SEP).append(rawOffset).append(SEP).append(returnValue).append("\n");
        }

        String var11 = builder.toString();
        String var12 = writetoFile(var11, outputPath);
        String var13 = "Total timezones=" + i + ", output file =" + var12;
        return var13;
    }

    private static String writetoFile(String output, String outputPath) {
        File outFile = new File(outputPath);
        String actualPath = outFile.getAbsolutePath();
        FileWriter fWriter = null;
        BufferedWriter bWriter = null;

        try {
            fWriter = new FileWriter(outFile);
            bWriter = new BufferedWriter(fWriter);
            bWriter.append(output);
        } catch (IOException var19) {
            System.err.println("Error in writing to file " + outFile.getAbsolutePath() + ", see below for the details");
            var19.printStackTrace();
        } finally {
            if(bWriter != null) {
                try {
                    bWriter.close();
                } catch (IOException var18) {
                    var18.printStackTrace();
                }
            }

            if(fWriter != null) {
                try {
                    fWriter.close();
                } catch (IOException var17) {
                    var17.printStackTrace();
                }
            }

        }

        return actualPath;
    }

    public static Map<String, TimeZoneUtil.TzView> getTzdata() {
        TreeMap tzViewMap = new TreeMap();
        String[] tzIdArr = getAllTimezoneIds();

        for(int i = 0; i < tzIdArr.length; ++i) {
            String tzId = tzIdArr[i];
            TimeZone timeZone = TimeZone.getTimeZone(tzId);
            int dstSavings = timeZone.getDSTSavings() / 1000;
            int rawOffset = timeZone.getRawOffset() / 1000;
            String displayName = timeZone.getDisplayName();
            if(displayName.contains("\'")) {
                displayName = displayName.replaceAll("\'", "\\\'");
                System.out.println("Display Name has special character needed escaping, escaped value =" + displayName);
            }

            TimeZoneUtil.TzView tzView = new TimeZoneUtil.TzView(dstSavings, rawOffset, displayName, tzId);
            tzViewMap.put(tzId, tzView);
        }

        return tzViewMap;
    }

    public static final void resetCalenderToStartOfTheDay(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    public static final void setTimeToEndofDay(Calendar calendar) {
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
    }

    public static final void reSetTimeToEndofDay(Calendar calendar) {
        setTimeToEndofDay(calendar);
    }



    public static Date offsetReportDateToUTC(Date date, String reportTimeZoneCode, Integer offsetHours) {
        if(isUTCTimeZone(reportTimeZoneCode)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            if(offsetHours != null) {
                calendar.add(10, offsetHours.intValue());
            }

            return calendar.getTime();
        } else {
            return offsetTimeZone(date, reportTimeZoneCode, getPlatformTimeZone());
        }
    }

    public static Date offsetReportDateFromUTC(Date date, String reportTimeZoneCode, Integer offsetHours) {
        date = offsetTimeZone(date, getPlatformTimeZone(), reportTimeZoneCode);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if(isUTCTimeZone(reportTimeZoneCode) && offsetHours != null) {
            calendar.add(10, offsetHours.intValue());
        }

        return calendar.getTime();
    }

    public static boolean isUTCTimeZone(String timeZoneCode) {
        return "UTC".equalsIgnoreCase(timeZoneCode) || "GMT".equalsIgnoreCase(timeZoneCode);
    }

    public static Date getStartDateByTimeZoneCode(String timeZoneCode) {
        /*if(timeZoneCode != null) {
            timeZoneCode = TimeZoneThreadLocal.getNetworkTimeZone();
            if(UtilLogic.isNullOrEmpty(timeZoneCode)) {
                timeZoneCode = getPlatformTimeZone();
            }
        }*/

        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTimeInMillis(date.getTime());
        TimeZone timeZone = calendar.getTimeZone();
        date = offsetTimeZone(calendar.getTime(), timeZone.getID(), timeZoneCode);
        calendar.setTimeInMillis(date.getTime());
        resetCalenderToStartOfTheDay(calendar);
        return calendar.getTime();
    }

    /*public static Date getCurrentDateByTimeZoneCode(String timeZoneCode) {
        if(UtilLogic.isNullOrEmpty(timeZoneCode)) {
            timeZoneCode = TimeZoneThreadLocal.getNetworkTimeZone();
            if(UtilLogic.isNullOrEmpty(timeZoneCode)) {
                timeZoneCode = getPlatformTimeZone();
            }
        }

        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTimeInMillis(date.getTime());
        TimeZone timeZone = calendar.getTimeZone();
        date = offsetTimeZone(calendar.getTime(), timeZone.getID(), timeZoneCode);
        calendar.setTimeInMillis(date.getTime());
        return calendar.getTime();
    }*/

    /*public static Date getStartDateInReportTimeZone() {
        return getStartDateByTimeZoneCode(getReportTimeZone());
    }

    public static Date getStartDateInNetworkTimeZone() {
        return getStartDateByTimeZoneCode(getNetworkTimeZone());
    }

    public static Date getStartDateByUserTimeZone() {
        return getStartDateByTimeZoneCode(getUserTimeZone());
    }
*/
    public static Date utcDateInstance() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTimeInMillis(date.getTime());
        TimeZone timeZone = calendar.getTimeZone();
        date = offsetTimeZone(calendar.getTime(), timeZone.getID(), "UTC");
        return calendar.getTime();
    }

    public static final Date resetCalenderToStartOfTheDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        resetCalenderToStartOfTheDay(calendar);
        return calendar.getTime();
    }

    public static final Date reSetTimeToEndofDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        reSetTimeToEndofDay(calendar);
        return calendar.getTime();
    }

    public static boolean isValidFromAndToDates(Date fromDate, Date toDate) {
        long milliseconds1 = fromDate.getTime();
        long milliseconds2 = toDate.getTime();
        return milliseconds2 >= milliseconds1;
    }

    public static String fromUTCToTimeZone(Date utcDate, String distTimeZone, String strFormat) {
        SimpleDateFormat df = new SimpleDateFormat(strFormat);
        df.setTimeZone(TimeZone.getTimeZone(distTimeZone));
        return df.format(utcDate);
    }

    public static class TzView implements Serializable {
        private static final long serialVersionUID = 3951060142773377344L;
        private int dstSavings;
        private int rawOffset;
        private String displayName;
        private String tzId;

        public int getDstSavings() {
            return this.dstSavings;
        }

        public void setDstSavings(int dstSavings) {
            this.dstSavings = dstSavings;
        }

        public int getRawOffset() {
            return this.rawOffset;
        }

        public void setRawOffset(int rawOffset) {
            this.rawOffset = rawOffset;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getTzId() {
            return this.tzId;
        }

        public void setTzId(String tzId) {
            this.tzId = tzId;
        }

        public TzView() {
        }

        public TzView(int dstSavings, int rawOffset, String displayName, String tzId) {
            this.dstSavings = dstSavings;
            this.rawOffset = rawOffset;
            this.displayName = displayName;
            this.tzId = tzId;
        }
    }

    public static void main(String[] args) {
       Date estDate = getCurrentTimeInEST();
        Date utcDate = getCurrentTimeInUTC();
        System.out.println((offsetTimeZoneToUTC(estDate, "EST")));
       /*System.out.println(offsetTimeZoneFromUTC(utcDate,"EST"));*//*
        getTzdata();*/
    }
}
