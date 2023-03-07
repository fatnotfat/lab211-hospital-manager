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
public class DoctorList {

    ArrayList<Doctor> dtList;

    public DoctorList() {
        dtList = new ArrayList<>();
    }

  public void loadFromFile(String fName) {
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
                String doctorID = stk.nextToken().toUpperCase();
                String doctorName = stk.nextToken();
                char sexChar = stk.nextToken().trim().toUpperCase().charAt(0);
//                boolean sex= true;
//                if(sexChar == 'M'){
//                    sex = true;
//                }else if(sexChar == 'F'){
//                    sex = false;
//                }
                Boolean sex = sexChar == 'M' || sexChar == 'F';
                String address = stk.nextToken();
                String deptID = stk.nextToken();
                //trường hợp null
                SimpleDateFormat fomater = new SimpleDateFormat("dd/MM/yyyy");
                String createDateStr = stk.nextToken().trim();
                String lastUpdateDateStr = stk.nextToken().trim();
                Date createDate = null;
                Date lastUpdateDate = null;
                
                if (!createDateStr.equalsIgnoreCase("null")) {
                    createDate = fomater.parse(createDateStr);
                }
                if (!lastUpdateDateStr.equalsIgnoreCase("null")) {
                    lastUpdateDate = fomater.parse(lastUpdateDateStr);
                }
                Doctor newDoctor = new Doctor(doctorID, doctorName, sex, address, deptID, createDate, lastUpdateDate);
                this.dtList.add(newDoctor);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeToFile(String fName) {
        if (checkEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Doctor x : dtList) {
                pw.println("|" + x.getDoctorID() + "|" + x.getDoctorName() + "|" + Validation.genderFormat(x.isSex()) + "|" + x.getAddress() + "|"
                        + x.getDeptID() + "|" + Validation.formatDate(x.getCreateDate()) + "|" + Validation.formatDate(x.getLastUpdateDate()) + "|");
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean checkDocID(String ID) {
        for (Doctor doctor : dtList) {
            if (doctor.getDoctorID().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkDocDepartmentID(String depID){
        for (Doctor doctor : dtList) {
            if(doctor.getDeptID().equalsIgnoreCase(depID)){
                return true;
            }
        }
        return false;
    }

    public void addToList(Doctor doctor) {
        System.out.println("Add successful!");
        dtList.add(doctor);
    }

    public void displayAll() {
        System.out.println("==================================================DOCTOR____LIST==================================================");
        System.out.println("|---ID---|-------Name-------|----Sex----|------Address-----|----DepartmentID----|---CreateDate---|---LastUpdate---|");
        for (Doctor doctor : dtList) {
            System.out.printf("|%-8S|%-18S|%-11S|%-18S|%-20S|%-16S|%-16S|\n", doctor.getDoctorID(), doctor.getDoctorName(), Validation.genderFormat(doctor.isSex()), doctor.getAddress(), doctor.getDeptID(), Validation.formatDate(doctor.getCreateDate()), Validation.formatDate(doctor.getLastUpdateDate()));
        }
        System.out.println("\n");
    }

    public Doctor searchDoctor(String docID) {
        for (Doctor doctor : dtList) {
            if (doctor.getDoctorID().equalsIgnoreCase(docID)) {
                return doctor;
            }
        }
        return null;
    }

    public boolean deleteDoctor(Doctor doctor) {
        return dtList.remove(doctor);
    }

    public boolean checkEmpty() {
        return dtList.isEmpty();
    }
    
    public ArrayList getList(){
        return dtList;
    }

    public boolean checkDoctorName(String docName) {
        for (Doctor doctor : dtList) {
            if (doctor.getDoctorName().toUpperCase().contains(docName.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public void displayDoctorByName(String docName) {
        for (Doctor doctor : dtList) {
            if (doctor.getDoctorName().toUpperCase().contains(docName.toUpperCase())) {
                doctor.displayDoctor();
            }
        }
    }
}
