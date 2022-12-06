package co.camcar.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
