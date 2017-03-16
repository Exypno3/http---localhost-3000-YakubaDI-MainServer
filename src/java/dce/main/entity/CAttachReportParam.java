/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Администратор
 */
@XmlRootElement(name = "params")
public class CAttachReportParam {
    private Date        d_01 = null;    
    private Date        d_02 = null;
    private String      d_03;
    private String      d_04;
    private String      d_05;
    private String      d_06;
    private int         d_07;

    public int getD_07() {
        return d_07;
    }

    public void setD_07(int d_07) {
        this.d_07 = d_07;
    }

    public Date getD_02() {
        return d_02;
    }

    public void setD_02(Date d_02) {
        if(this.d_02 == null)this.d_02=new Date(); this.d_02 = d_02;
    }

    public String getD_03() {
        return d_03;
    }

    public void setD_03(String d_03) {
        this.d_03 = d_03;
    }

    public String getD_04() {
        return d_04;
    }

    public void setD_04(String d_04) {
        this.d_04 = d_04;
    }

    public String getD_05() {
        return d_05;
    }

    public void setD_05(String d_05) {
        this.d_05 = d_05;
    }

    public String getD_06() {
        return d_06;
    }

    public void setD_06(String d_06) {
        this.d_06 = d_06;
    }

    public Date getD_01() {
        return d_01;
    }
    
    public void setD_01(Date d_01) {
        if(this.d_01 == null)this.d_01=new Date(); this.d_01 = d_01;
    }
}
