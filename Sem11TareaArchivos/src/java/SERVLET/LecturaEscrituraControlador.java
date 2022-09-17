
package SERVLET;

import BEAN.TrabajadorBean;
import DAO.TrabajadorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LecturaEscrituraControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcad=request.getParameter("op");
        int op = Integer.parseInt(opcad);
        switch(op){
            case 1:{
                TrabajadorDAO objTrabajadorDAO = new TrabajadorDAO();
                ArrayList listatrabajador=objTrabajadorDAO.LeeFichero();
                request.setAttribute("listatrabajador",listatrabajador);
                getServletContext().getRequestDispatcher("/Principal.jsp").forward(request, response);
                break;
            }
          
            
            case 4:{
            
                String codcad=request.getParameter("txtcodigo");
                int codigo=Integer.parseInt(codcad);
                String nombre = request.getParameter("txtnombre");
                String sueldo = request.getParameter("txtsueldo");
                TrabajadorBean objCarreraBean = new TrabajadorBean(codigo,nombre,sueldo);
              
                TrabajadorDAO objRegionDAO = new TrabajadorDAO();
                objRegionDAO.EscribeFichero(objCarreraBean);
                
                 TrabajadorDAO objCarreraDAO = new TrabajadorDAO();                
                ArrayList listatrabajador=objCarreraDAO.LeeFichero();
               request.setAttribute("listatrabajador",listatrabajador);
                getServletContext().getRequestDispatcher("/Principal.jsp").forward(request, response);
              
                break;
            }
  
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
