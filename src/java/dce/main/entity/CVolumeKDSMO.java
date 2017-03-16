/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dce.main.entity;

import java.util.UUID;

/**
 *
 * @author YaluplinMD
 */
public class CVolumeKDSMO {
    private int k10_vtp; // Тип объема
    private String k11_smcd; // код СМО
    private int k12_vkd;  // Кол-во едениц объема
    private String k13_iguid = UUID.randomUUID().toString();
    //-----------------------------------------------------------------------------------------------------------------
    public String getK13_iguid() {return this.k13_iguid;}
    public void setK13_iguid(String pk13_iguid) {this.k13_iguid = pk13_iguid;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getK10_vtp() {return this.k10_vtp;}
    public void setK10_vtp(int pk10_vtp) {this.k10_vtp = pk10_vtp;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getK12_vkd() {return this.k12_vkd;}
    public void setK12_vkd(int pk12_vkd) {this.k12_vkd = pk12_vkd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getK11_smcd() {return this.k11_smcd;}
    public void setK11_smcd(String pk11_smcd) {this.k11_smcd = pk11_smcd;}
    //-----------------------------------------------------------------------------------------------------------------
}
