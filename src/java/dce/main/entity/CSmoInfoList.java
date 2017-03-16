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
class CSmoInfoList {
    private String smo_cd;
    private CSmoDetail  smo_st;

    public String getSmo_cd() {
        return smo_cd;
    }

    public void setSmo_cd(String smo_cd) {
        this.smo_cd = smo_cd;
    }

    public CSmoDetail getSmo_st() {
        return smo_st;
    }

    public void setSmo_st(CSmoDetail smo_st) {
        this.smo_st = smo_st;
    }
}
