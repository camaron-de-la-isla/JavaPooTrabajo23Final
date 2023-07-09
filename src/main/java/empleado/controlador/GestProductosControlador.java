/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado.controlador;

import common.producto.modelo.Altavoz;
import common.producto.modelo.GestorProductos;
import common.producto.modelo.Ordenador;
import common.producto.modelo.Smartphone;
import common.producto.modelo.Televisor;
import empleado.modelo.Empleado;
import empleado.vista.AddAltavozVista;
import empleado.vista.AddOrdenadorVista;
import empleado.vista.AddSmartphoneVista;
import empleado.vista.AddTelevisorVista;
import empleado.vista.BuscarProductosVista;
import empleado.vista.EliminarProductosVista;
import empleado.vista.IntEmpGestProductosVista;
import empleado.vista.ModificarAltavozVista;
import empleado.vista.ModificarOrdenadorVista;
import empleado.vista.ModificarSmartphoneVista;
import empleado.vista.ModificarTelevisorVista;
import empleado.vista.MostrarProductosVista;
import empleado.vista.ProductoNoEncontradoJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sergi
 */
public class GestProductosControlador {
    private IntEmpGestProductosVista vista;
    private Empleado empleadoAuth;
    private GestorProductos gestorProductos = new GestorProductos();
    private AddAltavozVista addAltavozVista = new AddAltavozVista();
    private AddOrdenadorVista addOrdenadorVista = new AddOrdenadorVista();
    private AddTelevisorVista addTelevisorVista = new AddTelevisorVista();
    private AddSmartphoneVista addSmartphoneVista = new AddSmartphoneVista();
    private MostrarProductosVista mostrarProductosVista = new MostrarProductosVista();
    private ModificarAltavozVista modificarAltavozVista = new ModificarAltavozVista();
    private ModificarOrdenadorVista modificarOrdenadorVista = new ModificarOrdenadorVista();
    private ModificarTelevisorVista modificarTelevisorVista = new ModificarTelevisorVista();
    private ModificarSmartphoneVista modificarSmartphoneVista = new ModificarSmartphoneVista();
    private EliminarProductosVista eliminarProductoVista = new EliminarProductosVista();
    private BuscarProductosVista buscarProductosVista =  new BuscarProductosVista();
    private ProductoNoEncontradoJDialog productoNoEncontradoJDialog = new ProductoNoEncontradoJDialog(new javax.swing.JFrame(), true);
    
    public GestProductosControlador(IntEmpGestProductosVista vista, Empleado empleadoAuth){
        this.vista = vista;
        this.empleadoAuth = empleadoAuth;
        this.vista.getAddAltavozBoton().addActionListener(new GestProductosControlador.AddAltavozButtonListener());
        this.vista.getAddOrdenadorBoton().addActionListener(new GestProductosControlador.AddOrdenadorButtonListener());
        this.vista.getAddTelevisorBoton().addActionListener(new GestProductosControlador.AddTelevisorButtonListener());
        this.vista.getAddSmartphoneBoton().addActionListener(new GestProductosControlador.AddSmartphoneButtonListener());
        this.vista.getMostrarProductosBoton().addActionListener(new GestProductosControlador.MostrarProductosButtonListener());
        this.vista.getModificarAltavozBoton().addActionListener(new GestProductosControlador.ModificarAltavozButtonListener());
        this.vista.getModificarOrdenadorBoton().addActionListener(new GestProductosControlador.ModificarOrdenadorButtonListener());
        this.vista.getModificarTelevisorBoton().addActionListener(new GestProductosControlador.ModificarTelevisorButtonListener());
        this.vista.getModificarSmartphoneBoton().addActionListener(new GestProductosControlador.ModificarSmartphoneButtonListener());
        this.vista.getEliminarProductoBoton().addActionListener(new GestProductosControlador.EliminarProductoButtonListener());
        this.vista.getBuscarProductoBoton().addActionListener(new GestProductosControlador.BuscarProductosButtonListener());
        
        
    }
    
