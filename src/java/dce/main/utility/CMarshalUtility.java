/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//-------------------------------------------------------------------------------
package dce.main.utility;

//import dce.main.entity.*;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
//import javax.xml.bind.Unmarshaller;

/**
 *
 * @author YaluplinMD
 */
//-------------------------------------------------------------------------------
public class CMarshalUtility {
    //-------------------------------------------------------------------------------
    public<T> String GetMarshlStr(T param)
    {
        String Result = "";
        try
        {
            JAXBContext context = null;
            if("dce.main.entity.COrderClinicPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.COrderClinicPackage.class);
            }
            else if("dce.main.entity.COrderHospitalPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.COrderHospitalPackage.class);
            }
            else if("dce.main.entity.COrderHospitalUrgentlyPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.COrderHospitalUrgentlyPackage.class);
            }
            else if("dce.main.entity.COrderLeaveHospitalPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.COrderLeaveHospitalPackage.class);
            }
            else if("dce.main.entity.COrderNullificationPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.COrderNullificationPackage.class);
            }
            else if("dce.main.entity.CKDInformationPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CKDInformationPackage.class);
            }
            else if("dce.main.entity.CRealKDPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CRealKDPackage.class);
            }
            else if("dce.main.entity.CFreeBedPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CFreeBedPackage.class);
            }
            else if("dce.main.entity.COrderCancelBedPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.COrderCancelBedPackage.class);
            }
            else if("dce.main.entity.CReservedUrgentlyPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CReservedUrgentlyPackage.class);
            }
            else if("dce.main.entity.COrderReservedPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.COrderReservedPackage.class);
            }
            else if("dce.main.entity.COrderReservedStatusPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.COrderReservedStatusPackage.class);
            }
            else if("dce.main.entity.CAssertReservedBedPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CAssertReservedBedPackage.class);
            }
            else if("dce.main.entity.CAttachInformationPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CAttachInformationPackage.class);
            }
            else if("dce.main.entity.CAttachDoctorPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CAttachDoctorPackage.class);
            }            
            else if("dce.main.entity.CAttach".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CAttach.class);
            }
            else if("dce.main.entity.CAttachPersonPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CAttachPersonPackage.class);
            }
            else if("dce.main.entity.CDeAttachPersonPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CDeAttachPersonPackage.class);
            }
            else if("dce.main.entity.CAttachCommonPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CAttachCommonPackage.class);
            }
            else if("dce.main.entity.CAttachDoctorSectionPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CAttachDoctorSectionPackage.class);
            }
            else if("dce.main.entity.CDeAttachQueryForMOPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CDeAttachQueryForMOPackage.class);
            }
            else if("dce.main.entity.CevPlanQtysPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CevPlanQtysPackage.class);
            }
            else if("dce.main.entity.CevContactsPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CevContactsPackage.class);
            }
            else if("dce.main.entity.CevPlanDatesPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CevPlanDatesPackage.class);
            }
            else if("dce.main.entity.CevPlanListPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CevPlanListPackage.class);
            }
            else if("dce.main.entity.CevFactInfosPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CevFactInfosPackage.class);
            }
            else if("dce.main.entity.CevFactExecsPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CevFactExecsPackage.class);
            }
            else if("dce.main.entity.CevFactInvcsPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CevFactInvcsPackage.class);
            }
            else if("dce.main.entity.CevUdvnStatsPackage".equals(param.getClass().getName()))
            {
                context = JAXBContext.newInstance(dce.main.entity.CevUdvnStatsPackage.class);
            }

            
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_ENCODING, "WINDOWS-1251");
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            m.marshal(param, sw);

            Result = sw.toString();
        }
        catch(Exception e){}
        
        return Result;
    }
    //---------------------------------------------------------------------------------------------------------
    
}
//-------------------------------------------------------------------------------
