
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;


public class CSVFile {
    private static String[] HEADER_STRING = {"campaign_name","campaign_transaction_number","campaign_externalreference_id","campaign_type","campaign_budget_type","campaign_execution_timezone","campaign_start_date","campaign_end_date","campaign_cost_method","campaign_contracted_impressions","campaign_valueadd_impressions","campaign_cost_basis","campaign_target_spend","campaign_coas_enable","campaign_coas_active_1","campaign_coas_name_1","campaign_coas_costmethod_1","campaign_coas_variablecost_1","campaign_coas_fixedcost_1","campaign_coas_active_2","campaign_coas_name_2","campaign_coas_costmethod_2","campaign_coas_variablecost_2","campaign_coas_fixedcost_2","campaign_ace_pacingmode","campaign_initial_ecpm","campaign_is_this_ecpmcampaign","campaign_brand_security","campaign_frequencycap_enable","campaign_frequency_value","campaign_frequency_expirydays","campaign_survey_vendor","campaign_survey_id","campaign_conversion_pixel","campaign_conversion_intervaldays","campaign_description","campaign_darkperiod","campaign_schedule","campaign_ace_override","campaign_manualoverride_coverage","campaign_override_dailycap","campaign_manual_dailycap","campaign_is_this_hardbooked","campaign_is_this_acepaced","campaign_togi_vendor","campaign_togi_excludesegment","campaign_rtbdealtype_fixedprice","campaign_rtb_dealid","campaign_rtb_seatid","campaign_is_this_sponsorshipcampaign","campaign_sales_person","placement_name","placement_category","placement_inherit_dates","placement_start_date","placement_end_date","placement_target_name","placement_advertisement","placement_cost_method","placement_target_spend","placement_cost_basis","placement_contracted_impressions","placement_valueadd_impressions","placement_coas_enable","placement_coas_active_1","placement_coas_name_1","placement_coas_costmethod_1","placement_coas_variablecost_1","placement_coas_fixedcost_1","placement_coas_active_2","placement_coas_name_2","placement_coas_costmethod_2","placement_coas_variablecost_2","placement_coas_fixedcost_2","placement_ace_pacingmode","placement_initial_ecpm","placement_is_this_ecpmplacement","placement_override_enable","placement_override_costbasis","placement_ace_override","placement_manualoverride_coverage","placement_override_dailycap","placement_manual_dailycap","placement_frequency_value","placement_frequency_expirydays","placement_trackingplacement_Only","placement_darkperiod","placement_schedule","placement_description","placement_notes","placement_is_this_hardbooked","placement_bootstrap_coverage","placement_rtbdealtype_inherit","placement_rtbdealtype_fixedprice","placement_rtb_dealid","placement_rtb_seatid","placement_thirdParty_trackingnumber","placement_3rdparty_sold","placement_override_traffickingfee","placement_override_pubrevshare"};
    private StringBuffer cvsFile;
    private boolean state;
    private HttpServletResponse response = null;
    private ServletOutputStream out;
    private String contentType;
    private String opFileName;

    private static final String CSV_MESSAGE = "Unsupported Encoding in CSV input Stream Read process";

    public CSVFile() {
        cvsFile = new StringBuffer();
    }

    public CSVFile(HttpServletResponse response, String contentType, String opFileName) {
        this();
        this.response = response;
        this.contentType = contentType;
        this.opFileName = opFileName;
        init ();
    }

    public void init() {
        response.setContentType(contentType);
        response.setHeader("Content-Disposition","attachment;filename=" + opFileName);
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void newRow() {
        state = false;
        append("\n");
    }

    public void append(String str) {
        if(response == null) {
            cvsFile.append(str);
        } else {
            try {
                out.write(str.getBytes("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addColumnValueInRow(String columnValue) {
        if (state) {
            append(",");
        }
        state = true;
        //append("\"");
        append(replaceComma(columnValue));
        //append("\"");
    }

    public void addValueInRow(String columnValue) {
        if (state) {
            append(",");
        }
        state = true;
        append(replaceComma(columnValue));

    }

    public void addHeader(String headerName) {
        addColumnValueInRow(headerName);
    }

    public void addColumnsValueInRow(List<String> columnsValue) {
        for (String columnValue : columnsValue) {
            addColumnValueInRow(columnValue);
        }
    }

    public void addHeaders(List<String> headerNames) {
        for (String headerName : headerNames) {
            addColumnValueInRow(headerName);
        }
    }

    public void addRow(Object...values) {
        this.newRow();
        for (Object value : values) {
            addColumnValueInRow(String.valueOf(value));
        }
    }

    @Override
    public String toString() {
        return cvsFile.toString();
    }

    public InputStream toInputStream() {
        try {
            return new ByteArrayInputStream(cvsFile.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            //Bug 30254 change - Logger replaced with YumeLogger
            //Logger.getLogger(CSVFile.class.getName()).log(Level.ERROR, null, ex);
            ex.printStackTrace();
        }
        return null;
    }


    public void closeStream() {
        if(out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String replaceComma(String v) {
        if(v == null) {
            return v;
        }
        return v.replaceAll("\"", "\"\"");
    }

    public StringBuffer getCsvFile () {
        return cvsFile;
    }

    public static void main(String[] args) {
        CSVFile csvFile = new CSVFile();
        csvFile.addHeaders(Arrays.asList(HEADER_STRING));
        csvFile.closeStream();
        System.out.println(csvFile.getCsvFile().toString());
    }


}

