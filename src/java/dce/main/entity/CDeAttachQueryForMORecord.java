/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dce.main.entity;

/**
 *
 * @author Администратор
 */
public class CDeAttachQueryForMORecord {
    private int m01_nzap;
    String m02_mosrc;   /*Лпу кто отправил запрос на открепление*/
    String m03_modes;   /*Лпу которому отправили запрос на открепление*/
    CPerson m04_pep;
    String m05_nntf; /*№ уведомления*/
    String m06_dntf; /*Дата уведомления*/

    public String getM05_nntf() {
        return m05_nntf;
    }

    public void setM05_nntf(String m05_nntf) {
        this.m05_nntf = m05_nntf;
    }

    public String getM06_dntf() {
        return m06_dntf;
    }

    public void setM06_dntf(String m06_dntf) {
        this.m06_dntf = m06_dntf;
    }

    public int getM01_nzap() {
        return m01_nzap;
    }

    public void setM01_nzap(int m01_nzap) {
        this.m01_nzap = m01_nzap;
    }

    public String getM02_mosrc() {
        return m02_mosrc;
    }

    public void setM02_mosrc(String m02_mosrc) {
        this.m02_mosrc = m02_mosrc;
    }

    public String getM03_modes() {
        return m03_modes;
    }

    public void setM03_modes(String m03_modes) {
        this.m03_modes = m03_modes;
    }

    public CPerson getM04_pep() {
        return m04_pep;
    }

    public void setM04_pep(CPerson m04_pep) {
        this.m04_pep = m04_pep;
    }
}
