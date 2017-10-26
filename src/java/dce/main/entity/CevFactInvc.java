/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;
import java.util.Date;
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author YakubaDI
 */
@XmlType(propOrder = {"rid","year","mnth","code_mo","smo_code","invcdatn","invcdato","invcdate","invcstts","ishob","q_g","person"})
public class CevFactInvc {
    private int rid;
    private int year;
    private int mnth;
    private String code_mo;
    private String smo_code;
    private Date invcdatn = null;
    private Date invcdato = null;
    private Date invcdate = null;
    private int invcstts;
    private String ishob;
    private String q_g;
    private CPerson person = new CPerson();

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMnth() {
        return mnth;
    }

    public void setMnth(int mnth) {
        this.mnth = mnth;
    }

    public String getCode_mo() {
        return code_mo;
    }

    public void setCode_mo(String code_mo) {
        this.code_mo = code_mo;
    }

    public String getSmo_code() {
        return smo_code;
    }

    public void setSmo_code(String smo_code) {
        this.smo_code = smo_code;
    }
    
    public Date getInvcdatn() {
        return invcdatn;
    }

    public void setInvcdatn(Date invcdatn) {
        this.invcdatn = invcdatn;
    }

    public Date getInvcdato() {
        return invcdato;
    }

    public void setInvcdato(Date invcdato) {
        this.invcdato = invcdato;
    }

    public Date getInvcdate() {
        return invcdate;
    }

    public void setInvcdate(Date invcdate) {
        this.invcdate = invcdate;
    }

    public int getInvcstts() {
        return invcstts;
    }

    public void setInvcstts(int invcstts) {
        this.invcstts = invcstts;
    }

    public String getIshob() {
        return ishob;
    }

    public void setIshob(String ishob) {
        this.ishob = ishob;
    }
    
    public String getQ_g() {
        return q_g;
    }

    public void setQ_g(String q_g) {
        this.q_g = q_g;
    }

    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }
  
    
    
}
