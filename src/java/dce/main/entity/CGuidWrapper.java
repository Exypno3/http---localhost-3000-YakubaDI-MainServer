/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dce.main.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YaluplinMD
 */
@XmlRootElement(name="orderpack")
public class CGuidWrapper {
    private CGuidStatusList p11_statuslist;
    
    public CGuidStatusList getP11_statuslist() {return this.p11_statuslist;}
    public void setP11_statuslist(CGuidStatusList pp11_statuslist) {this.p11_statuslist = pp11_statuslist;}
    
    public CGuidWrapper()
    {
        p11_statuslist = new CGuidStatusList();
    }
}
