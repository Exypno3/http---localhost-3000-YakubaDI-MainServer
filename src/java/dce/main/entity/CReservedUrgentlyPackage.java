/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
//-----------------------------------------------------------------------------------------------------------------

import dce.dbserver.CDBSever;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YaluplinMD
 */
//-----------------------------------------------------------------------------------------------------------------
@XmlRootElement(name="orderpack")
public class CReservedUrgentlyPackage {
     private CPackageInformation p10_packinf;
     private COrderHospitalUrgently p11_orderhospitalurgently;
     //----------------------------------------------------------------------------------------------------------------
     public CReservedUrgentlyPackage()
     {
         p11_orderhospitalurgently = new COrderHospitalUrgently();
     }
     //----------------------------------------------------------------------------------------------------------------
     public CPackageInformation getP10_packinf() {return this.p10_packinf;}
     public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
     //-----------------------------------------------------------------------------------------------------------------
     public COrderHospitalUrgently getP11_orderhospitalurgently() {return this.p11_orderhospitalurgently;}
     public void setP11_orderhospitalurgently(COrderHospitalUrgently pp11_orderhospitalurgently) {this.p11_orderhospitalurgently = pp11_orderhospitalurgently;}
     //----------------------------------------------------------------------------------------------------------------
     public CResponceOrdersPackage TryReservedUrgentlyBed(CReservedUrgentlyPackage pinppack)
     {
         try
        {
            CResponceOrdersPackage respack = p10_packinf.ParseOrderPackage(pinppack);
            
            if(respack.getR11_rsinf().getR10_responcecode() == 1 || respack.getR11_rsinf().getR10_responcecode() == 2)
            {
                respack.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(1004));
                return respack;
            }
            
            try
            {
                Calendar cal = Calendar.getInstance();
                cal.setTime(p11_orderhospitalurgently.getM12_dttmfh());
                
                CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
                dbsever.setQuerySTR("exec wpPackageManager @ProcTP=?,@yearcode=?, @monthcode=?, @LpuCode=?, @KpkCode=?, @resultcode=?, @PackGuidIn=?");
                dbsever.getPreparedStatement().setInt(1,7);
                dbsever.getPreparedStatement().setInt(2,cal.get(Calendar.YEAR));
                dbsever.getPreparedStatement().setInt(3, cal.get(Calendar.MONTH));
                dbsever.getPreparedStatement().setString(4, p11_orderhospitalurgently.getM11_modcd());
                dbsever.getPreparedStatement().setString(5, p11_orderhospitalurgently.getM14_kpkcd());  
                dbsever.getPreparedStatement().setInt(6, 4004); 
                dbsever.getPreparedStatement().setString(7, p10_packinf.getP12_pakageguid());

                dbsever.getPreparedStatement().execute();
                
                try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
                try { dbsever.getConnection().close(); } catch (Exception e) {  }
                
            }
            catch(Exception ex){return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 3000, p10_packinf.getP12_pakageguid());}
            
            respack.getR11_rsinf().setR10_responcecode(4004); /*экстренная койка зарезервирована*/
            respack.getR11_rsinf().setResponceMessage(CMessageUtils.GetMsgByID(4004));
            
            return respack;
        }
        catch(Exception e){return CPackageInformation.CreateErrorPackage(new CResponceOrdersPackage(), 1004, p10_packinf.getP12_pakageguid());}
     }
     //----------------------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------------------------------------
