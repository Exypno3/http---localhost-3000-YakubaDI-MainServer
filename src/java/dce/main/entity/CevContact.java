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
@XmlType(propOrder = {"id","code_mo","phone","comment"})
public class CevContact {
    private int id;
    private String code_mo;
    private String phone;
    private String comment;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
