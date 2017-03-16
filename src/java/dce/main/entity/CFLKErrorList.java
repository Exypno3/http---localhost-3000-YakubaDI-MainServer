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
public class CFLKErrorList {
    //-----------------------------------------------------------------------------------------------------------------
    private List<CFLKError> lFLKError = new LinkedList<CFLKError>();
    private CFLKError f10_flkerror[];
    //-----------------------------------------------------------------------------------------------------------------
    public CFLKError[] getF10_flkerror() {return this.f10_flkerror;}
    public void setF10_flkerror(CFLKError[] pf10_flkerror) {this.f10_flkerror = pf10_flkerror;}
    //-----------------------------------------------------------------------------------------------------------------
    public void AddFLKError(CFLKError rFLKError)
    {
        lFLKError.add(rFLKError);
        
        if(lFLKError.size() > 0)f10_flkerror = new CFLKError[lFLKError.size()];
        
        for(int i=0; i<lFLKError.size(); ++i)
        {
            f10_flkerror[i] = lFLKError.get(i);
        }
    }
    //-----------------------------------------------------------------------------------------------------------------
}
