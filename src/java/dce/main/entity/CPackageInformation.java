/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dce.main.entity;

import dce.dbserver.CDBSever;
import dce.main.utility.CMarshalUtility;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author YaluplinMD
 */
//--------------------------------------------------------------------------------------------------
public class CPackageInformation {
    //--------------------------------------------------------------------------------------------------
    private Date p10_pakagedate = null;
    private String p11_pakagesender;
    private String p12_pakageguid;
    private int p13_zerrpkg = 0;
    private String p14_errmsg;
    private boolean IsGloballPackageError = false;
    //--------------------------------------------------------------------------------------------------
    public Date getP10_pakagedate() {return this.p10_pakagedate;}
    public void setP10_pakagedate(Date pp10_pakagedate) {if(this.p10_pakagedate == null)this.p10_pakagedate=new Date(); this.p10_pakagedate = pp10_pakagedate;}
    
    public String getP11_pakagesender() {return this.p11_pakagesender;}
    public void setP11_pakagesender(String pp11_pakagesender) {this.p11_pakagesender = pp11_pakagesender;}
    
    public String getP12_pakageguid() {return this.p12_pakageguid;}
    public void setP12_pakageguid(String pp12_pakageguid) {this.p12_pakageguid = pp12_pakageguid;}
    
    public String getP14_errmsg() {return this.p14_errmsg;}
    public void setP14_errmsg(String pp14_errmsg) {this.p14_errmsg = pp14_errmsg;}
    
