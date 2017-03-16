//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
//-----------------------------------------------------------------------------------------------------------------
import java.util.Date;
//-----------------------------------------------------------------------------------------------------------------
public class CDoctor {
    private int d10_nzap;
    private String d11_snils;
    //private CAttachMODoctorList d12_lstmo = new CAttachMODoctorList(); /*список ЛПУ где трудится врач, с деталиацией по участкам*/
    private CAttachMODoctor d12_orcl[];/*список ЛПУ где трудится врач*/
    private String d13_sr; /*фамилия*/
    private String d14_nm; /*имя*/
    private String d15_ln; /*отчество*/
    private Date d16_br = null; /*дата рождения*/
    private Date d17_dn = null; /*дата начала действия*/
    private int d18_drg; /*тип врача 1- врач, 2 - средний мед персонал*/
    //-----------------------------------------------------------------------------------------------------------------
    public int getD10_nzap() {return this.d10_nzap;}
    public void setD10_nzap(int pd10_snils) {this.d10_nzap = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getD11_snils() {return this.d11_snils;}
    public void setD11_snils(String pd10_snils) {this.d11_snils = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    /*public CAttachMODoctorList getD12_lstmo() {return this.d12_lstmo;}
    public void setD12_lstmo(CAttachMODoctorList pd11_mo) {this.d12_lstmo = pd11_mo;}*/
    public CAttachMODoctor[] getD12_orcl() {return this.d12_orcl;}
    public void setD12_orcl(CAttachMODoctor[] pd10_snils) {this.d12_orcl = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getD13_sr() {return this.d13_sr;}
    public void setD13_sr(String pd12_sr) {this.d13_sr = pd12_sr;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getD14_nm() {return this.d14_nm;}
    public void setD14_nm(String pd13_nm) {this.d14_nm = pd13_nm;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getD15_ln() {return this.d15_ln;}
    public void setD15_ln(String pd14_ln) {this.d15_ln = pd14_ln;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getD16_br() {return this.d16_br;}
    public void setD16_br(Date pd15_br) {if(this.d16_br == null)this.d16_br=new Date(); this.d16_br = pd15_br;}
    //-----------------------------------------------------------------------------------------------------------------
    public Date getD17_dn() {return this.d17_dn;}
    public void setD17_dn(Date pd16_dn) {if(this.d17_dn == null)this.d17_dn=new Date(); this.d17_dn = pd16_dn;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getD18_drg() {return this.d18_drg;}
    public void setD18_drg(int pd17_drg) {this.d18_drg = pd17_drg;}
    //-----------------------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------------------------------
