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
//@XmlRootElement(name="orderpack")
public class CDeAttachList {
    //-----------------------------------------------------------------------------------------------------------------
    private CDeAttach l10_orcl[];
    //-----------------------------------------------------------------------------------------------------------------
    public CDeAttach[] getL10_orcl() {return this.l10_orcl;}
    public void setL10_orcl(CDeAttach[] pl10_orcl) {this.l10_orcl = pl10_orcl;}
    //-----------------------------------------------------------------------------------------------------------------
}
