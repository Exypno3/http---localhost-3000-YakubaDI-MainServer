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
public class CErrorFlkPack {
    private COrdersErrorList p10_errpack;
    
    public COrdersErrorList getP10_errpack() {return this.p10_errpack;}
    public void setP10_errpack(COrdersErrorList pp10_errpack) {this.p10_errpack = pp10_errpack;}
    
    public CErrorFlkPack()
    {
        p10_errpack = new COrdersErrorList();
    }
}