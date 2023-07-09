/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.authentificacion.controlador;

/**
 *
 * @author sergi
 */

import empleado.controlador.InterfazEmpleadosControlador;
import common.authentificacion.modelo.PasarelaAuthentificacion;
import common.authentificacion.vista.PasAuthClienteVista;
import common.authentificacion.vista.PasAuthEmpleadoVista;
import common.authentificacion.vista.PasarelaAuthentificacionVista;
import empleado.modelo.Empleado;
import empleado.vista.InterfazEmpleadosVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthControlador {
    private PasarelaAuthentificacionVista vista;
    public PasarelaAuthentificacion pasAuth;
    
    public AuthControlador(PasarelaAuthentificacionVista vista) {
        this.vista = vista;
        this.vista.getClienteButton().addActionListener(new ClienteButtonListener());
        this.vista.getEmpleadoButton().addActionListener(new EmpleadoButtonListener());
    }

    private class ClienteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PasAuthClienteVista clienteVista = new PasAuthClienteVista();
            clienteVista.setVisible(true);
            vista.dispose();
        }
    }

    private class EmpleadoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PasAuthEmpleadoVista empleadoVista = new PasAuthEmpleadoVista();
            empleadoVista.getIniciarSesionBoton().addActionListener(new IniciarSesionBotonListener(empleadoVista));
            empleadoVista.setVisible(true);
            vista.dispose();
        }
    }
    
    private class IniciarSesionBotonListener implements ActionListener{
        private PasAuthEmpleadoVista empleadoVista;
        
        public IniciarSesionBotonListener(PasAuthEmpleadoVista empleadoVista){
            this.empleadoVista = empleadoVista;
        }
        
        public void actionPerformed(ActionEvent e) {
            String dni = empleadoVista.getDni();
            String pass = empleadoVista.getPass();
            
            Empleado empleadoAuth = pasAuth.authentificarEmpleado(dni, pass);
            
            if(empleadoAuth != null) {
                InterfazEmpleadosVista interfazEmpleadoVista = new InterfazEmpleadosVista();
                InterfazEmpleadosControlador empleadoControlador = new InterfazEmpleadosControlador(interfazEmpleadoVista, empleadoAuth);
                interfazEmpleadoVista.setVisible(true);
                empleadoVista.dispose();
            }
            else{
                System.out.println("DNI o Contraseña incorrectas");
            }
            
        }
    }
    
    

    public static void main(String[] args) {
        PasarelaAuthentificacionVista vista = new PasarelaAuthentificacionVista();
        AuthControlador controller = new AuthControlador(vista);
        vista.setVisible(true);
    }
}

