package date;

import java.util.Date;

/**
 * Created by sramachandran on 3/29/17
 **/
public class DateRangeVO {
    private Date startDt;
    private Date endDt;
    private String startTimeId;
    private String endTimeId;

    public DateRangeVO() {
    }

    public DateRangeVO(Date startDt, Date endDt) {
        this.startDt = startDt;
        this.endDt = endDt;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(final Date startDt) {
        this.startDt = startDt;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(final Date endDt) {
        this.endDt = endDt;
    }

    public String getStartTimeId() {
        return startTimeId;
    }

    public void setStartTimeId(final String startTimeId) {
        this.startTimeId = startTimeId;
    }

    public String getEndTimeId() {
        return endTimeId;
    }

    public void setEndTimeId(final String endTimeId) {
        this.endTimeId = endTimeId;
    }
}
