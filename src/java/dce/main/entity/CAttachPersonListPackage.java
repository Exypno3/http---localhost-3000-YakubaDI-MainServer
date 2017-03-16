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
//---------------------------------------------------------------------------
@XmlRootElement(name = "orderpack")
//---------------------------------------------------------------------------
public class CAttachPersonListPackage {
    private CPackageInformation p10_packinf = new CPackageInformation();
    private int p11_nid;
    private int p12_all;

    public int getP12_all() {
        return p12_all;
    }

    public void setP12_all(int p12_all) {
        this.p12_all = p12_all;
    }
    private CAttachPersonList p12_alist = new CAttachPersonList();
    //---------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //---------------------------------------------------------------------------
    public CAttachPersonList getP12_alist() {return this.p12_alist;}
    public void setP12_alist(CAttachPersonList pp11_atachinfo) {this.p12_alist = pp11_atachinfo;}
    //---------------------------------------------------------------------------
    public int getP11_nid() {return this.p11_nid;}
    public void setP11_nid(int pd10_snils) {this.p11_nid = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
}
//---------------------------------------------------------------------------
