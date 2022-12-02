package co.camcar.conexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConectaCRUD
 */
@WebServlet("/ConectaCRUD")
public class ConectaCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConectaCRUD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String jdbcUrl="jdbc:mysql://localhost:3306/gestionPedidosCRUD?useSSL=false";
		String user ="root";
		String pass ="";
		
		String dirver = "com.mysql.cj.jdbc.Driver";
		try {
			PrintWriter out = response.getWriter();
			out.print("Nombre de la base de datos: "+jdbcUrl+"\n");
			Class.forName(dirver);
			Connection connection = DriverManager.getConnection(jdbcUrl, user,pass);
			out.print("Conectado");
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
