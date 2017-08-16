//------------------------------------------------------------------------------------------------------------------------------
package dce.main;
//------------------------------------------------------------------------------------------------------------------------------
import dce.main.entity.CAttachAgregateSmoMoByDate;
import dce.main.entity.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import dce.dbserver.CDBSever;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


//------------------------------------------------------------------------------------------------------------------------------
/**
 *
 * @author YaluplinMD
 */
//------------------------------------------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------------------------------------------
@WebService(serviceName = "DCExchangeSrv")
public class DCExchangeSrv {  
     @Resource WebServiceContext context;
    //------------------------------------------------------------------------------------------------------------------------------
    private String GetRemouteClientIP()
    {
        try
        {
            HttpServletRequest request = (HttpServletRequest)context.getMessageContext().get(MessageContext.SERVLET_REQUEST); 
            return request.getRemoteAddr();
        }
        catch(Exception e)
        {
            return "";
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SetLoginAccess")
    public int SetLoginAccess(@WebParam(name = "sendercode") String sendercode, @WebParam(name = "username") String username, 
                @WebParam(name = "password") String password, @WebParam(name = "oldpassword") String oldpassword)
    {
        if(sendercode.length() < 4  || sendercode == null || username.length() < 4  || username == null || password.length() < 4  || password == null)
            return -1;
    
        try
        {
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("exec wpAccessManager @ProcTP=1,@LoginName=?,@Password=?,@PasswordOld=?,@SenderCode=?");

            dbsever.getPreparedStatement().setString(1, username);
            dbsever.getPreparedStatement().setString(2, password);
            dbsever.getPreparedStatement().setString(3, oldpassword);
            dbsever.getPreparedStatement().setString(4, sendercode);

            ResultSet rs = dbsever.getPreparedStatement().executeQuery();            

            while (rs.next()) 
            {
                return rs.getInt("Result");
            }
            
            try { rs.close(); } catch (Exception e) {  }
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
        }
        catch(Exception e)
        {
            return -10;
        }
        return 1;
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "MakeTestConnect")
    @WebResult(name="retresult")
    public int MakeTestConnect()
    {
        try
        {
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("select 1 as result");

            ResultSet rs = dbsever.getPreparedStatement().executeQuery();            
            
            try { rs.close(); } catch (Exception e) {  }
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
        }
        catch(Exception e)
        {
            return 0;
        }
        
        return 1;
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetRealReservedBedList")
    @WebResult(name="orderpack")
    public COrderClinicPackage GetRealReservedBedList(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "mocode") String mocode, @WebParam(name = "kpkcode") String kpkcode, 
                    @WebParam(name = "yearcode") int yearcode, @WebParam(name = "monthcode") int monthcode){
      try{
            return null;
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetFreeKDInformation")
    @WebResult(name="orderpack")
    public CRealKDPackage GetFreeKDInformation(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "yearcode") int yearcode, @WebParam(name = "monthcode") int monthcode){
      try{
            return CPackageInformation.BuildPackage(new CRealKDPackage(), username, password, sendercode, "", "", yearcode, monthcode, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetFreeKDInformationByKPK")
    @WebResult(name="orderpack")
    public CRealKDPackage GetFreeKDInformationByKPK(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "kpkcode") String kpkcode, 
                    @WebParam(name = "yearcode") int yearcode, @WebParam(name = "monthcode") int monthcode){
      try{
            return CPackageInformation.BuildPackage(new CRealKDPackage(), username, password, sendercode, kpkcode, "", yearcode, monthcode, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetFreeKDInformationByMO")
    @WebResult(name="orderpack")
    public CRealKDPackage GetFreeKDInformationByMO(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "mocode") String mocode, 
                    @WebParam(name = "yearcode") int yearcode, @WebParam(name = "monthcode") int monthcode){
      try{
            return CPackageInformation.BuildPackage(new CRealKDPackage(), username, password, sendercode, "", mocode, yearcode, monthcode, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetFreeKDInformationByKPKMO")
    @WebResult(name="orderpack")
    public CRealKDPackage GetFreeKDInformationByKPKMO(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "mocode") String mocode, @WebParam(name = "kpkcode") String kpkcode, 
                    @WebParam(name = "yearcode") int yearcode, @WebParam(name = "monthcode") int monthcode){
      try{
            return CPackageInformation.BuildPackage(new CRealKDPackage(), username, password, sendercode, kpkcode, mocode, yearcode, monthcode, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------add 04.02.2014------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendTryFreeBed")
    @WebResult(name="orderpack")
    public CResponceOrdersPackage SendTryFreeBed(@WebParam(name = "orderpack") CFreeBedPackage pinppack,
                @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
          if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
           return pinppack.TryFreeBed(pinppack);
            
        }catch(Exception e){
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------add 04.02.2014------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendTryCancelBed")
    @WebResult(name="orderpack")
    public CResponceOrdersPackage SendTryCancelBed(@WebParam(name = "orderpack") COrderCancelBedPackage pinppack,
                @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
          if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
           return pinppack.TryCancelBed(pinppack);
            
        }catch(Exception e){
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------add 03.02.2014------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendReservedBedUrgently")
    @WebResult(name="orderpack")
    //tris method make call only HOSPITAL, add this control!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public CResponceOrdersPackage SendReservedBedUrgently(@WebParam(name = "orderpack") CReservedUrgentlyPackage pinppack,
                @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid());          
            
          
            return pinppack.TryReservedUrgentlyBed(pinppack);
            
        }catch(Exception e){
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------add 20.02.2014------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendTryAssertReservedBed")
    @WebResult(name="orderpack")
    public CResponceAssertBedPackage SendTryAssertReservedBed(@WebParam(name = "orderpack") CAssertReservedBedPackage pinppack,
                @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
        
        try
        {
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                    return CPackageInformation.CreateErrorPackage(new CResponceAssertBedPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());

             if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                    return CPackageInformation.CreateErrorPackage(new CResponceAssertBedPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());

             CResponceOrdersPackage res = pinppack.getP10_packinf().ParseOrderPackage(pinppack);
             
             CResponceAssertBedPackage _return = new CResponceAssertBedPackage();
             
             if(res.getR11_rsinf().getR10_responcecode() == 1000 || res.getR11_rsinf().getR10_responcecode() == 1001)
             {
                _return.getP10_packrespinf().getR11_rsinf().setPakageGUIDSrc(pinppack.getP10_packinf().getP12_pakageguid());
                _return.getP10_packrespinf().getR11_rsinf().setR10_responcecode(1004);
                _return.getP10_packrespinf().getR10_packinf().AddPakageInformation(new Date(), "9007",  UUID.randomUUID().toString());
                _return.getP10_packrespinf().getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1004));
                
                try
                {
                   if(res.getR12_orerl().getF10_orflker().length > 0)
                   {
                       _return.getP10_packrespinf().getR12_orerl().setF10_orflker(res.getR12_orerl().getF10_orflker());

                       return _return;
                   }
                }
                catch(Exception e){}
                
                return _return;
             }            
             
              try
              {
                if(res.getR12_orerl().getF10_orflker().length > 0)
                {
                    _return.getP10_packrespinf().getR12_orerl().setF10_orflker(res.getR12_orerl().getF10_orflker());

                    return _return;
                }
              }
              catch(Exception e){}
             
             pinppack.TryReservedBed();
             
             CRecWrapper _ret = CPackageInformation.BuildPackage(new CRecWrapper(), username, password, sendercode, "", "", 0, 0, 
                     pinppack.getP10_packinf().getP12_pakageguid(), null, 0, 0, 0);
         
            _return.setP11_statuslist(_ret.getP11_statuslist());
             
             return _return;
             
         }catch(Exception e){
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceAssertBedPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------add 20.02.2014------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetReservedBedStatus")
    @WebResult(name="orderpack")
    public CResponceReservedStatusPackage GetReservedBedStatus(@WebParam(name = "orderpack") COrderReservedStatusPackage pinppack,
                @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
          if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceReservedStatusPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
         if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceReservedStatusPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
                  
         CResponceOrdersPackage res = pinppack.getP10_packinf().ParseOrderPackage(pinppack);
         CResponceReservedStatusPackage _return = new CResponceReservedStatusPackage();
         try
         {
            if(res.getR12_orerl().getF10_orflker().length > 0)
            {
                _return.getP10_packrespinf().getR11_rsinf().setPakageGUIDSrc(pinppack.getP10_packinf().getP12_pakageguid());
                _return.getP10_packrespinf().getR11_rsinf().setR10_responcecode(1004);
                _return.getP10_packrespinf().getR10_packinf().AddPakageInformation(new Date(), "9007",  UUID.randomUUID().toString());
                _return.getP10_packrespinf().getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1004));
                
                _return.getP10_packrespinf().getR12_orerl().setF10_orflker(res.getR12_orerl().getF10_orflker());
                
                return _return;
            }
         }
         catch(Exception e){}
         
         CGuidWrapper _ret = CPackageInformation.BuildPackage(new CGuidWrapper(), username, password, sendercode, "", "", 0, 0, 
                 pinppack.getP10_packinf().getP12_pakageguid(), null, 0, 0, 0);
         
         if(_ret.getP11_statuslist().getG10_guitst() == null)
         {
             _return.getP10_packrespinf().getR11_rsinf().setR10_responcecode(1008);
             _return.getP10_packrespinf().getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1008));
         }
         
         _return.setP11_statuslist(_ret.getP11_statuslist());
         
         return _return;
            
        }catch(Exception e){
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceReservedStatusPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------add 03.02.2014------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendTryReservedBed")
    @WebResult(name="orderpack")
    public CResponceOrdersPackage SendTryReservedBed(@WebParam(name = "orderpack") COrderReservedPackage pinppack,
                @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
          if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
          return pinppack.TryReservedBed(pinppack);
            
        }catch(Exception e){
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------add 03.02.2014------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetKDInformationByKPKMO")
    @WebResult(name="orderpack")
    public CKDInformationPackage GetKDInformationByKPKMO(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "mocode") String mocode, @WebParam(name = "kpkcode") String kpkcode){
      try{
            return CPackageInformation.BuildPackage(new CKDInformationPackage(), username, password, sendercode, kpkcode, mocode, 0, 0, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetKDInformationByMO")
    @WebResult(name="orderpack")
    public CKDInformationPackage GetKDInformationByMO(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "mocode") String mocode){
      try{
            return CPackageInformation.BuildPackage(new CKDInformationPackage(), username, password, sendercode, "", mocode, 0, 0, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetKDInformationByKpk")
    @WebResult(name="orderpack")
    public CKDInformationPackage GetKDInformationByKpk(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "kpkcode") String kpkcode){
      try{
            return CPackageInformation.BuildPackage(new CKDInformationPackage(), username, password, sendercode, kpkcode, "", 0, 0, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetKDInformationPDG")
    @WebResult(name="orderpack")
    public CKDInformationPackage GetKDInformationPDG(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new CKDInformationPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 1, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetKDInformationLDS")
    @WebResult(name="orderpack")
    public CKDInformationPackage GetKDInformationLDS(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new CKDInformationPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetKDInformation")
    @WebResult(name="orderpack")
    public CKDInformationPackage GetKDInformation(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode){
        try
        {
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("select 1 as result, " + username + "," + sendercode);

            ResultSet rs = dbsever.getPreparedStatement().executeQuery();            
            
            try { rs.close(); } catch (Exception e) {  }
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
        }
        catch(Exception e)
        {
            return null;
        }
        
      try{
            return CPackageInformation.BuildPackage(new CKDInformationPackage(), username, password, sendercode, "", "", 0, 0, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetOrdersLeaveHospitalPDG")
    @WebResult(name="orderpack")
    public COrderLeaveHospitalPackage GetOrdersLeaveHospitalPDG(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new COrderLeaveHospitalPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 1, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetOrdersLeaveHospitalLDS")
    @WebResult(name="orderpack")
    public COrderLeaveHospitalPackage GetOrdersLeaveHospitalLDS(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new COrderLeaveHospitalPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetOrdersLeaveHospital")
    @WebResult(name="orderpack")
    public COrderLeaveHospitalPackage GetOrdersLeaveHospital(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode){
      try{
            return CPackageInformation.BuildPackage(new COrderLeaveHospitalPackage(), username, password, sendercode, "", "", 0, 0, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetOrdersNullificationPDG")
    @WebResult(name="orderpack")
    public COrderNullificationPackage GetOrdersNullificationPDG(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new COrderNullificationPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 1, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetOrdersNullificationLDS")
    @WebResult(name="orderpack")
    public COrderNullificationPackage GetOrdersNullificationLDS(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new COrderNullificationPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetOrdersNullification")
    @WebResult(name="orderpack")
    public COrderNullificationPackage GetOrdersNullification(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode){
      try{
            return CPackageInformation.BuildPackage(new COrderNullificationPackage(), username, password, sendercode, "", "", 0, 0, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetOrdersHospitalUrgentlyPDG")
    @WebResult(name="orderpack")
    public COrderHospitalUrgentlyPackage GetOrdersHospitalUrgentlyPDG(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new COrderHospitalUrgentlyPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 1, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetOrdersHospitalUrgentlyLDS")
    @WebResult(name="orderpack")
    public COrderHospitalUrgentlyPackage GetOrdersHospitalUrgentlyLDS(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new COrderHospitalUrgentlyPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetOrdersHospitalUrgently")
    @WebResult(name="orderpack")
    public COrderHospitalUrgentlyPackage GetOrdersHospitalUrgently(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode){
      try{
            return CPackageInformation.BuildPackage(new COrderHospitalUrgentlyPackage(), username, password, sendercode, "", "", 0, 0, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetFactOrdersHospitalPDG")
    @WebResult(name="orderpack")
    public COrderHospitalPackage GetFactOrdersHospitalPDG(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new COrderHospitalPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 1, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetFactOrdersHospitalLDS")
    @WebResult(name="orderpack")
    public COrderHospitalPackage GetFactOrdersHospitalLDS(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new COrderHospitalPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetFactOrdersHospital")
    @WebResult(name="orderpack")
    public COrderHospitalPackage GetFactOrdersHospital(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode){
      try{
            return CPackageInformation.BuildPackage(new COrderHospitalPackage(), username, password, sendercode, "", "", 0, 0, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetPlanOrdersClinicPDG")
    @WebResult(name="orderpack")
    public COrderClinicPackage GetPlanOrdersClinicPDG(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new COrderClinicPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 1, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetPlanOrdersClinicLDS")
    @WebResult(name="orderpack")
    public COrderClinicPackage GetPlanOrdersClinicLDS(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "lastsynhdate") Date lastsynhdate){
      try{
            return CPackageInformation.BuildPackage(new COrderClinicPackage(), username, password, sendercode, "", "", 0, 0, "", lastsynhdate, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetPlanOrdersClinic")
    @WebResult(name="orderpack")
    public COrderClinicPackage GetPlanOrdersClinic(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode){
      try{
            return CPackageInformation.BuildPackage(new COrderClinicPackage(), username, password, sendercode, "", "", 0, 0, "", null, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendPlanOrdersClinic")
    @WebResult(name="responcepack")
    public CResponceOrdersPackage SendPlanOrdersClinic(@WebParam(name = "orderpack") COrderClinicPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
          if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
          return pinppack.getP10_packinf().ParseOrderPackage(pinppack);
        }catch(Exception e){
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendFactOrdersHospital")
    @WebResult(name="responcepack")
    public CResponceOrdersPackage SendFactOrdersHospital(@WebParam(name = "orderpack") COrderHospitalPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
           return pinppack.getP10_packinf().ParseOrderPackage(pinppack);
        }catch(Exception e)
        {
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendOrdersHospitalUrgently")
    @WebResult(name="responcepack")
    public CResponceOrdersPackage SendOrdersHospitalUrgently(@WebParam(name = "orderpack") COrderHospitalUrgentlyPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
            return pinppack.getP10_packinf().ParseOrderPackage(pinppack);
        }catch(Exception e){
            
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendOrdersNullification")
    @WebResult(name="responcepack")
    public CResponceOrdersPackage SendOrdersNullification(@WebParam(name = "orderpack") COrderNullificationPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
           return pinppack.getP10_packinf().ParseOrderPackage(pinppack);
        }catch(Exception e){
            
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendOrdersLeave")
    @WebResult(name="responcepack")
    public CResponceOrdersPackage SendOrdersLeave(@WebParam(name = "orderpack") COrderLeaveHospitalPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
            return pinppack.getP10_packinf().ParseOrderPackage(pinppack);
        }catch(Exception e){
            
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendKDInformation")
    @WebResult(name="responcepack")
    public CResponceOrdersPackage SendKDInformation(@WebParam(name = "orderpack") CKDInformationPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
            return pinppack.getP10_packinf().ParseOrderPackage(pinppack);
        }catch(Exception e){
            
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    /*приписное*/
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetAttachInformation")/*ok*/
    @WebResult(name="responcepack")
    public CResponceAttachPackage GetAttachInformation(@WebParam(name = "orderpack") CAttachInformationPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
        try{
              if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());

              if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());

              int _res = CDBSever.CheckUserForAccess(username, password, sendercode);

              if(_res == 0)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
              else if(_res == -1)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid());

              /*try
              {
                  if(pinppack.getP10_packinf().getP11_pakagesender().equals("9007"))
                  {
                        CPackageInformation.WriteLog(pinppack.getP11_pr().getA19_pbd().toString(), "D:\\e2.txt");
                        CPackageInformation.WriteLog(pinppack.getP10_packinf().getP10_pakagedate().toString(), "D:\\e3.txt");
                  }
              }
              catch(Exception eee){}*/
              
              return pinppack.TryGetPrikInformation(pinppack);

          }catch(Exception e)
          {
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 9999, pinppack.getP10_packinf().getP12_pakageguid()), 
                pinppack.getP10_packinf().getP12_pakageguid());

            return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 9999, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    /*МИАЦ передаёт список врачей по ЛПУ*/
    @WebMethod(operationName = "SendAttachDoctorInformation")/*ok*/
    @WebResult(name="responcepack")
    public CResponceAttachPackage SendAttachDoctorInformation(@WebParam(name = "orderpack") CAttachDoctorPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
        try{
                /*ТОЛЬКО ДЛЯ МИАЦ всех остальных return*/
            
              if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());

              if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());

              int _res = CDBSever.CheckUserForAccess(username, password, sendercode);

              if(_res == 0)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
              else if(_res == -1)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid());

              return pinppack.TryAttachDoctorInformation(pinppack);

          }catch(Exception e)
          {
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 9999, pinppack.getP10_packinf().getP12_pakageguid()), 
                pinppack.getP10_packinf().getP12_pakageguid());

            return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 9999, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    /*ЛПУ передаёт список участков по СНИЛС*/
    @WebMethod(operationName = "SendAttachDoctorSectionInformation")/*ok*/
    @WebResult(name="responcepack")
    public CResponceAttachPackage SendAttachDoctorSectionInformation(@WebParam(name = "orderpack") CAttachDoctorSectionPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
        try{
                /*ТОЛЬКО ДЛЯ МИАЦ всех остальных return*/
            
              if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());

              if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());

              int _res = CDBSever.CheckUserForAccess(username, password, sendercode);

              if(_res == 0)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
              else if(_res == -1)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid());

              return pinppack.TryAttachDoctorSectionInformation(pinppack);

          }catch(Exception e)
          {
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 9999, pinppack.getP10_packinf().getP12_pakageguid()), 
                pinppack.getP10_packinf().getP12_pakageguid());

            return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 9999, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    /*@WebMethod(operationName = "GetAttachDoctorInformation")
    @WebResult(name="orderpack")
    public CAttachDoctorPackage GetAttachDoctorInformation(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "mocode") String mocode){
      try{
            return CPackageInformation.BuildPackage(new CAttachDoctorPackage(), username, password, sendercode, "", mocode, 0, 0, "", null, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }*/
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "MakeAttachAction")/*ok*/
    @WebResult(name="orderpack")
    public CResponceAttachPackage MakeAttachAction(@WebParam(name = "orderpack") CAttachPersonPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());

            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());

            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);

            if(_res == 0)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(pinppack.getP11_atachlist().getL10_orcl().length > 2500)
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5001, pinppack.getP10_packinf().getP12_pakageguid());
            
            /*if(pinppack.getP11_atachlist().getL10_orcl().length > 1 && !pinppack.getP10_packinf().getP11_pakagesender().equals("15001")
                     && !pinppack.getP10_packinf().getP11_pakagesender().equals("15003")
                     && !pinppack.getP10_packinf().getP11_pakagesender().equals("15564"))
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5001, pinppack.getP10_packinf().getP12_pakageguid());*/
            
            if(pinppack.getP11_atachlist().getL10_orcl()[0].getP13_orcl().length > 2500)
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5001, pinppack.getP10_packinf().getP12_pakageguid());
            
            /*if(pinppack.getP11_atachlist().getL10_orcl()[0].getP13_orcl().length > 1 && !pinppack.getP10_packinf().getP11_pakagesender().equals("15001")
                     && !pinppack.getP10_packinf().getP11_pakagesender().equals("15003")
                     && !pinppack.getP10_packinf().getP11_pakagesender().equals("15564")
                    )
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5001, pinppack.getP10_packinf().getP12_pakageguid());*/
            
            if(CDBSever.IsEmptyString(pinppack.getP11_atachlist().getL10_orcl()[0].getP11_mocd()))
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5002, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP11_atachlist().getL10_orcl()[0].getP11_mocd().equals(pinppack.getP10_packinf().getP11_pakagesender()))
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5002, pinppack.getP10_packinf().getP12_pakageguid());
            
            return pinppack.TryAttachAction(0);
            
        }catch(Exception e){
            return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 9999, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "MakeDeAttachActionCancel")/*ok*/
    @WebResult(name="orderpack")
    public CResponceAttachPackage MakeDeAttachActionCancel(@WebParam(name = "orderpack") CAttachPersonPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());

            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());

            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);

            if(_res == 0)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(pinppack.getP11_atachlist().getL10_orcl().length > 2500)
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5001, pinppack.getP10_packinf().getP12_pakageguid());
            
            /*if(pinppack.getP11_atachlist().getL10_orcl().length > 1 && !pinppack.getP10_packinf().getP11_pakagesender().equals("15001")
                     && !pinppack.getP10_packinf().getP11_pakagesender().equals("15003")
                     && !pinppack.getP10_packinf().getP11_pakagesender().equals("15564"))
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5001, pinppack.getP10_packinf().getP12_pakageguid());*/
            
            if(pinppack.getP11_atachlist().getL10_orcl()[0].getP13_orcl().length > 2500)
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5001, pinppack.getP10_packinf().getP12_pakageguid());
            
            /*if(pinppack.getP11_atachlist().getL10_orcl()[0].getP13_orcl().length > 1 && !pinppack.getP10_packinf().getP11_pakagesender().equals("15001")
                     && !pinppack.getP10_packinf().getP11_pakagesender().equals("15003")
                     && !pinppack.getP10_packinf().getP11_pakagesender().equals("15564")
                    )
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5001, pinppack.getP10_packinf().getP12_pakageguid());*/
            
            if(CDBSever.IsEmptyString(pinppack.getP11_atachlist().getL10_orcl()[0].getP11_mocd()))
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5002, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP11_atachlist().getL10_orcl()[0].getP11_mocd().equals(pinppack.getP10_packinf().getP11_pakagesender()))
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5002, pinppack.getP10_packinf().getP12_pakageguid());
            
            return pinppack.TryAttachAction(121);
            
        }catch(Exception e){
            return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 9999, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "MakeDeAttachAction")
    @WebResult(name="orderpack")
    public CResponceAttachPackage MakeDeAttachAction(@WebParam(name = "orderpack") CDeAttachPersonPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());

            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());

            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);

            if(_res == 0)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid());
          
            if(pinppack.getP11_deatachlist().getL10_orcl().length > 2500)
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5001, pinppack.getP10_packinf().getP12_pakageguid());
            
            /*if(pinppack.getP11_deatachlist().getL10_orcl().length > 1 && !pinppack.getP10_packinf().getP11_pakagesender().equals("15001")
                     && !pinppack.getP10_packinf().getP11_pakagesender().equals("15003")
                     && !pinppack.getP10_packinf().getP11_pakagesender().equals("15564"))
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5001, pinppack.getP10_packinf().getP12_pakageguid());*/
            
            if(CDBSever.IsEmptyString(pinppack.getP11_deatachlist().getL10_orcl()[0].getP15_mo()))
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5002, pinppack.getP10_packinf().getP12_pakageguid());
            
            //if(!pinppack.getP11_deatachlist().getL10_orcl()[0].getP15_mo().equals(pinppack.getP10_packinf().getP11_pakagesender()))
            if(!CDBSever.GetDBValue(username, password, sendercode, pinppack.getP11_deatachlist().getL10_orcl()[0].getP15_mo()).
                    equals(CDBSever.GetDBValue(username, password, sendercode, pinppack.getP10_packinf().getP11_pakagesender())))
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5003, pinppack.getP10_packinf().getP12_pakageguid());
            
            return pinppack.TryDeAttachAction();
            
        }catch(Exception e){
            return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 9999, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    /*Списки для открепления*/
    @WebMethod(operationName = "GetQueryForDeAttachForMO")
    @WebResult(name="orderpack")
    public CDeAttachQueryForMOPackage GetQueryForDeAttachForMO(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "synhdate") Date synhdate){
      try{
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DATE, - 10);
            
            if(synhdate == null || cal.getTime().compareTo(synhdate) != -1)
                return CPackageInformation.CreateErrorPackage(new CDeAttachQueryForMOPackage(), 1013, "");
          
            return CPackageInformation.BuildPackage(new CDeAttachQueryForMOPackage(), username, password, sendercode, "", "", 0, 0, "", synhdate, 1, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendQueryForDeAttachForMO")
    @WebResult(name="orderpack")
    public CResponceAttachPackage SendQueryForDeAttachForMO(@WebParam(name = "orderpack") CDeAttachQueryForMOPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());

            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());

            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);

            if(_res == 0)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid());
          
            if(pinppack.getP11_list().getP_10orcl().length > 2500)
                return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 5001, pinppack.getP10_packinf().getP12_pakageguid());
            
            
            return pinppack.LoadListToDB();
            
        }catch(Exception e){
            return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 9999, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    /*Список открепившихся на дату до текущей*/
    @WebMethod(operationName = "GetDeAttachByDate")
    @WebResult(name="orderpack")
    public CDeAttachPersonPackage GetDeAttachByDate(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "controldate") Date controldate){
      try{
            return CPackageInformation.BuildPackage(new CDeAttachPersonPackage(), username, password, sendercode, "", "", 0, 0, "", controldate, 1, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    /*Списки прикрепленных по диапазонам*/
    @WebMethod(operationName = "GetAttachListByRange")
    @WebResult(name="orderpack")
    public CAttachPersonListPackage GetAttachListByRange(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "startid") int startid, @WebParam(name = "isadres") int isadres){
      try{
            return CPackageInformation.BuildPackage(new CAttachPersonListPackage(), username, password, sendercode, "", "", 0, 0, "", null, 1, startid, isadres);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    /*Списки прикрепленных по диапазонам acts*/
    @WebMethod(operationName = "GetAttachListByRangeAct")
    @WebResult(name="orderpack")
    public CAttachPersonListPackage GetAttachListByRangeAct(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "startid") int startid, @WebParam(name = "monthact") int monthact, 
                        @WebParam(name = "yearact") int yearact){
      try{
            if(yearact<2016 || yearact > 2020 || monthact < 1 || monthact > 12)
                return CPackageInformation.CreateErrorPackage(new CAttachPersonListPackage(), 1013, "");
          
            return CPackageInformation.BuildPackage(new CAttachPersonListPackage(), username, password, sendercode, "", "", yearact, monthact, "", null, 1, startid, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    /*сведения о последнем прикреплении умерших*/
    @WebMethod(operationName = "GetAttachListByRangeDead")
    @WebResult(name="orderpack")
    public CAttachPersonListPackage GetAttachListByRangeDead(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "startid") int startid){
      try{
            
            return CPackageInformation.BuildPackage(new CAttachPersonListPackage(), username, password, sendercode, "", "", 0, 0, "", null, 100, startid, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    /*Статистика по прикреплению СМО-МО на дату*/
    @WebMethod(operationName = "GetAttachAgregateSmoMoByDate")
    @WebResult(name="orderpack")
    public CAttachAgregateSmoMoByDate GetAttachAgregateSmoMoByDate(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
                    @WebParam(name = "sendercode") String sendercode, @WebParam(name = "params") CAttachReportParam params){
      try{
            return CPackageInformation.MakeReport(new CAttachAgregateSmoMoByDate(), params, 1, username, password, sendercode);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "SendAttachMoStreetSection")/*ok*/
    @WebResult(name="orderpack")
    public CResponceAttachPackage SendAttachMoStreetSection(@WebParam(name = "orderpack") CAttachMoStreetSectionPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());

            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                  return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());

            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);

            return pinppack.ProcessSendAttachMoStreetSection();
            
        }catch(Exception e){
            return CPackageInformation.CreateErrorPackage(new CResponceAttachPackage(), 9999, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "GetAttachMoStreetSection")/*ok*/
    @WebResult(name="orderpack")
    public CAttachMoStreetSectionPackage GetAttachMoStreetSection(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
            @WebParam(name = "sendercode") String sendercode){
      try{
            return CPackageInformation.BuildPackage(new CAttachMoStreetSectionPackage(), username, password, sendercode, "", "", 0, 0, "", null, 1, 0, 0);
            
        }catch(Exception e){
            return null;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "getEvPlanQtys")
    @WebResult(name="orderpack")
    public CevPlanQtysPackage getEvPlanQtys(@WebParam(name = "username") String username, @WebParam(name = "password") String password, 
            @WebParam(name = "sendercode") String sendercode, @WebParam(name = "year") int year) {
      try{
            return CPackageInformation.evGetPackage(new CevPlanQtysPackage(), username, password, sendercode, year, 0, 0);
            
        }catch(Exception e){
            return null;
        }    
    }

    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "getEvContacts")
    @WebResult(name="orderpack")
    public CevContactsPackage getEvContacts(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode) {
      try{
            return CPackageInformation.evGetPackage(new CevContactsPackage(), username, password, sendercode, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }    
    }

    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "getEvPlanDates")
    @WebResult(name="orderpack")
    public CevPlanDatesPackage getEvPlanDates(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode) {
      try{
            return CPackageInformation.evGetPackage(new CevPlanDatesPackage(), username, password, sendercode, 0, 0, 0);
            
        }catch(Exception e){
            return null;
        }    
    }
    
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "getEvPlanList")
    @WebResult(name="orderpack")
    public CevPlanListPackage getEvPlanList(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode, 
                @WebParam(name = "year") int year, @WebParam(name = "mnth") int mnth, @WebParam(name = "page") int page) {
      try{
            return CPackageInformation.evGetPackage(new CevPlanListPackage(), username, password, sendercode, year, mnth, page);

            
        }catch(Exception e){
            return null;
        }    
    }

    

    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "putEvContacts")
    @WebResult(name="responcepack")
    public CResponceOrdersPackage putEvContacts(@WebParam(name = "orderpack") CevContactsPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
            return pinppack.getP10_packinf().evPutPackage(pinppack);
        }catch(Exception e){
            
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "putEvPlanDates")
    @WebResult(name="responcepack")
    public CResponceOrdersPackage putEvPlanDates(@WebParam(name = "orderpack") CevPlanDatesPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
            return pinppack.getP10_packinf().evPutPackage(pinppack);
        }catch(Exception e){
            
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    @WebMethod(operationName = "putEvPlanList")
    @WebResult(name="responcepack")
    public CResponceOrdersPackage putEvPlanList(@WebParam(name = "orderpack") CevPlanListPackage pinppack,
            @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "sendercode") String sendercode){
      try{
            if(pinppack.getP10_packinf().getP12_pakageguid().length() < 10 || pinppack.getP10_packinf().getP12_pakageguid() == null)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1005, pinppack.getP10_packinf().getP12_pakageguid());
            
            if(!pinppack.getP10_packinf().getP11_pakagesender().equals(sendercode))
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1006, pinppack.getP10_packinf().getP12_pakageguid());
          
            int _res = CDBSever.CheckUserForAccess(username, password, sendercode);
            
            if(_res == 0)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1002, pinppack.getP10_packinf().getP12_pakageguid()); 
            else if(_res == -1)
                return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, pinppack.getP10_packinf().getP12_pakageguid()); 
          
            return pinppack.getP10_packinf().evPutPackage(pinppack);
        }catch(Exception e){
            
            pinppack.getP10_packinf().SaveResponceInfoToDB(CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid()), 
                    pinppack.getP10_packinf().getP12_pakageguid());
            
            return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1003, pinppack.getP10_packinf().getP12_pakageguid());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    
    
}
//------------------------------------------------------------------------------------------------------------------------------