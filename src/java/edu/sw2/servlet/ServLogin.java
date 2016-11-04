package edu.sw2.servlet;

import edu.sw2.jdbc.Conexion;
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

@WebServlet(name = "ServLogin", urlPatterns = {"/s03"})
public class ServLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession(true);
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("password");

        String sql = "SELECT * FROM login";
        PreparedStatement stmt = null;
        Connection con = null;
        ResultSet rs = null;
        String pag = "";
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();            
            while (rs.next()) {
                int codigo = rs.getInt(1);
                String cod = Integer.toString(codigo);
                String nombre = rs.getString(2);
                String pass = rs.getString(3);

                if (usuario.equalsIgnoreCase(nombre)
                        && (clave.equalsIgnoreCase(pass))) {

                    pag = "Index.jsp";
                } else {

                    pag = "login.html";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher(pag);
        rd.forward(request, response);
        return;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
