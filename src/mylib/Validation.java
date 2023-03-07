/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validation {

    //ham nay de nhap so nguyen tu ban phim
    //va tra ve so nguyen vua nhap
    //input:msg la cau thong bao cua user
    //code nay co kha nang gay 2 loai error:
    //  - Loi nhap sai format cua ngon ngu 
    //  - Loi nhap num <0
    public static int inputNumber(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.print(msg);
        num = sc.nextInt();
        if (num < 0) {
            throw new Exception();
        }
        return num;
    }

    //ham nay de nhap chuoi tu ban phim
    //va tra ve chuoi vua nhap
    //code nay co kha nang gay error: la chuoi trong
    public static String inputString(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        String str = sc.nextLine();
        if (str.equals("")) {
            throw new Exception();
        }
        return str;
    }

    public static double inputDouble(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        double num = 0;
        System.out.print(msg);
        num = sc.nextDouble();
        if (num < 0) {
            throw new Exception();
        }
        return num;
    }

    public static boolean inputBoolean(String msg) throws Exception {
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        boolean s = sc.nextBoolean();
        if (s != true && s != false) {
            throw new Exception();
        }
        return s;
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "null";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = formatter.format(date);
            return strDate;
        }
    }

    public static String genderFormat(boolean gender) {
        if (gender == true) {
            return "male";
        } else {
            return "female";
        }
    }
    
    
    public static boolean genderChangeFormat(String strGender){
        return strGender.equalsIgnoreCase("male");
    }

}
