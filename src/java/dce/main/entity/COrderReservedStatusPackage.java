/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
//----------------------------------------------------------------------------------------------------------------
import javax.xml.bind.annotation.XmlRootElement;
//----------------------------------------------------------------------------------------------------------------
/**
 *
 * @author YaluplinMD
 */
//----------------------------------------------------------------------------------------------------------------
@XmlRootElement(name="orderpack")
public class COrderReservedStatusPackage 
{
    private CPackageInformation p10_packinf;
    private CPackGuidList p11guid_list;
    //----------------------------------------------------------------------------------------------------------------
    public COrderReservedStatusPackage()
    {
        p11guid_list = new CPackGuidList();
    }
    //----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //----------------------------------------------------------------------------------------------------------------
    public CPackGuidList getP11guid_list() {return this.p11guid_list;}
    public void setP11guid_list(CPackGuidList pp11guid_list) {this.p11guid_list = pp11guid_list;}
    //----------------------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------
