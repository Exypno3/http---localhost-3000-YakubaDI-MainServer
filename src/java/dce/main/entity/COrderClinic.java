/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dce.main.entity;

import java.util.Date;
/**
 *
 * @author YaluplinMD
 */
//----------------------------------------------------------------------------------------------------------------
public class COrderClinic 
{
    private int m10_nzap;
    
    private String m11_ornm; // order number
    
    private Date m12_ordt = null;  // order date
    private int m13_ortp;   // order type
    private String m14_moscd;            //Код ЛПУ направившей на госпитализацию
    private String m15_modcd;       //Код ЛПУ куда направлен пациент
    
    private CPerson m16_pr;// = new CPerson();
    
    private String m18_mkbcd; // mkbx
    private String m19_kpkcd; // bed profile
    private String m20_sccd; // section
    private String m21_dcnm; // doctor tabel number
    private Date m22_dtph = null; // date of plan hospital
    
    private int m23_zerr=0;       // служебное поле при загрузке проставлять признак - запись с ошибкой

    private String m24_usok; // условия оказания мед помощи: 1 - стационарно, 2 - дневной стационар
    private String m25_trcd; // код ОКАТО

    public String getM25_trcd() {
        return m25_trcd;
    }

    public void setM25_trcd(String m25_trcd) {
        this.m25_trcd = m25_trcd;
    }
    
    private String z99_guid;
   
     public String getM24_usok() {
        return m24_usok;
    }

    public void setM24_usok(String m24_usok) {
        this.m24_usok = m24_usok;
    }
    //-----------------------------------------------------------------------------------------------------------------
    public String getZ99_guid() {return this.z99_guid;}
    public void setZ99_guid(String pz99_guid) {this.z99_guid = pz99_guid;}
    //-----------------------------------------------------------------------------------------------------------------
    public COrderClinic()
    {
        m16_pr = new CPerson();
    }
    //-----------------------------------------------------------------------------------------------------------------
    public int getM10_nzap() {return this.m10_nzap;}
    public void setM10_nzap(int pm10_nzap) {this.m10_nzap = pm10_nzap;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM23_zerr() {return this.m23_zerr;}
    public void setM23_zerr(int pm23_zerr) {this.m23_zerr = pm23_zerr;}
    //-----------------------------------------------------------------------------------------------------------------
    public CPerson getM16_pr() {return this.m16_pr;}
    public void setM16_pr(CPerson pm16_pr) {this.m16_pr = pm16_pr;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM11_ornm() {return this.m11_ornm;}
    public void setM11_ornm(String pm11_ornm) {this.m11_ornm = pm11_ornm;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM12_ordt() {return this.m12_ordt;}
    public void setM12_ordt(Date pm12_ordt) {if(this.m12_ordt == null)this.m12_ordt=new Date(); this.m12_ordt = pm12_ordt;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM13_ortp() {return this.m13_ortp;}
    public void setM13_ortp(int pm13_ortp) {this.m13_ortp = pm13_ortp;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM14_moscd() {return this.m14_moscd;}
    public void setM14_moscd(String pm14_moscd) {this.m14_moscd = pm14_moscd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM15_modcd() {return this.m15_modcd;}
    public void setM15_modcd(String pm15_modcd) {this.m15_modcd = pm15_modcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM18_mkbcd() {return this.m18_mkbcd;}
    public void setM18_mkbcd(String pm18_mkbcd) {this.m18_mkbcd = pm18_mkbcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM19_kpkcd() {return this.m19_kpkcd;}
    public void setM19_kpkcd(String pm19_kpkcd) {this.m19_kpkcd = pm19_kpkcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM20_sccd() {return this.m20_sccd;}
    public void setM20_sccd(String pm20_sccd) {this.m20_sccd = pm20_sccd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM21_dcnm() {return this.m21_dcnm;}
    public void setM21_dcnm(String pm21_dcnm) {this.m21_dcnm = pm21_dcnm;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM22_dtph() {return this.m22_dtph;}
    public void setM22_dtph(Date pm22_dtph) {if(this.m22_dtph == null)this.m22_dtph=new Date(); this.m22_dtph = pm22_dtph;}
    //----------------------------------------------------------------------------------------------------------------- 
}
