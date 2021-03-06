package dce.main.entity;
//-----------------------------------------------------------------------------------------------------------------
import java.util.Date;
//-----------------------------------------------------------------------------------------------------------------
public class CAttachInfo {
    private Date a10_aad = null; /*attach date*/
    private String a11_snisl; 
    private String a12_sect; 
    private int a13_attp; /* тип прикрепления 1 - первичное, 2 - по заявлению*/
    private int a14_pr; /*1 - по перезду*/
    private int a15_profile;
    //-----------------------------------------------------------------------------------------------------------------
    public int getA14_pr() {return a14_pr;}
    public void setA14_pr(int a14_pr) {this.a14_pr = a14_pr;}    
    //-----------------------------------------------------------------------------------------------------------------
    public Date getA10_aad() {return this.a10_aad;}
    public void setA10_aad(Date pa12_aad) {if(this.a10_aad == null)this.a10_aad=new Date(); this.a10_aad = pa12_aad;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA11_snisl() {return this.a11_snisl;}
    public void setA11_snisl(String pd10_snils) {this.a11_snisl = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getA12_sect() {return this.a12_sect;}
    public void setA12_sect(String pd10_snils) {this.a12_sect = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public int getA13_attp() {return this.a13_attp;}
    public void setA13_attp(int pa15_attp) {this.a13_attp = pa15_attp;}
    //-----------------------------------------------------------------------------------------------------------------
	public int getA15_profile() {
		return a15_profile;
	}
	public void setA15_profile(int a15_profile) {
		this.a15_profile = a15_profile;
	}
}
//-----------------------------------------------------------------------------------------------------------------
