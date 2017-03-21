

/**
 * Created by sramachandran on 1/16/17
 **/
public class CampaignBulkExportVO {


    private String campaign_name;
    private String campaign_transaction_number;
    private String campaign_externalreference_id;
    private String campaign_type;
    private String campaign_budget_type;
    private String campaign_execution_timezone;
    private String campaign_start_date;
    private String campaign_end_date;
    private String campaign_cost_method;
    private String campaign_contracted_impressions;
    private String campaign_valueadd_impressions;
    private String campaign_cost_basis;
    private String campaign_target_spend;
    private String campaign_coas_enable;
    private String campaign_coas_active_1;
    private String campaign_coas_name_1;
    private String campaign_coas_costmethod_1;
    private String campaign_coas_variablecost_1;
    private String campaign_coas_fixedcost_1;
    private String campaign_coas_active_2;
    private String campaign_coas_name_2;
    private String campaign_coas_costmethod_2;
    private String campaign_coas_variablecost_2;
    private String campaign_coas_fixedcost_2;
    private String campaign_ace_pacingmode;
    private String campaign_initial_ecpm;
    private String campaign_is_this_ecpmcampaign;
    private String campaign_brand_security;
    private String campaign_frequencycap_enable;
    private String campaign_frequency_value;
    private String campaign_frequency_expirydays;
    private String campaign_survey_vendor;
    private String campaign_survey_id;
    private String campaign_conversion_pixel;
    private String campaign_conversion_intervaldays;
    private String campaign_description;
    private String campaign_darkperiod;
    private String campaign_schedule;
    private String campaign_ace_override;
    private String campaign_manualoverride_coverage;
    private String campaign_override_dailycap;
    private String campaign_manual_dailycap;
    private String campaign_is_this_hardbooked;
    private String campaign_is_this_acepaced;
    private String campaign_togi_vendor;
    private String campaign_togi_excludesegment;
    private String campaign_rtbdealtype_fixedprice;
    private String campaign_rtb_dealid;
    private String campaign_rtb_seatid;
    private String campaign_is_this_sponsorshipcampaign;
    private String campaign_sales_person;


    @Override
    public String toString() {
        return campaign_name+","+campaign_transaction_number+","+campaign_externalreference_id+","+campaign_type+","+campaign_budget_type+","+campaign_execution_timezone+","+campaign_start_date+","+campaign_end_date+","+campaign_cost_method+","+campaign_contracted_impressions+","+campaign_valueadd_impressions+","+campaign_cost_basis+","+campaign_target_spend+","+campaign_coas_enable+","+campaign_coas_active_1+","+campaign_coas_name_1+","+campaign_coas_costmethod_1+","+campaign_coas_variablecost_1+","+campaign_coas_fixedcost_1+","+campaign_coas_active_2+","+campaign_coas_name_2+","+campaign_coas_costmethod_2+","+campaign_coas_variablecost_2+","+campaign_coas_fixedcost_2+","+campaign_ace_pacingmode+","+campaign_initial_ecpm+","+campaign_is_this_ecpmcampaign+","+campaign_brand_security+","+campaign_frequencycap_enable+","+campaign_frequency_value+","+campaign_frequency_expirydays+","+campaign_survey_vendor+","+campaign_survey_id+","+campaign_conversion_pixel+","+campaign_conversion_intervaldays+","+campaign_description+","+campaign_darkperiod+","+campaign_schedule+","+campaign_ace_override+","+campaign_manualoverride_coverage+","+campaign_override_dailycap+","+campaign_manual_dailycap+","+campaign_is_this_hardbooked+","+campaign_is_this_acepaced+","+campaign_togi_vendor+","+campaign_togi_excludesegment+","+campaign_rtbdealtype_fixedprice+","+campaign_rtb_dealid+","+campaign_rtb_seatid+","+campaign_is_this_sponsorshipcampaign+","+campaign_sales_person;

    }

    public static void main(String[] args) {
        System.out.println(new CampaignBulkExportVO().toString());
    }
}
