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
@XmlType(propOrder = {"p10_packinf","evFactExecs"})
public class CevFactExecsPackage {
    private CPackageInformation p10_packinf;
    private CevFactExecs evFactExecs;

    public CevFactExecsPackage() {
        this.evFactExecs = new CevFactExecs();
    }

    public CPackageInformation getP10_packinf() {
        return p10_packinf;
    }

    public void setP10_packinf(CPackageInformation p10_packinf) {
        this.p10_packinf = p10_packinf;
    }

    public CevFactExecs getEvFactExecs() {
        return evFactExecs;
    }

    public void setEvFactExecs(CevFactExecs evFactExecs) {
        this.evFactExecs = evFactExecs;
    }
    
    
    
}
