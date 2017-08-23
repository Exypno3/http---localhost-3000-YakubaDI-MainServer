//------------------------------------------------------------------------------
package dce.dbserver;
//------------------------------------------------------------------------------

import dce.main.entity.IConfigConstantsList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author YaluplinMD
 */
//------------------------------------------------------------------------------
public class CDBSever {
    private java.sql.Connection Connection = null;
    private PreparedStatement PreparedStatement = null;

    public Connection getConnection() {
        return Connection;
    }

    public void setConnection(Connection Connection) {
        this.Connection = Connection;
    }

    public PreparedStatement getPreparedStatement() {
        return PreparedStatement;
    }

    public void setPreparedStatement(PreparedStatement PreparedStatement) {
        this.PreparedStatement = PreparedStatement;
    }
    
    private String QuerySTR;
    //------------------------------------------------------------------------------
    public void setQuerySTR(String pQuerySTR)
    {
        try
        {
            PreparedStatement = Connection.prepareStatement(pQuerySTR);
        }
        catch(Exception ex){
            int t = 0;
        }
    }
    //------------------------------------------------------------------------------
    public CDBSever(String LoginName, String Password)
    {
        try
        { 
            String url = "";
            File fXml=new File("c:\\ServerSetup\\connectinfo.xml");
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document doc=db.parse(fXml);
            
            doc.getDocumentElement().normalize();
                        
            NodeList nList = doc.getElementsByTagName("connectinfo");
            for (int temp = 0; temp < nList.getLength(); temp++) 
            {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                    Element eElement = (Element) nNode;
                    
                    url = eElement.getElementsByTagName("databasename").item(0).getTextContent();
                    LoginName = eElement.getElementsByTagName("username").item(0).getTextContent();
                    Password = eElement.getElementsByTagName("password").item(0).getTextContent();
                }
                break;
            }

            Class.forName(IConfigConstantsList.ConfMsgList[3]);
            Connection = DriverManager.getConnection(url, LoginName, Password);
        }
        catch(Exception ex){
            int r = 0;
        }
    }
    //------------------------------------------------------------------------------
    protected void finalize ( ) {
        try
        {
            /*if(MSSqlPreparedStatement != null)MSSqlPreparedStatement.close();
            if(MsSqlConnection != null)MSSqlPreparedStatement.close();*/
        }
        catch(Exception ex){}
    }
    //------------------------------------------------------------------------------
    public static void WriteLog(String LogMsg, String LogFile)
    {
        try {
            //FileWriter writeFile3 = null;
            File logFile3 = new File(LogFile);

            FileWriter writeFile3 = new FileWriter(logFile3);
            
            writeFile3.write(LogMsg);
            writeFile3.close();
        } 
        catch (IOException ex) {}
    }
    //------------------------------------------------------------------------------
    public static boolean IsEmptyString(String resRts)
    {
        if(resRts == null || resRts.trim().length() == 0)return true;
        
        return false;
    }
    //------------------------------------------------------------------------------
    public static int CheckUserForAccess(String rUserLogin, String rPassword, String rMessageSender)
    {
        if(rUserLogin == null || rUserLogin.length() == 0 || rPassword == null || rPassword.length() == 0 || 
                rMessageSender == null || rMessageSender.length() == 0)return 0;
        
        try
        {
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("exec wpLoginManager @ProcTP=?,@sender=?,@loginname=?,@password=?");

            dbsever.getPreparedStatement().setInt(1,1);
            dbsever.getPreparedStatement().setString(2,rMessageSender);
            dbsever.getPreparedStatement().setString(3,rUserLogin);
            dbsever.getPreparedStatement().setString(4,rPassword);

            ResultSet rs = dbsever.getPreparedStatement().executeQuery();
            while (rs.next()) 
            {
                if(rs.getInt("result") == 1)
                {
                    try { rs.close(); } catch (Exception e) {  }
                    try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
                    try { dbsever.getConnection().close(); } catch (Exception e) {  }
                    return 1;
                }
                try { rs.close(); } catch (Exception e) {  }
                try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
                try { dbsever.getConnection().close(); } catch (Exception e) {  }
                return 0;
            }
        }
        catch(Exception ex){ 
            return -1;
        }
        return -1;
    }
    //------------------------------------------------------------------------------
    public static String GetDBValue(String rUserLogin, String rPassword, String rMessageSender, String param)
    {
        if(rUserLogin == null || rUserLogin.length() == 0 || rPassword == null || rPassword.length() == 0 || 
                rMessageSender == null || rMessageSender.length() == 0)return "";
        
        try
        {
            CDBSever dbsever = new CDBSever(IConfigConstantsList.ConfMsgList[0], IConfigConstantsList.ConfMsgList[1]);
            dbsever.setQuerySTR("select isnull(parentcode,code) lpucode from rfcLPU where code='" + param + "'");

            ResultSet rs = dbsever.getPreparedStatement().executeQuery();
            while (rs.next()) 
            {
                String __res = rs.getString("lpucode");
                rs.close();
                
                try { rs.close(); } catch (Exception e) {  }
                try { dbsever.getPreparedStatement().close(); } catch (Exception e) {  }
                try { dbsever.getConnection().close(); } catch (Exception e) {  }
                
                return __res;
            }            
        }
        catch(Exception ex){ 
            return "";
        }
        return "";
    }
    //------------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
