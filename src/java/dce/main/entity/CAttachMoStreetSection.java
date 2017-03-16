/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;

/**
 *
 * @author Администратор
 */
class CAttachMoStreetSection {
    private String a10_mocd;
    private CAttachMoSectionStreet  a11_orcl[];

    public String getA10_mocd() {
        return a10_mocd;
    }

    public void setA10_mocd(String a10_mocd) {
        this.a10_mocd = a10_mocd;
    }

    public CAttachMoSectionStreet[] getA11_orcl() {
        return a11_orcl;
    }

    public void setA11_orcl(CAttachMoSectionStreet[] a11_orcl) {
        this.a11_orcl = a11_orcl;
    }
}
