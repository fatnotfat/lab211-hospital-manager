/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.HospitalManager;
import mylib.Validation;

/**
 *
 * @author HAU NUONG MO HANH
 */
public class Tester {

    public static void main(String[] args) {
        int choice = 0;
        String filename1 = "departments.dat";
        String filename2 = "doctors.dat";
        HospitalManager h = new HospitalManager(filename1, filename2);
        do {
            try {
                System.out.println("===================HOSPITAL_MANAGERMENT====================");
                System.out.println("1.Show information. ");
                System.out.println("2.Add new. ");
                System.out.println("3.Update information. ");
                System.out.println("4.Delete. ");
                System.out.println("5.Search information. ");
                System.out.println("6.Store date to file. ");
                System.out.println("Others - Quit!");
                choice = Validation.inputNumber("Input choice which you want to execute: ");
                switch (choice) {
                    case 1:
                            try {
                                System.out.println("        1.1 Show doctor list. ");
                                System.out.println("        1.2 Show department list. ");
                                System.out.println("        Others number. Exit!. ");
                                int choice1 = Validation.inputNumber("Your choice: ");
                                switch(choice1){
                                    case 1:
                                        h.displayDoctorList();
                                        break;
                                    case 2:
                                        h.displayDepartmentList();
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("The input must be a number!");
                            }
                        break;
                    case 2:
                        try {
                            System.out.println("        2.1 Add new doctor. ");
                            System.out.println("        2.2 Add new department. ");
                            System.out.println("        Others number. Exit!. ");
                            int choice3 = Validation.inputNumber("Your choice: ");
                            switch (choice3) {
                                case 1:
                                    h.addDoctor();
                                    break;
                                case 2:
                                    h.addDepartment();
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("The input must be a number!");
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("        3.1 Update doctor. ");
                            System.out.println("        3.2 Update department. ");
                            System.out.println("        Others number. Exit!. ");
                            int choice1 = Validation.inputNumber("Your choice: ");
                            switch (choice1) {
                                case 1:
                                    h.updateDoctorInformation();
                                    break;
                                case 2:
                                    h.updateDepartmentInformation();
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("The input must be a number!");
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("        4.1 Delete doctor. ");
                            System.out.println("        4.2 Delete department. ");
                            System.out.println("        Others number. Exit!. ");
                            int choice1 = Validation.inputNumber("Your choice: ");
                            switch (choice1) {
                                case 1:
                                    h.deleteDoctor();
                                    break;
                                case 2:
                                    h.deleteDepartment();
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("The input must be a number!");
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("        5.1 Search doctor by name. ");
                            System.out.println("        5.2 Search department by ID. ");
                            System.out.println("        Others number. Exit!. ");
                            int choice1 = Validation.inputNumber("Your choice: ");
                            switch (choice1) {
                                case 1:
                                    h.searchDoctorByName();
                                    break;
                                case 2:
                                    h.searchDepartmentByID();
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("The input must be a number!");
                        }
                        break;
                    case 6:
                        try {

                            h.writeData(filename2);
                            System.out.println("Wrote data to file ...");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
            } catch (Exception e) {
                choice = 0;
            }
        } while (choice > 0 && choice < 7);
        System.out.println("Goodbye!");
    }
}
