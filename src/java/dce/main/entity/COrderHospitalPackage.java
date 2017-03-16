/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dce.main.entity;

import java.util.LinkedList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YaluplinMD
 */
@XmlRootElement(name="orderpack")
public class COrderHospitalPackage {
    
    private CPackageInformation p10_packinf;
    COrderHospitalList p11_orderhospitallist;
    //-----------------------------------------------------------------------------------------------------------------
    public COrderHospitalPackage()
    {
        p11_orderhospitallist = new COrderHospitalList();
    }
    //-----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //-----------------------------------------------------------------------------------------------------------------
    public COrderHospitalList getP11_orderhospitallist() {return this.p11_orderhospitallist;}
    public void setP11_orderhospitallist(COrderHospitalList pp11_orderhospitallist) {this.p11_orderhospitallist = pp11_orderhospitallist;}
    //-----------------------------------------------------------------------------------------------------------------
    /*public void ParseDatesStructure(CResponceOrdersPackage _return)
    {
        LinkedList<Integer> listNzap = new LinkedList<Integer>();
        LinkedList<String> listOrdersNum = new LinkedList<String>();
        
        if(p11_orderhospitallist.getL10_orcl().length == 0)
        {
            p10_packinf.AddErrorToPack(_return, "107", 7);
        }
        
        LinkedList<String> ContrFL = new LinkedList<String>();
        ContrFL.add("dct");
        ContrFL.add("dcs");
        ContrFL.add("smcd");
        ContrFL.add("trcd");
        ContrFL.add("pfio");
        ContrFL.add("pnm");
        ContrFL.add("ps");
        ContrFL.add("pbd");
        
             
        
        
        for(int i = 0; i < p11_orderhospitallist.getL10_orcl().length; ++i)
        {
            CheckNzap(_return, listNzap, p11_orderhospitallist.getL10_orcl()[i]);
            
            CheckOrnm(_return, listOrdersNum, p11_orderhospitallist.getL10_orcl()[i]);
            
            CheckOrdt(_return, p11_orderhospitallist.getL10_orcl()[i]);
            
            CheckOrtp(_return, p11_orderhospitallist.getL10_orcl()[i]);
            
            CheckMoscd(_return, p11_orderhospitallist.getL10_orcl()[i]);
            CheckModcd(_return, p11_orderhospitallist.getL10_orcl()[i]);            
                        
            p11_orderhospitallist.getL10_orcl()[i].getM17_pr().CheckPersonStructure(_return, p11_orderhospitallist.getL10_orcl()[i], 
                    ContrFL, p11_orderhospitallist.getL10_orcl()[i].getM17_pr());
            
            CheckMKBX(_return, p11_orderhospitallist.getL10_orcl()[i]);
            CheckKPK(_return, p11_orderhospitallist.getL10_orcl()[i]);
            CheckSection(_return, p11_orderhospitallist.getL10_orcl()[i]);
            CheckHospDate(_return, p11_orderhospitallist.getL10_orcl()[i]);
            
            CheckCardNum(_return, p11_orderhospitallist.getL10_orcl()[i]);
            
            listNzap.add(p11_orderhospitallist.getL10_orcl()[i].getM10_nzap());
            listOrdersNum.add(p11_orderhospitallist.getL10_orcl()[i].getM11_ornm());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
     private void CheckCardNum(CResponceOrdersPackage _return, COrderHospital OrderClinic)
    {
        if(OrderClinic.getM20_crdnum() == null || OrderClinic.getM20_crdnum().length() != 5)
        {
             _return.AddErrorToRecord(OrderClinic, _return, "222", 42);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckHospDate(CResponceOrdersPackage _return, COrderHospital OrderClinic)
    {
        if(OrderClinic.getM16_dttmfh() == null)
        {
             _return.AddErrorToRecord(OrderClinic, _return, "221", 41);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckSection(CResponceOrdersPackage _return, COrderHospital OrderClinic)
    {
        if(OrderClinic.getM19_sccd() == null || OrderClinic.getM19_sccd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "219", 39);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckKPK(CResponceOrdersPackage _return, COrderHospital OrderClinic)
    {
        if(OrderClinic.getM18_kpkcd() == null || OrderClinic.getM18_kpkcd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "218", 38);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckMKBX(CResponceOrdersPackage _return, COrderHospital OrderClinic)
    {
        if(OrderClinic.getM21_mkbcd() == null || OrderClinic.getM21_mkbcd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "217", 37);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckModcd(CResponceOrdersPackage _return, COrderHospital OrderClinic)
    {
        if(OrderClinic.getM15_modcd() == null || OrderClinic.getM15_modcd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "205", 25);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckMoscd(CResponceOrdersPackage _return, COrderHospital OrderClinic)
    {
        if(OrderClinic.getM14_moscd() == null || OrderClinic.getM14_moscd().length() != 5)
        {
            _return.AddErrorToRecord(OrderClinic, _return, "204", 24);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckOrtp(CResponceOrdersPackage _return, COrderHospital OrderClinic)
    {
        if(OrderClinic.getM13_ortp() < 1 || OrderClinic.getM13_ortp() > 2)
        {
            _return.AddErrorToRecord(OrderClinic, _return, "203", 23);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckOrdt(CResponceOrdersPackage _return, COrderHospital OrderClinic)
    {
        if(OrderClinic.getM12_ordt() == null)
        {
            _return.AddErrorToRecord(OrderClinic, _return, "202", 22);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckNzap(CResponceOrdersPackage _return, LinkedList<Integer> listNzap, COrderHospital OrderClinic)
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
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckOrnm(CResponceOrdersPackage _return, LinkedList<String> listOrdersNum, COrderHospital OrderClinic)
    {
        if(OrderClinic.getM11_ornm().trim().length()== 0 || OrderClinic.getM11_ornm().trim() == null)
        {
            _return.AddErrorToRecord(OrderClinic, _return, "200", 20);
        }
            
        for (String tmpNumOrd : listOrdersNum) 
        {
            if (tmpNumOrd == OrderClinic.getM11_ornm()) 
            {
                _return.AddErrorToRecord(OrderClinic, _return, "201", 21);
                break;
             }
        }    
        
       
    }*/
    //------------------------------------------------------------------------------------------------------------------------------
}
