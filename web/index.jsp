<%-- 
    Document   : index
    Created on : 7/10/2022, 12:43:39 AM
    Author     : Diego Sandoval
--%>
<%@page import="modelo.Tsangre" %>
<%@page import="java.util.HashMap" %>
<%@page import="modelo.select" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        
        <title>JSP Page</title>
    </head>
    <body>
        
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
        
        
                    
    <!-- A grey horizontal navbar that becomes vertical on small screens -->
<nav class="navbar navbar-expand-sm bg-light">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Link 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 3</a>
    </li>
  </ul>

</nav>                
            
        </div>
                    
        <div class="container">
        
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th>carne</th>
                    <th>nombres</th>
                    <th>apellidos</th>
                    <th>direccion</th>
                    <th>telefono</th>
                    <th>correo</th>
                    <th>fecha</th>
                    <th>sangre</th>
                    
                  </tr>
                </thead>
                <tbody id="tbl_estudiantes">
                    <%
                    select selc = new select();
                    DefaultTableModel tabla = new DefaultTableModel();
                    tabla = selc.leer();
                    
                    for(int t=0; t<tabla.getRowCount();t++){
                        out.println("<tr data-id=" + tabla.getValueAt(t, 0) + "data-id_s=" + tabla.getValueAt(t, 9)+ ">");
                            out.println("<td>" + tabla.getValueAt(t, 1) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 2) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 3) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 4) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 5) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 6) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 7) + "</td>");
                            out.println("<td>" + tabla.getValueAt(t, 8) + "</td>");
                        out.println("</tr>");
                    }

                    %>
                </tbody>
            </table>
            
        </div>
        
                <script type="text/javascript">
                    
                    $('#tbl_estudiantes').on('click','tr td',function(evt){
                     var target,id,carne,nombres,apellidos,direccion,telefono,correo,fecha_nacimiento,id_sangre;
                     target = $(event.target);
                     id = target.parent().data("id");
                     id_sangre = target.parent().data("id_sangre");
                     carne = target.parent("tr").find("td").eq(0).html();
                     nombres = target.parent("tr").find("td").eq(1).html();
                     apellidos = target.parent("tr").find("td").eq(2).html();
                     direccion = target.parent("tr").find("td").eq(3).html();
                     telefono = target.parent("tr").find("td").eq(4).html();
                     correo = target.parent("tr").find("td").eq(5).html();
                     fecha_nacimiento = target.parent("tr").find("td").eq(6).html();
                     
                     
                     $("#txt_id").val(id);
                     $("#txt_carne").val(carne);
                     $("#txt_nombres").val(nombres);
                     $("#txt_apellidos").val(apellidos);
                     $("#txt_direccion").val(direccion);
                     $("#txt_telefono").val(telefono);
                     $("#txt_correo").val(correo);
                     $("#drop_sangre").val(id_sangre);
                     $("#txt_fn").val(fecha_nacimiento);
                     
                     
                    });
                     
                    
                </script>   -->     
                
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    Open modal
  </button>    
                
                
                <div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        
          <h1>FORMULARIO EMPLEADOS</h1>
        
        <div class="container">
            
            <form action="control" method="post" class="form-group">
                
                <label for="lbl_id" >id</label>
                <input type="text" name="txt_id" id="txt_id" class="form-control"  value="0" readonly><!--readonly-->
                
                
                <label for="lbl_carne" >carne</label>
                <input type="text" name="txt_carne" id="txt_carne" class="form-control" placeholder="Ejemplo:12133" required>
                
                <label for="lbl_nombres" >nombres</label>
                <input type="text" name="txt_nombres" id="txt_nombres" class="form-control" placeholder="nombre" required>
            
                <label for="lbl_apellidos" >apellidos</label>
                <input type="text" name="txt_apellidos" id="txt_apellidos" class="form-control" placeholder="apellidos" required>
            
                <label for="lbl_direccion" >direccion</label>
                <input type="text" name="txt_direccion" id="txt_direccion" class="form-control" placeholder="direccion" required>
            
                <label for="lbl_telefono" >telefono</label>
                <input type="number" name="txt_telefono" id="txt_telefono" class="form-control" placeholder="telefono" required>
            
                <label for="lbl_correo" >EMAIL</label>
                <input type="text" name="txt_correo" id="txt_correo" class="form-control" placeholder="email" required>
            
                <label for="lbl_sangre" >Tipo de sangre</label>
                <select name="drop_sangre" id="drop_sangre" class="form-control">
                    
                    <% 
                            
                            Tsangre S = new Tsangre();
                            HashMap<String,String> drop = S.drop_sangre();
                            for(String i: drop.keySet()){

                                out.println("<option value= '" + i + "'>" + drop.get(i) + "</option> ");
                            }


                    %>
                        
                </select>
                
                <label for="lbl_fn" >fecha</label>
                <input type="text" name="txt_fn" id="txt_fn" class="form-control" placeholder="fecha" required>
                
                
                <br>
                <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">agregar</button>
                <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-secondary">modificar</button>
                
                <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" >Eliminar</button>
            </form>
          
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
                
                
    </body>
</html>
