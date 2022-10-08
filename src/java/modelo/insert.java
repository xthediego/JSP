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
public class insert extends estudiante{
    private conexion cn;
    
    public insert() {
    }

    public insert(int id, String carne, String nombres, String apellidos, String direccion, String numero, String correo, String fecha_nacimiento, int id_sangre) {
        super(id, carne, nombres, apellidos, direccion, numero, correo, fecha_nacimiento, id_sangre);
    }
    
    @Override
    public int agregar(){
        int retorno = 0;
        try{
            cn = new conexion();
            
            PreparedStatement parametro;
            String query = "INSERT INTO estudiantes(carne,nombres,apellidos,direccion,telefono,correo,fecha_nacimiento,id_sangre)VALUES(?,?,?,?,?,?,?,?);";
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
            
            retorno = parametro.executeUpdate();
            cn.close_conexion();
        }catch(SQLException ex){
        
            System.out.println(ex.getMessage());
            retorno =0;
        }
            return retorno;
    }
    
}
