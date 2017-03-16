/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;
//---------------------------------------------------------------------------
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "orderpack")
public class CAttachDoctorPackage {
    private CPackageInformation p10_packinf = new CPackageInformation();
    private CDoctorList p11_doclist = new CDoctorList(); /*список врачей*/
    //---------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //---------------------------------------------------------------------------
    public CDoctorList getP11_doclist() {return this.p11_doclist;}
    public void setP11_doclist(CDoctorList pp11_doclist) {this.p11_doclist = pp11_doclist;}
    //-----------------------------------------------------------------------------------------------------------------
    public CResponceAttachPackage TryAttachDoctorInformation(CAttachDoctorPackage pinppack)
    {
        return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1012, p10_packinf.getP12_pakageguid());
        
        /*CResponceAttachPackage respack = null;
        try
        {
            respack = p10_packinf.ParseAttachPackage(pinppack, 0);
            
            if(respack.getP10_packrespinf().getR11_rsinf().getR10_responcecode() == 1000 || respack.getP10_packrespinf().getR11_rsinf().getR10_responcecode() == 1001)
            {
                //respack.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1004));
                return respack;
            }
        
        }
        catch(Exception e){return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1004, p10_packinf.getP12_pakageguid());}
        
        return respack;*/
    }
    //---------------------------------------------------------------------------
}
//---------------------------------------------------------------------------
