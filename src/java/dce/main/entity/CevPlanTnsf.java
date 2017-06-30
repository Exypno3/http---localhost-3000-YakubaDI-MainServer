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
@XmlType(propOrder = {"id","code_mo","kind","tnsfdate","tnsftype","address"})
public class CevPlanTnsf {
    private int id;
    private String code_mo;
    private int kind;
    private Date tnsfdate = null;
    private int tnsftype;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getTnsfdate() {
        return tnsfdate;
    }

    public void setTnsfdate(Date tnsfdate) {
        this.tnsfdate = tnsfdate;
    }

    public int getTnsftype() {
        return tnsftype;
    }

    public void setTnsftype(int tnsftype) {
        this.tnsftype = tnsftype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    
}
