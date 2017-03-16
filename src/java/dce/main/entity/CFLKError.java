/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//----------------------------------------------------------------------------------------------------------------
package dce.main.entity;

import java.util.UUID;

/**
 *
 * @author YaluplinMD
 */
//----------------------------------------------------------------------------------------------------------------
public class CFLKError {
    private int e10_ecd;
    private String e11_ems;
    private String e12_iguid = UUID.randomUUID().toString();
    //----------------------------------------------------------------------------------------------------------------
    public String getE12_iguid() {return this.e12_iguid;}
    public void setE12_iguid(String pe12_iguid) {this.e12_iguid = pe12_iguid;}
    //----------------------------------------------------------------------------------------------------------------
    public int getE10_ecd() {return this.e10_ecd;}
    public void setE10_ecd(int pe10_ecd) {this.e10_ecd = pe10_ecd;}
    //----------------------------------------------------------------------------------------------------------------
    public String getE11_ems() {return this.e11_ems;}
    public void setE11_ems(String pe11_ems) {this.e11_ems = pe11_ems;}
    //----------------------------------------------------------------------------------------------------------------
    public CFLKError(){}
    //----------------------------------------------------------------------------------------------------------------
    public CFLKError(int re10_ecd, String re11_ems)
    {
        e10_ecd = re10_ecd;
        e11_ems = re11_ems;
    }
    //----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------
