/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.insert;
import modelo.modificar;

/**
 *
 * @author Diego Sandoval
 */
public class control extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    insert sr;
    modificar mo;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet control</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet control at " + request.getContextPath() + "</h1>");
            out.println("<a href='index.jsp'>REGRESAR</a>");
            sr = new insert(0,request.getParameter("txt_carne"), request.getParameter("txt_nombres"), request.getParameter("txt_apellidos"), request.getParameter("txt_direccion"),request.getParameter("txt_telefono"),request.getParameter("txt_correo") ,request.getParameter("txt_fn"),Integer.valueOf(request.getParameter("drop_puesto"))   );

            if("agregar".equals(request.getParameter("btn_agregar"))){
                
                
                if(sr.agregar() > 0){
                        //sr.agregar();
                        //out.println("<h1> egregado  </h1>");
                        //out.println("<a href='index.jsp'>REGRESAR</a>");
                        response.sendRedirect("index.jsp");
                }else{
                        out.println("<h1>error.......</h1>");
                        out.println("<a href='index.jsp'>REGRESAR</a>");
                }
            }
            //modificar
            if("modificar".equals(request.getParameter("btn_modificar"))){
                
                
                if(mo.modificar() > 0){
                        //sr.agregar();
                        //out.println("<h1> egregado  </h1>");
                        //out.println("<a href='index.jsp'>REGRESAR</a>");
                        response.sendRedirect("index.jsp");
                }else{
                        out.println("<h1>no se modifico error.......</h1>");
                        out.println("<a href='index.jsp'>REGRESAR</a>");
                }
            }
            
            //eliminar
            if("eliminar".equals(request.getParameter("btn_eliminar"))){
                
                
                if(mo.eliminar() > 0){
                        //sr.agregar();
                        //out.println("<h1> egregado  </h1>");
                        //out.println("<a href='index.jsp'>REGRESAR</a>");
                        response.sendRedirect("index.jsp");
                }else{
                        out.println("<h1>no se elimino.......</h1>");
                        out.println("<a href='index.jsp'>REGRESAR</a>");
                }
            }
       
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
