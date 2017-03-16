/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//----------------------------------------------------------------------------------------------------------------
package dce.main.entity;

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
public class CFreeBedPackage {
    //----------------------------------------------------------------------------------------------------------------
    private CPackageInformation p10_packinf;
    private COrderLeaveHospital p11_orderleavehospital;
    //----------------------------------------------------------------------------------------------------------------
    public CFreeBedPackage()
    {
        p11_orderleavehospital = new COrderLeaveHospital();
    }
    //----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //-----------------------------------------------------------------------------------------------------------------
    public COrderLeaveHospital getP11_orderleavehospital() {return this.p11_orderleavehospital;}
    public void setP11_orderleavehospital(COrderLeaveHospital pp11_orderleavehospital) {this.p11_orderleavehospital = pp11_orderleavehospital;}
    //----------------------------------------------------------------------------------------------------------------
    public CResponceOrdersPackage TryFreeBed(CFreeBedPackage pinppack)
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
                cal.setTime(p11_orderleavehospital.getM16_dttmlv());
                
                CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
                dbsever.setQuerySTR("exec wpPackageManager @ProcTP=?,@yearcode=?, @monthcode=?, @LpuCode=?, @KpkCode=?, @resultcode=?, @PackGuidIn=?");
                dbsever.getPreparedStatement().setInt(1,8);
                dbsever.getPreparedStatement().setInt(2,cal.get(Calendar.YEAR));
                dbsever.getPreparedStatement().setInt(3, cal.get(Calendar.MONTH));
                dbsever.getPreparedStatement().setString(4, p11_orderleavehospital.getM14_modcd());
                dbsever.getPreparedStatement().setString(5, p11_orderleavehospital.getM18_kpkcd());  
                dbsever.getPreparedStatement().setInt(6, 3013); 
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
            respack.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(2000));
            
            return respack;
        }
        catch(Exception e){return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1004, p10_packinf.getP12_pakageguid());}
    }
    //----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------
