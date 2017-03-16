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
class CAttachMoSectionStreet {
    private String c10_sect;
    private CAttachSectionStreet c11_orcl[];

    public String getC10_sect() {
        return c10_sect;
    }

    public void setC10_sect(String c10_sect) {
        this.c10_sect = c10_sect;
    }

    public CAttachSectionStreet[] getC11_orcl() {
        return c11_orcl;
    }

    public void setC11_orcl(CAttachSectionStreet[] c11_orcl) {
        this.c11_orcl = c11_orcl;
    }
}
