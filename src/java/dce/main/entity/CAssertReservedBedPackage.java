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
@XmlRootElement(name = "orderpack")
public class CAssertReservedBedPackage 
{
    private CPackageInformation p10_packinf;
    private CAssertReservedBedList p11_abl = new CAssertReservedBedList();
    //----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //----------------------------------------------------------------------------------------------------------------
    public CAssertReservedBedList getP11_abl() {return this.p11_abl;}
    public void setP11_abl(CAssertReservedBedList pp11_abl) {this.p11_abl = pp11_abl;}
    //----------------------------------------------------------------------------------------------------------------
    public void TryReservedBed()
    {
        try
        {
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("exec wpPackageManager @ProcTP=?, @PackGuidIn=?");
            dbsever.getPreparedStatement().setInt(1,10);
            dbsever.getPreparedStatement().setString(2,p10_packinf.getP12_pakageguid());
            dbsever.getPreparedStatement().execute();
            
            try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
            try { dbsever.getConnection().close(); } catch (Exception e) {  }
        }
        catch(Exception e){}
    }
    //----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------
