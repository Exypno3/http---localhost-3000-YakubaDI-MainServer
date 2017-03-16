//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
//-----------------------------------------------------------------------------------------------------------------
public class CAttach {
    private int p10_nzap;
    /* @XmlElement(nillable=true, required=true)*/
    private String p11_mocd; /*код ЛПУ должен совпадать с SenderCode*/
    private CPerson p12_pr = new CPerson();
    private CAttachInfo[] p13_orcl;
    //-----------------------------------------------------------------------------------------------------------------
    public int getP10_nzap() {return this.p10_nzap;}
    public void setP10_nzap(int pd10_snils) {this.p10_nzap = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public CPerson getP12_pr() {return this.p12_pr;}
    public void setP12_pr(CPerson pp11_pr) {this.p12_pr = pp11_pr;}
    //-----------------------------------------------------------------------------------------------------------------
    public String getP11_mocd() {return this.p11_mocd;}
    public void setP11_mocd(String pd10_snils) {this.p11_mocd = pd10_snils;}
    //-----------------------------------------------------------------------------------------------------------------
    public CAttachInfo[] getP13_orcl() {return this.p13_orcl;}
    public void setP13_orcl(CAttachInfo[] pp12_ai) {this.p13_orcl = pp12_ai;}
    //-----------------------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------------------------------
