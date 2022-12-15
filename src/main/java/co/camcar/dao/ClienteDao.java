package co.camcar.dao;

import java.util.List;

import co.camcar.controlador.entity.Cliente;

public interface ClienteDao {
	
	List<Cliente> getClientes();

	void insertarCliente(Cliente cliente);
	
	Cliente getCliente(int id);
	
	void eliminarCliente(int id);

}
