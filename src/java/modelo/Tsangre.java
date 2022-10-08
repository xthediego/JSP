/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.util.HashMap;
import java.sql.SQLException;
/**
 *
 * @author Diego Sandoval
 */
public class Tsangre {
    private String sangre;
    private int id_sangre;
    conexion cn;

    public Tsangre(){}
    public Tsangre(String sangre, int id_sangre) {
        this.sangre = sangre;
        this.id_sangre = id_sangre;
    }

    
    
    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    public int getId_sangre() {
        return id_sangre;
    }

    public void setId_sangre(int id_sangre) {
        this.id_sangre = id_sangre;
    }
    
    public HashMap drop_sangre(){
        HashMap<String,String> drop = new HashMap();
        
        try{
            cn = new conexion();
            String query="SELECT id_sangre as id,sangre FROM sangre;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            
            while(consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("sangre"));
        
            }
            
            cn.close_conexion();
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
        }
        
        
        return drop;
    }
    
    
    
}
