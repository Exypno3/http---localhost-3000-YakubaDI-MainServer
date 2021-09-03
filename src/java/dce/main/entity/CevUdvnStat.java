/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author YakubaDI
 */
@XmlType(propOrder = {"rid","person"})
public class CevUdvnStat {
    private int rid;
    private CPerson person = new CPerson();
    
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }
    
    
}
