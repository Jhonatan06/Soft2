
package edu.sw2.servlet;

import edu.sw2.beans.ClienteBean;
import edu.sw2.jdbc.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MostrarClientes", urlPatterns = {"/s02-Cliente"})
public class ServListarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession ses = request.getSession(true);

        String sql = "SELECT * FROM clientes";
        PreparedStatement stmt = null;
        Connection con = null;
        ResultSet rs = null;
        
        List<ClienteBean> listCli = new ArrayList<>();
        ClienteBean c = null;
        
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);            
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nombre = rs.getString(2);
                String estado = rs.getString(3);
                int utilidad = rs.getInt(4);
                String rating = rs.getString(5);
                
             c = new ClienteBean(nombre, estado, rating);
             listCli.add(c);             
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            System.out.println("-------------------------------" + c.getNombre());
                        
            ses.setAttribute("cliente", listCli); 
             
            RequestDispatcher rd = request.getRequestDispatcher("Clientes.jsp");
            rd.forward(request, response);
            return;            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