    private class BuscarProductosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            buscarProductosVista.setVisible(true);
        }
    }
         
    private class EliminarProductoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            eliminarProductoVista.getBorrarIdBoton().addActionListener(new GestProductosControlador.BorrarIdButtonListener());
            eliminarProductoVista.getBorrarNombreBoton().addActionListener(new GestProductosControlador.BorrarNombreButtonListener());
            eliminarProductoVista.setVisible(true);
        }
    }
     
    private class ModificarAltavozButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarAltavozVista.getSubmitNombreBoton().addActionListener(new GestProductosControlador.SubmitNombreAltavozButtonListener());
            modificarAltavozVista.getSubmitIdBoton().addActionListener(new GestProductosControlador.SubmitIdAltavozButtonListener());
            modificarAltavozVista.getSubmitDatosNuevosBoton().addActionListener(new GestProductosControlador.SubmitAltavozButtonListener());
            modificarAltavozVista.setVisible(true);
        }
    }
    
    private class ModificarOrdenadorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarOrdenadorVista.getSubmitNombreBoton().addActionListener(new GestProductosControlador.SubmitNombreOrdenadorButtonListener());
            modificarOrdenadorVista.getSubmitIdBoton().addActionListener(new GestProductosControlador.SubmitIdOrdenadorButtonListener());
            modificarOrdenadorVista.getSubmitDatosNuevosBoton().addActionListener(new GestProductosControlador.SubmitOrdenadorButtonListener());
            modificarOrdenadorVista.setVisible(true);
        }
    }
    
    private class ModificarSmartphoneButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarSmartphoneVista.getSubmitNombreBoton().addActionListener(new GestProductosControlador.SubmitNombreSmartphoneButtonListener());
            modificarSmartphoneVista.getSubmitIdBoton().addActionListener(new GestProductosControlador.SubmitIdSmartphoneButtonListener());
            modificarSmartphoneVista.getSubmitDatosNuevosBoton().addActionListener(new GestProductosControlador.SubmitSmartphoneButtonListener());
            modificarSmartphoneVista.setVisible(true);
        }
    }
    
    private class ModificarTelevisorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarTelevisorVista.getSubmitNombreBoton().addActionListener(new GestProductosControlador.SubmitNombreTelevisorButtonListener());
            modificarTelevisorVista.getSubmitIdBoton().addActionListener(new GestProductosControlador.SubmitIdTelevisorButtonListener());
            modificarTelevisorVista.getSubmitDatosNuevosBoton().addActionListener(new GestProductosControlador.SubmitTelevisorButtonListener());
            modificarTelevisorVista.setVisible(true);
        }
    }
    
    private class AddAltavozButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            addAltavozVista.getSubmitAltavozBoton().addActionListener(new GestProductosControlador.SubmitAltavozButtonListener());
            addAltavozVista.setVisible(true);
        }
    }
    
    private class AddOrdenadorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            addOrdenadorVista.getSubmitOrdenadorBoton().addActionListener(new GestProductosControlador.SubmitOrdenadorButtonListener());
            addOrdenadorVista.setVisible(true);
        }
    }
    
    private class AddTelevisorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            addTelevisorVista.getSubmitTelevisorBoton().addActionListener(new GestProductosControlador.SubmitTelevisorButtonListener());
            addTelevisorVista.setVisible(true);
        }
    }
    
    private class AddSmartphoneButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            addSmartphoneVista.getSubmitSmartphoneBoton().addActionListener(new GestProductosControlador.SubmitSmartphoneButtonListener());
            addSmartphoneVista.setVisible(true);
        }
    }
    
    
    private class SubmitAltavozButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Altavoz addAltavoz = new Altavoz(gestorProductos.readProductos().size()+1, addAltavozVista.getNombre(), Double.parseDouble(addAltavozVista.getPrecio()), Integer.parseInt(addAltavozVista.getStock()), Integer.parseInt(addAltavozVista.getPotencia()), addAltavozVista.getMarca(), addAltavozVista.getModelo(), addAltavozVista.getColor());
            gestorProductos.addProducto(addAltavoz);
            addAltavozVista.setVisible(false);
            System.out.println("Altavoz Añadido correctamente");
        }
    }
    
    private class SubmitOrdenadorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Ordenador addOrdenador = new Ordenador(gestorProductos.readProductos().size()+1, addOrdenadorVista.getNombre(), Double.parseDouble(addOrdenadorVista.getPrecio()), Integer.parseInt(addOrdenadorVista.getStock()), Integer.parseInt(addOrdenadorVista.getRam()), Integer.parseInt(addOrdenadorVista.getAlmacenamiento()), addOrdenadorVista.getSistemaOperativo(), addOrdenadorVista.getMarca(), addOrdenadorVista.getModelo(), addAltavozVista.getColor());
            gestorProductos.addProducto(addOrdenador);
            addOrdenadorVista.setVisible(false);
            System.out.println("Ordenador Añadido correctamente");
        }
    }
    
    private class SubmitTelevisorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Televisor addTelevisor = new Televisor(gestorProductos.readProductos().size()+1, addTelevisorVista.getNombre(), Double.parseDouble(addTelevisorVista.getPrecio()), Integer.parseInt(addTelevisorVista.getStock()), Integer.parseInt(addTelevisorVista.getPulgadas()), addTelevisorVista.getMarca(), addTelevisorVista.getModelo(), addTelevisorVista.getColor());
            gestorProductos.addProducto(addTelevisor);
            System.out.println("Televisor Añadido correctamente");
        }
    }
    
    private class SubmitSmartphoneButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Smartphone addSmartphone = new Smartphone(gestorProductos.readProductos().size()+1, addSmartphoneVista.getNombre(), Double.parseDouble(addSmartphoneVista.getPrecio()), Integer.parseInt(addSmartphoneVista.getStock()), Integer.parseInt(addSmartphoneVista.getRam()), Integer.parseInt(addSmartphoneVista.getAlmacenamiento()), addSmartphoneVista.getSistemaOperativo(), addSmartphoneVista.getMarca(), addSmartphoneVista.getModelo(), addSmartphoneVista.getColor());
            gestorProductos.addProducto(addSmartphone);
            System.out.println("Smartphone Añadido correctamente");
        }
    }
    
    private class SubmitNombreAltavozButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarAltavozVista.setAltavozTextBoxes((Altavoz) gestorProductos.buscarProductoId(Integer.parseInt(modificarAltavozVista.getBuscarIdTextField().getText())));
        }
    }
    
    private class SubmitIdAltavozButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarAltavozVista.setAltavozTextBoxes((Altavoz) gestorProductos.buscarProductoNombre(modificarAltavozVista.getBuscarNombreTextField().getText()));
        }
    }
    
        private class SubmitNombreTelevisorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarTelevisorVista.setTelevisorTextBoxes((Televisor) gestorProductos.buscarProductoId(Integer.parseInt(modificarTelevisorVista.getBuscarIdTextField().getText())));
        }
    }
    
    private class SubmitIdTelevisorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarTelevisorVista.setTelevisorTextBoxes((Televisor) gestorProductos.buscarProductoNombre(modificarTelevisorVista.getBuscarNombreTextField().getText()));
        }
    }
    
        private class SubmitNombreOrdenadorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarOrdenadorVista.setOrdenadorTextBoxes((Ordenador) gestorProductos.buscarProductoId(Integer.parseInt(modificarOrdenadorVista.getBuscarIdTextField().getText())));
        }
    }
    
    private class SubmitIdOrdenadorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarOrdenadorVista.setOrdenadorTextBoxes((Ordenador) gestorProductos.buscarProductoNombre(modificarOrdenadorVista.getBuscarNombreTextField().getText()));
        }
    }
    
       private class SubmitNombreSmartphoneButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarSmartphoneVista.setSmartphoneTextBoxes((Smartphone) gestorProductos.buscarProductoId(Integer.parseInt(modificarSmartphoneVista.getBuscarIdTextField().getText())));
        }
    }
    
    private class SubmitIdSmartphoneButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            modificarSmartphoneVista.setSmartphoneTextBoxes((Smartphone) gestorProductos.buscarProductoNombre(modificarSmartphoneVista.getBuscarNombreTextField().getText()));
        }
    }
    
    private class BorrarNombreButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(gestorProductos.deleteProducto(eliminarProductoVista.getNombreTextField()) == false){
                productoNoEncontradoJDialog.setVisible(true);
            }
            else
                eliminarProductoVista.setVisible(false);

        }
    }
    
    private class BorrarIdButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(gestorProductos.deleteProducto(Integer.parseInt(eliminarProductoVista.getIdTextField())) == false){
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
    
    
    
}
