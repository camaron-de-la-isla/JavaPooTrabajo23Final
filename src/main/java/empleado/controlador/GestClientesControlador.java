/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado.controlador;

import cliente.modelo.Cliente;
import cliente.modelo.GestorClientes;
import empleado.modelo.Empleado;
import empleado.vista.AddClienteVista;
import empleado.vista.ClienteNoEncontradoJDialog;
import empleado.vista.EliminarClientesVista;
import empleado.vista.IntEmpGestClientesVista;
import empleado.vista.ModificarClienteVista;
import empleado.vista.MostrarClientesVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sergi
 */
public class GestClientesControlador {
    private IntEmpGestClientesVista vista;
    private Empleado empleadoAuth;
    private AddClienteVista addClienteVista = new AddClienteVista();
    private MostrarClientesVista mostrarClientesVista = new MostrarClientesVista();
    private GestorClientes gestorClientes = new GestorClientes();
    private ModificarClienteVista modificarClienteVista = new ModificarClienteVista();
    private EliminarClientesVista eliminarClienteVista = new EliminarClientesVista();
    private ClienteNoEncontradoJDialog clienteNoEncontradoJDialog = new ClienteNoEncontradoJDialog(new javax.swing.JFrame(), true);
    
    public GestClientesControlador(IntEmpGestClientesVista vista, Empleado empleadoAuth){
       this.vista = vista;
        this.empleadoAuth = empleadoAuth;
        this.vista.getAddClienteBoton().addActionListener(new GestClientesControlador.AddClienteButtonListener());
        this.vista.getMostrarClienteBoton().addActionListener(new GestClientesControlador.MostrarClientesButtonListener());
        this.vista.getModificarClienteBoton().addActionListener(new GestClientesControlador.ModificarClienteButtonListener());
        this.vista.getEliminarClienteBoton().addActionListener(new GestClientesControlador.EliminarClienteButtonListener());
    }
    
    private class EliminarClienteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            eliminarClienteVista.getBorrarBoton().addActionListener(new GestClientesControlador.BorrarButtonListener());
            eliminarClienteVista.setVisible(true);
        }
    }
     
    private class ModificarClienteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarClienteVista.getSubmitDniBoton().addActionListener(new GestClientesControlador.SubmitDniButtonListener());
            modificarClienteVista.getSubmitUserBoton().addActionListener(new GestClientesControlador.SubmitUserButtonListener());
            modificarClienteVista.getSubmitDatosNuevosBoton().addActionListener(new GestClientesControlador.SubmitDatosNuevosButtonListener());
            modificarClienteVista.setVisible(true);
        }
    }
    
    private class AddClienteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            addClienteVista.getSubmitClienteBoton().addActionListener(new GestClientesControlador.SubmitClienteButtonListener());
            addClienteVista.setVisible(true);
        }
    }
    
    private class SubmitClienteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Cliente addCliente = new Cliente(addClienteVista.getNombre(), addClienteVista.getApellidos(), addClienteVista.getDni(), addClienteVista.getDireccion(), addClienteVista.getTelefono(), addClienteVista.getEmail(), addClienteVista.getUser(), addClienteVista.getPass());
            if(gestorClientes.addCliente(addCliente) == false){
                clienteNoEncontradoJDialog.setVisible(false);
            }
            else
                addClienteVista.setVisible(false);
            
            System.out.println("Cliente Añadido correctamente");
        }
    }
    
    private class SubmitDniButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarClienteVista.setClientesTextBoxes(gestorClientes.buscarClienteDni(modificarClienteVista.getBuscarDniTextField().getText()));
        }
    }
    
    private class SubmitUserButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarClienteVista.setClientesTextBoxes(gestorClientes.buscarCliente(modificarClienteVista.getBuscarDniTextField().getText()));
        }
    }
    
    private class BorrarButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(gestorClientes.deleteCliente(eliminarClienteVista.getDnitextField()) == false){
                clienteNoEncontradoJDialog.setVisible(true);
            }
            else
                eliminarClienteVista.setVisible(false);

        }
    }
    
    private class MostrarClientesButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String clientesStr = gestorClientes.MostrarClientes();
            mostrarClientesVista.getClientesTextArea().setText(clientesStr);
            mostrarClientesVista.setVisible(true);
        }
    }
    
    private class SubmitDatosNuevosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Cliente clienteNuevo = new Cliente(modificarClienteVista.getNombreNuevo(), modificarClienteVista.getApellidosNuevos(), modificarClienteVista.getDniNuevo(), modificarClienteVista.getDireccionNuevo(), modificarClienteVista.getTelefonoNuevo(), modificarClienteVista.getEmailNuevo(), modificarClienteVista.getUserNuevo(), modificarClienteVista.getPassNuevo());
            if(gestorClientes.updateCliente(modificarClienteVista.getDniTextField(), clienteNuevo) == false){
                clienteNoEncontradoJDialog.setVisible(true);
            }
            else
                modificarClienteVista.setVisible(false);
        }
    }
    
}
