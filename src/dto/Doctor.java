/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import mylib.Validation;

/**
 *
 * @author HAU NUONG MO HANH
 */
public class Doctor {
    private String doctorID;
    private String doctorName;
    private boolean sex;
    private String address;
    private String deptID;
    private Date createDate;
    private Date lastUpdateDate;

    public Doctor() {
    }

    public Doctor(String doctorID, String doctorName, boolean sex, String address, String deptID, Date createDate, Date lastUpdateDate) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.sex = sex;
        this.address = address;
        this.deptID = deptID;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void displayDoctor() {
        System.out.printf("|%-8S|%-18S|%-11S|%-18S|%-20S|%-16S|%-16S|\n", doctorID, doctorName, Validation.genderFormat(sex),address,deptID,Validation.formatDate(createDate),Validation.formatDate(lastUpdateDate));
    }
    
    
}
