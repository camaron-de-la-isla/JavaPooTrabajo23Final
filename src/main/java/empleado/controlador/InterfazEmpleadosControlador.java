/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado.controlador;

import cliente.modelo.Cliente;
import cliente.modelo.GestorClientes;
import empleado.modelo.Empleado;
import empleado.vista.AddClienteVista;
import empleado.vista.IntEmpGestClientesVista;
import empleado.vista.IntEmpGestEmpleadosVista;
import empleado.vista.IntEmpGestPedidosVista;
import empleado.vista.IntEmpGestProductosVista;
import empleado.vista.IntEmpGestStockVista;
import empleado.vista.IntEmpHacerPedidoVista;
import empleado.vista.InterfazEmpleadosVista;
import empleado.vista.MostrarClientesVista;
import empleado.vista.NoPrivilegiosJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 *
 * @author sergi
 */
public class InterfazEmpleadosControlador {
    private InterfazEmpleadosVista vista;
    private Empleado empleadoAuth;
    private NoPrivilegiosJDialog noPrivilegiosJDialog;
    
    public InterfazEmpleadosControlador(InterfazEmpleadosVista vista, Empleado empleadoAuth) {
        this.vista = vista;
        this.empleadoAuth = empleadoAuth;
        this.vista.getGestClientesButton().addActionListener(new InterfazEmpleadosControlador.GestClientesButtonListener());
        this.vista.getGestEmpleadosButton().addActionListener(new InterfazEmpleadosControlador.GestEmpleadosButtonListener());
        this.vista.getGestPedidosButton().addActionListener(new InterfazEmpleadosControlador.GestPedidosButtonListener());
        this.vista.getGestProductosButton().addActionListener(new InterfazEmpleadosControlador.GestProductosButtonListener());
        this.vista.getGestStockButton().addActionListener(new InterfazEmpleadosControlador.GestStockButtonListener());
        this.vista.getHacerPedidoButton().addActionListener(new InterfazEmpleadosControlador.HacerPedidoButtonListener());
        vista.setNombreEmpleado(empleadoAuth.getNombre(), empleadoAuth.getApellidos());
        //Faltan los listeners        
    }
    
    private class GestClientesButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            IntEmpGestClientesVista gestClientesVista = new IntEmpGestClientesVista();
            GestClientesControlador gestClientesControlador = new GestClientesControlador(gestClientesVista, empleadoAuth);
            gestClientesVista.setNombreEmpleado(empleadoAuth.getNombre(), empleadoAuth.getApellidos());
            gestClientesVista.setVisible(true);
        }
    }

    
    
    
    private class GestEmpleadosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (empleadoAuth.getPrivilegios()==true){
            IntEmpGestEmpleadosVista gestEmpleadosVista = new IntEmpGestEmpleadosVista();
            GestEmpleadosControlador gestEmpleadosControlador = new GestEmpleadosControlador(gestEmpleadosVista, empleadoAuth);
            gestEmpleadosVista.setNombreEmpleado(empleadoAuth.getNombre(), empleadoAuth.getApellidos());
            gestEmpleadosVista.setVisible(true);
            }
            else
                noPrivilegiosJDialog.setVisible(true);
                
        }
    }

    private class GestPedidosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            IntEmpGestPedidosVista gestPedidosVista = new IntEmpGestPedidosVista();
            gestPedidosVista.setNombreEmpleado(empleadoAuth.getNombre(), empleadoAuth.getApellidos());
            gestPedidosVista.setVisible(true);
        }
    }
    
    private class GestProductosButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            IntEmpGestProductosVista gestProductosVista = new IntEmpGestProductosVista();
            gestProductosVista.setNombreEmpleado(empleadoAuth.getNombre(), empleadoAuth.getApellidos());
            gestProductosVista.setVisible(true);
        }
    }
    
    private class GestStockButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            IntEmpGestStockVista gestStockVista = new IntEmpGestStockVista();
            gestStockVista.setNombreEmpleado(empleadoAuth.getNombre(), empleadoAuth.getApellidos());
            gestStockVista.setVisible(true);
        }
    }
    
    private class HacerPedidoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            IntEmpHacerPedidoVista hacerPedidoVista = new IntEmpHacerPedidoVista();
            hacerPedidoVista.setNombreEmpleado(empleadoAuth.getNombre(), empleadoAuth.getApellidos());
            hacerPedidoVista.setVisible(true);
        }
    }
    

    
    
            
    
}
