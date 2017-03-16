/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dce.main.entity;

/**
 *
 * @author YaluplinMD
 */
public class COrdersFLKError {
    private int f10_nzap;
    private CFLKErrorList f11_flkerrorList = new CFLKErrorList();
    //-----------------------------------------------------------------------------------------------------------------
    public int getF10_nzap() {return this.f10_nzap;}
    public void setF10_nzap(int pf10_nzap) {this.f10_nzap = pf10_nzap;}
    //-----------------------------------------------------------------------------------------------------------------
    public CFLKErrorList getF11_flkerrorList() {return this.f11_flkerrorList;}
    public void setF11_flkerrorList(CFLKErrorList pf11_flkerrorList) {this.f11_flkerrorList = pf11_flkerrorList;}
    //-----------------------------------------------------------------------------------------------------------------
    public COrdersFLKError(){}
    //-----------------------------------------------------------------------------------------------------------------
    public COrdersFLKError(int rnzap, CFLKError rCFLKError)
    {
        f10_nzap = rnzap;
        f11_flkerrorList.AddFLKError(rCFLKError);
    }
    //-----------------------------------------------------------------------------------------------------------------
}
