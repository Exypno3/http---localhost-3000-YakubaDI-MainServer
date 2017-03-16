/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//----------------------------------------------------------------------------------------------------------------
package dce.main.entity;

import java.util.Date;

/**
 *
 * @author YaluplinMD
 */
//----------------------------------------------------------------------------------------------------------------
public class CGuidStatus 
{
    private String r10_guid;
    private int r11_stcd;
    private Date r12_hsdt;
    //----------------------------------------------------------------------------------------------------------------
    public String getR10_guid() {return this.r10_guid;}
    public void setR10_guid(String pr10_guid) {this.r10_guid = pr10_guid;}
    //----------------------------------------------------------------------------------------------------------------
    public int getR11_stcd() {return this.r11_stcd;}
    public void setR11_stcd(int pr11_stcd) {this.r11_stcd = pr11_stcd;}
    //----------------------------------------------------------------------------------------------------------------
    public Date getR12_hsdt() {return this.r12_hsdt;}
    public void setR12_hsdt(Date pr12_hsdt) {if(this.r12_hsdt == null)this.r12_hsdt=new Date(); this.r12_hsdt = pr12_hsdt;}
    //----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------
