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
@XmlType(propOrder = {"rid","code_mo","execdate","execstep","execmeth","prevdate","person"})
public class CevFactExec {
    private int rid;
    private String code_mo;
    private Date execdate = null;
    private int execstep;
    private int execmeth;
    private Date prevdate = null;

    public Date getPrevdate() {
        return prevdate;
    }

    public void setPrevdate(Date prevdate) {
        this.prevdate = prevdate;
    }
    
    private CPerson person = new CPerson();

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getCode_mo() {
        return code_mo;
    }

    public void setCode_mo(String code_mo) {
        this.code_mo = code_mo;
    }

    public Date getExecdate() {
        return execdate;
    }

    public void setExecdate(Date execdate) {
        this.execdate = execdate;
    }

    public int getExecstep() {
        return execstep;
    }

    public void setExecstep(int execstep) {
        this.execstep = execstep;
    }


    public int getExecmeth() {
        return execmeth;
    }

    public void setExecmeth(int execmeth) {
        this.execmeth = execmeth;
    }
    
    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }
    
    
}
