/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;
import java.util.Date;
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
    private String mkbx;
    private Date mkbxdate = null;
    private int mkbxstts;
    private int mkbxmeth;
    private String doc_ss;
    private int opcode;
    private CPerson person = new CPerson();

    public int getRid() {
        return rid;
    }

    @XmlElement(required = true, nillable = false)
    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getKind() {
        return kind;
    }

    @XmlElement(required = true, nillable = false)
    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getYear() {
        return year;
    }

    @XmlElement(required = true, nillable = false)
    public void setYear(int year) {
        this.year = year;
    }

    public int getMnth() {
        return mnth;
    }

    @XmlElement(required = true, nillable = false)
    public void setMnth(int mnth) {
        this.mnth = mnth;
    }

    public String getCode_mo() {
        return code_mo;
    }

    @XmlElement(required = true, nillable = false)
    public void setCode_mo(String code_mo) {
        this.code_mo = code_mo;
    }

    public String getDfSection() {
        return dfSection;
    }

    @XmlElement(required = true, nillable = false)
    public void setDfSection(String dfSection) {
        this.dfSection = dfSection;
    }

    public int getCategory() {
        return category;
    }

    @XmlElement(required = true, nillable = false)
    public void setCategory(int category) {
        this.category = category;
    }
    

    public String getMkbx() {
        return mkbx;
    }

    @XmlElement(required = false, nillable = false)
    public void setMkbx(String mkbx) {
        this.mkbx = mkbx;
    }

    public Date getMkbxdate() {
        return mkbxdate;
    }

    @XmlElement(required = false, nillable = false)
    public void setMkbxdate(Date mkbxdate) {
        this.mkbxdate = mkbxdate;
    }

    public int getMkbxstts() {
        return mkbxstts;
    }

    @XmlElement(required = false, nillable = false)
    public void setMkbxstts(int mkbxstts) {
        this.mkbxstts = mkbxstts;
    }

    public int getMkbxmeth() {
        return mkbxmeth;
    }

    @XmlElement(required = false, nillable = false)
    public void setMkbxmeth(int mkbxmeth) {
        this.mkbxmeth = mkbxmeth;
    }

    public String getDoc_ss() {
        return doc_ss;
    }

    @XmlElement(required = false, nillable = false)
    public void setDoc_ss(String doc_ss) {
        this.doc_ss = doc_ss;
    }
    
    
    public int getOpcode() {
        return opcode;
    }

    @XmlElement(required = false, nillable = false)
    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    @XmlElement(required = true, nillable = false)
    public CPerson getPerson() {
        return person;
    }

    public void setPerson(CPerson person) {
        this.person = person;
    }
    

}
