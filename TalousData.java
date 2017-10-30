/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonToolV2_asiakasT;

/**
 *
 * @author John-Robert
 */
public class TalousData {
    public String revenue;
    public String profit;
    public String personnel;
    public String operatingMargin;
    public String equityRatio;
    public String deli;
    
//    public TalousData(){
//        this.revenue = null;
//        this.profit = null;
//        this.personnel = null;
//        this.operatingMargin = null;
//        this.equityRatio = null;
//    }
    public TalousData(String revenues,String profits,String personnel,String operatingProfits,String equityRatios,String deli){
        this.revenue = revenues;
        this.profit = profits;
        this.personnel = personnel;
        this.operatingMargin = operatingProfits;
        this.equityRatio = equityRatios;
        this.deli = deli;
//        System.out.println(this.toString());
    }
    
    public String getRevenue(){
        return this.revenue;
    }
    public String getProfit(){
        return this.profit;
    }
    public String getPersonnel(){
        return this.personnel;
    }
    public String getOperatingMargin(){
        return this.operatingMargin;
    }
    public String getEquityRatio(){
        return this.equityRatio;
    }
    @Override
    public String toString(){
        return this.revenue+deli+this.profit+deli+this.personnel+deli+this.operatingMargin+deli+this.equityRatio;
    }
}
