/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
//----------------------------------------------------------------------------------------------------------------
/**
 *
 * @author YaluplinMD
 */
//----------------------------------------------------------------------------------------------------------------
public class CAssertReservedBed 
{
    private int p10_recid;
    private CBedAssertDetail p11_brdt = new CBedAssertDetail();
    private int p12_nzap;
    //----------------------------------------------------------------------------------------------------------------
    public int getP12_nzap() {return this.p12_nzap;}
    public void setP12_nzap(int pp12_nzap) {this.p12_nzap = pp12_nzap;}
    //----------------------------------------------------------------------------------------------------------------
    public int getP10_recid() {return this.p10_recid;}
    public void setP10_recid(int pp10_recid) {this.p10_recid = pp10_recid;}
    //----------------------------------------------------------------------------------------------------------------
    public CBedAssertDetail getP11_brdt() {return this.p11_brdt;}
    public void setP11_brdt(CBedAssertDetail pp11_brdt) {this.p11_brdt = pp11_brdt;}
    //----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------