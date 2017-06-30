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
@XmlType(propOrder = {"p10_packinf","evContacts"})
public class CevContactsPackage {
    private CPackageInformation p10_packinf;
    private CevContacts evContacts;

    public CevContactsPackage() {
        evContacts = new CevContacts();
    }

    public CPackageInformation getP10_packinf() {
        return p10_packinf;
    }

    public void setP10_packinf(CPackageInformation p10_packinf) {
        this.p10_packinf = p10_packinf;
    }

    public CevContacts getEvContacts() {
        return evContacts;
    }

    public void setEvContacts(CevContacts evContacts) {
        this.evContacts = evContacts;
    }
    
    
    
}
