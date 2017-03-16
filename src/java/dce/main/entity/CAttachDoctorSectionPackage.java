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
public class CAttachDoctorSectionPackage {
    //---------------------------------------------------------------------------
    private CPackageInformation p10_packinf = new CPackageInformation();
    private String p11_mocd; /*код ЛПУ должен совпадать с SenderCode*/
    private CAttachDoctorSection p12_orcl[];
    //---------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //---------------------------------------------------------------------------
    public String getP11_mocd() {return this.p11_mocd;}
    public void setP11_mocd(String pd10_snils) {this.p11_mocd = pd10_snils;}
    //---------------------------------------------------------------------------
    public CAttachDoctorSection[] getP12_orcl() {return this.p12_orcl;}
    public void setP12_orcl(CAttachDoctorSection[] pd10_snils) {this.p12_orcl = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public CResponceAttachPackage TryAttachDoctorSectionInformation(CAttachDoctorSectionPackage pinppack)
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
    //---------------------------------------------------------------------------
}
