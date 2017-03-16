/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-----------------------------------------------------------------------------------------------------------------
package dce.main.entity;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author YaluplinMD
 */
//-----------------------------------------------------------------------------------------------------------------
@XmlRootElement(name="orderpack")
public class COrderClinicPackage {
    private CPackageInformation p10_packinf;
    private COrderClinicList p11_ordercliniclist;
    //-----------------------------------------------------------------------------------------------------------------
    public COrderClinicPackage()
    {
        p11_ordercliniclist = new COrderClinicList();
    }
    //-----------------------------------------------------------------------------------------------------------------
    public CPackageInformation getP10_packinf() {return this.p10_packinf;}
    public void setP10_packinf(CPackageInformation pp10_packinf) {this.p10_packinf = pp10_packinf;}
    //-----------------------------------------------------------------------------------------------------------------
    public COrderClinicList getP11_ordercliniclist() {return this.p11_ordercliniclist;}
    public void setP11_ordercliniclist(COrderClinicList pp11_OrderClinicList) {this.p11_ordercliniclist = pp11_OrderClinicList;}
    //------------------------------------------------------------------------------------------------------------------------------
    /*public void ParseDatesStructure(CResponceOrdersPackage _return)
    {
        LinkedList<Integer> listNzap = new LinkedList<Integer>();
        LinkedList<String> listOrdersNum = new LinkedList<String>();
        
        if(p11_ordercliniclist.getL10_orcl().length == 0)
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
        ContrFL.add("pph");
        
        try
        {
                                JAXBContext context = JAXBContext.newInstance(dce.main.entity.COrderClinicPackage.class);
        
                                Marshaller m = context.createMarshaller();
                                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                                //dce.main.entity.COrderClinicPackage el = new dce.main.entity.COrderClinicPackage();
                                //el.setL10_orcl(p11_ordercliniclist.getL10_orcl());

                                StringWriter sw = new StringWriter();
                                m.marshal(this, sw);

                                Unmarshaller um = context.createUnmarshaller();
                                String s = sw.toString();

                                System.out.println(s);

                                FileWriter writeFile = null;
                                
                                File logFile = new File("D:\\LISTSS.txt");
                                try {
                                    writeFile = new FileWriter(logFile);
                                } catch (IOException ex) {}
                                writeFile.write(s);
                                writeFile.close();
                                
                                
                                String userName = "sa";
                                String password = "ghjvtntq12345";

                                String url = "jdbc:sqlserver://S-DB2\\DB2SQL2008;databaseName=ExchDB";

                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                Connection conn = DriverManager.getConnection(url, userName, password);
                                System.out.println("connected");
                                //Statement statement = conn.createStatement();

                                String queryString = "exec wpPackageManager @ProcTP=?,@Package=?";

                                PreparedStatement pstm = conn.prepareStatement(queryString);
                                pstm.setInt(1,1);
                                pstm.setString(2,s);

                                ResultSet rs = pstm.executeQuery();
                                while (rs.next()) {
                                   System.out.println(rs.getString(1));
                                }
                                
        }
        catch(Exception e){}
        
        
        
        for(int i = 0; i < p11_ordercliniclist.getL10_orcl().length; ++i)
        {
            CheckNzap(_return, listNzap, p11_ordercliniclist.getL10_orcl()[i]);
            
            CheckOrnm(_return, listOrdersNum, p11_ordercliniclist.getL10_orcl()[i]);
            
            CheckOrdt(_return, p11_ordercliniclist.getL10_orcl()[i]);
            
            CheckOrtp(_return, p11_ordercliniclist.getL10_orcl()[i]);
            
            CheckMoscd(_return, p11_ordercliniclist.getL10_orcl()[i]);
            CheckModcd(_return, p11_ordercliniclist.getL10_orcl()[i]);            
                        
            p11_ordercliniclist.getL10_orcl()[i].getM16_pr().CheckPersonStructure(_return, p11_ordercliniclist.getL10_orcl()[i], 
                    ContrFL, p11_ordercliniclist.getL10_orcl()[i].getM16_pr());
            
            CheckMKBX(_return, p11_ordercliniclist.getL10_orcl()[i]);
            CheckKPK(_return, p11_ordercliniclist.getL10_orcl()[i]);
            CheckSection(_return, p11_ordercliniclist.getL10_orcl()[i]);
            CheckDocTabNumber(_return, p11_ordercliniclist.getL10_orcl()[i]);
            CheckHospDate(_return, p11_ordercliniclist.getL10_orcl()[i]);
            
            listNzap.add(p11_ordercliniclist.getL10_orcl()[i].getM10_nzap());
            listOrdersNum.add(p11_ordercliniclist.getL10_orcl()[i].getM11_ornm());
        }
    }*/
    //------------------------------------------------------------------------------------------------------------------------------
    /*private void CheckHospDate(CResponceOrdersPackage _return, COrderClinic OrderClinic)
    {
        if(OrderClinic.getM22_dtph() == null)
        {
             _return.AddErrorToRecord(OrderClinic, _return, "221", 41);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckDocTabNumber(CResponceOrdersPackage _return, COrderClinic OrderClinic)
    {
        if(OrderClinic.getM21_dcnm() == null || OrderClinic.getM21_dcnm().length() != 5)
        {
            _return.AddErrorToRecord(OrderClinic, _return, "220", 40);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckSection(CResponceOrdersPackage _return, COrderClinic OrderClinic)
    {
        if(OrderClinic.getM20_sccd() == null || OrderClinic.getM20_sccd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "219", 39);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckKPK(CResponceOrdersPackage _return, COrderClinic OrderClinic)
    {
        if(OrderClinic.getM19_kpkcd() == null || OrderClinic.getM19_kpkcd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "218", 38);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckMKBX(CResponceOrdersPackage _return, COrderClinic OrderClinic)
    {
        if(OrderClinic.getM18_mkbcd() == null || OrderClinic.getM18_mkbcd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "217", 37);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckModcd(CResponceOrdersPackage _return, COrderClinic OrderClinic)
    {
        if(OrderClinic.getM15_modcd() == null || OrderClinic.getM15_modcd().length() != 5) 
        {
            _return.AddErrorToRecord(OrderClinic, _return, "205", 25);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckMoscd(CResponceOrdersPackage _return, COrderClinic OrderClinic)
    {
        if(OrderClinic.getM14_moscd() == null || OrderClinic.getM14_moscd().length() != 5)
        {
            _return.AddErrorToRecord(OrderClinic, _return, "204", 24);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckOrtp(CResponceOrdersPackage _return, COrderClinic OrderClinic)
    {
        if(OrderClinic.getM13_ortp() < 1 || OrderClinic.getM13_ortp() > 2)
        {
            _return.AddErrorToRecord(OrderClinic, _return, "203", 23);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckOrdt(CResponceOrdersPackage _return, COrderClinic OrderClinic)
    {
        if(OrderClinic.getM12_ordt() == null)
        {
            _return.AddErrorToRecord(OrderClinic, _return, "202", 22);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private void CheckNzap(CResponceOrdersPackage _return, LinkedList<Integer> listNzap, COrderClinic OrderClinic)
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
    private void CheckOrnm(CResponceOrdersPackage _return, LinkedList<String> listOrdersNum, COrderClinic OrderClinic)
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
//-----------------------------------------------------------------------------------------------------------------
