
import cliente.modelo.Cliente;
import cliente.modelo.InterfazCliente;
import common.authentificacion.modelo.PasarelaAuthentificacion;
import common.producto.modelo.GestorProductos;
import common.producto.modelo.Producto;
import empleado.modelo.Empleado;
import empleado.modelo.GestorEmpleados;
import empleado.modelo.InterfazEmpleados;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sergi
 */
public class Main {
    public static void main(String[] args) {
        PasarelaAuthentificacion p = new PasarelaAuthentificacion();
        Object usuarioObjeto = p.autentificar();

        if(usuarioObjeto instanceof Cliente) {
            Cliente cliente = (Cliente) usuarioObjeto;
            InterfazCliente interfazCliente = new InterfazCliente();
            interfazCliente.InterfazCli(cliente);
        }
        else if(usuarioObjeto instanceof Empleado) {
            Empleado empleado = (Empleado) usuarioObjeto;
            InterfazEmpleados interfazEmpleados = new InterfazEmpleados();
            interfazEmpleados.InterfazEmp(empleado);
        }
        else {
            System.out.println("Error");
        }

    }
}
