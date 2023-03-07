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
public class HospitalManager {

    DeptList deptList;
    DoctorList doctorList;

    public HospitalManager(String filename1, String filename2) {
        deptList = new DeptList();
        doctorList = new DoctorList();
        deptList.loadFromFile(filename1);
        doctorList.loadFromFile(filename2);
    }

    public Date getCurrentDate() {
        Date dNow = new Date();
        return dNow;
    }

    public void addDoctor() {
        boolean flags = false;
        do {
            Doctor doc = new Doctor();
            boolean error;
            //nhap department ID
            do {
                try {
                    System.out.println("The department ID need to input first.");
                    String deptID = Validation.inputString("Input department's ID: ");
                    if (deptList.checkDepID(deptID)) {
                        doc.setDeptID(deptID);
                        error = false;
                    } else {
                        System.out.println("Department's ID not found!");
                        String depID = Validation.inputString("Do you want to continue?((Y/N)):");
                        if (depID.equalsIgnoreCase("y")) {
                            error = true;
                        } else {
                            System.out.println("Added fail!");
                            return;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Department ID should not be blank! Try again!");
                    error = true;
                }
            } while (error);
            //nhap doctor id
            do {
                try {
                    String docID = Validation.inputString("Input doctor's ID: ");
                    if (doctorList.checkDocID(docID)) {
                        System.out.println("Doctor's ID was duplicated! Try again!");
                        error = true;
                    } else {
                        doc.setDoctorID(docID);
                        error = false;
                    }
                } catch (Exception e) {
                    System.out.println("Doctor's ID should not be blank! Try again!");
                    error = true;
                }
            } while (error);
            //nhap doctor name
            do {
                try {
                    String docName = Validation.inputString("Input doctor's name: ");
                    doc.setDoctorName(docName);
                    error = false;
                } catch (Exception e) {
                    System.out.println("Doctor name should not be blank! Try again!");
                    error = true;
                }
            } while (error);
            //nhap gioi tinh
            do {
                try {
                    boolean sex = Validation.inputBoolean("Input gender (type true is male or false is female): ");
                    doc.setSex(sex);
                    error = false;
                } catch (Exception e) {
                    System.out.println("Invalid! Please try again!");
                    error = true;
                }
            } while (error);
            //nhap dia chi
            do {
                try {
                    String address = Validation.inputString("Input address: ");
                    doc.setAddress(address);
                    error = false;
                } catch (Exception e) {
                    System.out.println("Address should not be blank! Please try again!");
                    error = true;
                }
            } while (error);
            //lay ngay hien tai
            doc.setCreateDate(getCurrentDate());
            doc.setLastUpdateDate(null);
            //luu vao list
            doctorList.addToList(doc);
            try {
                String choice2 = Validation.inputString("Do you want to continue or not? (Y or N): ");
                flags = choice2.equalsIgnoreCase("y");
            } catch (Exception e) {
                System.out.print("");
            }
            doctorList.displayAll();
        } while (flags);
    }

    public void addDepartment() {
        boolean flags = true;
        while (flags) {
            Department dep = new Department();
            //nhap department ID
            boolean error;
            do {
                try {
                    String deptID = Validation.inputString("Input department's ID: ");
                    if (deptList.checkDepID(deptID)) {
                        System.out.println("Department's ID was duplicated! Try again!");
                        error = true;
                    } else {
                        dep.setDeptID(deptID);
                        error = false;
                    }
                } catch (Exception e) {
                    System.out.println("Department ID should not be blank! Try again!");
                    error = true;
                }
            } while (error);

            //nhap department name
            do {
                try {
                    String deptName = Validation.inputString("Input department's name: ");
                    dep.setDeptName(deptName);
                    error = false;
                } catch (Exception e) {
                    System.out.println("Department name should not be blank! Try again!");
                    error = true;
                }
            } while (error);
            //lay ngay hien tai 
            dep.setCreateDate(getCurrentDate());
            dep.setLastUpdateDate(null);
            //luu vao list va in ra
            deptList.addToList(dep);
            try {
                String choice2 = Validation.inputString("Do you want to continue or not? (Y or N): ");
                flags = choice2.equalsIgnoreCase("y");
            } catch (Exception e) {
                System.out.print("");
            }
            deptList.displayAll();
        }
    }

    public void updateDoctorInformation() {
        if (doctorList.checkEmpty()) {
            System.out.println("The docter list is empty! Please input information first!");
        } else {
            boolean flags;
            do {
                try {
                    String docID = Validation.inputString("Input doctor's ID: ");
                    if (doctorList.searchDoctor(docID) != null) {
                        System.out.println("Doctor has name, sex, address, department's ID, create date and last update date. ");
                        System.out.println("- If you want to change name, type 'N'.");
                        System.out.println("- If you want to change gender, type 'G'.");
                        System.out.println("- If you want to change address, type 'A'.");
                        System.out.println("- If you want to change departmentID, type 'D'.");
                        System.out.println("*Others are exit!");
                        String choice = Validation.inputString("Input your choice: ");
                        Doctor doc = doctorList.searchDoctor(docID);
                        boolean error;
                        if (choice.equalsIgnoreCase("n")) {
                            //nhap doctor name
                            do {
                                try {
                                    String docName = Validation.inputString("Input new doctor's name: ");
                                    doc.setDoctorName(docName);
                                    error = false;
                                } catch (Exception e) {
                                    System.out.println("Doctor name should not be blank! Try again!");
                                    error = true;
                                }
                            } while (error);
                            //lay ngay hien tai
                            doc.setLastUpdateDate(getCurrentDate());
                            //luu vao list
                            System.out.println("Update successfull!");
                            doctorList.displayAll();
                        } else if (choice.equalsIgnoreCase("g")) {
                            //nhap gioi tinh
                            do {
                                try {
                                    boolean sex = Validation.inputBoolean("Input new gender (type true is male or false is female): ");
                                    doc.setSex(sex);
                                    error = false;
                                } catch (Exception e) {
                                    System.out.println("Invalid! Please try again!");
                                    error = true;
                                }
                            } while (error);
                            //lay ngay hien tai
                            doc.setLastUpdateDate(getCurrentDate());
                            //luu vao list
                            System.out.println("Update successfull!");
                            doctorList.displayAll();
                        } else if (choice.equalsIgnoreCase("a")) {
                            //nhap dia chi
                            do {
                                try {
                                    String address = Validation.inputString("Input new address: ");
                                    doc.setAddress(address);
                                    error = false;
                                } catch (Exception e) {
                                    System.out.println("Address should not be blank! Please try again!");
                                    error = true;
                                }
                            } while (error);
                            //lay ngay hien tai
                            doc.setLastUpdateDate(getCurrentDate());
                            //luu vao list
                            System.out.println("Update successfull!");
                            doctorList.displayAll();
                        } else if (choice.equalsIgnoreCase("d")) {
                            //nhap department ID
                            do {
                                try {
                                    String deptID = Validation.inputString("Input new department's ID: ");
                                    if (deptList.checkDepID(deptID)) {
                                        doc.setDeptID(deptID);
                                        error = false;
                                    } else {
                                        System.out.println("Department's ID not found!");
                                        String depID = Validation.inputString("Do you want to continue?((Y/N)):");
                                        if (depID.equalsIgnoreCase("y")) {
                                            error = true;
                                        } else {
                                            error = false;
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("Department ID should not be blank! Try again!");
                                    error = true;
                                }
                            } while (error);
                            //lay ngay hien tai
                            doc.setLastUpdateDate(getCurrentDate());
                            //luu vao list
                            System.out.println("Update successfull!");
                            doctorList.displayAll();
                        } else {
                            System.out.println("The doctor information was not change!");
                        }
                    } else {
                        System.out.println("The doctor is not found!");
                        System.out.println("Update falied!");
                    }
                    String choice2 = Validation.inputString("Do you want to continue or not? (Y or N): ");
                    flags = choice2.equalsIgnoreCase("y");
                } catch (Exception e) {
                    System.out.println("Error! Please try again!");
                    flags = true;
                }
            } while (flags);
        }
    }

    public void updateDepartmentInformation() {
        if (deptList.checkEmpty()) {
            System.out.println("The department list is empty! Please input information first!");
        } else {
            boolean flags;
            do {
                try {
                    String deptID = Validation.inputString("Input department's ID: ");
                    if (deptList.searchDepartment(deptID) != null) {
                        System.out.println("Department has name.");
                        System.out.println("- If you want to change name, type 'N'.");
                        System.out.println("*Others are exit!");
                        String choice = Validation.inputString("Input your choice: ");
                        Department dep = deptList.searchDepartment(deptID);
                        boolean error;
                        if (choice.equalsIgnoreCase("n")) {
                            //nhap department name
                            do {
                                try {
                                    String deptName = Validation.inputString("Input new department's name: ");
                                    dep.setDeptName(deptName);
                                    error = false;
                                } catch (Exception e) {
                                    System.out.println("Department name should not be blank! Try again!");
                                    error = true;
                                }
                            } while (error);
                            //lay ngay hien tai de cap nhat
                            dep.setLastUpdateDate(getCurrentDate());
                        } else {
                            System.out.println("Departmnet information was not change!");
                        }
                    } else {
                        System.out.println("Department is not found!");
                        System.out.println("Update failed!");
                    }
                    //luu vao list va in ra
                    deptList.displayAll();
                    String choice2 = Validation.inputString("Do you want to continue or not? (Y or N): ");
                    flags = choice2.equalsIgnoreCase("y");
                } catch (Exception e) {
                    System.out.println("Error! Please try again!");
                    flags = true;
                }
            } while (flags);
        }
    }

    public void deleteDoctor() {
        if (doctorList.checkEmpty()) {
            System.out.println("The list is empty! You must input doctor first to do this function!");
        } else {
            boolean flags;
            do {
                try {
                    String docID = Validation.inputString("Input doctor ID: ");
                    if (doctorList.searchDoctor(docID) == null) {
                        System.out.println("The doctor does not exist!");
                    } else {
                        String choice = Validation.inputString("Do you want to delete this doctor? ('Y' is yes or others is no): ");
                        if (choice.equalsIgnoreCase("y")) {
                            doctorList.deleteDoctor(doctorList.searchDoctor(docID));
                            System.out.println("Delete successfull!");
                            doctorList.displayAll();
                        } else {
                            System.out.println("Delete fail! The list is unchange!");
                            doctorList.displayAll();
                        }
                    }
                    String choice2 = Validation.inputString("Do you want to continue or not? (Y or N): ");
                    flags = choice2.equalsIgnoreCase("y");
                } catch (Exception e) {
                    System.out.println("Error! Please try again!");
                    flags = true;
                }
            } while (flags);
        }
    }

    public void deleteDepartment() {
        if (deptList.checkEmpty()) {
            System.out.println("The list is empty! You must input department first to do this function!");
        } else {
            boolean flags;
            do {
                try {
                    String depID = Validation.inputString("Input department ID: ");
                    if (deptList.searchDepartment(depID) == null) {
                        System.out.println("The department does not exist!");
                    } else {
                        if (deptList.checkDepID(depID)) {
                            if(doctorList.checkDocDepartmentID(depID)){
                                System.out.println("The doctor already add to this department! Please try again!");
                            }
                         else {
                            String choice = Validation.inputString("Do you want to delete this department?(Y/N)");
                            if (choice.equalsIgnoreCase("y")) {
                                deptList.deleteDepartment(deptList.searchDepartment(depID));
                                System.out.println("Deleted successfull");
                                deptList.displayAll();
                            } else {
                                System.out.println("Deleted fail!");
                                deptList.displayAll();
                            }
                        }
                        }
                    }
                    String choice2 = Validation.inputString("Do you want to continue or not? (Y or N): ");
                    flags = choice2.equalsIgnoreCase("y");
                } catch (Exception e) {
                    System.out.println("Error! Please try again!");
                    flags = true;
                }
            } while (flags);
        }
    }

    public void searchDoctorByName() {
        if (doctorList.checkEmpty()) {
            System.out.println("The list is empty! You must input doctor first to search!");
        } else {
            boolean flags;
            do {
                try {
                    String docName = Validation.inputString("Input doctor's name to search: ");
                    if (doctorList.checkDoctorName(docName)) {
                        System.out.println("==================================================DOCTOR____LIST==================================================");
                        System.out.println("|---ID---|-------Name-------|----Sex----|------Address-----|----DepartmentID----|---CreateDate---|---LastUpdate---|");
                        doctorList.displayDoctorByName(docName);
                    } else {
                        System.out.println("The doctor does not exist!");
                    }
                    String choice2 = Validation.inputString("Do you want to continue or not? (Y or N): ");
                    flags = choice2.equalsIgnoreCase("y");
                } catch (Exception e) {
                    System.out.println("Error! Please try again!");
                    flags = true;
                }
            } while (flags);
        }
    }

    public void searchDepartmentByID() {
        if (deptList.checkEmpty()) {
            System.out.println("The list is empty! You must input department first to search!");
        } else {
            boolean flags;
            do {
                try {
                    String deptID = Validation.inputString("Input department's ID to search: ");
                    if (deptList.checkDepID(deptID)) {
                        System.out.println("====================APARTMENT_BY_ID====================");
                        System.out.println("|---ID---|---Name---|---CreateDate---|---LastUpdate---|");
                        deptList.displayDepartmentByID(deptID);
                    } else {
                        System.out.println("The department does not exist!");
                    }
                    String choice2 = Validation.inputString("Do you want to continue or not? (Y or N): ");
                    flags = choice2.equalsIgnoreCase("y");
                } catch (Exception e) {
                    System.out.println("Error! Please try again!");
                    flags = true;
                }
            } while (flags);
        }
    }

    public boolean checkDoctorList() {
        return doctorList.checkEmpty();
    }

    public void displayDoctorList() {
        if (doctorList.checkEmpty()) {
            System.out.println("The list is empty!");
        } else {
            doctorList.displayAll();
        }
    }

    public void displayDepartmentList() {
        if (deptList.checkEmpty()) {
            System.out.println("The list is empty!");
        } else {
            deptList.displayAll();
        }
    }

    public void writeData(String filename2) {
        doctorList.writeToFile("doctors.dat");
        deptList.writeToFile("departments.dat");
        System.out.println("Store data sucessfully!");
    }

}
