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
public class CAttachMODoctor {
    private String m10_mocd; /*лпу где трудится врач, ОГРН для МИАЦ и код из SPR01 для всех остальных*/
    //private CAttachMOSection m11_orcl[];/*список участков в лпу где трудится*/
    private Date m11_dn = null; /*дата начала действия*/
    //-----------------------------------------------------------------------------------------------------------------
    public String getM10_mocd() {return this.m10_mocd;}
    public void setM10_mocd(String pd10_snils) {this.m10_mocd = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    /*public CAttachMOSection[] getM11_orcl() {return this.m11_orcl;}
    public void setM11_orcl(CAttachMOSection[] pd10_snils) {this.m11_orcl = pd10_snils;}*/
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM11_dn() {return this.m11_dn;}
    public void setM11_dn(Date pd16_dn) {if(this.m11_dn == null)this.m11_dn=new Date(); this.m11_dn = pd16_dn;}
    //-----------------------------------------------------------------------------------------------------------------
}
