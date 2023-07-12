
package guia5partejer3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DirectorioTelefonico {
  private Map<String, Cliente> directorio;

    public DirectorioTelefonico() {
        directorio = new HashMap<>();
    }

    public void agregarCliente(String nroTel, Cliente cliente) {
        directorio.put(nroTel, cliente);
    }

    public Cliente buscarCliente(String nroTel) {
        return directorio.get(nroTel);
    }

    public List<String> buscarTelefono(String apellido) {
        List<String> telefonos = new ArrayList<>();
        for (Map.Entry<String, Cliente> entry : directorio.entrySet()) {
            if (entry.getValue().getApellido().equalsIgnoreCase(apellido)) {
                telefonos.add(entry.getKey());
            }
        }
        return telefonos;
    }

    public List<Cliente> buscarClientes(String ciudad) {
        List<Cliente> clientes = new ArrayList<>();
        for (Cliente cliente : directorio.values()) {
            if (cliente.getCiudad().equalsIgnoreCase(ciudad)) {
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void borrarCliente(String telefono) {
        directorio.remove(telefono);
    }
}  

