/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.authentificacion.controlador;

/**
 *
 * @author sergi
 */

import common.authentificacion.vista.PasAuthClienteVista;
import common.authentificacion.vista.PasAuthEmpleadoVista;
import common.authentificacion.vista.PasarelaAuthentificacionVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthControlador {
    private PasarelaAuthentificacionVista vista;

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
            empleadoVista.setVisible(true);
            vista.dispose();
        }
    }

    public static void main(String[] args) {
        PasarelaAuthentificacionVista vista = new PasarelaAuthentificacionVista();
        AuthControlador controller = new AuthControlador(vista);
        vista.setVisible(true);
    }
}

