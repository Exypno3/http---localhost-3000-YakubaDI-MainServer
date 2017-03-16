/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lena
 */
@XmlRootElement(name = "orderpack")
public class CAttachPersonPackage {
    //---------------------------------------------------------------------------
    private CPackageInformation p10_packinf = new CPackageInformation();
    private CAttachList p11_atachlist = new CAttachList();
    //---------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //---------------------------------------------------------------------------
    public CAttachList getP11_atachlist() {return this.p11_atachlist;}
    public void setP11_atachlist(CAttachList pp11_atachinfo) {this.p11_atachlist = pp11_atachinfo;}
    //---------------------------------------------------------------------------
    public CResponceAttachPackage TryAttachAction(int lPackType)
    {
        CResponceAttachPackage respack = null;
        
        try
        {
            respack = p10_packinf.ParseAttachPackage(this, 0, lPackType);
            
            if(respack.getP10_packrespinf().getR11_rsinf().getR10_responcecode() == 1000 || respack.getP10_packrespinf().getR11_rsinf().getR10_responcecode() == 1001)
            {
                //respack.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1004));
                return respack;
            }
        
        }
        catch(Exception e){return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1004, p10_packinf.getP12_pakageguid());}
        
        return respack;
    }
    //---------------------------------------------------------------------------
}
//---------------------------------------------------------------------------
