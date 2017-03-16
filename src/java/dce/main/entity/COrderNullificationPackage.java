/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
//-----------------------------------------------------------------------------------------------------------------

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YaluplinMD
 */
//-----------------------------------------------------------------------------------------------------------------
@XmlRootElement(name="orderpack")
public class COrderNullificationPackage {
    private CPackageInformation p10_packinf;
    COrderNullificationList p11_ordernullificationlist;
    //-----------------------------------------------------------------------------------------------------------------
    public COrderNullificationPackage()
    {
        p11_ordernullificationlist = new COrderNullificationList();
    }
    //-----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //-----------------------------------------------------------------------------------------------------------------
    public COrderNullificationList getP11_ordernullificationlist() {return this.p11_ordernullificationlist;}
    public void setP11_ordernullificationlist(COrderNullificationList pp11_ordernullificationlist) {this.p11_ordernullificationlist = pp11_ordernullificationlist;}
    //-----------------------------------------------------------------------------------------------------------------
    /*public void ParseDatesStructure(CResponceOrdersPackage _return)
    {
        LinkedList<Integer> listNzap = new LinkedList<Integer>();
        LinkedList<String> listOrdersNum = new LinkedList<String>();
        
        if(p11_ordernullificationlist.getL10_orcl().length == 0)
        {
            p10_packinf.AddErrorToPack(_return, "107", 7);
        }
                
              
        
        
        for(int i = 0; i < p11_ordernullificationlist.getL10_orcl().length; ++i)
        {
            CheckNzap(_return, listNzap, p11_ordernullificationlist.getL10_orcl()[i]);
            
            CheckOrnm(_return, listOrdersNum, p11_ordernullificationlist.getL10_orcl()[i]);
            
            CheckOrdt(_return, p11_ordernullificationlist.getL10_orcl()[i]);
            
            CheckNullSourseOrdt(_return, p11_ordernullificationlist.getL10_orcl()[i]);
            CheckNullSourseSenderOrdt(_return, p11_ordernullificationlist.getL10_orcl()[i]);
            CheckNullReasonOrdt(_return, p11_ordernullificationlist.getL10_orcl()[i]);
            
            listNzap.add(p11_ordernullificationlist.getL10_orcl()[i].getM10_nzap());
            listOrdersNum.add(p11_ordernullificationlist.getL10_orcl()[i].getM11_ornm());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckNullReasonOrdt(CResponceOrdersPackage _return, COrderNullification OrderClinic)
    {
        if(OrderClinic.getM15_ornrcd() == 0) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "225", 45);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckNullSourseSenderOrdt(CResponceOrdersPackage _return, COrderNullification OrderClinic)
    {
        if(OrderClinic.getM14_ornscd() == null || OrderClinic.getM14_ornscd().length() == 0) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "224", 44);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckNullSourseOrdt(CResponceOrdersPackage _return, COrderNullification OrderClinic)
    {
        if(OrderClinic.getM13_orstp() == 0) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "223", 43);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckOrdt(CResponceOrdersPackage _return, COrderNullification OrderClinic)
    {
        if(OrderClinic.getM12_ordt() == null)
        {
            _return.AddErrorToRecord(OrderClinic, _return, "202", 22);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckNzap(CResponceOrdersPackage _return, LinkedList<Integer> listNzap, COrderNullification OrderClinic)
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
    private void CheckOrnm(CResponceOrdersPackage _return, LinkedList<String> listOrdersNum, COrderNullification OrderClinic)
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
    //-----------------------------------------------------------------------------------------------------------------
}
