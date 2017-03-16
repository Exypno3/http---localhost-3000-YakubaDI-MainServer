/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dce.main.entity;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author YaluplinMD
 */
public class COrdersErrorList {
    //-----------------------------------------------------------------------------------------------------------------
    private List<COrdersFLKError> lErrorList = new LinkedList<COrdersFLKError>();
    private COrdersFLKError f10_orflker[] = null;
    //-----------------------------------------------------------------------------------------------------------------
    public COrdersFLKError[] getF10_orflker() {return this.f10_orflker;}
    public void setF10_orflker(COrdersFLKError[] pf10_orflker) {this.f10_orflker = pf10_orflker;}
    //-----------------------------------------------------------------------------------------------------------------
    public void AddErrorToList(int rnzap, CFLKError rError)
    {
        boolean isZapExists = false;
        
        for(int i=0; i<lErrorList.size(); ++i)
        {
            if(lErrorList.get(i).getF10_nzap() == rnzap)
            {
                isZapExists = true;
                lErrorList.get(i).getF11_flkerrorList().AddFLKError(rError);
                break;
            }    
        }
       
        if(isZapExists == false)
        {
            COrdersFLKError rec = new COrdersFLKError(rnzap, rError);
            lErrorList.add(rec);
        }
        
        
        if(lErrorList.size() > 0)f10_orflker = new COrdersFLKError[lErrorList.size()];
        
        for(int i=0; i<lErrorList.size(); ++i)
        {
            f10_orflker[i] = lErrorList.get(i);
        }
    }
    //-----------------------------------------------------------------------------------------------------------------
}
