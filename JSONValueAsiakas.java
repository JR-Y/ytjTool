/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonToolV2_asiakasT;

import java.util.HashMap;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author John-Robert
 */
public class JSONValueAsiakas {

    JSONObject yritys;
    String delim;
    HashMap<String, TalousData> data;

    public JSONValueAsiakas(String delim) {
        this.delim = delim;
    }

    public HashMap<String, TalousData> getMap(String s) throws JSONException {
        try {
            yritys = new JSONObject(s.replace('.', ','));
            
        } catch (JSONException ex) {
//            Logger.getLogger(JSONValueAsiakas.class.getName()).log(Level.SEVERE, null, ex);
        }
        data = new HashMap();
        try {
            JSONArray regEntDates = yritys.getJSONArray("dates");
            for (int i = 0; i < regEntDates.length(); i++) {
                String revenues = yritys.getJSONArray("revenues").get(i).toString();
                String profits = yritys.getJSONArray("profits").get(i).toString();
                String personnel = yritys.getJSONArray("personnel").get(i).toString();
                String operatingMargins = yritys.getJSONArray("operatingMargins").get(i).toString();
                String equityRatios = yritys.getJSONArray("equityRatios").get(i).toString();
                TalousData d = new TalousData(revenues, profits, personnel, operatingMargins, equityRatios, delim);
                this.data.put(regEntDates.get(i).toString(), d);
            }
        } catch (JSONException e) {
        }
        
        return data;
    }

    public String getYear(String year) throws JSONException {
        String s;
        s = data.get(year).toString();
        return s;
    }

    public String getRevenue(String year) throws JSONException {
        String s;
        s = data.get(year).getRevenue();
        return s;
    }

    public String getProfits(String year) throws JSONException {
        String s;
        s = data.get(year).getProfit();
        return s;
    }

    public String getpersonnel(String year) throws JSONException {
        String s;
        s = data.get(year).getPersonnel();
        return s;
    }

    public String getOperatingMargins(String year) throws JSONException {
        String s;
        s = data.get(year).getOperatingMargin();
        return s;
    }

    public String getEquityRatios(String year) throws JSONException {
        String s;
        s = data.get(year).getEquityRatio();
        return s;
    }
    @Override
    public String toString(){
        String s="";
        for(int i = 0;i<data.size();i++){
            if(s.isEmpty()){
                s = data.toString();
            }else{
                s=s+data.toString();
            }
        }        
        return s;
    }

}
