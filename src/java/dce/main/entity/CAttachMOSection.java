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
//-----------------------------------------------------------------------------------------------------------------
public class CAttachMOSection {
    private String s10_sect;/*код участка*/
    private Date s11_dn = null; /*дата начала действия*/
    private String s12_snum; /*номер участка*/
    //-----------------------------------------------------------------------------------------------------------------
    public String getS12_snum() {return s12_snum;}
    //-----------------------------------------------------------------------------------------------------------------
    public void setS12_snum(String s12_snum) {this.s12_snum = s12_snum;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getS10_sect() {return this.s10_sect;}
    public void setS10_sect(String pd10_snils) {this.s10_sect = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getS11_dn() {return this.s11_dn;}
    public void setS11_dn(Date pd16_dn) {if(this.s11_dn == null)this.s11_dn=new Date(); this.s11_dn = pd16_dn;}
    //-----------------------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------------------------------
