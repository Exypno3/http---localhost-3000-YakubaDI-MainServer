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
@XmlRootElement(name="orderpack")
public class CKDInformationPackage {
    private CPackageInformation p10_packinf;
    private CKDInformationList p11_kdInformationlist;
    //-----------------------------------------------------------------------------------------------------------------
    public CKDInformationPackage()
    {
        p11_kdInformationlist = new CKDInformationList();
    }
    //-----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //-----------------------------------------------------------------------------------------------------------------
    public CKDInformationList getP11_kdInformationlist() {return this.p11_kdInformationlist;}
    public void setP11_kdInformationlist(CKDInformationList pp11_kdInformationlist) {this.p11_kdInformationlist = pp11_kdInformationlist;}
    //-----------------------------------------------------------------------------------------------------------------
}
