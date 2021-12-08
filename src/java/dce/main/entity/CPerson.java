/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;

import java.util.Date;
//import java.util.LinkedList;
//import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author YaluplinMD
 */
//-----------------------------------------------------------------------------------------------------------------
//@XmlType(propOrder={"a10_dct", "a11_dcs", "a12_dcn", "a13_smcd", "a14_trcd", "a15_pfio", "a16_pnm", "a17_pln", "a18_ps", "a19_pbd", "a20_pph", "a21_ps", "a22_pn", "a23_dt"})
public class CPerson {
    private int a10_dct;  // Тип документа 
    private String a11_dcs; //document seria
    private String a12_dcn; // document number
    private String a13_smcd;   //Код СМО
    private String a14_trcd;   //Код территории страхования
    private String a15_pfio; // fio
    private String a16_pnm; //name
    private String a17_pln; // lastname
    private String a18_ps; // sex
    private Date a19_pbd = null; // birthdate
    private String a20_pph; // phone
    private String a21_ps; // doc_ser
    private String a22_pn; // doc_num
    private int a23_dt; // doc_type
    private String a24_sl; // snils
    private String a25_enp; // enp
    //-----------------------------------------------------------------------------------------------------------------
    public int getA23_dt() {return this.a23_dt;}
    public void setA23_dt(int pa23_dt) {this.a23_dt = pa23_dt;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA25_enp() {return this.a25_enp;}
    public void setA25_enp(String pa22_pn) {this.a25_enp = pa22_pn;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA22_pn() {return this.a22_pn;}
    public void setA22_pn(String pa22_pn) {this.a22_pn = pa22_pn;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA21_ps() {return this.a21_ps;}
    public void setA21_ps(String pa21_ps) {this.a21_ps = pa21_ps;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getA10_dct() {return this.a10_dct;}
    public void setA10_dct(int pa10_dct) {this.a10_dct = pa10_dct;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA11_dcs() {return this.a11_dcs;}
    public void setA11_dcs(String pa11_dcs) {this.a11_dcs = pa11_dcs;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA12_dcn() {return this.a12_dcn;}
    public void setA12_dcn(String pa12_dcn) {this.a12_dcn = pa12_dcn;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA13_smcd() {return this.a13_smcd;}
    public void setA13_smcd(String pa13_smcd) {this.a13_smcd = pa13_smcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA14_trcd() {return this.a14_trcd;}
    public void setA14_trcd(String pa14_trcd) {this.a14_trcd = pa14_trcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA15_pfio() {return this.a15_pfio;}
    public void setA15_pfio(String pa15_pfio) {this.a15_pfio = pa15_pfio;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA16_pnm() {return this.a16_pnm;}
    public void setA16_pnm(String pa16_pnm) {this.a16_pnm = pa16_pnm;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA17_pln() {return this.a17_pln;}
    public void setA17_pln(String pa17_pln) {this.a17_pln = pa17_pln;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA18_ps() {return this.a18_ps;}
    public void setA18_ps(String pa18_ps) {this.a18_ps = pa18_ps;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getA19_pbd() {return this.a19_pbd;}
    public void setA19_pbd(Date pa19_pbd) {if(this.a19_pbd == null)this.a19_pbd=new Date(); this.a19_pbd = pa19_pbd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA20_pph() {return this.a20_pph;}
    public void setA20_pph(String pa20_pph) {this.a20_pph = pa20_pph;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA24_sl() {return this.a24_sl;}
    public void setA24_sl(String pa21_ps) {this.a24_sl = pa21_ps;}
    //-----------------------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------------------------------
