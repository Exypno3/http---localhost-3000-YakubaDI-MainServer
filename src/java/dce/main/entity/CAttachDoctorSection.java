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
public class CAttachDoctorSection {
    private int d10_nzap;
    private String d11_snils;
    private CAttachMOSection d12_orcl[];/*список участков в лпу где трудится врач*/
    private Date d13_dn = null; /*дата начала действия*/
    private int d14_st; /*долность врача 1 - врач, 2 - сред мед.персонал*/
    private String d15_mo; /*код структурного если в p11_mocd идёт юр лицо*/
    private String d16_sr; /*фамилия*/
    private String d17_nm; /*имя*/
    private String d18_ln; /*отчество*/
    private Date d19_br = null;
    private int d20_ds; /*специальность мед работника*/
    
    public int getD20_ds() {
        return d20_ds;
    }

    public void setD20_ds(int d20_ds) {
        this.d20_ds = d20_ds;
    }
    
    public String getD16_sr() {
        return d16_sr;
    }

    public void setD16_sr(String d16_sr) {
        this.d16_sr = d16_sr;
    }

    public String getD17_nm() {
        return d17_nm;
    }

    public void setD17_nm(String d17_nm) {
        this.d17_nm = d17_nm;
    }

    public String getD18_ln() {
        return d18_ln;
    }

    public void setD18_ln(String d18_ln) {
        this.d18_ln = d18_ln;
    }

    public Date getD19_br() {
        return d19_br;
    }

    public void setD19_br(Date d19_br) {
        if(this.d19_br == null)this.d19_br=new Date(); this.d19_br = d19_br;
    }
    //-----------------------------------------------------------------------------------------
    public int getD14_st() {return d14_st;}
    public void setD14_st(int d14_st) {this.d14_st = d14_st;}
    //-----------------------------------------------------------------------------------------
    public int getD10_nzap() {return this.d10_nzap;}
    public void setD10_nzap(int pd10_snils) {this.d10_nzap = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getD11_snils() {return this.d11_snils;}
    public void setD11_snils(String pd10_snils) {this.d11_snils = pd10_snils;}
    //-----------------------------------------------------------------------------------------
    public CAttachMOSection[] getD12_orcl() {return this.d12_orcl;}
    public void setD12_orcl(CAttachMOSection[] pd10_snils) {this.d12_orcl = pd10_snils;}
    //-----------------------------------------------------------------------------------------
    public Date getD13_dn() {return this.d13_dn;}
    public void setD13_dn(Date pd15_br) {if(this.d13_dn == null)this.d13_dn=new Date(); this.d13_dn = pd15_br;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getD15_mo() {return this.d15_mo;}
    public void setD15_mo(String pd10_snils) {this.d15_mo = pd10_snils;}
    //-----------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------
