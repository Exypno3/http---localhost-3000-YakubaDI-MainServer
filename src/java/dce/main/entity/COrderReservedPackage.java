
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
//----------------------------------------------------------------------------------------------------------------

import dce.dbserver.CDBSever;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author YaluplinMD
 */
//----------------------------------------------------------------------------------------------------------------
@XmlRootElement(name="orderpack")
public class COrderReservedPackage {
    private CPackageInformation p10_packinf;
    private COrderClinic p11_orderclinic;
    //----------------------------------------------------------------------------------------------------------------
    public COrderReservedPackage()
    {
        p11_orderclinic = new COrderClinic();
    }
    //----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //-----------------------------------------------------------------------------------------------------------------
    public COrderClinic getP11_orderclinic() {return this.p11_orderclinic;}
    public void setP11_orderclinic(COrderClinic pp11_orderclinic) {this.p11_orderclinic = pp11_orderclinic;}
    //----------------------------------------------------------------------------------------------------------------
    public CResponceOrdersPackage TryReservedBed(COrderReservedPackage pinppack)
    {   
        int result = 0, rec_id = 0;
        try
        {
            CResponceOrdersPackage respack = p10_packinf.ParseOrderPackage(pinppack);
            
            if(respack.getR11_rsinf().getR10_responcecode() != 2000)
            {
                respack.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1004));
                return respack;
            }
            try
            {
                Calendar cal = Calendar.getInstance();
                cal.setTime(p11_orderclinic.getM22_dtph());
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                
                CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
                dbsever.setQuerySTR("set dateformat dmy exec wpPackageManager @ProcTP=?,@yearcode=?, @monthcode=?, @LpuCode=?, @KpkCode=?, @PackGuidIn=?,@OrderNumber=?,@OrderDate=?");
                dbsever.getPreparedStatement().setInt(1,4);
                dbsever.getPreparedStatement().setInt(2,cal.get(Calendar.YEAR));
                dbsever.getPreparedStatement().setInt(3, cal.get(Calendar.MONTH));
                dbsever.getPreparedStatement().setString(4, p11_orderclinic.getM15_modcd());
                dbsever.getPreparedStatement().setString(5, p11_orderclinic.getM19_kpkcd());                        
                dbsever.getPreparedStatement().setString(6, p10_packinf.getP12_pakageguid()); 
                dbsever.getPreparedStatement().setString(7, p11_orderclinic.getM11_ornm());                        
                dbsever.getPreparedStatement().setString(8, dateFormat.format(p11_orderclinic.getM12_ordt())); 
                
                ResultSet rs = dbsever.getPreparedStatement().executeQuery();

                while (rs.next()) 
                {
                    result = rs.getInt("result");
                    rec_id = rs.getInt("recid");

                    break;
                }
                try { rs.close(); } catch (Exception e) {  }
                try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
                try { dbsever.getConnection().close(); } catch (Exception e) {  }
                
                if(result != 4000)
                {
                    return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), result, p10_packinf.getP12_pakageguid());
                }
            }
            catch(Exception ex){return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, p10_packinf.getP12_pakageguid());}          
            return SendQueryLPUForKD(rec_id);
        }
        catch(Exception e){return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(),1004, p10_packinf.getP12_pakageguid());}
    }
    //----------------------------------------------------------------------------------------------------------------
    private String CheckNullStr(String inStr)
    {
        return ((inStr == null || inStr.trim().length() == 0)?"-":inStr.trim());
    }
    //----------------------------------------------------------------------------------------------------------------
    private CResponceOrdersPackage SendQueryLPUForKD(int rec_id)
    {  
        String _ip_result = "", ParamStr = "";
        int sock_port = 0, quer_type = 0;
        
        try
        {
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("set dateformat dmy exec wpPackageManager @ProcTP=11,@LpuCode=?");
            dbsever.getPreparedStatement().setString(1, p11_orderclinic.getM15_modcd());
            
            ResultSet rs = dbsever.getPreparedStatement().executeQuery();

            while (rs.next()) 
            {
                _ip_result = rs.getString("result");
                quer_type = rs.getInt("adrType");
                sock_port = rs.getInt("adrPort");

                break;
            }
            try { rs.close(); } catch (Exception e) {  }
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
                
            if(_ip_result == null || _ip_result.length() < 5)
            {
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1007, p10_packinf.getP12_pakageguid());
            }
        }
        catch(Exception ex){return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, p10_packinf.getP12_pakageguid());}          
            
        
        URL lpuurl = null;
        URLConnection lpuconnect = null;
        BufferedReader in = null;
        
        Socket smtpSocket = null;  
        BufferedWriter os = null;
        BufferedReader is = null;
        
        CResponceOrdersPackage _return = new CResponceOrdersPackage(); 
        _return.getR10_packinf().AddPakageInformation(new Date(), "9007", UUID.randomUUID().toString());
        
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            if(quer_type == 1)
            {
                ParamStr =                       
                            "recid=" + CheckNullStr(Integer.toString(rec_id))
                            + "&ordernumber=" + CheckNullStr(p11_orderclinic.getM11_ornm())
                            + "&orderdate=" + dateFormat.format(p11_orderclinic.getM12_ordt())
                            + "&ordertype=" + CheckNullStr((Integer.toString(p11_orderclinic.getM13_ortp())))
                            + "&mosrc=" + CheckNullStr(p11_orderclinic.getM14_moscd())
                            + "&modesc=" + CheckNullStr(p11_orderclinic.getM15_modcd())
                            + "&doctype=" + CheckNullStr((Integer.toString(p11_orderclinic.getM16_pr().getA10_dct())))
                            + "&docser=" + URLEncoder.encode(CheckNullStr(p11_orderclinic.getM16_pr().getA11_dcs()), "utf-8")
                            + "&docnum=" + URLEncoder.encode(CheckNullStr(p11_orderclinic.getM16_pr().getA12_dcn()), "utf-8")
                            + "&fio=" + URLEncoder.encode(CheckNullStr(p11_orderclinic.getM16_pr().getA15_pfio()), "utf-8")
                            + "&ima=" + URLEncoder.encode(CheckNullStr(p11_orderclinic.getM16_pr().getA16_pnm()), "utf-8")
                            + "&otch=" + URLEncoder.encode(CheckNullStr(p11_orderclinic.getM16_pr().getA17_pln()), "utf-8")
                            + "&datr=" + dateFormat.format(p11_orderclinic.getM16_pr().getA19_pbd())
                            + "&sex=" + CheckNullStr(p11_orderclinic.getM16_pr().getA18_ps())
                            + "&passer=" + URLEncoder.encode(CheckNullStr(p11_orderclinic.getM16_pr().getA21_ps()), "utf-8")
                            + "&pasnum=" + URLEncoder.encode(CheckNullStr(p11_orderclinic.getM16_pr().getA22_pn()), "utf-8")
                            + "&mkbx=" + CheckNullStr(p11_orderclinic.getM18_mkbcd())
                            + "&kpk=" + CheckNullStr(p11_orderclinic.getM19_kpkcd())
                            + "&plandate=" + dateFormat.format(p11_orderclinic.getM22_dtph())
                            + "&phone=" + URLEncoder.encode(CheckNullStr(p11_orderclinic.getM16_pr().getA20_pph()), "utf-8");
            }
            else if(quer_type == 2)
            {
                ParamStr =                       
                            "recid=" + CheckNullStr(Integer.toString(rec_id))
                            + "&ordernumber=" + CheckNullStr(p11_orderclinic.getM11_ornm())
                            + "&orderdate=" + dateFormat.format(p11_orderclinic.getM12_ordt())
                            + "&ordertype=" + CheckNullStr((Integer.toString(p11_orderclinic.getM13_ortp())))
                            + "&mosrc=" + CheckNullStr(p11_orderclinic.getM14_moscd())
                            + "&modesc=" + CheckNullStr(p11_orderclinic.getM15_modcd())
                            + "&doctype=" + CheckNullStr((Integer.toString(p11_orderclinic.getM16_pr().getA10_dct())))
                            + "&docser=" + CheckNullStr(p11_orderclinic.getM16_pr().getA11_dcs())
                            + "&docnum=" + CheckNullStr(p11_orderclinic.getM16_pr().getA12_dcn())
                            + "&fio=" + CheckNullStr(p11_orderclinic.getM16_pr().getA15_pfio())
                            + "&ima=" + CheckNullStr(p11_orderclinic.getM16_pr().getA16_pnm())
                            + "&otch=" + CheckNullStr(p11_orderclinic.getM16_pr().getA17_pln())
                            + "&datr=" + dateFormat.format(p11_orderclinic.getM16_pr().getA19_pbd())
                            + "&sex=" + CheckNullStr(p11_orderclinic.getM16_pr().getA18_ps())
                            + "&passer=" + CheckNullStr(p11_orderclinic.getM16_pr().getA21_ps())
                            + "&pasnum=" + CheckNullStr(p11_orderclinic.getM16_pr().getA22_pn())
                            + "&mkbx=" + CheckNullStr(p11_orderclinic.getM18_mkbcd())
                            + "&kpk=" + CheckNullStr(p11_orderclinic.getM19_kpkcd())
                            + "&plandate=" + dateFormat.format(p11_orderclinic.getM22_dtph())
                            + "&phone=" + CheckNullStr(p11_orderclinic.getM16_pr().getA20_pph());
            }
        }
        catch(Exception ex)
        {
           //WriteLog(ex.getMessage(), "D:\\e23.txt"); 
            
           return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1010, p10_packinf.getP12_pakageguid());  
        }
        try
        {
            if(quer_type == 1)
            {
                lpuurl = new URL(_ip_result + "?" + ParamStr);
                lpuconnect = lpuurl.openConnection();
                /*lpuconnect.setConnectTimeout(10000);
                lpuconnect.setReadTimeout(10000);*/
            
                in = new BufferedReader(new InputStreamReader(lpuconnect.getInputStream(), "Windows-1251"));
            }
        }
        catch(Exception ex)
        {
            try
            {
                CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
                dbsever.setQuerySTR("exec wpPackageManager @ProcTP=?,@rec_id=?");
                dbsever.getPreparedStatement().setInt(1,12);
                dbsever.getPreparedStatement().setInt(2,rec_id);

                dbsever.getPreparedStatement().execute();
                
                try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
                try { dbsever.getConnection().close(); } catch (Exception e) {  }
            }
            catch(Exception epx){return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, p10_packinf.getP12_pakageguid());}
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3001, p10_packinf.getP12_pakageguid());  
        }
        try
        {
            if(quer_type == 2)
            {
                InetAddress ipAddress = InetAddress.getByName(_ip_result);
                smtpSocket = new Socket(ipAddress, sock_port);
                os = new BufferedWriter(new OutputStreamWriter(smtpSocket.getOutputStream(),  "windows-1251"));
                is = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream(), "windows-1251"));
            }
       }
       catch(Exception ex)
       {
           try
            {
                CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
                dbsever.setQuerySTR("exec wpPackageManager @ProcTP=?,@rec_id=?");
                dbsever.getPreparedStatement().setInt(1,12);
                dbsever.getPreparedStatement().setInt(2,rec_id);

                dbsever.getPreparedStatement().execute();
                
                try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
                try { dbsever.getConnection().close(); } catch (Exception e) {  }
            }
            catch(Exception epx){return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, p10_packinf.getP12_pakageguid());}
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1011, p10_packinf.getP12_pakageguid());  
       }
        
       int LpuResponceCode = 0;
       
       try
       {
            String inputLine, XmlString = "";

            if(quer_type == 1)
            {
                while ((inputLine = in.readLine()) != null) XmlString += inputLine;
                in.close();
            }
            else if(quer_type == 2)
            {
                if (smtpSocket != null && os != null && is != null) 
                {
                    os.append(ParamStr); 
                    os.flush();

                    while ((inputLine = is.readLine()) != null)XmlString += inputLine;
                    
                    os.close();
                    is.close();
                    smtpSocket.close();   
                    
                }
            }
                        
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder;  
              
            builder = factory.newDocumentBuilder();  
            Document document = builder.parse( new InputSource( new StringReader(XmlString) ) );                        
            
            NodeList nList = document.getElementsByTagName("bedresponce");
            for (int temp = 0; temp < nList.getLength(); temp++) 
            {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                    Element eElement = (Element) nNode;
                    
                    LpuResponceCode = Integer.parseInt(eElement.getElementsByTagName("responcecode").item(0).getTextContent());
                }
                break;
            }
            
            /*
            LpuResponceCode:
            3004 - 310
            */
            
            _return.getR11_rsinf().setPakageGUIDSrc(p10_packinf.getP12_pakageguid());
            _return.getR11_rsinf().setR10_responcecode(LpuResponceCode);
            _return.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(2000));
            
            dbinfoupdate(LpuResponceCode, rec_id);
            
            p10_packinf.SaveResponceInfoToDB(_return, p10_packinf.getP12_pakageguid());
            
            return _return; 
        } 
        catch (Exception e) 
        {
            dbinfoupdate(3002, rec_id);
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3002, p10_packinf.getP12_pakageguid());  
        } 
    }
    //--------------------------------------------------------------------------------------------------
    public static void WriteLog(String LogMsg, String LogFile)
    {
        try {
            FileWriter writeFile3 = null;
            File logFile3 = new File(LogFile);

            writeFile3 = new FileWriter(logFile3);
            
            writeFile3.write(LogMsg);
            writeFile3.close();
        } 
        catch (IOException ex) {}
    }
    //----------------------------------------------------------------------------------------------------------------
    private void dbinfoupdate(int LpuResponceCode, int rec_id)
    {
        try
        {
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("exec wpPackageManager @ProcTP=?,@resultcode=?,@rec_id=?");
            dbsever.getPreparedStatement().setInt(1,9);
            dbsever.getPreparedStatement().setInt(2,LpuResponceCode);
            dbsever.getPreparedStatement().setInt(3,rec_id);

            dbsever.getPreparedStatement().execute();
            
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
        }
        catch(Exception ex){}
    }
    //----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------
