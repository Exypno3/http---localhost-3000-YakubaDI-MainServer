/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dce.main.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YaluplinMD
 */
@XmlRootElement(name = "responcepack")
public class CResponceAssertBedPackage 
{
    //----------------------------------------------------------------------------------------------------------------
    private CResponceOrdersPackage p10_packrespinf;
    private CRecStatusList p11_statuslist;
    //----------------------------------------------------------------------------------------------------------------
    public CResponceAssertBedPackage()
    {
        p10_packrespinf = new CResponceOrdersPackage();
        p11_statuslist = new CRecStatusList();
    }
    //----------------------------------------------------------------------------------------------------------------
    public CResponceOrdersPackage getP10_packrespinf() {return this.p10_packrespinf;}
    public void setP10_packrespinf(CResponceOrdersPackage pp10_packrespinf) {this.p10_packrespinf = pp10_packrespinf;}
    //----------------------------------------------------------------------------------------------------------------
    public CRecStatusList getP11_statuslist() {return this.p11_statuslist;}
    public void setP11_statuslist(CRecStatusList pp11_statuslist) {this.p11_statuslist = pp11_statuslist;}
    //----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------
