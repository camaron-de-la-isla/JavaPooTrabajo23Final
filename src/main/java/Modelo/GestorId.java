/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author sergi
 */

public class GestorId {
    private static int id = 0;

    public static int assignId() {
        id++;
        return id;
    }

    public static int getId() {
        return assignId();
    }


}
