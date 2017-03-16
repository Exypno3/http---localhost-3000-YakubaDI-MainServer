/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
//----------------------------------------------------------------------------------------------------------------

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YaluplinMD
 */
//----------------------------------------------------------------------------------------------------------------
@XmlRootElement(name = "responcepack")
public class CResponceReservedStatusPackage {
    //----------------------------------------------------------------------------------------------------------------
    private CResponceOrdersPackage p10_packrespinf;
    private CGuidStatusList p11_statuslist;
    //----------------------------------------------------------------------------------------------------------------
    public CResponceReservedStatusPackage()
    {
        p10_packrespinf = new CResponceOrdersPackage();
        p11_statuslist = new CGuidStatusList();
    }
    //----------------------------------------------------------------------------------------------------------------
    public CResponceOrdersPackage getP10_packrespinf() {return this.p10_packrespinf;}
    public void setP10_packrespinf(CResponceOrdersPackage pp10_packrespinf) {this.p10_packrespinf = pp10_packrespinf;}
    //----------------------------------------------------------------------------------------------------------------
    public CGuidStatusList getP11_statuslist() {return this.p11_statuslist;}
    public void setP11_statuslist(CGuidStatusList pp11_statuslist) {this.p11_statuslist = pp11_statuslist;}
    //----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------
