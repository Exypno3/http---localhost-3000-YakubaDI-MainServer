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
public class CDeAttachPersonPackage {
    //---------------------------------------------------------------------------
    private CPackageInformation p10_packinf = new CPackageInformation();
    private CDeAttachList p11_deatachlist = new CDeAttachList();
    //---------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //---------------------------------------------------------------------------
    public CDeAttachList getP11_deatachlist() {return this.p11_deatachlist;}
    public void setP11_deatachlist(CDeAttachList pp11_atachinfo) {this.p11_deatachlist = pp11_atachinfo;}
    //---------------------------------------------------------------------------
    public CResponceAttachPackage TryDeAttachAction()
    {
        CResponceAttachPackage respack = null;
        
        try
        {
            respack = p10_packinf.ParseAttachPackage(this, 0, 0);
            
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
