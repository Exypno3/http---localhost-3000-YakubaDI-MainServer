/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//----------------------------------------------------------------------------------------------
package dce.main.entity;
//----------------------------------------------------------------------------------------------

import java.util.UUID;

/**
 *
 * @author YaluplinMD
 */
//----------------------------------------------------------------------------------------------
public class CBedProfile {
    //----------------------------------------------------------------------------------------------
    private String k10_kpkcd; //профиль койки
    private int k11_cntcn;// состояло пациентов на отчетный период
    private int k12_cnten;// поступило пациентов на отчетный период
    private int k13_cntlv;// выбыло пациентов на отчетный период
    private int k14_cntpl;// планируется пациентов на отчетный период
    private int k15_cntfrmn;// свободных коек мужчины
    private int k16_cntfrwm;// свободных коек женщины
    private int k17_cntfrch;// свободных коек дети
//    private int k20_cntfrall;// свободных коек всего
    
    private CVolumeKDSMOList k18_vkdlist;

    
    private String k19_iguid = UUID.randomUUID().toString();


//    public int getK20_cntfrall() {
//        return k20_cntfrall;
//    }

//    public void setK20_cntfrall(int k20_cntfrall) {
//        this.k20_cntfrall = k20_cntfrall;
//    }

    //-----------------------------------------------------------------------------------------------------------------
    public String getK19_iguid() {return this.k19_iguid;}
    public void setK19_iguid(String pk19_iguid) {this.k19_iguid = pk19_iguid;} 
    //-----------------------------------------------------------------------------------------------------------------
    public CVolumeKDSMOList getK18_vkdlist() {return this.k18_vkdlist;}
    public void setK18_vkdlist(CVolumeKDSMOList pk18_vkdlist) {this.k18_vkdlist = pk18_vkdlist;} 
    //-----------------------------------------------------------------------------------------------------------------
    public String getK10_kpkcd() {return this.k10_kpkcd;}
    public void setK10_kpkcd(String pk10_kpkcd) {this.k10_kpkcd = pk10_kpkcd;} 
    //-----------------------------------------------------------------------------------------------------------------
    public int getK11_cntcn() {return this.k11_cntcn;}
    public void setK11_cntcn(int pk11_cntcn) {this.k11_cntcn = pk11_cntcn;} 
    //-----------------------------------------------------------------------------------------------------------------
    public int getK12_cnten() {return this.k12_cnten;}
    public void setK12_cnten(int pk12_cnten) {this.k12_cnten = pk12_cnten;} 
    //-----------------------------------------------------------------------------------------------------------------
    public int getK13_cntlv() {return this.k13_cntlv;}
    public void setK13_cntlv(int pk13_cntlv) {this.k13_cntlv = pk13_cntlv;} 
    //-----------------------------------------------------------------------------------------------------------------
    public int getK14_cntpl() {return this.k14_cntpl;}
    public void setK14_cntpl(int pk14_cntpl) {this.k14_cntpl = pk14_cntpl;} 
    //-----------------------------------------------------------------------------------------------------------------
    public int getK15_cntfrmn() {return this.k15_cntfrmn;}
    public void setK15_cntfrmn(int pk15_cntfrmn) {this.k15_cntfrmn = pk15_cntfrmn;} 
    //-----------------------------------------------------------------------------------------------------------------
    public int getK16_cntfrwm() {return this.k16_cntfrwm;}
    public void setK16_cntfrwm(int pk16_cntfrwm) {this.k16_cntfrwm = pk16_cntfrwm;} 
    //-----------------------------------------------------------------------------------------------------------------
    public int getK17_cntfrch() {return this.k17_cntfrch;}
    public void setK17_cntfrch(int pk17_cntfrch) {this.k17_cntfrch = pk17_cntfrch;} 
    //----------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------
