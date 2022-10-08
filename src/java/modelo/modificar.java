/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author Diego Sandoval
 */
public class modificar extends estudiante{
    private conexion cn;
    
    public modificar() {
    }

    public modificar(int id, String carne, String nombres, String apellidos, String direccion, String numero, String correo, String fecha_nacimiento, int id_sangre) {
        super(id, carne, nombres, apellidos, direccion, numero, correo, fecha_nacimiento, id_sangre);
    }
    
    @Override
    public int modificar(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "UPDATE  estudiantes set carne=?, nombres=?,apellidos=?,direccion=?,telefono=?,correo=?,fecha_nacimiento=?,id_sangre=?  where id_estudiante=?  ;";
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            parametro.setString(1,getCarne());
            parametro.setString(2,getNombres());
            parametro.setString(3,getApellidos());
            parametro.setString(4,getDireccion());
            parametro.setString(5,getNumero());
            parametro.setString(6,getCorreo());
            parametro.setString(7,getFecha_nacimiento());
            parametro.setInt(8,getId_sangre());
            parametro.setInt(9,getId());
            
            retorno = parametro.executeUpdate();
            cn.close_conexion();
        }catch(SQLException ex){
        
            System.out.println(ex.getMessage());
            retorno =0;
        }
            return retorno;
    }
    
    @Override
    public int eliminar(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "DELETE FROM estudiantes WHERE id_estudiante=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            
            
            parametro.setInt(1,getId());
            
            retorno = parametro.executeUpdate();
            cn.close_conexion();
        }catch(SQLException ex){
        
            System.out.println(ex.getMessage());
            retorno =0;
        }
            return retorno;
    }
    
}
