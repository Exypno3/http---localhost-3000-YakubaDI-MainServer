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
public class CErrorDetailPack {
    private CErrorDetailList p10_errpack;
    
    public CErrorDetailList getP10_errpack() {return this.p10_errpack;}
    public void setP10_errpack(CErrorDetailList pp10_errpack) {this.p10_errpack = pp10_errpack;}
    
    public CErrorDetailPack()
    {
        p10_errpack = new CErrorDetailList();
    }
}
