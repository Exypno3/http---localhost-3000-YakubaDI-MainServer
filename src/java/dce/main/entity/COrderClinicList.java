/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YaluplinMD
 */
//-----------------------------------------------------------------------------------------------------------------
@XmlRootElement(name="COrderClinicList")
public class COrderClinicList 
{
    //-----------------------------------------------------------------------------------------------------------------
    private COrderClinic l10_orcl[];
    //-----------------------------------------------------------------------------------------------------------------
    public COrderClinic[] getL10_orcl() {return this.l10_orcl;}
    public void setL10_orcl(COrderClinic[] pl10_orcl) {this.l10_orcl = pl10_orcl;}
    //-----------------------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------------------------------
