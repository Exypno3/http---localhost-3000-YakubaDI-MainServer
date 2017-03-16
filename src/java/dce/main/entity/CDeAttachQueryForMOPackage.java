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
@XmlRootElement(name="orderpack")
public class CDeAttachQueryForMOPackage {
    private CPackageInformation p10_packinf = new CPackageInformation();
    private CDeAttachQueryForMOList p11_list = new CDeAttachQueryForMOList();

    public CPackageInformation getP10_packinf() {
        return p10_packinf;
    }

    public void setP10_packinf(CPackageInformation p10_packinf) {
        this.p10_packinf = p10_packinf;
    }

    public CDeAttachQueryForMOList getP11_list() {
        return p11_list;
    }

    public void setP11_list(CDeAttachQueryForMOList p11_list) {
        this.p11_list = p11_list;
    }
    //-------------------------------------------------------------------------
    public CResponceAttachPackage LoadListToDB()
    {
        CResponceAttachPackage respack = null;
        
        try
        {
            respack = p10_packinf.ParseAttachPackage(this, 0, 0);
            
            if(respack.getP10_packrespinf().getR11_rsinf().getR10_responcecode() == 1000 || respack.getP10_packrespinf().getR11_rsinf().getR10_responcecode() == 1001)
            {
                return respack;
            }
        
        }
        catch(Exception e){return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1004, p10_packinf.getP12_pakageguid());}
        
        return respack;
    }
}
