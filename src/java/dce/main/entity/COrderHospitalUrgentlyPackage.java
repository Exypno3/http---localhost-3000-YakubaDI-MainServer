/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;

import java.util.LinkedList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YaluplinMD
 */
//-----------------------------------------------------------------------------------------------------------------
@XmlRootElement(name="orderpack")
public class COrderHospitalUrgentlyPackage {
    private CPackageInformation p10_packinf;
    COrderHospitalUrgentlyList p11_orderhospitalurgentlylist;
    //-----------------------------------------------------------------------------------------------------------------
    public COrderHospitalUrgentlyPackage()
    {
        p11_orderhospitalurgentlylist = new COrderHospitalUrgentlyList();
    }
    //-----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //-----------------------------------------------------------------------------------------------------------------
    public COrderHospitalUrgentlyList getP11_orderhospitalurgentlylist() {return this.p11_orderhospitalurgentlylist;}
    public void setP11_orderhospitalurgentlylist(COrderHospitalUrgentlyList pp11_orderhospitalurgentlylist) {this.p11_orderhospitalurgentlylist = pp11_orderhospitalurgentlylist;}
    //-----------------------------------------------------------------------------------------------------------------
    /*public void ParseDatesStructure(CResponceOrdersPackage _return)
    {
        LinkedList<Integer> listNzap = new LinkedList<Integer>();
        
        if(p11_orderhospitalurgentlylist.getL10_orcl().length == 0)
        {
            p10_packinf.AddErrorToPack(_return, "107", 7);
        }
        
        LinkedList<String> ContrFL = new LinkedList<String>();
        ContrFL.add("dct");
        ContrFL.add("pfio");
        ContrFL.add("pnm");
        ContrFL.add("ps");
        ContrFL.add("pbd");
        
        
        
        
        
        for(int i = 0; i < p11_orderhospitalurgentlylist.getL10_orcl().length; ++i)
        {
            CheckNzap(_return, listNzap, p11_orderhospitalurgentlylist.getL10_orcl()[i]);
            
            CheckModcd(_return, p11_orderhospitalurgentlylist.getL10_orcl()[i]);            
                        
            p11_orderhospitalurgentlylist.getL10_orcl()[i].getM13_pr().CheckPersonStructure(_return, p11_orderhospitalurgentlylist.getL10_orcl()[i], 
                    ContrFL, p11_orderhospitalurgentlylist.getL10_orcl()[i].getM13_pr());
            
            CheckMKBX(_return, p11_orderhospitalurgentlylist.getL10_orcl()[i]);
            CheckKPK(_return, p11_orderhospitalurgentlylist.getL10_orcl()[i]);
            CheckSection(_return, p11_orderhospitalurgentlylist.getL10_orcl()[i]);
            CheckHospDate(_return, p11_orderhospitalurgentlylist.getL10_orcl()[i]);
            
            CheckCardNum(_return, p11_orderhospitalurgentlylist.getL10_orcl()[i]);
            
            listNzap.add(p11_orderhospitalurgentlylist.getL10_orcl()[i].getM10_nzap());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
     private void CheckCardNum(CResponceOrdersPackage _return, COrderHospitalUrgently OrderClinic)
    {
        if(OrderClinic.getM16_crdnum() == null || OrderClinic.getM16_crdnum().length() != 5)
        {
             _return.AddErrorToRecord(OrderClinic, _return, "222", 42);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckHospDate(CResponceOrdersPackage _return, COrderHospitalUrgently OrderClinic)
    {
        if(OrderClinic.getM12_dttmfh() == null)
        {
             _return.AddErrorToRecord(OrderClinic, _return, "221", 41);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckSection(CResponceOrdersPackage _return, COrderHospitalUrgently OrderClinic)
    {
        if(OrderClinic.getM15_sccd() == null || OrderClinic.getM15_sccd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "219", 39);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckKPK(CResponceOrdersPackage _return, COrderHospitalUrgently OrderClinic)
    {
        if(OrderClinic.getM14_kpkcd() == null || OrderClinic.getM14_kpkcd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "218", 38);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckMKBX(CResponceOrdersPackage _return, COrderHospitalUrgently OrderClinic)
    {
        if(OrderClinic.getM17_mkbcd() == null || OrderClinic.getM17_mkbcd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "217", 37);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckModcd(CResponceOrdersPackage _return, COrderHospitalUrgently OrderClinic)
    {
        if(OrderClinic.getM11_modcd() == null || OrderClinic.getM11_modcd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "205", 25);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckNzap(CResponceOrdersPackage _return, LinkedList<Integer> listNzap, COrderHospitalUrgently OrderClinic)
    {
        if(OrderClinic.getM10_nzap() <= 0)
        {
            p10_packinf.PassValTrueIsGloballPackageError();
            _return.AddErrorToRecord(OrderClinic, _return, "105", 5);
        }
            
        for (int tmpNzar : listNzap) 
        {
            if (tmpNzar == OrderClinic.getM10_nzap()) 
            {
                p10_packinf.PassValTrueIsGloballPackageError();
                _return.AddErrorToRecord(OrderClinic, _return, "104", 4);
                break;
            }
        }
    }*/
    //------------------------------------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------------------------------
