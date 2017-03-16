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
public class CAttachInformationPackage {
    private CPackageInformation p10_packinf = new CPackageInformation();
    private CPerson p11_pr = new CPerson();
    //-----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //-----------------------------------------------------------------------------------------------------------------
    public CPerson getP11_pr() {return this.p11_pr;}
    public void setP11_pr(CPerson pp11_pr) {this.p11_pr = pp11_pr;}
    //-----------------------------------------------------------------------------------------------------------------
    public CResponceAttachPackage TryGetPrikInformation(CAttachInformationPackage pinppack)
    {
        CResponceAttachPackage respack = null;
        
        try
        {
            respack = p10_packinf.ParseAttachPackage(pinppack, 0, 0);
            
            if(respack.getP10_packrespinf().getR11_rsinf().getR10_responcecode() == 1000 || respack.getP10_packrespinf().getR11_rsinf().getR10_responcecode() == 1001)
            {
                //respack.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1004));
                return respack;
            }
        
        }
        catch(Exception e){return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1004, p10_packinf.getP12_pakageguid());}
        
        return respack;
    }
    //-----------------------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------------------------------
