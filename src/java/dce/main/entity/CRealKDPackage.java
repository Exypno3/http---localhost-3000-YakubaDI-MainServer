/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
//-----------------------------------------------------------------------------------------------------------------

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YaluplinMD
 */
//-----------------------------------------------------------------------------------------------------------------
@XmlRootElement(name="orderpack")
public class CRealKDPackage {
    private CPackageInformation p10_packinf;
    private CPeriodInfomation p11_perinf;
    private CLpuKpkList p12_lpukpklist;
    //-------------------------------------------------------------------------------------------------------------
    public CRealKDPackage()
    {
        p11_perinf = new CPeriodInfomation();
        p12_lpukpklist = new CLpuKpkList();
    }
    //-------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //-------------------------------------------------------------------------------------------------------------
    public CPeriodInfomation getP11_perinf() {return this.p11_perinf;}
    public void setP11_perinf(CPeriodInfomation pp11_perinf) {this.p11_perinf = pp11_perinf;}
    //-------------------------------------------------------------------------------------------------------------
    public CLpuKpkList getP12_lpukpklist() {return this.p12_lpukpklist;}
    public void setP12_lpukpklist(CLpuKpkList pp12_lpukpklist) {this.p12_lpukpklist = pp12_lpukpklist;}
    //-------------------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------------------------------
