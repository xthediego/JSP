/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Diego Sandoval
 */
public class select {
    private conexion cn;
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        
        try{
            cn = new conexion();
            cn.abrir_conexion();
            String query="SELECT e.id_estudiante as id, e.carne,e.nombres,e.apellidos,e.direccion,e.telefono,e.correo,e.fecha_nacimiento, s.sangre,s.id_sangre FROM estudiantes as e inner join sangre as s on e.id_sangre = s.id_sangre;";
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            String encabezados[]= {"id","carne","nombres","apellidos","direccion","telefono","correo","fecha","Tipo_de_sangre","id_sangre"};
            tabla.setColumnIdentifiers(encabezados);
            
            String datos[]= new String[10];
            while(consulta.next()){
                
                datos[0]= consulta.getString("id");
                datos[1]= consulta.getString("carne");
                datos[2]= consulta.getString("nombres");
                datos[3]= consulta.getString("apellidos");
                datos[4]= consulta.getString("direccion");
                datos[5]= consulta.getString("telefono");
                datos[6]= consulta.getString("correo");
                datos[7]= consulta.getString("fecha_nacimiento");
                datos[8]= consulta.getString("sangre");
                datos[9]= consulta.getString("id_sangre");
                
                tabla.addRow(datos);
            }   
            
            cn.close_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
    
}
