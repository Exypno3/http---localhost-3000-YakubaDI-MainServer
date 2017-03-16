package dce.main.entity;

import java.util.Date;
/**
 *
 * @author YaluplinMD
 */
public class COrderHospital {
    private int m10_nzap;
    
    private String m11_ornm;
    private Date m12_ordt = null;
    private int m13_ortp;
    private String m14_moscd;            //Код ЛПУ направившей на госпитализацию
    private String m15_modcd;       //Код ЛПУ где находится пациент
    private Date m16_dttmfh = null;  // Дата и время фактической госпитализации
    
    private CPerson m17_pr = new CPerson();
    
    private String m18_kpkcd;
    private String m19_sccd;
    private String m20_crdnum; // номер карты стационарного больного
    private String m21_mkbcd;   
    
    private int m22_zerr=0;
    private String m24_usok; // условия оказания мед помощи: 1 - стационарно, 2 - дневной стационар

    public String getM25_trcd() {
        return m25_trcd;
    }

    public void setM25_trcd(String m25_trcd) {
        this.m25_trcd = m25_trcd;
    }
    private String m25_trcd; // код ОКАТО

    private String z99_guid;
    
    public String getM24_usok() {
        return m24_usok;
    }

    public void setM24_usok(String m24_usok) {
        this.m24_usok = m24_usok;
    }
    
    
    //-----------------------------------------------------------------------------------------------------------------
    public String getZ99_guid() {return this.z99_guid;}
    public void setZ99_guid(String pz99_guid) {this.z99_guid = pz99_guid;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM22_zerr() {return this.m22_zerr;}
    public void setM22_zerr(int pm22_zerr) {this.m22_zerr = pm22_zerr;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM10_nzap() {return this.m10_nzap;}
    public void setM10_nzap(int pm10_nzap) {this.m10_nzap = pm10_nzap;}
    //-----------------------------------------------------------------------------------------------------------------
    public CPerson getM17_pr() {return this.m17_pr;}
    public void setM17_pr(CPerson pm17_pr) {this.m17_pr = pm17_pr;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM11_ornm() {return this.m11_ornm;}
    public void setM11_ornm(String pm11_ornm) {this.m11_ornm = pm11_ornm;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getM12_ordt() {return this.m12_ordt;}
    public void setM12_ordt(Date pm12_ordt) {if(this.m12_ordt == null)this.m12_ordt = new Date(); this.m12_ordt = pm12_ordt;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getM13_ortp() {return this.m13_ortp;}
    public void setM13_ortp(int pm13_ortp) {this.m13_ortp = pm13_ortp;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM14_moscd() {return this.m14_moscd;}
    public void setM14_moscd(String pm14_moscd) {this.m14_moscd = pm14_moscd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM15_modcd() {return this.m15_modcd;}
    public void setM15_modcd(String pm15_modcd) {this.m15_modcd = pm15_modcd;}
    //-----------------------------------------------------------------------------------------------------------------
    
    public Date getM16_dttmfh() {return this.m16_dttmfh;}
    public void setM16_dttmfh(Date pm16_dttmfh) {if(this.m16_dttmfh == null)this.m16_dttmfh = new Date(); this.m16_dttmfh = pm16_dttmfh;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM18_kpkcd() {return this.m18_kpkcd;}
    public void setM18_kpkcd(String pm18_kpkcd) {this.m18_kpkcd = pm18_kpkcd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM19_sccd() {return this.m19_sccd;}
    public void setM19_sccd(String pm19_sccd) {this.m19_sccd = pm19_sccd;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM20_crdnum() {return this.m20_crdnum;}
    public void setM20_crdnum(String pm20_crdnum) {this.m20_crdnum = pm20_crdnum;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getM21_mkbcd() {return this.m21_mkbcd;}
    public void setM21_mkbcd(String pm21_mkbcd) {this.m21_mkbcd = pm21_mkbcd;}
    //-----------------------------------------------------------------------------------------------------------------
}
