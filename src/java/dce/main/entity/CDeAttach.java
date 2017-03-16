/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;

import java.util.Date;

/**
 *
 * @author Администратор
 */
public class CDeAttach {
    private int p10_nzap;
    private CPerson p11_pr = new CPerson();
    private String p12_sect; /*участок*/
    private Date p13_add = null; // дата открепления
    private int p14_adr; /*причина открепления*/
    private String p15_mo; /*ЛПУ открепления*/
    private String p16_f; /*кто открепил 1 - фонд*/

    public String getP16_f() {
        return p16_f;
    }

    public void setP16_f(String p16_f) {
        this.p16_f = p16_f;
    }
    //-----------------------------------------------------------------------------------------------------------------
    public int getP10_nzap() {return this.p10_nzap;}
    public void setP10_nzap(int pd10_snils) {this.p10_nzap = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public CPerson getP11_pr() {return this.p11_pr;}
    public void setP11_pr(CPerson pp11_pr) {this.p11_pr = pp11_pr;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getP12_sect() {return this.p12_sect;}
    public void setP12_sect(String pd10_snils) {this.p12_sect = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getP13_add() {return this.p13_add;}
    public void setP13_add(Date pa19_pbd) {if(this.p13_add == null)this.p13_add=new Date(); this.p13_add = pa19_pbd;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getP14_adr() {return this.p14_adr;}
    public void setP14_adr(int pd10_snils) {this.p14_adr = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getP15_mo() {return this.p15_mo;}
    public void setP15_mo(String pd10_snils) {this.p15_mo = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
}
