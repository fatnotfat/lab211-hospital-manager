/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import mylib.Validation;

/**
 *
 * @author HAU NUONG MO HANH
 */
public class DeptList {
    ArrayList<Department> dpList;

    public DeptList() {
        dpList = new ArrayList<>();
    }
    
    public void loadFromFile(String fName){
        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, "|");
                String deptID = stk.nextToken().toUpperCase();
                String deptName = stk.nextToken();
                String createDateStr = stk.nextToken().trim();
                String lastUpdateDateStr = stk.nextToken().trim();
                Date createDate = null;
                Date lastUpdateDate = null;
                SimpleDateFormat fomater = new SimpleDateFormat("dd/mm/yyyy");
                if (!createDateStr.equalsIgnoreCase("null")) {
                    createDate = fomater.parse(createDateStr);
                }
                if (!lastUpdateDateStr.equalsIgnoreCase("null")) {
                    lastUpdateDate = fomater.parse(lastUpdateDateStr);
                }
                Department newDept = new Department(deptID, deptName, createDate, lastUpdateDate);
                this.dpList.add(newDept);
            }
            bf.close(); fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }   
    }
    public void writeToFile(String fName){
        if(checkEmpty()){
            System.out.println("Empty list!");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Department x: dpList){
                pw.println("|" + x.getDeptID()+ "|" + x.getDeptName() + "|" + Validation.formatDate(x.getCreateDate()) + "|" + Validation.formatDate(x.getLastUpdateDate())+"|");
            }
            pw.close(); fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void displayAll(){
        System.out.println("====================APARTMENT_LIST====================");
        System.out.println("|---ID---|---Name---|---CreateDate---|---LastUpdate---|");
        for (Department department : dpList) {           
            System.out.printf("|%-8S|%-10S|%-16s|%-16s|\n",department.getDeptID(),department.getDeptName(),Validation.formatDate(department.getCreateDate()),Validation.formatDate(department.getLastUpdateDate()));
        }
        System.out.println("\n");
    }
    
    public boolean checkDepID(String ID){
        for (Department department : dpList) {
            if(department.getDeptID().equalsIgnoreCase(ID))
                return true;
        }
        return false;
    }
    public Department searchDepartment(String deptID){
        for (Department department : dpList) {
            if(department.getDeptID().equalsIgnoreCase(deptID))
                return department;
        }
        return null;
    }
    
    
    public void addToList(Department dep){
        dpList.add(dep);
    }
    
    public boolean checkEmpty(){
        return dpList.isEmpty();
    }
    
    public boolean deleteDepartment(Department department){
        return dpList.remove(department);
    }
    
    public void displayDepartmentByID(String deptID){
        for (Department department : dpList) {
            if(department.getDeptID().equalsIgnoreCase(deptID)){
            department.displayDepartment();
            }
        }
    }
}
 