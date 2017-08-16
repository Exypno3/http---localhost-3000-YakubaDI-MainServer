/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author YakubaDI
 */
@XmlRootElement(name="orderpack")
@XmlType(propOrder = {"p10_packinf","evFactInfos"})
public class CevFactInfosPackage {
    private CPackageInformation p10_packinf;
    private CevFactInfos evFactInfos;

    public CevFactInfosPackage() {
        this.evFactInfos = new CevFactInfos();
    }

    public CPackageInformation getP10_packinf() {
        return p10_packinf;
    }

    public void setP10_packinf(CPackageInformation p10_packinf) {
        this.p10_packinf = p10_packinf;
    }

    public CevFactInfos getEvFactInfos() {
        return evFactInfos;
    }

    public void setEvFactInfos(CevFactInfos evFactInfos) {
        this.evFactInfos = evFactInfos;
    }
    
    
}
