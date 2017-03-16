/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;

import java.util.Date;

/**
 *
 * @author YaluplinMD
 */
//-----------------------------------------------------------------------------------------------------------------
public class COrderNullification {
    private int m10_nzap;
    
    private String m11_ornm;
    private Date m12_ordt = null;
    private int m13_orstp;//тип того кто анулировал
    private String m14_ornscd;//кто анулировал
    private int m15_ornrcd; // причина анулирования
    private Date m16_ornld; // дата анулирования
    private Date m17_dtph = null; // date of plan hospital
    private String m18_lpucode; // код лпу куда выписано направление
    private String m19_kpkcd; // код профиля койки
    
    private int m20_zerr=0;
    
    private String z99_guid;
    //-----------------------------------------------------------------------------------------------------------------
    public String getZ99_guid() {return this.z99_guid;}
    public void setZ99_guid(String pz99_guid) {this.z99_guid = pz99_guid;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM19_kpkcd() {return this.m19_kpkcd;}
    public void setM19_kpkcd(String pm19_kpkcd) {this.m19_kpkcd = pm19_kpkcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM18_lpucode() {return this.m18_lpucode;}
    public void setM18_lpucode(String pm18_lpucode) {this.m18_lpucode = pm18_lpucode;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM17_dtph() {return this.m17_dtph;}
    public void setM17_dtph(Date pm17_dtph) {if(this.m17_dtph == null)this.m17_dtph=new Date(); this.m17_dtph = pm17_dtph;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM20_zerr() {return this.m20_zerr;}
    public void setM20_zerr(int pm20_zerr) {this.m20_zerr = pm20_zerr;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM10_nzap() {return this.m10_nzap;}
    public void setM10_nzap(int pm10_nzap) {this.m10_nzap = pm10_nzap;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM11_ornm() {return this.m11_ornm;}
    public void setM11_ornm(String pm11_ornm) {this.m11_ornm = pm11_ornm;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM12_ordt() {return this.m12_ordt;}
    public void setM12_ordt(Date pm12_ordt) {if(this.m12_ordt == null)this.m12_ordt=new Date(); this.m12_ordt = pm12_ordt;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM13_orstp() {return this.m13_orstp;}
    public void setM13_orstp(int pm13_orstp) {this.m13_orstp = pm13_orstp;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM14_ornscd() {return this.m14_ornscd;}
    public void setM14_ornscd(String pm14_ornscd) {this.m14_ornscd = pm14_ornscd;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM15_ornrcd() {return this.m15_ornrcd;}
    public void setM15_ornrcd(int pm15_ornrcd) {this.m15_ornrcd = pm15_ornrcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM16_ornld() {return this.m16_ornld;}
    public void setM16_ornld(Date pm16_ornld) {if(this.m16_ornld == null)this.m16_ornld=new Date(); this.m16_ornld = pm16_ornld;}
    //-----------------------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------------------------------
