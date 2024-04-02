/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.checkDate;

/**
 *
 * @author CAM TRI
 */
public class check {
//    private String thoigian;
    public static boolean checkDate(String input){
        String[] parts = input.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        if((day >= 1 && day <= 31) && (month >= 1 && month <= 12) && year >= 0){
            return true;
        }
        return false;
    }
}
