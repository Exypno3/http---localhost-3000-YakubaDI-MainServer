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
public class CResponceAttachPackage {
    private CResponceOrdersPackage p10_packrespinf = new CResponceOrdersPackage();
    private CAttachList p11_atachlist = new CAttachList();
    //----------------------------------------------------------------------------------------------------------------
    public CResponceOrdersPackage getP10_packrespinf() {return this.p10_packrespinf;}
    public void setP10_packrespinf(CResponceOrdersPackage pp10_packrespinf) {this.p10_packrespinf = pp10_packrespinf;}
    //----------------------------------------------------------------------------------------------------------------
    public CAttachList getP11_atachlist() {return this.p11_atachlist;}
    public void setP11_atachlist(CAttachList pp11_atachinfo) {this.p11_atachlist = pp11_atachinfo;}
    //----------------------------------------------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------