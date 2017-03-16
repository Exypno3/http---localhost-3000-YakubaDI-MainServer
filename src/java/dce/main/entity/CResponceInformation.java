/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//--------------------------------------------------------------------------------------------------
package dce.main.entity;

/**
 *
 * @author YaluplinMD
 */
//--------------------------------------------------------------------------------------------------
public class CResponceInformation {

    private int r10_responcecode = 2000;    
    private String ResponceMessage = CMessageUtils.GetMsgByID(2000); 
    private String PakageGUIDSrc; // GUID входного пакета на который формируем ответ
    //--------------------------------------------------------------------------------------------------
    public int getR10_responcecode() {return this.r10_responcecode;}
    public void setR10_responcecode(int pr10_responcecode) {this.r10_responcecode = pr10_responcecode;}
    //--------------------------------------------------------------------------------------------------
    public String getResponceMessage() {return this.ResponceMessage;}
    public void setResponceMessage(String pResponceMessage) {this.ResponceMessage = pResponceMessage;}
    //--------------------------------------------------------------------------------------------------
    public String getPakageGUIDSrc() {return this.PakageGUIDSrc;}
    public void setPakageGUIDSrc(String pPakageGUIDSrc) {this.PakageGUIDSrc = pPakageGUIDSrc;}
    //--------------------------------------------------------------------------------------------------
}
//--------------------------------------------------------------------------------------------------
