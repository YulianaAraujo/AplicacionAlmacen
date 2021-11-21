/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen.controlador;

import almacen.modelo.Proveedor;
import almacen.dao.ProveedorDaoLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yulis Araujo
 */
@WebServlet(name = "ProveedorServelet", urlPatterns = {"/ProveedorServelet"})
public class ProveedorServlet extends HttpServlet {
    @EJB
    private ProveedorDaoLocal ProveedorDao;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String idProveedorStr = request.getParameter("idProveedor");
        String nombre = request.getParameter("nombre");
        int idproveedor = idProveedorStr.equals("") ? 0 : Integer.parseInt(action);
        Proveedor proveedor = new Proveedor(idproveedor, nombre);
        
        if("Add".equalsIgnoreCase(action)){
          ProveedorDao.addProveedor(proveedor);
        }else if("Edit".equalsIgnoreCase(action)){
            ProveedorDao.editProveedor(proveedor);
        }else if("Delete".equalsIgnoreCase(action)){
            ProveedorDao.deleteProveedor(idproveedor);
        }else if("Search".equalsIgnoreCase(action)){
            proveedor=ProveedorDao.getProveedor(idproveedor);
        }
        request.setAttribute("proveedor", proveedor);
        request.setAttribute("TodoProveedor", ProveedorDao.getTodoProveedor(""));
        request.getRequestDispatcher("proveedorInfo.jsp").forward(request, response);
    }

}
