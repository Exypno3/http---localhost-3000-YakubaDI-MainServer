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
@XmlType(propOrder = {"rid","code_mo","kind","evdt","meth","comment","address"})
public class CevPlanDate {
    private int rid;
    private String code_mo;
    private int kind;
    private Date evdt = null;
    private int meth;
    private String comment;
    private String address;

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

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public Date getEvdt() {
        return evdt;
    }

    public void setEvdt(Date evdt) {
        this.evdt = evdt;
    }

    public int getMeth() {
        return meth;
    }

    public void setMeth(int meth) {
        this.meth = meth;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

 
    
}