    public int getP13_zerrpkg() {return this.p13_zerrpkg;}
    public void setP13_zerrpkg(int pp13_zerrpkg) {this.p13_zerrpkg = pp13_zerrpkg;}
    //---------------------------------------------------------------------------------------------------
    /*public CPackageInformation()
    {
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        
            PakageDate = new SimpleDateFormat("dd.mm.yyyy").parse(dateFormat.format(PakageDate));
        }
        catch(Exception e){}
    }*/
    //---------------------------------------------------------------------------------------------------
    private boolean CheckPackageDate()
    {
        if(p10_pakagedate == null)
        {
            IsGloballPackageError = true;
            return false;
        }
        
        return true;
    }
    //---------------------------------------------------------------------------------------------------
    private boolean CheckSenderCode()
    {
        if(p11_pakagesender == null || p11_pakagesender.length() == 0)
        {
            IsGloballPackageError = true;
            return false;
        }
        
        return true;
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private boolean CheckGUID()
    {
        if(p12_pakageguid == null || p12_pakageguid.length() == 0 || p12_pakageguid.length() < 10)
        {
            IsGloballPackageError = true;
            return false;
        }
        
        return true;
    }
    //-----------------------------------------------------------------------------------------------------------------
    /*public boolean ParsePackageStructure(CResponceOrdersPackage _return)
    {
        if(!CheckGUID())AddErrorToPack(_return, "100", 0);
        if(!CheckSenderCode())AddErrorToPack(_return, "101", 1);
        if(!CheckPackageDate())AddErrorToPack(_return, "108", 8);
        
        return IsGloballPackageError;
    }*/
    //--------------------------------------------------------------------------------------------------    
    public void PassValTrueIsGloballPackageError()
    {
        IsGloballPackageError = true;
    }
    //--------------------------------------------------------------------------------------------------    
    public boolean SendValIsGloballPackageError()
    {
        return IsGloballPackageError;
    }
    //--------------------------------------------------------------------------------------------------    
    /*public void AddErrorToPack(CResponceOrdersPackage _return, String code, int erindex)
    {
        _return.getR12_orerl().AddErrorToList(-1, new CFLKError(Integer.parseInt(code), IMsgConstantList.ErrMsg[erindex]));
        
        _return.getR10_packinf().setP13_zerrpkg(1);
    }*/
    //--------------------------------------------------------------------------------------------------
    public void AddPakageInformation(Date pPakageDate, String pPakageSender, String pPakageGUID)
    {
        //PakageDate = new Date();
        p10_pakagedate = pPakageDate;
        p11_pakagesender = pPakageSender;
        p12_pakageguid = pPakageGUID;
    }
    //--------------------------------------------------------------------------------------------------
    public<T> CResponceAttachPackage ParseAttachPackage(T pIn, int rProcTP, int lPackType) throws JAXBException
    {
        //nzap = -1 ошибка в оформлении пакета
        String PackGuid = "", pkSenderCode = ""; 
        int zErr_Code = 0;
        CResponceAttachPackage _return = new CResponceAttachPackage();
        try
        {
            if(lPackType != 0)
            {
                if(lPackType == 121)
                {
                    PackGuid = ((CAttachPersonPackage)pIn).getP10_packinf().getP12_pakageguid();
                }
            }
            else
            { 
                if("dce.main.entity.CAttachInformationPackage".equals(pIn.getClass().getName()))
                {
                    lPackType = 100;
                    PackGuid = ((CAttachInformationPackage)pIn).getP10_packinf().getP12_pakageguid();
                }
                else if("dce.main.entity.CAttachDoctorPackage".equals(pIn.getClass().getName()))
                {
                    lPackType = 101;
                    PackGuid = ((CAttachDoctorPackage)pIn).getP10_packinf().getP12_pakageguid();
                }
                else if("dce.main.entity.CAttachPersonPackage".equals(pIn.getClass().getName()))
                {
                    lPackType = 102;
                    PackGuid = ((CAttachPersonPackage)pIn).getP10_packinf().getP12_pakageguid();
                }
                else if("dce.main.entity.CDeAttachPersonPackage".equals(pIn.getClass().getName()))
                {
                    lPackType = 103;
                    PackGuid = ((CDeAttachPersonPackage)pIn).getP10_packinf().getP12_pakageguid();
                }
                else if("dce.main.entity.CAttachCommonPackage".equals(pIn.getClass().getName()))
                {
                    if(rProcTP == 1)lPackType = 104;
                    else if(rProcTP == 2)lPackType = 105;
                    PackGuid = ((CAttachCommonPackage)pIn).getP10_packinf().getP12_pakageguid();
                }
                else if("dce.main.entity.CAttachDoctorSectionPackage".equals(pIn.getClass().getName()))
                {
                    lPackType = 108;
                    PackGuid = ((CAttachDoctorSectionPackage)pIn).getP10_packinf().getP12_pakageguid();
                }
                else if("dce.main.entity.CDeAttachQueryForMOPackage".equals(pIn.getClass().getName()))
                {
                    lPackType = 110;
                    PackGuid = ((CDeAttachQueryForMOPackage)pIn).getP10_packinf().getP12_pakageguid();
                }
            }
            
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("exec wpPackageManager @ProcTP=1,@Package=?,@PackType="+ Integer.toString(lPackType) +",@ZERRCODE=?,@SenderCode=?");
            
            _return.getP10_packrespinf().getR11_rsinf().setPakageGUIDSrc(PackGuid);
        
            _return.getP10_packrespinf().getR10_packinf().AddPakageInformation(new Date(), "9007",  UUID.randomUUID().toString());
            
            //dbsever.getPreparedStatement().setInt(1,1);
            dbsever.getPreparedStatement().setString(1, (new CMarshalUtility()).GetMarshlStr(pIn));
            //dbsever.getPreparedStatement().setInt(3,lPackType);
            
            if(zErr_Code == 0)dbsever.getPreparedStatement().setNull(2, Types.NULL); 
            else dbsever.getPreparedStatement().setInt(2,  zErr_Code);
            if(pkSenderCode == null || pkSenderCode.length() == 0)dbsever.getPreparedStatement().setNull(3, Types.NULL); 
            else dbsever.getPreparedStatement().setString(3,  pkSenderCode);
            
              
            //WriteLog((new CMarshalUtility()).GetMarshlStr(pIn), "D:\\e1.txt");
                                    
            
            ResultSet rs = dbsever.getPreparedStatement().executeQuery();            
                
            JAXBContext jc = JAXBContext.newInstance(dce.main.entity.CErrorFlkPack.class);
            
            Unmarshaller u = jc.createUnmarshaller();             
            
            String res_xml = "", res_deatt_info = "";
            
            int pack_error = 0, iserrorrec = 0;
            
            while (rs.next()) 
            {
                res_xml = rs.getString("Result");
                pack_error = rs.getInt("pack_error");
                iserrorrec = rs.getInt("iserrorrec");
                
                if(lPackType == 102)
                {
                    res_deatt_info = rs.getString("xml_deattch");
                }
                
                break;        
            }
              
            try { rs.close(); } catch (Exception e) {  }
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
                    
            //WriteLog(res_xml, "D:\\e3.txt");
                        
            if(pack_error == 1 || pack_error == 2 || iserrorrec == 1)
            {
                StringBuffer xmlStr = new StringBuffer(res_xml);
                CErrorFlkPack res = (CErrorFlkPack)u.unmarshal(new StreamSource(new StringReader(xmlStr.toString()))); 
                
                _return.getP10_packrespinf().getR12_orerl().setF10_orflker(res.getP10_errpack().getF10_orflker());

                if(pack_error == 1)
                {
                    _return.getP10_packrespinf().getR11_rsinf().setR10_responcecode(1000);
                    _return.getP10_packrespinf().getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1000));
                }
                if(pack_error == 2)
                {
                    _return.getP10_packrespinf().getR11_rsinf().setR10_responcecode(1009);
                    _return.getP10_packrespinf().getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1009));
                }
                else if(iserrorrec != 0)
                {
                    _return.getP10_packrespinf().getR11_rsinf().setR10_responcecode(1001);
                    _return.getP10_packrespinf().getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1001));
                }
            }
            else if(res_xml != null && res_xml.length() != 0 && lPackType == 100)
            {
                //WriteLog("sdsd", "D:\\e2.txt");
                
                jc = JAXBContext.newInstance(dce.main.entity.CAttachList.class);
            
                u = jc.createUnmarshaller(); 
                
                StringBuffer xmlStr = new StringBuffer(res_xml);
                CAttachList res= (CAttachList)u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())));
                
                _return.setP11_atachlist(res);
                
                //WriteLog((new CMarshalUtility()).GetMarshlStr(res), "D:\\e1.txt");
            }
            else if(res_deatt_info != null && res_deatt_info.length() > 10 && lPackType == 102)
            {
                jc = JAXBContext.newInstance(dce.main.entity.CAttachList.class);
            
                u = jc.createUnmarshaller(); 
                
                StringBuffer xmlStr = new StringBuffer(res_deatt_info);
                CAttachList res= (CAttachList)u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())));
                
                _return.setP11_atachlist(res);
            }

        }
        catch(Exception e)
        {
            //SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1003, PackGuid), PackGuid);
            //if(lPackType == 100)WriteLog(e.getMessage(), "D:\\error.txt");
            return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1003, PackGuid);
        }

        //SaveResponceInfoToDB(_return, PackGuid);
        
        return _return;
    }
    //--------------------------------------------------------------------------------------------------
    public<T> CResponceOrdersPackage ParseOrderPackage(T pIn) throws JAXBException
    {
        //nzap = -1 ошибка в оформлении пакета
        String PackGuid = "", pkSenderCode = ""; 
        int zErr_Code = 0;
        CResponceOrdersPackage _return = new CResponceOrdersPackage();
        try
        {
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("exec wpPackageManager @ProcTP=?,@Package=?,@PackType=?,@ZERRCODE=?,@SenderCode=?");
            
            int lPackType = 100;            
            
            if("dce.main.entity.COrderClinicPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 1;
                PackGuid = ((COrderClinicPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.COrderHospitalPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 2;
                PackGuid = ((COrderHospitalPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.COrderHospitalUrgentlyPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 3;
                PackGuid = ((COrderHospitalUrgentlyPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.COrderNullificationPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 4;
                zErr_Code = ((COrderNullificationPackage)pIn).getP10_packinf().getP13_zerrpkg();
                pkSenderCode = ((COrderNullificationPackage)pIn).getP10_packinf().getP11_pakagesender();
                PackGuid = ((COrderNullificationPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.COrderLeaveHospitalPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 5;
                PackGuid = ((COrderLeaveHospitalPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.CKDInformationPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 6;
                PackGuid = ((CKDInformationPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.COrderReservedPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 7;
                PackGuid = ((COrderReservedPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.COrderCancelBedPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 8;
                PackGuid = ((COrderCancelBedPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.CReservedUrgentlyPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 9;
                PackGuid = ((CReservedUrgentlyPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.CFreeBedPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 10;
                PackGuid = ((CFreeBedPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.COrderReservedStatusPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 11;
                PackGuid = ((COrderReservedStatusPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.CAssertReservedBedPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 12;
                PackGuid = ((CAssertReservedBedPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
                 
            _return.getR11_rsinf().setPakageGUIDSrc(PackGuid);
        
            _return.getR10_packinf().AddPakageInformation(new Date(), "9007",  UUID.randomUUID().toString());
            
            dbsever.getPreparedStatement().setInt(1,1);
            dbsever.getPreparedStatement().setString(2, (new CMarshalUtility()).GetMarshlStr(pIn));
            dbsever.getPreparedStatement().setInt(3,lPackType);
            
            if(zErr_Code == 0)dbsever.getPreparedStatement().setNull(4, Types.NULL); 
            else dbsever.getPreparedStatement().setInt(4,  zErr_Code);
            if(pkSenderCode == null || pkSenderCode.length() == 0)dbsever.getPreparedStatement().setNull(5, Types.NULL); 
            else dbsever.getPreparedStatement().setString(5,  pkSenderCode);
            
              
            //WriteLog((new CMarshalUtility()).GetMarshlStr(pIn), "D:\\e1.txt");
                                    
            
            ResultSet rs = dbsever.getPreparedStatement().executeQuery();            
                
            JAXBContext jc = JAXBContext.newInstance(dce.main.entity.CErrorFlkPack.class);
            
            Unmarshaller u = jc.createUnmarshaller();             
            
            String res_xml = "";
            
                        //WriteLog((new Date()).toString(), "D:\\e2.txt");
            int pack_error = 0, iserrorrec = 0;
            
            while (rs.next()) 
            {
                res_xml = rs.getString("Result");
                pack_error = rs.getInt("pack_error");
                iserrorrec = rs.getInt("iserrorrec");
                
                break;        
                /*
                ++cnt;
                IsGlobErr = rs.getInt("PackError");
                _return.AddErrorToRecordByNzap(rs.getInt("n_zap"), _return, rs.getInt("code"), rs.getString("name"));
                */
            }
              
            try { rs.close(); } catch (Exception e) {  }
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
                        
            //WriteLog(res_xml, "D:\\e3.txt");
                        
            if(res_xml != null && res_xml.length() != 0)
            {
                StringBuffer xmlStr = new StringBuffer(res_xml);
                CErrorFlkPack res = (CErrorFlkPack)u.unmarshal(new StreamSource(new StringReader(xmlStr.toString()))); 
                
                _return.getR12_orerl().setF10_orflker(res.getP10_errpack().getF10_orflker());

                if(pack_error == 1)
                {
                    _return.getR11_rsinf().setR10_responcecode(1000);
                    _return.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1000));
                }
                if(pack_error == 2)
                {
                    _return.getR11_rsinf().setR10_responcecode(1009);
                    _return.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1009));
                }
                else if(iserrorrec != 0)
                {
                    _return.getR11_rsinf().setR10_responcecode(1001);
                    _return.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1001));
                }
            }
            /*для приписного*/
            if(pack_error != 1 && pack_error != 2 && iserrorrec == 0 && lPackType >= 100)
            {
                
            }

        }
        catch(Exception e)
        {
            SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, PackGuid), PackGuid);
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, PackGuid);
        }

        SaveResponceInfoToDB(_return, PackGuid);
        
        return _return;
    }
    //--------------------------------------------------------------------------------------------------
    public static void WriteLog(String LogMsg, String LogFile)
    {
        try {
            File logFile3 = new File(LogFile);
            FileWriter writeFile3 = new FileWriter(logFile3);
            writeFile3.write(LogMsg);
            writeFile3.close();
        } 
        catch (IOException ex) {}
    }
    //--------------------------------------------------------------------------------------------------
    public<T> void SaveResponceInfoToDB(T _respinfo, String PackGuid)
    {
        try
        {
            JAXBContext context = null;
            if(_respinfo.getClass().getName() == "dce.main.entity.CResponceOrdersPackage")
            {
                context = JAXBContext.newInstance(dce.main.entity.CResponceOrdersPackage.class);
            }
            else if(_respinfo.getClass().getName() == "dce.main.entity.CResponceAttachPackage")
            {
                context = JAXBContext.newInstance(dce.main.entity.CResponceAttachPackage.class);
            }
                    
                    //JAXBContext.newInstance(dce.main.entity.CResponceOrdersPackage.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_ENCODING, "WINDOWS-1251");
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            m.marshal(_respinfo, sw);

            String Result = sw.toString();

            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("exec wpPackageManager @ProcTP=?,@Package=?,@PackGuidIn=?");
            dbsever.getPreparedStatement().setInt(1,3);
            dbsever.getPreparedStatement().setString(2,Result);
            dbsever.getPreparedStatement().setString(3,PackGuid);
            dbsever.getPreparedStatement().execute();
            
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
        }
        catch(Exception ex){}
    }
    //--------------------------------------------------------------------------------------------------
    public static <T> T BuildPackage(T param, String username, String password, String sendercode, String rKpkCode, String rMOCode, 
                int _year, int _month, String rGUID, Date lastsynhdate, int IsPartDates, int rangevalue, int isadres)
    {
        try{
            //if(CDBSever.CheckUserForAccess(username, password, sendercode) != 1) return CreateErrorPackage(param, 1002, ""); 
            
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CreateErrorPackage(param, 1002, ""); 
            else if(_res == -1)
                return CreateErrorPackage(param, 3000, ""); 
              
            JAXBContext jc = null;
            int PackType = 0;

            ///////////////////////////////////////////////////////////////////
            if(param.getClass().getName() == "dce.main.entity.COrderClinicPackage")
            {
                PackType = 1;
                jc = JAXBContext.newInstance(dce.main.entity.COrderClinicPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.COrderHospitalPackage")
            {
                PackType = 2;
                jc = JAXBContext.newInstance(dce.main.entity.COrderHospitalPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.COrderHospitalUrgentlyPackage")
            {
                PackType = 3;
                jc = JAXBContext.newInstance(dce.main.entity.COrderHospitalUrgentlyPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.COrderNullificationPackage")
            {
                PackType = 4;
                jc = JAXBContext.newInstance(dce.main.entity.COrderNullificationPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.COrderLeaveHospitalPackage")
            {
                PackType = 5;
                jc = JAXBContext.newInstance(dce.main.entity.COrderLeaveHospitalPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CKDInformationPackage")
            {
                PackType = 6;
                jc = JAXBContext.newInstance(dce.main.entity.CKDInformationPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CRealKDPackage")
            {
                PackType = 7;
                jc = JAXBContext.newInstance(dce.main.entity.CRealKDPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CGuidWrapper")
            {
                PackType = 8;
                jc = JAXBContext.newInstance(dce.main.entity.CGuidWrapper.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CRecWrapper")
            {
                PackType = 9;
                jc = JAXBContext.newInstance(dce.main.entity.CRecWrapper.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CAttachDoctorPackage")
            {
                PackType = 101;
                jc = JAXBContext.newInstance(dce.main.entity.CAttachDoctorPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CDeAttachPersonPackage")
            {
                PackType = 106;
                jc = JAXBContext.newInstance(dce.main.entity.CDeAttachPersonPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CAttachPersonListPackage" && IsPartDates == 100)
            {
                PackType = 111;
                jc = JAXBContext.newInstance(dce.main.entity.CAttachPersonListPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CAttachPersonListPackage" && _month == 0 && _year == 0)
            {
                PackType = 107;
                jc = JAXBContext.newInstance(dce.main.entity.CAttachPersonListPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CAttachPersonListPackage" && _month != 0 && _year != 0)
            {
                PackType = 109;
                jc = JAXBContext.newInstance(dce.main.entity.CAttachPersonListPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CDeAttachQueryForMOPackage")
            {
                PackType = 110;
                jc = JAXBContext.newInstance(dce.main.entity.CDeAttachQueryForMOPackage.class);
            }
            
            ///////////////////////////////////////////////////////////////////////////////////
            if(PackType == 109)
            {
                CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
                dbsever.setQuerySTR("set dateformat dmy exec wpPackageManager @ProcTP=13,@yearcode=" + Integer.toString(_year) + ",@monthcode=" + Integer.toString(_month));
             
                ResultSet rs = dbsever.getPreparedStatement().executeQuery();
           
                while (rs.next()) 
                {
                    if(rs.getString("result").equals("0"))
                    {
                        return CreateErrorPackage(param, 1014, ""); 
                    }
                }
                
                try { rs.close(); } catch (Exception e) {  }
                try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
                try { dbsever.getConnection().close(); } catch (Exception e) {  }
            }
            
            
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("set dateformat dmy exec wpPackageManager @ProcTP=?,@PackType=?, @SenderCode=?, @KpkCode=?, "
                    + "@LpuCode=?,@yearcode=?,@monthcode=?,@PackGuidIn=?,@StartGetDataDate=?,@PartialGetDates=?,@RangeValue=?,@isadres=?");
            dbsever.getPreparedStatement().setInt(1,2);
            dbsever.getPreparedStatement().setInt(2,PackType);
            dbsever.getPreparedStatement().setString(3, sendercode);
            
            if(rKpkCode == null || rKpkCode.length() == 0)dbsever.getPreparedStatement().setNull(4, Types.NULL); 
            else dbsever.getPreparedStatement().setString(4,  rKpkCode);

            if(rMOCode == null || rMOCode.length() == 0)dbsever.getPreparedStatement().setNull(5, Types.NULL); 
            else dbsever.getPreparedStatement().setString(5,  rMOCode);            
            
            if(_year == 0)dbsever.getPreparedStatement().setNull(6, Types.NULL); 
            else dbsever.getPreparedStatement().setInt(6,  _year);
            
            if(_month == 0)dbsever.getPreparedStatement().setNull(7, Types.NULL); 
            else dbsever.getPreparedStatement().setInt(7,  _month);
            
            if(rGUID == null || rGUID.length() == 0)dbsever.getPreparedStatement().setNull(8, Types.NULL); 
            else dbsever.getPreparedStatement().setString(8,  rGUID);
            
            if(lastsynhdate == null)dbsever.getPreparedStatement().setNull(9, Types.NULL); 
            else 
            {
                Calendar cal = Calendar.getInstance();
                cal.setTime(lastsynhdate);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH) + 1; /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
                int day = cal.get(Calendar.DAY_OF_MONTH);
                
                //DateFormat df = new SimpleDateFormat("dd.mm.yyyy HH:mm:ss");
                String reportDate =  (Integer.toString(day).length() == 1 ? "0"+Integer.toString(day):Integer.toString(day))+
                        "." + (Integer.toString(month).length() == 1 ? "0"+Integer.toString(month):Integer.toString(month)) 
                        + "." + Integer.toString(year);//df.format(lastsynhdate);
                dbsever.getPreparedStatement().setString(9,  reportDate);
            }
            
            if(IsPartDates == 0)dbsever.getPreparedStatement().setNull(10, Types.NULL); 
            else dbsever.getPreparedStatement().setInt(10,  IsPartDates);
            
            if(rangevalue == 0)dbsever.getPreparedStatement().setNull(11, Types.NULL); 
            else dbsever.getPreparedStatement().setInt(11,  rangevalue);
            
            dbsever.getPreparedStatement().setInt(12,  isadres);
            
            String res_xml = "";
          
  
            ResultSet rs = dbsever.getPreparedStatement().executeQuery();
           
            while (rs.next()) 
            {
                res_xml = rs.getString("result");
                
                break;
            }
            
            
            
            try { rs.close(); } catch (Exception e) {  }
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
           
            Unmarshaller u = jc.createUnmarshaller();
            StringBuffer xmlStr = new StringBuffer(res_xml);
            T res = (T)u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())));  
            
            return res;
            
        }catch(Exception e){
            return null;
        }
    }
    //--------------------------------------------------------------------------------------------------
    public static <T> T CreateErrorPackage(T pIn, int rErrIndex, String srcPackGUID)
    {
        CPackageInformation _return = new CPackageInformation();
        _return.setP10_pakagedate(new Date());
        _return.setP11_pakagesender("9007");
        _return.setP12_pakageguid(UUID.randomUUID().toString());
        _return.setP13_zerrpkg(-1);
        _return.setP14_errmsg(CMessageUtils.GetMsgByID(rErrIndex));
        
        if("dce.main.entity.COrderClinicPackage".equals(pIn.getClass().getName()))((COrderClinicPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.COrderHospitalPackage".equals(pIn.getClass().getName()))((COrderHospitalPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.COrderHospitalUrgentlyPackage".equals(pIn.getClass().getName()))((COrderHospitalUrgentlyPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.COrderNullificationPackage".equals(pIn.getClass().getName()))((COrderNullificationPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.COrderLeaveHospitalPackage".equals(pIn.getClass().getName()))((COrderLeaveHospitalPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CKDInformationPackage".equals(pIn.getClass().getName()))((CKDInformationPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CRealKDPackage".equals(pIn.getClass().getName()))((CRealKDPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CResponceReservedStatusPackage".equals(pIn.getClass().getName()))((CResponceReservedStatusPackage)pIn).getP10_packrespinf().setR10_packinf(_return);
        else if("dce.main.entity.CResponceAssertBedPackage".equals(pIn.getClass().getName()))((CResponceAssertBedPackage)pIn).getP10_packrespinf().setR10_packinf(_return);
        else if("dce.main.entity.CResponceOrdersPackage".equals(pIn.getClass().getName()))
        {
            ((CResponceOrdersPackage)pIn).setR10_packinf(_return);
            ((CResponceOrdersPackage)pIn).getR11_rsinf().setR10_responcecode(rErrIndex);
            ((CResponceOrdersPackage)pIn).getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(rErrIndex));
            ((CResponceOrdersPackage)pIn).getR11_rsinf().setPakageGUIDSrc(srcPackGUID);
        }
        else if("dce.main.entity.CResponceAttachPackage".equals(pIn.getClass().getName()))
        {            
            ((CResponceAttachPackage)pIn).getP10_packrespinf().setR10_packinf(_return);
            ((CResponceAttachPackage)pIn).getP10_packrespinf().getR11_rsinf().setR10_responcecode(rErrIndex);
            ((CResponceAttachPackage)pIn).getP10_packrespinf().getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(rErrIndex));
            ((CResponceAttachPackage)pIn).getP10_packrespinf().getR11_rsinf().setPakageGUIDSrc(srcPackGUID);
        }
        else if("dce.main.entity.CAttachDoctorPackage".equals(pIn.getClass().getName()))((CAttachDoctorPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CAttachPersonPackage".equals(pIn.getClass().getName()))((CAttachPersonPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CDeAttachPersonPackage".equals(pIn.getClass().getName()))((CDeAttachPersonPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CAttachCommonPackage".equals(pIn.getClass().getName()))((CAttachCommonPackage)pIn).setP10_packinf(_return);   
        else if("dce.main.entity.CAttachDoctorSectionPackage".equals(pIn.getClass().getName()))((CAttachDoctorSectionPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CAttachPersonListPackage".equals(pIn.getClass().getName()))((CAttachPersonListPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CDeAttachQueryForMOPackage".equals(pIn.getClass().getName()))((CDeAttachQueryForMOPackage)pIn).setP10_packinf(_return);
        
        else if("dce.main.entity.CevPlanQtysPackage".equals(pIn.getClass().getName()))((CevPlanQtysPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CevPlanListPackage".equals(pIn.getClass().getName()))((CevPlanListPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CevContactsPackage".equals(pIn.getClass().getName()))((CevContactsPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CevPlanDatesPackage".equals(pIn.getClass().getName()))((CevPlanDatesPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CevFactInfosPackage".equals(pIn.getClass().getName()))((CevFactInfosPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CevFactExecsPackage".equals(pIn.getClass().getName()))((CevFactExecsPackage)pIn).setP10_packinf(_return);
        else if("dce.main.entity.CevFactInvcsPackage".equals(pIn.getClass().getName()))((CevFactInvcsPackage)pIn).setP10_packinf(_return);
        
        
        return pIn;
    }
    //--------------------------------------------------------------------------------------------------
    public static <T> T MakeReport(T param, CAttachReportParam params, int reporttype, String username, String password, String sendercode)
    {
        try
        {
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            int proctp = 0;
            
            String res_xml = "";
            
            if(_res == 0)
                return null; 
            else if(_res == -1)
                return null; 
            
            JAXBContext jc = null;
            
            if(reporttype == 1)
            {
                if(params.getD_01() == null) return null;
                proctp = 1;
                jc = JAXBContext.newInstance(dce.main.entity.CAttachAgregateSmoMoByDate.class);
            }

            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
                dbsever.setQuerySTR("set dateformat dmy exec wpReportXML @ProcTP=?, @DistrictRef=?, @ReportDate=?, @SenderCode=?");
                dbsever.getPreparedStatement().setInt(1,proctp);
                dbsever.getPreparedStatement().setNull(2,Types.NULL);
                
                if(params.getD_01() == null)dbsever.getPreparedStatement().setNull(3, Types.NULL); 
                else
                {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(params.getD_01());
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH) + 1; /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
                    int day = cal.get(Calendar.DAY_OF_MONTH);

                    //DateFormat df = new SimpleDateFormat("dd.mm.yyyy HH:mm:ss");
                    String reportDate =  (Integer.toString(day).length() == 1 ? "0"+Integer.toString(day):Integer.toString(day))+
                            "." + (Integer.toString(month).length() == 1 ? "0"+Integer.toString(month):Integer.toString(month)) 
                            + "." + Integer.toString(year);
                    dbsever.getPreparedStatement().setString(3,  reportDate);
                }
                
                
                dbsever.getPreparedStatement().setString(4,sendercode);
                
            ResultSet rs = dbsever.getPreparedStatement().executeQuery();
           
            while (rs.next()) 
            {
                res_xml = rs.getString("result");
                
                break;
            }
            try { rs.close(); } catch (Exception e) {  }
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
                
            Unmarshaller u = jc.createUnmarshaller();
            StringBuffer xmlStr = new StringBuffer(res_xml);
            T res = (T)u.unmarshal(new StreamSource(new StringReader(xmlStr.toString()))); 
            
            return res;
        }
        catch(Exception e){return null;}
        
    }
    //--------------------------------------------------------------------------------------------------
    public static <T> T evGetPackage(T param, String username, String password, String sendercode, 
        int yearCode, int mnthCode, int page, String smoCode, Date infoDate, 
        String codeMO, Date execDate)
    {

        try{
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CreateErrorPackage(param, 1002, ""); 
            else if(_res == -1)
                return CreateErrorPackage(param, 3000, ""); 
              
            JAXBContext jc = null;
            int PackType = 0;

            ///////////////////////////////////////////////////////////////////
            if(param.getClass().getName() == "dce.main.entity.CevPlanQtysPackage")
            {
                PackType = 231;
                jc = JAXBContext.newInstance(dce.main.entity.CevPlanQtysPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CevPlanListPackage")
            {
                PackType = 232; 
                jc = JAXBContext.newInstance(dce.main.entity.CevPlanListPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CevContactsPackage")
            {
                PackType = 233; 
                jc = JAXBContext.newInstance(dce.main.entity.CevContactsPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CevPlanDatesPackage")
            {
                PackType = 234; 
                jc = JAXBContext.newInstance(dce.main.entity.CevPlanDatesPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CevFactInfosPackage")
            {
                PackType = 236; 
                jc = JAXBContext.newInstance(dce.main.entity.CevFactInfosPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CevFactExecsPackage")
            {
                PackType = 237; 
                jc = JAXBContext.newInstance(dce.main.entity.CevFactExecsPackage.class);
            }
            else if(param.getClass().getName() == "dce.main.entity.CevFactInvcsPackage")
            {
                PackType = 238; 
                jc = JAXBContext.newInstance(dce.main.entity.CevFactInvcsPackage.class);
            }
            
            
            ///////////////////////////////////////////////////////////////////////////////////
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("set dateformat dmy exec evGetPackage @PackType=?, @SenderCode=?, @YearCode=?, @MnthCode=?, @Page=?, @SmoCode=?, @InfoDate=?, @CodeMO=?, @ExecDate=?");
            dbsever.getPreparedStatement().setInt(1,PackType);
            dbsever.getPreparedStatement().setString(2, sendercode);
            
            if(yearCode == 0)
                dbsever.getPreparedStatement().setNull(3, Types.NULL); 
            else 
                dbsever.getPreparedStatement().setInt(3,  yearCode);
            
            if(mnthCode == 0)
                dbsever.getPreparedStatement().setNull(4, Types.NULL); 
            else 
                dbsever.getPreparedStatement().setInt(4,  mnthCode);
            
            if(page == 0)
                dbsever.getPreparedStatement().setNull(5, Types.NULL); 
            else 
                dbsever.getPreparedStatement().setInt(5,  page);
            
            if(smoCode == null)
                dbsever.getPreparedStatement().setNull(6, Types.NULL); 
            else 
                dbsever.getPreparedStatement().setString(6,  smoCode);

            if(infoDate == null)
                dbsever.getPreparedStatement().setNull(7, Types.NULL); 
            else {
                SimpleDateFormat dateFormat =  new SimpleDateFormat("dd.MM.yyyy");
                dbsever.getPreparedStatement().setString(7, dateFormat.format(infoDate));
            }
            
            if(codeMO == null)
                dbsever.getPreparedStatement().setNull(8, Types.NULL); 
            else 
                dbsever.getPreparedStatement().setString(8,  codeMO);

            if(execDate == null)
                dbsever.getPreparedStatement().setNull(9, Types.NULL); 
            else {
                SimpleDateFormat dateFormat =  new SimpleDateFormat("dd.MM.yyyy");
                dbsever.getPreparedStatement().setString(9, dateFormat.format(execDate));
            }   
                        
            
            


            String res_xml = "";
            ResultSet rs = dbsever.getPreparedStatement().executeQuery();
           
            while (rs.next()) 
            {
                res_xml = rs.getString("result");
                break;
            }
            
            WriteLog("<?xml version=\"1.0\" encoding=\"Windows-1251\"?>\r\n"+res_xml, "C:\\res_xml.xml");
            
            try { rs.close(); } catch (Exception e) {  }
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
           
            Unmarshaller u = jc.createUnmarshaller();
            StringBuffer xmlStr = new StringBuffer(res_xml);
            T res = (T)u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())));  
            
            return res;
            
        }catch(Exception e){
            WriteLog(e.toString(), "C:\\xcpt.txt");
            
            return null;
        }
    }
    //--------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------
    public<T> CResponceOrdersPackage evPutPackage(T pIn) throws JAXBException
    {

        //nzap = -1 ошибка в оформлении пакета
        String PackGuid = "", pkSenderCode = ""; 
        int zErr_Code = 0;
        CResponceOrdersPackage _return = new CResponceOrdersPackage();
        
        try
        {
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("exec evPutPackage @Package=?,@PackType=?");
            
            int lPackType = 200;            
            
            /*if("dce.main.entity.CevPlanQtysPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 231;
                PackGuid = ((CevPlanQtysPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            */
            if("dce.main.entity.CevPlanListPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 232;
                PackGuid = ((CevPlanListPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.CevContactsPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 233;
                PackGuid = ((CevContactsPackage)pIn).getP10_packinf().getP12_pakageguid();
                pkSenderCode = ((CevContactsPackage)pIn).getP10_packinf().getP11_pakagesender();                
            }
            else if("dce.main.entity.CevPlanDatesPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 234;
                PackGuid = ((CevPlanDatesPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.CevFactInfosPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 236;
                PackGuid = ((CevFactInfosPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            else if("dce.main.entity.CevFactExecsPackage".equals(pIn.getClass().getName()))
            {
                lPackType = 237;
                PackGuid = ((CevFactExecsPackage)pIn).getP10_packinf().getP12_pakageguid();
            }
            
                 
            _return.getR11_rsinf().setPakageGUIDSrc(PackGuid);
        
            _return.getR10_packinf().AddPakageInformation(new Date(), "9007",  UUID.randomUUID().toString());
            
            dbsever.getPreparedStatement().setString(1, (new CMarshalUtility()).GetMarshlStr(pIn));
            dbsever.getPreparedStatement().setInt(2,lPackType);
            
            
           /*
            if(pkSenderCode == null || pkSenderCode.length() == 0)
                dbsever.getPreparedStatement().setNull(3, Types.NULL); 
            else 
                dbsever.getPreparedStatement().setString(3,  pkSenderCode);
            */
              
            //WriteLog((new CMarshalUtility()).GetMarshlStr(pIn), "C:\\e.txt");

            
            ResultSet rs = dbsever.getPreparedStatement().executeQuery();            
                
            JAXBContext jc = JAXBContext.newInstance(dce.main.entity.CErrorFlkPack.class);
            
            Unmarshaller u = jc.createUnmarshaller();             
            
            String res_xml = "";
            
            int pack_error = 0, iserrorrec = 0;
            
            while (rs.next()) 
            {
                res_xml = rs.getString("Result");
                pack_error = rs.getInt("pack_error");
                iserrorrec = rs.getInt("iserrorrec");
                
                break;        
                /*
                ++cnt;
                IsGlobErr = rs.getInt("PackError");
                _return.AddErrorToRecordByNzap(rs.getInt("n_zap"), _return, rs.getInt("code"), rs.getString("name"));
                */
            }
              
            try { rs.close(); } catch (Exception e) {  }
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
                        
            //WriteLog(res_xml, "C:\\res_xml.txt");
                        
            if(res_xml != null && res_xml.length() != 0)
            {
                StringBuffer xmlStr = new StringBuffer(res_xml);
                CErrorFlkPack res = (CErrorFlkPack)u.unmarshal(new StreamSource(new StringReader(xmlStr.toString()))); 
                
                _return.getR12_orerl().setF10_orflker(res.getP10_errpack().getF10_orflker());

                if(pack_error == 1)
                {
                        
                    _return.getR11_rsinf().setR10_responcecode(1000);
                    _return.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1000));
                }
                if(pack_error == 2)
                {
                    _return.getR11_rsinf().setR10_responcecode(1009);
                    _return.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1009));
                }
                else if(iserrorrec != 0)
                {
                    _return.getR11_rsinf().setR10_responcecode(1001);
                    _return.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1001));
                }
            }

        }
        catch(Exception e)
        {
            WriteLog(e.toString(), "C:\\xcpt.txt");
            
            SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, PackGuid), PackGuid);
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, PackGuid);
        }

        SaveResponceInfoToDB(_return, PackGuid);
        
        return _return;
    }
    //--------------------------------------------------------------------------------------------------

   
/* 
    public static void main(String[] args) {
    
        
        String ggg = "<orderpack>\n" +
"  <p10_packinf>\n" +
"    <p10_pakagedate>2017-06-29T11:52:55.0900000</p10_pakagedate>\n" +
"    <p11_pakagesender>9007</p11_pakagesender>\n" +
"    <p12_pakageguid>0BE14100-6E0A-4CFC-8686-782F3708B1A2</p12_pakageguid>\n" +
"    <p13_zerrpkg>0</p13_zerrpkg>\n" +
"  </p10_packinf>\n" +
"  <evPlanQtys>\n" +
"    <evPlanQuantity>\n" +
"      <id>7</id>\n" +
"      <kind>1</kind>\n" +
"      <year>2017</year>\n" +
"      <mnth>1</mnth>\n" +
"      <code_mo>01001</code_mo>\n" +
"      <quantity>87</quantity>\n" +
"    </evPlanQuantity>\n" +
"    <evPlanQuantity>\n" +
"      <id>2303</id>\n" +
"      <kind>2</kind>\n" +
"      <year>2017</year>\n" +
"      <mnth>12</mnth>\n" +
"      <code_mo>45014</code_mo>\n" +
"      <quantity>184</quantity>\n" +
"    </evPlanQuantity>\n" +
"    <evPlanQuantity>\n" +
"      <id>2302</id>\n" +
"      <kind>2</kind>\n" +
"      <year>2017</year>\n" +
"      <mnth>12</mnth>\n" +
"      <code_mo>46010</code_mo>\n" +
"      <quantity>20</quantity>\n" +
"    </evPlanQuantity>\n" +
"   </evPlanQtys>\n" +
"</orderpack>";
        try
        {
        
            JAXBContext jc = null;
        
            jc = JAXBContext.newInstance(dce.main.entity.CevPlanListPackage.class);
            
            Unmarshaller u = jc.createUnmarshaller();
            StringBuffer xmlStr = new StringBuffer(ggg);
            StringReader sr = new StringReader(xmlStr.toString());
            StreamSource ss = new StreamSource(sr);
            CevPlanListPackage res = (CevPlanListPackage)u.unmarshal(ss);  
        

            System.err.println("asdfsdf");
        }
        catch(Exception eee)
        {
            String gg = "";
        }

 try {
    CevPlanListPackage pack = CPackageInformation.evGetPackage(new CevPlanListPackage(), "9007", "9007fond", "9007", 2017, 1);
    JAXBContext jaxbContext = JAXBContext.newInstance(dce.main.entity.CevPlanListPackage.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
    jaxbMarshaller.marshal( pack, new File( "C:\\pack.xml" ) );
    //jaxbMarshaller.marshal( pack, System.out );    
 } catch(Exception e)    
 {
     System.err.println(e.getMessage());
 }

} */    
//--------------------------------------------------------------------------------------------------
}