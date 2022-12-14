package co.camcar.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.camcar.controlador.entity.Cliente;
import co.camcar.dao.ClienteDao;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	@Autowired
	private ClienteDao clienteDao;

	@RequestMapping("/lista")
	public String listaClientes(Model modelo) {
		//obtener los clientes desde le DAO
		List<Cliente> clientes = clienteDao.getClientes();
		//agregar los clientes al modelo
		modelo.addAttribute("clientes", clientes);
		return "lista-clientes"; //es un jsp
	}
	
	@RequestMapping("/formularioAgregar")
	public String muestraFormularioAgregar(Model modelo) {
		
		//bind datos clientes
		Cliente cliente  = new Cliente();
		modelo.addAttribute("cliente", cliente);
		return "formulario-cliente";
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente cliente) {
		
		//Insertar Cliente en Base de Datos
		clienteDao.insertarCliente(cliente);
		
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/formularioActualizar")
	public String muestraFormularioActualizar(@RequestParam("clienteId") int id, Model modelo) {
		//obtener cliente
		Cliente cliente  = clienteDao.getCliente(id);
		//bind datos clientes
		modelo.addAttribute("cliente", cliente);
		return "formulario-cliente";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId") int id) {
		clienteDao.eliminarCliente(id);
		return "redirect:/cliente/lista";
	}
}
