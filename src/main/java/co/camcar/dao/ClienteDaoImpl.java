package co.camcar.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.camcar.controlador.entity.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		//Obtener la sesión
		Session session = sessionFactory.getCurrentSession();
		//Crear la consulta (Query)
		Query<Cliente> consulta = session.createQuery("from Cliente", Cliente.class);
		//ejecutar la query devolver los resultados
		List<Cliente> clientes = consulta.getResultList();
		return clientes;
	}

	@Override
	@Transactional
	public void insertarCliente(Cliente cliente) {
		//Obtener la sesión
		Session session = sessionFactory.getCurrentSession();
		//insertar cliente en bbdd
		//session.save(cliente); insert
		session.saveOrUpdate(cliente);//insert and update
		
	}

	@Override
	@Transactional
	public Cliente getCliente(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cliente cliente = session.get(Cliente.class, id);
		return cliente;
	}

	@Override
	@Transactional
	public void eliminarCliente(int id) {
		Session session = sessionFactory.getCurrentSession();
		//session.delete(id);
		Query consulta = session.createQuery("delete from Cliente where id=:clienteId");
		consulta.setParameter("clienteId", id);
		consulta.executeUpdate();
	}

}
