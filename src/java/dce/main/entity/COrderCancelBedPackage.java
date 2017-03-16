/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
//----------------------------------------------------------------------------------------------------------------

import dce.dbserver.CDBSever;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YaluplinMD
 */
//----------------------------------------------------------------------------------------------------------------
@XmlRootElement(name="orderpack")
public class COrderCancelBedPackage {
    //----------------------------------------------------------------------------------------------------------------
    private CPackageInformation p10_packinf;
    private COrderNullification p11_ordernullification;
    //----------------------------------------------------------------------------------------------------------------
    public COrderCancelBedPackage()
    {
        p11_ordernullification = new COrderNullification();
    }
    //----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //-----------------------------------------------------------------------------------------------------------------
    public COrderNullification getP11_ordernullification() {return this.p11_ordernullification;}
    public void setP11_ordernullification(COrderNullification pp11_ordernullification) {this.p11_ordernullification = pp11_ordernullification;}
    //----------------------------------------------------------------------------------------------------------------
    public CResponceOrdersPackage TryCancelBed(COrderCancelBedPackage pinppack)
    {
        try
        {
            int result_cd = 0;
            CResponceOrdersPackage respack = p10_packinf.ParseOrderPackage(pinppack);
            
            if(respack.getR11_rsinf().getR10_responcecode() == 1 || respack.getR11_rsinf().getR10_responcecode() == 2)
            {
                respack.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1004));
                return respack;
            }
            
            try
            {
                Calendar cal = Calendar.getInstance();
                cal.setTime(p11_ordernullification.getM17_dtph());
                
                CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
                dbsever.setQuerySTR("exec wpPackageManager @ProcTP=?,@yearcode=?, @monthcode=?, @LpuCode=?, @KpkCode=?, @resultcode=?, @PackGuidIn=?");
                dbsever.getPreparedStatement().setInt(1,6);
                dbsever.getPreparedStatement().setInt(2,cal.get(Calendar.YEAR));
                dbsever.getPreparedStatement().setInt(3, cal.get(Calendar.MONTH));
                dbsever.getPreparedStatement().setString(4, p11_ordernullification.getM18_lpucode());
                dbsever.getPreparedStatement().setString(5, p11_ordernullification.getM19_kpkcd());  
                dbsever.getPreparedStatement().setInt(6, 3012); 
                dbsever.getPreparedStatement().setString(7, p10_packinf.getP12_pakageguid());

                ResultSet rs = dbsever.getPreparedStatement().executeQuery();
                
                while (rs.next()) 
                {
                    result_cd = rs.getInt("result");

                    break;        
                }
              
                try { rs.close(); } catch (Exception e) {  }
                try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
                try { dbsever.getConnection().close(); } catch (Exception e) {  }
                
            }
            catch(Exception ex){return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, p10_packinf.getP12_pakageguid());}
            
            respack.getR11_rsinf().setR10_responcecode(result_cd); 
            respack.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(result_cd));
            
            return respack;
        }
        catch(Exception e){return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1004, p10_packinf.getP12_pakageguid());}
    }
    //----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------
