/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;

import java.util.Date;

/**
 *
 * @author Администратор
 */
//---------------------------------------------------------------------------
public class CAttachCommonPackage {
    //---------------------------------------------------------------------------
    private CPackageInformation p10_packinf = new CPackageInformation();
    private String p11_docsnisl;
    private String p12_docsnisl_new;
    private String p13_section;
    private String p14_section_new;
    private String p15_mocode;
    private String p16_mocode_new;
    private Date p17_aad = null; /*дата прикрепления*/
    private Date p18_add = null; /*дата открепления*/
    //---------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //---------------------------------------------------------------------------
    public Date getP17_aad() {return this.p17_aad;}
    public void setP17_aad(Date pd15_br) {if(this.p17_aad == null)this.p17_aad=new Date(); this.p17_aad = pd15_br;}
    //---------------------------------------------------------------------------
    public Date getP18_add() {return this.p18_add;}
    public void setP18_add(Date pd15_br) {if(this.p18_add == null)this.p18_add=new Date(); this.p18_add = pd15_br;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getP11_docsnisl() {return this.p11_docsnisl;}
    public void setP11_docsnisl(String pa22_pn) {this.p11_docsnisl = pa22_pn;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getP12_docsnisl_new() {return this.p12_docsnisl_new;}
    public void setP12_docsnisl_new(String pa22_pn) {this.p12_docsnisl_new = pa22_pn;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getP13_section() {return this.p13_section;}
    public void setP13_section(String pa22_pn) {this.p13_section = pa22_pn;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getP14_section_new() {return this.p14_section_new;}
    public void setP14_section_new(String pa22_pn) {this.p14_section_new = pa22_pn;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getP15_mocode() {return this.p15_mocode;}
    public void setP15_mocode(String pa22_pn) {this.p15_mocode = pa22_pn;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getP16_mocode_new() {return this.p16_mocode_new;}
    public void setP16_mocode_new(String pa22_pn) {this.p16_mocode_new = pa22_pn;}
    //---------------------------------------------------------------------------
    public CResponceAttachPackage MakeCommonAction(int ProcTP)
    {
        CResponceAttachPackage respack = null;
        
        try
        {
            respack = p10_packinf.ParseAttachPackage(this, ProcTP, 0);
            
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
