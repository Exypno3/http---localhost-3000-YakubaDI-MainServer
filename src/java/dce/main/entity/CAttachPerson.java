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
public class CAttachPerson {
    private String a01; /*фамилия*/
    private String a02; /*имя*/
    private String a03; /*отчество*/
    private Date a04 = null; /*дата рождения*/
    private String a05; /*серия полиса*/
    private String a06; /*№ полиса*/
    private String a07; /*тип полиса*/
    private String a08; /*енп*/
    private CAttachMO[] a09;    /*данные об участках и врачах*/
    private String a10; /*пол*/
    private int a11; /*pid*/
    private String a12_r;// RNNAME;
    private String a13_c;//CITY;
    private String a14_n;//NP;
    private String a15_u;//UL;
    private String a16_d;//DOM;
    private String a17_k;//KOR;
    private String a18_k;//KV;
    private String a19_pr;//PRNNAME;
    private String a20_pc;//PCITY;
    private String a21_pn;//PNP;
    private String a22_pu;//PUL;
    private String a23_pd;//PDOM;
    private String a24_pk;//PKOR;
    private String a25_pk;//PKV;
    private int a26_hp;//кто прекрепил 1 - ТФОМС
    private String a27; //phone
    private String a28; //серия удл
    private String a29; //№ удл
    private String a30; //тип удл
    private String a31; //СНИЛС
    private String a32; //СМО
    private Date a33 = null; /*дата смерти*/
    
    public String getA32() {
        return a32;
    }

    public void setA32(String a32) {
        this.a32 = a32;
    }
    
    public String getA27() {
        return a27;
    }

    public void setA27(String a27) {
        this.a27 = a27;
    }

    public String getA28() {
        return a28;
    }

    public void setA28(String a28) {
        this.a28 = a28;
    }

    public String getA29() {
        return a29;
    }

    public void setA29(String a29) {
        this.a29 = a29;
    }

    public String getA30() {
        return a30;
    }

    public void setA30(String a30) {
        this.a30 = a30;
    }

    public String getA31() {
        return a31;
    }

    public void setA31(String a31) {
        this.a31 = a31;
    }

    public int getA26_hp() {
        return a26_hp;
    }

    public void setA26_hp(int a26_hp) {
        this.a26_hp = a26_hp;
    }
    //-------------------------------------------------------------------------
    public String getA12_r() {
        return a12_r;
    }

    public void setA12_r(String a12_r) {
        this.a12_r = a12_r;
    }

    public String getA13_c() {
        return a13_c;
    }

    public void setA13_c(String a13_c) {
        this.a13_c = a13_c;
    }

    public String getA14_n() {
        return a14_n;
    }

    public void setA14_n(String a14_n) {
        this.a14_n = a14_n;
    }

    public String getA15_u() {
        return a15_u;
    }

    public void setA15_u(String a15_u) {
        this.a15_u = a15_u;
    }

    public String getA16_d() {
        return a16_d;
    }

    public void setA16_d(String a16_d) {
        this.a16_d = a16_d;
    }

    public String getA17_k() {
        return a17_k;
    }

    public void setA17_k(String a17_k) {
        this.a17_k = a17_k;
    }

    public String getA18_k() {
        return a18_k;
    }

    public void setA18_k(String a18_k) {
        this.a18_k = a18_k;
    }

    public String getA19_pr() {
        return a19_pr;
    }

    public void setA19_pr(String a19_pr) {
        this.a19_pr = a19_pr;
    }

    public String getA20_pc() {
        return a20_pc;
    }

    public void setA20_pc(String a20_pc) {
        this.a20_pc = a20_pc;
    }

    public String getA21_pn() {
        return a21_pn;
    }

    public void setA21_pn(String a21_pn) {
        this.a21_pn = a21_pn;
    }

    public String getA22_pu() {
        return a22_pu;
    }

    public void setA22_pu(String a22_pu) {
        this.a22_pu = a22_pu;
    }

    public String getA23_pd() {
        return a23_pd;
    }

    public void setA23_pd(String a23_pd) {
        this.a23_pd = a23_pd;
    }

    public String getA24_pk() {
        return a24_pk;
    }

    public void setA24_pk(String a24_pk) {
        this.a24_pk = a24_pk;
    }

    public String getA25_pk() {
        return a25_pk;
    }

    public void setA25_pk(String a25_pk) {
        this.a25_pk = a25_pk;
    }
    //--------------------------------------------------------------------------------
    public int getA11() {
        return a11;
    }
    //--------------------------------------------------------------------------------
    public void setA11(int a11) {
        this.a11 = a11;
    }
    //--------------------------------------------------------------------------------
    public String getA01() {return this.a01;}
    public void setA01(String pd10_snils) {this.a01 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public String getA02() {return this.a02;}
    public void setA02(String pd10_snils) {this.a02 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public String getA03() {return this.a03;}
    public void setA03(String pd10_snils) {this.a03 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public Date getA04() {return this.a04;}
    public void setA04(Date pd10_snils) {if(this.a04 == null)this.a04=new java.util.Date(); this.a04 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public Date getA33() {return this.a33;}
    public void setA33(Date pd10_snils) {if(this.a33 == null)this.a33=new java.util.Date(); this.a33 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public String getA05() {return this.a05;}
    public void setA05(String pd10_snils) {this.a05 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public String getA06() {return this.a06;}
    public void setA06(String pd10_snils) {this.a06 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public String getA07() {return this.a07;}
    public void setA07(String pd10_snils) {this.a07 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public String getA08() {return this.a08;}
    public void setA08(String pd10_snils) {this.a08 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public CAttachMO[] getA09() {return this.a09;}
    public void setA09(CAttachMO[] pd10_snils) {this.a09 = pd10_snils;}
    //--------------------------------------------------------------------------------
    public String getA10() {return this.a10;}
    public void setA10(String pd10_snils) {this.a10 = pd10_snils;}
    //--------------------------------------------------------------------------------
}
//--------------------------------------------------------------------------------
