/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YaluplinMD
 */
@XmlRootElement(name="orderpack")
public class COrderLeaveHospitalPackage {
    private CPackageInformation p10_packinf;
    private COrderLeaveHospitalList p11_orderleavehospitallist;
    //-----------------------------------------------------------------------------------------------------------------
    public COrderLeaveHospitalPackage()
    {
        p11_orderleavehospitallist = new COrderLeaveHospitalList();
    }
    //-----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //-----------------------------------------------------------------------------------------------------------------
    public COrderLeaveHospitalList getP11_orderleavehospitallist() {return this.p11_orderleavehospitallist;}
    public void setP11_orderleavehospitallist(COrderLeaveHospitalList pp11_orderleavehospitallist) {this.p11_orderleavehospitallist = pp11_orderleavehospitallist;}
    //-----------------------------------------------------------------------------------------------------------------
    /*public void ParseDatesStructure(CResponceOrdersPackage _return)
    {
        LinkedList<Integer> listNzap = new LinkedList<Integer>();
        
        if(p11_orderleavehospitallist.getL10_orcl().length == 0)
        {
            p10_packinf.AddErrorToPack(_return, "107", 7);
        }
        
        LinkedList<String> ContrFL = new LinkedList<String>();
        ContrFL.add("dct");
        ContrFL.add("pfio");
        ContrFL.add("pnm");
        ContrFL.add("ps");
        ContrFL.add("pbd");
                     
        
        
        for(int i = 0; i < p11_orderleavehospitallist.getL10_orcl().length; ++i)
        {
            CheckNzap(_return, listNzap, p11_orderleavehospitallist.getL10_orcl()[i]);
            
            CheckModcd(_return, p11_orderleavehospitallist.getL10_orcl()[i]);            
                        
            p11_orderleavehospitallist.getL10_orcl()[i].getM17_pr().CheckPersonStructure(_return, p11_orderleavehospitallist.getL10_orcl()[i], 
                    ContrFL, p11_orderleavehospitallist.getL10_orcl()[i].getM17_pr());
            
            CheckKPK(_return, p11_orderleavehospitallist.getL10_orcl()[i]);
            CheckModcd(_return, p11_orderleavehospitallist.getL10_orcl()[i]);
            CheckHospDate(_return, p11_orderleavehospitallist.getL10_orcl()[i]);
            CheckLeaveDate(_return, p11_orderleavehospitallist.getL10_orcl()[i]);
            
            CheckCardNum(_return, p11_orderleavehospitallist.getL10_orcl()[i]);
            
            listNzap.add(p11_orderleavehospitallist.getL10_orcl()[i].getM10_nzap());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
     private void CheckCardNum(CResponceOrdersPackage _return, COrderLeaveHospital OrderClinic)
    {
        if(OrderClinic.getM20_crdnum() == null || OrderClinic.getM20_crdnum().length() != 5)
        {
             _return.AddErrorToRecord(OrderClinic, _return, "222", 42);
        }
    }
     //------------------------------------------------------------------------------------------------------------------------------
    private void CheckLeaveDate(CResponceOrdersPackage _return, COrderLeaveHospital OrderClinic)
    {
        if(OrderClinic.getM16_dttmlv() == null)
        {
             _return.AddErrorToRecord(OrderClinic, _return, "226", 46);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckHospDate(CResponceOrdersPackage _return, COrderLeaveHospital OrderClinic)
    {
        if(OrderClinic.getM15_dttmfh() == null)
        {
             _return.AddErrorToRecord(OrderClinic, _return, "221", 41);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckModcd(CResponceOrdersPackage _return, COrderLeaveHospital OrderClinic)
    {
        if(OrderClinic.getM14_modcd() == null || OrderClinic.getM14_modcd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "205", 25);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckKPK(CResponceOrdersPackage _return, COrderLeaveHospital OrderClinic)
    {
        if(OrderClinic.getM18_kpkcd() == null || OrderClinic.getM18_kpkcd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "218", 38);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckNzap(CResponceOrdersPackage _return, LinkedList<Integer> listNzap, COrderLeaveHospital OrderClinic)
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
//------------------------------------------------------------------------------------------------------------------------------
