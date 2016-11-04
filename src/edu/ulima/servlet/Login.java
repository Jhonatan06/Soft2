package edu.ulima.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ulima.jdbc.Conexion;

@WebServlet("/s01")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession(true);
		String usuario = request.getParameter("usuario");
        String clave = request.getParameter("pwd");
        
        
        String sql = "SELECT * FROM login";
        PreparedStatement stmt = null;
        Connection con = null;
        ResultSet rs = null;
                
        try{
        	con = Conexion.getConnection();
        	stmt = con.prepareStatement(sql);
        	rs = stmt.executeQuery();
        	while (rs.next()){
        		int codigo = rs.getInt(1);
        		String cod = Integer.toString(codigo);
        		String nombre = rs.getString(2);
        		String pass = rs.getString(3);
        		
        		if (usuario.equalsIgnoreCase(cod) && 
                        ( clave.equalsIgnoreCase(pass))) {            
        			        			
                    String pag = "/Principal.jsp";
                    RequestDispatcher rd = request.getRequestDispatcher(pag);
                    rd.forward(request, response);
                    return;
                } else {
             	
                    String pag = "/Login.jsp";
                    RequestDispatcher rd = request.getRequestDispatcher(pag);
                    rd.forward(request, response);
                    return;
                }
        	}
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
        	try {        	
        		rs.close();
        		stmt.close();
        		con.close();
        	    } catch (SQLException ex) {
        		ex.printStackTrace();
        	    }
        }
        
	}

}
