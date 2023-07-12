/*
 Un directorio telefónico posee una lista de Clientes de los que interesa conocer: dni, nombre,
apellido, ciudad y dirección. El directorio está compuesto por el número de teléfono y los datos
del Cliente (Directorio: <teléfono,Cliente> donde el teléfono no es un atributo del cliente. Cuando
agendamos un cliente al directorio telefónico lo agendamos con su número de teléfono, que es
único)
El directorio telefónico posee además las siguientes funcionalidades:
● agregarCliente(nroTel, Cliente):void  que permite registrar un nuevo cliente con su
respectivo nro de teléfono. Siendo el nro del teléfono la clave del mismo.
● buscarCliente(nroTel):Cliente  que en base al nro de teléfono retorna el Cliente asociado al
mismo.
● buscarTeléfono(apellido):List  que en base a un apellido nos devuelve una lista con los nros.
de teléfono asociados a dicho apellido.
● buscarClientes(ciudad):List  que en base a una ciudad nos devuelve una lista con los
Clientes asociados a dicha ciudad.
● borrarCliente(telefono):void que en base a un nro de teléfono elimina el cliente del directorio.

Luego desde el método main de una clase Test se pide:
 Crear un directorio.
 Cargar 5 clientes al directorio a través de su método agregarCliente, con sus respectivos
nros de teléfono.
 Probar el resto los métodos que posee directorio.
Importante: Armar el modelo UML representado las clases necesarias. Implementar en java.
 */
package guia5partejer3;

import java.util.List;

public class Guia5PartEjer3 {

   
    public static void main(String[] args) {
        // Crear el directorio telefónico
        DirectorioTelefonico directorio = new DirectorioTelefonico();

        // Cargar 5 clientes al directorio
        Cliente cliente1 = new Cliente("12345678", "Juan", "Pérez", "Buenos Aires", "Calle 123");
        Cliente cliente2 = new Cliente("87654321", "María", "Gómez", "Córdoba", "Avenida XYZ");
        Cliente cliente3 = new Cliente("56781234", "Carlos", "López", "Buenos Aires", "Calle 456");
        Cliente cliente4 = new Cliente("43218765", "Laura", "Fernández", "Córdoba", "Avenida ABC");
        Cliente cliente5 = new Cliente("98765432", "Pedro", "Rodríguez", "Buenos Aires", "Calle 789");

        directorio.agregarCliente("11111111", cliente1);
        directorio.agregarCliente("22222222", cliente2);
        directorio.agregarCliente("33333333", cliente3);
        directorio.agregarCliente("44444444", cliente4);
        directorio.agregarCliente("55555555", cliente5);

        // Probar los métodos del directorio
        Cliente clienteEncontrado = directorio.buscarCliente("33333333");
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.getNombre() + " " + clienteEncontrado.getApellido());
        } else {
            System.out.println("Cliente no encontrado.");
        }

        List<String> telefonosApellido = directorio.buscarTelefono("Fernández");
        if (!telefonosApellido.isEmpty()) {
            System.out.println("Teléfonos encontrados para el apellido Fernández:");
            for (String telefono : telefonosApellido) {
                System.out.println(telefono);
            }
        } else {
            System.out.println("No se encontraron teléfonos para el apellido Fernández.");
        }

        List<Cliente> clientesCiudad = directorio.buscarClientes("Buenos Aires");
        if (!clientesCiudad.isEmpty()) {
            System.out.println("Clientes encontrados en la ciudad de Buenos Aires:");
            for (Cliente cliente : clientesCiudad) {
                System.out.println(cliente.getNombre() + " " + cliente.getApellido());
            }
        } else {
            System.out.println("No se encontraron clientes en la ciudad de Buenos Aires.");
        }

        directorio.borrarCliente("44444444");
        System.out.println("Cliente con teléfono 44444444 eliminado.");

        // Verificar que el cliente se haya eliminado
        clienteEncontrado = directorio.buscarCliente("44444444");
        if (clienteEncontrado == null) {
            System.out.println("Cliente con teléfono 44444444 no encontrado.");
    }
    }
}
