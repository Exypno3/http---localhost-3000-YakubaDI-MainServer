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
@XmlType(propOrder = {"rid","smo_code","code_mo","infodate","infometh","infostep","person"})
public class CevFactInfo {
    private int rid;
    private String smo_code;
    private String code_mo;
    private Date infodate = null;
    private int infometh;
    private int infostep;
    private int inforslt;
    private CPerson person = new CPerson();


    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getSmo_code() {
        return smo_code;
    }

    public void setSmo_code(String smo_code) {
        this.smo_code = smo_code;
    }

    public String getCode_mo() {
        return code_mo;
    }

    public void setCode_mo(String code_mo) {
        this.code_mo = code_mo;
    }

    public Date getInfodate() {
        return infodate;
    }

    public void setInfodate(Date infodate) {
        this.infodate = infodate;
    }

    public int getInfometh() {
        return infometh;
    }

    public void setInfometh(int infometh) {
        this.infometh = infometh;
    }

    public int getInfostep() {
        return infostep;
    }

    public void setInfostep(int infostep) {
        this.infostep = infostep;
    }


    public int getInforslt() {
        return inforslt;
    }

    public void setInforslt(int inforslt) {
        this.inforslt = inforslt;
    }

    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }
    
    
}
