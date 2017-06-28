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
public class CevPlanQtysPackage {
    private CPackageInformation p10_packinf;
    private CevPlanQtys evPlanQtys;

    public CevPlanQtysPackage() {
        evPlanQtys = new CevPlanQtys();
    }

    public CPackageInformation getP10_packinf() {
        return p10_packinf;
    }

    public void setP10_packinf(CPackageInformation p10_packinf) {
        this.p10_packinf = p10_packinf;
    }

    public CevPlanQtys getEvPlanQtys() {
        return evPlanQtys;
    }

    public void setEvPlanQtys(CevPlanQtys evPlanQtys) {
        this.evPlanQtys = evPlanQtys;
    }

    
    
}
