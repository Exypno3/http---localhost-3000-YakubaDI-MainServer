/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
/**
 *
 * @author YakubaDI
 */
@XmlType(propOrder = {"rid","kind","year","mnth","code_mo","dfSection","category","opcode","person"})
public class CevPlan {
    private int rid;
    private int kind;
    private int year;
    private int mnth;
    private String code_mo;
    private String dfSection;
    private int category;
    private int opcode;
    private CPerson person = new CPerson();

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
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

    public String getDfSection() {
        return dfSection;
    }

    public void setDfSection(String dfSection) {
        this.dfSection = dfSection;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    
    public int getOpcode() {
        return opcode;
    }

    @XmlElement(required = false, nillable = false)
    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }
    

}
