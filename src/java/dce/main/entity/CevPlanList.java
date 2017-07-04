/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author YakubaDI
 */
@XmlRootElement(name="orderpack")
public class CevPlanList {
    private CevPlan evPlanList[];

    public CevPlan[] getEvPlanList() {
        return evPlanList;
    }

    public void setEvPlanList(CevPlan[] evPlanList) {
        this.evPlanList = evPlanList;
    }
    
    
}
