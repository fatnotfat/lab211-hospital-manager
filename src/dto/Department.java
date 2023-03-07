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
public class Department {
    private String deptID;
    private String deptName;
    private Date createDate;
    private Date lastUpdateDate;

    public Department(String deptID, String deptName, Date createDate, Date lastUpdateDate) {
        this.deptID = deptID;
        this.deptName = deptName;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Department() {
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
    
    public void displayDepartment(){
        System.out.printf("|%-8S|%-10S|%-16s|%-16s|\n",deptID,deptName,Validation.formatDate(createDate),Validation.formatDate(lastUpdateDate));
    }
    
}
