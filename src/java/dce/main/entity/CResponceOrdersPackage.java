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
public class CResponceOrdersPackage {
    private CPackageInformation r10_packinf; // package info
    private CResponceInformation r11_rsinf;
    private COrdersErrorList r12_orerl;
    //--------------------------------------------------------------------------------------------------
    public CResponceOrdersPackage()
    {
        r12_orerl = new COrdersErrorList();
        r10_packinf = new CPackageInformation();
        r11_rsinf = new CResponceInformation();
    }
    //--------------------------------------------------------------------------------------------------
    public CPackageInformation getR10_packinf() {return this.r10_packinf;}
    public void setR10_packinf(CPackageInformation pr10_packinf) {this.r10_packinf = pr10_packinf;}
    //--------------------------------------------------------------------------------------------------
    public CResponceInformation getR11_rsinf() {return this.r11_rsinf;}
    public void setR11_rsinf(CResponceInformation pr11_rsinf) {this.r11_rsinf = pr11_rsinf;}
    //--------------------------------------------------------------------------------------------------
    public COrdersErrorList getR12_orerl() {return this.r12_orerl;}
    public void setR12_orerl(COrdersErrorList pr12_orerl) {this.r12_orerl = pr12_orerl;}
    //--------------------------------------------------------------------------------------------------
    public void AddErrorToRecordByNzap(int pn_zap, CResponceOrdersPackage _return, int code, String Errmsg)
    {
        _return.getR12_orerl().AddErrorToList(pn_zap, new CFLKError(code, Errmsg));
    }
    //--------------------------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------------------------------
}
