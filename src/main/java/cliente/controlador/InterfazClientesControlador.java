/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.controlador;

/**
 *
 * @author sergi
 */

import cliente.vista.InterfazClientesVista;
import common.producto.modelo.GestorProductos;
import common.producto.modelo.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazClientesControlador {
    private InterfazClientesVista vista;
    private GestorProductos gestorProductos;
    private List<Producto> listaProductos;
    
    public InterfazClientesControlador(InterfazClientesVista vista) {
        this.vista = vista;
        this.gestorProductos = new GestorProductos();
        this.listaProductos = gestorProductos.readProductos();
        
        // Asignar listeners a los botones u otros componentes de la vista
        vista.getjButton1().addActionListener(new InicioButtonListener());
        vista.getjButton2().addActionListener(new CategoriaButtonListener("Altavoces"));
        vista.getjButton3().addActionListener(new CategoriaButtonListener("Ordenadores"));
        vista.getjButton4().addActionListener(new CategoriaButtonListener("Smartphones"));
        vista.getjButton5().addActionListener(new CategoriaButtonListener("Televisores"));
        vista.getjButton6().addActionListener(new BuscarButtonListener());
        vista.getjButton8().addActionListener(new PopupButtonListener());
        
        // Cargar los productos en la tabla al iniciar la vista
        vista.cargarProductos();
    }
    

    // Listeners para los botones
    
    class InicioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Acciones al hacer clic en el botón de inicio
            JOptionPane.showMessageDialog(vista, "Clic en el botón de inicio");
        }
    }
    
    class CategoriaButtonListener implements ActionListener {
        private String categoria;
        
        public CategoriaButtonListener(String categoria) {
            this.categoria = categoria;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // Acciones al hacer clic en un botón de categoría
            JOptionPane.showMessageDialog(vista, "Clic en el botón de la categoría: " + categoria);
        }
    }
    
    class BuscarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Acciones al hacer clic en el botón de buscar
            JOptionPane.showMessageDialog(vista, "Clic en el botón de buscar");
        }
    }
    
    class PopupButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Acciones al hacer clic en el botón con menú emergente
            JOptionPane.showMessageDialog(vista, "Clic en el botón con menú emergente");
        }
    }
    
      public static void main(String[] args) {
        // Crear la instancia de la vista
        InterfazClientesVista vista = new InterfazClientesVista();
        
        // Crear la instancia del controlador y pasar la vista como parámetro
        InterfazClientesControlador controlador = new InterfazClientesControlador(vista);
        
        // Establecer la vista visible
        vista.setVisible(true);
    }
}

