/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado.controlador;

import empleado.modelo.GestorEmpleados;
import empleado.modelo.Empleado;
import empleado.vista.AddEmpleadoVista;
import empleado.vista.CambiarPrivilegiosVista;
import empleado.vista.ClienteNoEncontradoJDialog;
import empleado.vista.EliminarEmpleadosVista;
import empleado.vista.IntEmpGestEmpleadosVista;
import empleado.vista.ModificarEmpleadoVista;
import empleado.vista.MostrarEmpleadosVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sergi
 */
public class GestEmpleadosControlador {
    private IntEmpGestEmpleadosVista vista;
    private Empleado empleadoAuth;
    private AddEmpleadoVista addEmpleadoVista = new AddEmpleadoVista();
    private MostrarEmpleadosVista mostrarEmpleadosVista = new MostrarEmpleadosVista();
    private GestorEmpleados gestorEmpleados = new GestorEmpleados();
    private ModificarEmpleadoVista modificarEmpleadoVista = new ModificarEmpleadoVista();
    private EliminarEmpleadosVista eliminarEmpleadoVista = new EliminarEmpleadosVista();
    private CambiarPrivilegiosVista cambiarPrivilegiosVista = new CambiarPrivilegiosVista();
    private ClienteNoEncontradoJDialog clienteNoEncontradoJDialog = new ClienteNoEncontradoJDialog(new javax.swing.JFrame(), true);
    
    public GestEmpleadosControlador(IntEmpGestEmpleadosVista vista, Empleado empleadoAuth){
       this.vista = vista;
        this.empleadoAuth = empleadoAuth;
        this.vista.getAddEmpleadoBoton().addActionListener(new GestEmpleadosControlador.AddEmpleadoButtonListener());
        this.vista.getMostrarEmpleadosBoton().addActionListener(new GestEmpleadosControlador.MostrarEmpleadosButtonListener());
        this.vista.getModificarEmpleadoBoton().addActionListener(new GestEmpleadosControlador.ModificarEmpleadoButtonListener());
        this.vista.getEliminarEmpleadoBoton().addActionListener(new GestEmpleadosControlador.EliminarEmpleadoButtonListener());
        this.vista.getCambiarPrivilegiosBoton().addActionListener(new GestEmpleadosControlador.CambiarPrivilegiosButtonListener());
    }
    
    private class EliminarEmpleadoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            eliminarEmpleadoVista.getBorrarBoton().addActionListener(new GestEmpleadosControlador.BorrarButtonListener());
            eliminarEmpleadoVista.setVisible(true);
        }
    }
     
    private class ModificarEmpleadoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarEmpleadoVista.getSubmitDniBoton().addActionListener(new GestEmpleadosControlador.SubmitDniButtonListener());
            modificarEmpleadoVista.getSubmitDatosNuevosBoton().addActionListener(new GestEmpleadosControlador.SubmitDatosNuevosButtonListener());
            modificarEmpleadoVista.setVisible(true);
        }
    }
    
    private class BuscarEmpleadoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(gestorEmpleados.buscarEmpleado(cambiarPrivilegiosVista.getDniTextField().getText()) != null){
                cambiarPrivilegiosVista.setNombreTextField(gestorEmpleados.buscarEmpleado(cambiarPrivilegiosVista.getDniTextField().getText()).getNombre()+" "+gestorEmpleados.buscarEmpleado(cambiarPrivilegiosVista.getDniTextField().getText()).getApellidos());
            }
            else
                clienteNoEncontradoJDialog.setVisible(true);
        }
    }
    
    private class DarPrivilegiosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gestorEmpleados.buscarEmpleado(cambiarPrivilegiosVista.getDniTextField().getText()).setPrivilegios(true);
        }
    }
    
    private class QuitarPrivilegiosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gestorEmpleados.buscarEmpleado(cambiarPrivilegiosVista.getDniTextField().getText()).setPrivilegios(false);
        }
    }
    
    private class CambiarPrivilegiosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cambiarPrivilegiosVista.getBuscarEmpleadoBoton().addActionListener(new GestEmpleadosControlador.BuscarEmpleadoButtonListener());
            cambiarPrivilegiosVista.getDarPrivilegiosBoton().addActionListener(new GestEmpleadosControlador.DarPrivilegiosButtonListener());
            cambiarPrivilegiosVista.getQuitarPrivilegiosBoton().addActionListener(new GestEmpleadosControlador.QuitarPrivilegiosButtonListener());
            cambiarPrivilegiosVista.setVisible(true);
        }
    }
    
    private class AddEmpleadoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            addEmpleadoVista.getSubmitEmpleadoBoton().addActionListener(new GestEmpleadosControlador.SubmitEmpleadoButtonListener());
            addEmpleadoVista.setVisible(true);
        }
    }
    
    private class SubmitEmpleadoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Empleado addEmpleado = new Empleado(addEmpleadoVista.getNombre(), addEmpleadoVista.getApellidos(), addEmpleadoVista.getDni(), addEmpleadoVista.getDireccion(), addEmpleadoVista.getTelefono(), addEmpleadoVista.getEmail(), addEmpleadoVista.getPuesto(), Double.parseDouble(addEmpleadoVista.getSalario()), addEmpleadoVista.getPass(), false);
            gestorEmpleados.addEmpleado(addEmpleado);
            System.out.println("Cliente Añadido correctamente");
        }
    }
    
    private class SubmitDniButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarEmpleadoVista.setEmpleadosTextBoxes(gestorEmpleados.buscarEmpleado(modificarEmpleadoVista.getBuscarDniTextField().getText()));
        }
    }
    
    private class BorrarButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gestorEmpleados.deleteEmpleado(eliminarEmpleadoVista.getDnitextField());

        }
    }
    
    private class MostrarEmpleadosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String empleadosStr = gestorEmpleados.MostrarEmpleados();
            mostrarEmpleadosVista.getEmpleadosTextArea().setText(empleadosStr);
            mostrarEmpleadosVista.setVisible(true);
        }
    }
    
    private class SubmitDatosNuevosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Empleado empleadoNuevo = new Empleado(modificarEmpleadoVista.getNombreNuevo(), modificarEmpleadoVista.getApellidosNuevos(), modificarEmpleadoVista.getDniNuevo(), modificarEmpleadoVista.getDireccionNuevo(), modificarEmpleadoVista.getTelefonoNuevo(), modificarEmpleadoVista.getEmailNuevo(),modificarEmpleadoVista.getPuestoNuevo(), Double.parseDouble(modificarEmpleadoVista.getSalarioNuevo()), modificarEmpleadoVista.getPassNuevo(), false);
            gestorEmpleados.updateEmpleado(modificarEmpleadoVista.getDniTextField(), empleadoNuevo);
        }
    }
    
}
