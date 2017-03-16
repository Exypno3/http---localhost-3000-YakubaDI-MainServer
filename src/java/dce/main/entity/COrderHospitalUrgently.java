/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
//-----------------------------------------------------------------------------------------------------------------
import java.util.Date;

/**
 *
 * @author YaluplinMD
 */
//-----------------------------------------------------------------------------------------------------------------
public class COrderHospitalUrgently {
    private int m10_nzap;
    
    private String m11_modcd;       //Код ЛПУ где находится пациент
    private Date m12_dttmfh = null;
    
    private CPerson m13_pr = new CPerson();
    
    private String m14_kpkcd;
    private String m15_sccd;
    private String m16_crdnum;
    private String m17_mkbcd;   
    
    private int m18_zerr=0;
    
    private String z99_guid;
    //-----------------------------------------------------------------------------------------------------------------
    public String getZ99_guid() {return this.z99_guid;}
    public void setZ99_guid(String pz99_guid) {this.z99_guid = pz99_guid;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM18_zerr() {return this.m18_zerr;}
    public void setM18_zerr(int pm18_zerr) {this.m18_zerr = pm18_zerr;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM10_nzap() {return this.m10_nzap;}
    public void setM10_nzap(int pm10_nzap) {this.m10_nzap = pm10_nzap;}
    //-----------------------------------------------------------------------------------------------------------------
    public CPerson getM13_pr() {return this.m13_pr;}
    public void setM13_pr(CPerson pm13_pr) {this.m13_pr = pm13_pr;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM11_modcd() {return this.m11_modcd;}
    public void setM11_modcd(String pm11_modcd) {this.m11_modcd = pm11_modcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM12_dttmfh() {return this.m12_dttmfh;}
    public void setM12_dttmfh(Date pm12_dttmfh) {if(this.m12_dttmfh == null)this.m12_dttmfh = new Date(); this.m12_dttmfh = pm12_dttmfh;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM14_kpkcd() {return this.m14_kpkcd;}
    public void setM14_kpkcd(String pm14_kpkcd) {this.m14_kpkcd = pm14_kpkcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM15_sccd() {return this.m15_sccd;}
    public void setM15_sccd(String pm15_sccd) {this.m15_sccd = pm15_sccd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM16_crdnum() {return this.m16_crdnum;}
    public void setM16_crdnum(String pm16_crdnum) {this.m16_crdnum = pm16_crdnum;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM17_mkbcd() {return this.m17_mkbcd;}
    public void setM17_mkbcd(String pm17_mkbcd) {this.m17_mkbcd = pm17_mkbcd;}
    //-----------------------------------------------------------------------------------------------------------------
}
