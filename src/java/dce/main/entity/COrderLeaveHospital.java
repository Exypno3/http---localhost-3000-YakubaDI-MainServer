/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-------------------------------------------------------------------------------------------------
package dce.main.entity;

import java.util.Date;

/**
 *
 * @author YaluplinMD
 */
//-------------------------------------------------------------------------------------------------
public class COrderLeaveHospital {
    private int m10_nzap;
    
    private String m11_ornm; // order number
    
    private Date m12_ordt = null;  // order date
    private int m13_ortp;   // order type
    private String m14_modcd;       // лпу откуда выписали
    private Date m15_dttmfh = null; // дата госпитализации
    private Date m16_dttmlv = null; // дата выписки
    
    private CPerson m17_pr = new CPerson();
    
    private String m18_kpkcd;   // профиль койки
    private String m19_sccd;    // отделение
    private String m20_crdnum;  // № карты стационарного больного
    
    private int m21_zerr;
    
    private String z99_guid;
    //-----------------------------------------------------------------------------------------------------------------
    public String getZ99_guid() {return this.z99_guid;}
    public void setZ99_guid(String pz99_guid) {this.z99_guid = pz99_guid;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM21_zerr() {return this.m21_zerr;}
    public void setM21_zerr(int pm21_zerr) {this.m21_zerr = pm21_zerr;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM10_nzap() {return this.m10_nzap;}
    public void setM10_nzap(int pm10_nzap) {this.m10_nzap = pm10_nzap;}
    //-----------------------------------------------------------------------------------------------------------------
    public CPerson getM17_pr() {return this.m17_pr;}
    public void setM17_pr(CPerson pm17_pr) {this.m17_pr = pm17_pr;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM11_ornm() {return this.m11_ornm;}
    public void setM11_ornm(String pm11_ornm) {this.m11_ornm = pm11_ornm;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM12_ordt() {return this.m12_ordt;}
    public void setM12_ordt(Date pm12_ordt) {if(this.m12_ordt == null)this.m12_ordt = new Date(); this.m12_ordt = pm12_ordt;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM13_ortp() {return this.m13_ortp;}
    public void setM13_ortp(int pm13_ortp) {this.m13_ortp = pm13_ortp;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM14_modcd() {return this.m14_modcd;}
    public void setM14_modcd(String pm14_modcd) {this.m14_modcd = pm14_modcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM15_dttmfh() {return this.m15_dttmfh;}
    public void setM15_dttmfh(Date pm15_dttmfh) {if(this.m15_dttmfh == null)this.m15_dttmfh = new Date(); this.m15_dttmfh = pm15_dttmfh;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM16_dttmlv() {return this.m16_dttmlv;}
    public void setM16_dttmlv(Date pm16_dttmlv) {if(this.m16_dttmlv == null)this.m16_dttmlv = new Date(); this.m16_dttmlv = pm16_dttmlv;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM18_kpkcd() {return this.m18_kpkcd;}
    public void setM18_kpkcd(String pm18_kpkcd) {this.m18_kpkcd = pm18_kpkcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM19_sccd() {return this.m19_sccd;}
    public void setM19_sccd(String pm19_sccd) {this.m19_sccd = pm19_sccd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM20_crdnum() {return this.m20_crdnum;}
    public void setM20_crdnum(String pm20_crdnum) {this.m20_crdnum = pm20_crdnum;}
    //-----------------------------------------------------------------------------------------------------------------
}
//-------------------------------------------------------------------------------------------------
