/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;

import java.util.Date;

/**
 *
 * @author Администратор
 */
public class CAttachMO {
    private Date i1 = null; /*дата прикрепления*/
    private String i2; /*СНИЛС врача*/
    private String i3; /*участок врача*/
    private String i4; /*код МО*/
    private int i5; //тип прикрепления
    //--------------------------------------------------------------------------------
    public int getI5() {return i5;}
    public void setI5(int i5) {this.i5 = i5;}
    //--------------------------------------------------------------------------------
    public Date getI1() {return this.i1;}
    public void setI1(Date pd10_snils) {if(this.i1 == null)this.i1=new java.util.Date(); this.i1 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public String getI2() {return this.i2;}
    public void setI2(String pd10_snils) {this.i2 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public String getI3() {return this.i3;}
    public void setI3(String pd10_snils) {this.i3 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public String getI4() {return this.i4;}
    public void setI4(String pd10_snils) {this.i4 = pd10_snils;}
    //--------------------------------------------------------------------------------
}
