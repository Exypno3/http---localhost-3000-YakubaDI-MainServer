/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Администратор
 */
@XmlRootElement(name = "orderpack")
public class CAttachMoStreetSectionPackage {
    private CPackageInformation p10_packinf = new CPackageInformation();
    private CAttachMoStreetSectionList p11_atachmoscstlist = new CAttachMoStreetSectionList();
    //---------------------------------------------------------------------------

    public CPackageInformation getP10_packinf() {
        return p10_packinf;
    }

    public void setP10_packinf(CPackageInformation p10_packinf) {
        this.p10_packinf = p10_packinf;
    }

    public CAttachMoStreetSectionList getP11_atachmoscstlist() {
        return p11_atachmoscstlist;
    }

    public void setP11_atachmoscstlist(CAttachMoStreetSectionList p11_atachmoscstlist) {
        this.p11_atachmoscstlist = p11_atachmoscstlist;
    }
    
    public CResponceAttachPackage ProcessSendAttachMoStreetSection()
    {
        CResponceAttachPackage respack = null;
        
        return respack;
    }
}
