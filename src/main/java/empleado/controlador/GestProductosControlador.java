/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado.controlador;

import cliente.modelo.Cliente;
import cliente.modelo.GestorClientes;
import common.producto.modelo.Producto;
import empleado.modelo.Empleado;
import empleado.vista.AddClienteVista;
import empleado.vista.ClienteNoEncontradoJDialog;
import empleado.vista.EliminarClientesVista;
import empleado.vista.IntEmpGestClientesVista;
import empleado.vista.IntEmpGestProductosVista;
import empleado.vista.ModificarClienteVista;
import empleado.vista.MostrarClientesVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sergi
 */
public class GestProductosControlador {
    private IntEmpGestProductosVista vista;
    private Empleado empleadoAuth;
    private AddProductoVista addProductoVista = new AddProductoVista();
    private MostrarProductosVista mostrarProductosVista = new MostrarProductosVista();
    private GestorProductos gestorProductos = new GestorProductos();
    private ModificarProductoVista modificarProductoVista = new ModificarProductoVista();
    private EliminarProductosVista eliminarProductoVista = new EliminarProductosVista();
    private BuscarProductoVista buscarProductoVista =  new BuscarProductoVista();
    private ProductoNoEncontradoJDialog productoNoEncontradoJDialog = new ProductoNoEncontradoJDialog(new javax.swing.JFrame(), true);
    
    public GestProductosControlador(IntEmpGestClientesVista vista, Empleado empleadoAuth){
       this.vista = vista;
        this.empleadoAuth = empleadoAuth;
        this.vista.getAddProductoBoton().addActionListener(new GestProductosControlador.AddClienteButtonListener());
        this.vista.getMostrarProductoBoton().addActionListener(new GestProductosControlador.MostrarProductosButtonListener());
        this.vista.getModificarProductoBoton().addActionListener(new GestProductosControlador.ModificarProductoButtonListener());
        this.vista.getEliminarProductoBoton().addActionListener(new GestProductosControlador.EliminarProductoButtonListener());
        this.vista.getBuscarProductoBoton().addActionListener(new GestProductosControlador.BuscarProductoButtonListener());
        
    }
    
    private class EliminarProductoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            eliminarProductoVista.getBorrarBoton().addActionListener(new GestProductosControlador.BorrarButtonListener());
            eliminarProductoVista.setVisible(true);
        }
    }
     
    private class ModificarProductoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarProductoVista.getSubmitDniBoton().addActionListener(new GestProductosControlador.SubmitNombreButtonListener());
            modificarProductoVista.getSubmitUserBoton().addActionListener(new GestProductosControlador.SubmitIdButtonListener());
            modificarProductoVista.getSubmitDatosNuevosBoton().addActionListener(new GestProductosControlador.SubmitDatosNuevosButtonListener());
            modificarProductoVista.setVisible(true);
        }
    }
    
    private class AddProductoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            addProductoVista.getSubmitProductoBoton().addActionListener(new GestProductosControlador.SubmitProductoButtonListener());
            addProductoVista.setVisible(true);
        }
    }
    
    private class SubmitProductoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Producto addProducto = new Producto(addProductoVista.getNombre(), addProductoVista.getApellidos(), addProductoVista.getDni(), addProductoVista.getDireccion(), addProductoVista.getTelefono(), addProductoVista.getEmail(), addProductoVista.getUser(), addProductoVista.getPass());
            if(gestorProductos.addProducto(addProducto) == false){
                productoNoEncontradoJDialog.setVisible(false);
            }
            else
                addProductoVista.setVisible(false);
            System.out.println("Producto Añadido correctamente");
        }
    }
    
    private class SubmitDniButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarProductoVista.setProductosTextBoxes(gestorProductos.buscarProductoDni(modificarProductoVista.getBuscarDniTextField().getText()));
        }
    }
    
    private class SubmitUserButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarProductoVista.setClientesTextBoxes(gestorProductos.buscarProducto(modificarProductoVista.getBuscarDniTextField().getText()));
        }
    }
    
    private class BorrarButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(gestorProductos.deleteProducto(eliminarProductoVista.getDnitextField()) == false){
                productoNoEncontradoJDialog.setVisible(true);
            }
            else
                eliminarProductoVista.setVisible(false);

        }
    }
    
    private class MostrarProductosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String productosStr = gestorProductos.MostrarProductos();
            mostrarProductosVista.getProductosTextArea().setText(productosStr);
            mostrarProductosVista.setVisible(true);
        }
    }
    
    private class SubmitDatosNuevosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Producto productoNuevo = new Producto(modificarProductoVista.getNombreNuevo(), modificarProductoVista.getApellidosNuevos(), modificarProductoVista.getDniNuevo(), modificarProductoVista.getDireccionNuevo(), modificarProductoVista.getTelefonoNuevo(), modificarProductoVista.getEmailNuevo(), modificarProductoVista.getUserNuevo(), modificarProductoVista.getPassNuevo());
            if(gestorProductos.updateProducto(modificarProductoVista.getDniTextField(), productoNuevo) == false){
                productoNoEncontradoJDialog.setVisible(true);
            }
            else
                modificarProductoVista.setVisible(false);
        }
    }
    
}
