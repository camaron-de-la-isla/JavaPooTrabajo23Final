
import cliente.modelo.Cliente;
import cliente.modelo.GestorClientes;
import cliente.modelo.InterfazCliente;
import common.authentificacion.modelo.PasarelaAuthentificacion;
import common.producto.modelo.GestorProductos;
import common.producto.modelo.Producto;
import empleado.modelo.Empleado;
import empleado.modelo.GestorEmpleados;
import empleado.InterfazEmpleados;
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

        GestorClientes gestor = new GestorClientes();
        gestor.inicializarClientes();
        List<Cliente> clientes = gestor.readClientes();
        for(int i=0; i<clientes.size(); i++){
            System.out.println("SIN FUNCION");
            System.out.println(clientes.get(i).toString());
        }
        
        System.out.println("CON FUNCION");
        System.out.println(gestor.MostrarClientes());

    }
}
