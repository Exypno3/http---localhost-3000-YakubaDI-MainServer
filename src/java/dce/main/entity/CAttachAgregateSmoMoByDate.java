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
@XmlRootElement(name = "rep_pack")
public class CAttachAgregateSmoMoByDate {
    private CMoSmoList l10_orcl[];

    public CMoSmoList[] getL10_orcl() {
        return l10_orcl;
    }

    public void setL10_orcl(CMoSmoList[] l10_orcl) {
        this.l10_orcl = l10_orcl;
    }
}
