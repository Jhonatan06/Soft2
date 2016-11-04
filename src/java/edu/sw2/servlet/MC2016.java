package edu.sw2.servlet;

import edu.sw2.beans.ClienteBean;
import edu.sw2.jdbc.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MC", urlPatterns = {"/s02"})
public class MC2016 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession ses = request.getSession(true);

        String sql = "SELECT * FROM clientes";
        PreparedStatement stmt = null;
        Connection con = null;
        ResultSet rs = null;

        List<ClienteBean> listM = new ArrayList<>();
        List<ClienteBean> listC = new ArrayList<>();
        ClienteBean m = null;
        ClienteBean c = null;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nombre = rs.getString(2);
                int utilidad = rs.getInt(4);
                int utilidadP = rs.getInt(6);

                int growE = rs.getInt(7);
                int growP = rs.getInt(8);

                m = new ClienteBean(utilidad, utilidadP);                

                c = new ClienteBean(growE, growP);
                
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
        }

        request.setAttribute("meta", m);
        request.setAttribute("grow", c);
        
        RequestDispatcher rd = request.getRequestDispatcher("Clientes.jsp");
        rd.forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
