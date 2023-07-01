/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado.modelo;

/**
 *
 * @author sergi
 */

import empleado.modelo.Empleado;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;
import common.FileUtil;
import java.util.Vector;


public class GestorEmpleados {
final String filePath = "../empleados.dat";
List<Empleado> empleados;
public GestorEmpleados(){
    inicializarEmpleados();
}
 public void inicializarEmpleados() {
        File file = new File(filePath);
        if (!file.exists()) {
            empleados = new Vector<>();
            empleados.add(new Empleado("Mario", "Perez", "12345678A", "Calle Tajo 6", "654433234", "marioperez@gmail.com", "Encargado", 1500, "1234", true));
            empleados.add(new Empleado("Maria", "Garcia", "3726349I", "Calle Jarama 21", "635522333", "mariagarcia@gmail.com", "Cajera", 1200, "1234", false));
            FileUtil.save(filePath, empleados);
            System.out.println("Archivo creado");
        } else {
            cargarEmpleados();
        }
    }
 
     private void cargarEmpleados() {
        List<Empleado> cTemp = FileUtil.readList(filePath);
        if (cTemp != null) {
            empleados = cTemp;
        } else {
            empleados = new Vector<>();
        }
    }
 
    public boolean addEmpleado(Empleado empleado) {
    try{
        empleados.add(empleado);
        FileUtil.save(filePath, empleados);
    }catch(Exception e){
        return false;
    }
    return true;
}

    public List<Empleado> readEmpleados() {
    return empleados;
}

    public Empleado buscarEmpleado(String dni) {
        for(int i = 0; i < empleados.size(); i++){
            if(empleados.get(i).getDni().equals(dni))
                return empleados.get(i);
        } 
        return null;
    }
    

    public void updateEmpleado(String dniModificar, Empleado empleadoNuevo) {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            if (empleado.getDni().equals(dniModificar)) {
                empleados.set(i, empleadoNuevo);
                FileUtil.save(filePath, empleados);
                System.out.println("Empleado actualizado");
            }
        }
    }

     public void deleteEmpleado(String dni) {
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



