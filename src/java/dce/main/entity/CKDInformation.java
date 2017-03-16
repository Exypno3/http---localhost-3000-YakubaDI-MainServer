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
public class CKDInformation {
    private int m10_nzap;
    private Date m11_indt = null;
    private String m12_mocd;    // код лпу
    
    private CBedProfileList m13_bprlist; // список данных в разрезе профилей коек
    
    private int m14_zerr=0;

    public String getM15_usok() {
        return m15_usok;
    }

    public void setM15_usok(String m15_usok) {
        this.m15_usok = m15_usok;
    }
    
    private String m15_usok;
    
    private String z99_guid;
    //-----------------------------------------------------------------------------------------------------------------
    public String getZ99_guid() {return this.z99_guid;}
    public void setZ99_guid(String pz99_guid) {this.z99_guid = pz99_guid;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM11_indt() {return this.m11_indt;}
    public void setM11_indt(Date pm11_indt) {this.m11_indt = pm11_indt;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM14_zerr() {return this.m14_zerr;}
    public void setM14_zerr(int pm14_zerr) {this.m14_zerr = pm14_zerr;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM12_mocd() {return this.m12_mocd;}
    public void setM12_mocd(String pm12_mocd) {this.m12_mocd = pm12_mocd;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM10_nzap() {return this.m10_nzap;}
    public void setM10_nzap(int pm10_nzap) {this.m10_nzap = pm10_nzap;}
    //-----------------------------------------------------------------------------------------------------------------
    public CBedProfileList getM13_bprlist() {return this.m13_bprlist;}
    public void setM13_bprlist(CBedProfileList pm13_bprlist) {this.m13_bprlist = pm13_bprlist;}
    //-----------------------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------------------------------
