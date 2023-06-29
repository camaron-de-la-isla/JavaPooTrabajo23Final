/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado;

/**
 *
 * @author sergi
 */

import empleado.Empleado;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import common.FileUtil;


public class GestorEmpleados {

    public void inicializarEmpleados() {
    String filePath = "../empleados.dat";
    List<Empleado> empleados = new ArrayList<>();
    empleados.add(new Empleado("Mario", "Perez", "12345678A", "Calle Tajo 6", "654433234", "marioperez@gmail.com", "Encargado", 1500, "1234", true));
    empleados.add(new Empleado("Maria", "Garcia", "3726349I", "Calle Jarama 21", "635522333", "mariagarcia@gmail.com", "Cajera", 1200, "1234", false));
    
    FileUtil.save(filePath, empleados);
    System.out.println("Archivo creado");
}
    
    public void addEmpleado(Empleado empleado) {
    String filePath = "../empleados.dat";
    List<Empleado> empleados = FileUtil.readList(filePath);
    empleados.add(empleado);
    FileUtil.save(filePath, empleados);
    System.out.println("Empleado añadido");
}

    public List<Empleado> readEmpleados() {
    String filePath = "../empleados.dat";
    List<Empleado> empleados = FileUtil.readList(filePath);
    return empleados != null ? empleados : new ArrayList<>();
}

    public Empleado buscarEmpleado(String dni) {
        String filePath = "../empleados.dat";
        List<Empleado> empleados = FileUtil.readList(filePath);
        for (Empleado empleado : empleados) {
            if (empleado.getDni().equals(dni)) {
                return empleado;
            }
        }
        return null;
    }

public void updateEmpleado(String dniModificar, Empleado empleadoNuevo) {
        String filePath = "../empleados.dat";
        List<Empleado> empleados = FileUtil.readList(filePath);

        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            if (empleado.getDni().equals(dniModificar)) {
                empleados.set(i, empleadoNuevo);
                FileUtil.save(filePath, empleados);
                System.out.println("Empleado actualizado");
                return;
            }
        }

        System.out.println("No se encontró ningún empleado con el DNI especificado");
    }

     public void deleteEmpleado(String dni) {
        String filePath = "../empleados.dat";
        List<Empleado> empleados = FileUtil.readList(filePath);

        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            if (empleado.getDni().equals(dni)) {
                empleados.remove(i);
                FileUtil.save(filePath, empleados);
                System.out.println("Empleado eliminado");
                return;
            }
        }

        System.out.println("No se encontró ningún empleado con el DNI especificado");
    }

    public boolean authentificarEmpleado(String dni, String contraseña) {
        Empleado empleadoAuthentificar = buscarEmpleado(dni);
        if (empleadoAuthentificar != null) {
            if (empleadoAuthentificar.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        else{
            System.out.println("Credenciales incorrectas");
            return false;
        }
        return false;
    }

    public boolean existeEmpleado(String dni){
        Empleado empleadoAuthentificar = buscarEmpleado(dni);
        if(empleadoAuthentificar != null){
            return true;
        } else {
            return false;
        }
    }

}



