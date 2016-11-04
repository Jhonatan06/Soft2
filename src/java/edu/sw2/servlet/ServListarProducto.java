/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sw2.servlet;

import edu.sw2.beans.ClienteBean;
import edu.sw2.beans.ProductoBean;
import edu.sw2.jdbc.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "ListarProducto", urlPatterns = {"/s04-Producto"})
public class ServListarProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ses = request.getSession(true);

        String sql = "SELECT * FROM productos";
        PreparedStatement stmt = null;
        Connection con = null;
        ResultSet rs = null;

        List<ProductoBean> listPro = new ArrayList<>();
        ProductoBean p = null;

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                String producto = rs.getString(1);
                String zona = rs.getString(2);
                int ingreso = rs.getInt(3);

                p = new ProductoBean(producto, zona, ingreso);
                listPro.add(p);
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

            /*
            System.out.println("-------------------------------" + p.getProducto());
            */
            
            ses.setAttribute("producto", listPro);
            RequestDispatcher rd = request.getRequestDispatcher("Producto.jsp");
            rd.forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
