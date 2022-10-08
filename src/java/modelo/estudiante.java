/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Diego Sandoval
 */
public class estudiante {
    private int id,id_sangre;
    private String carne,nombres,apellidos,direccion,numero,correo,fecha_nacimiento;

    public estudiante(){}
    public estudiante(int id, String carne, String nombres, String apellidos, String direccion, String numero, String correo, String fecha_nacimiento, int id_sangre) {
        this.id = id;
        this.carne = carne;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.numero = numero;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_sangre = id_sangre;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId_sangre() {
        return id_sangre;
    }

    /**
     *
     * @param id_sangre
     */
    public void setId_sangre(int id_sangre) {
        this.id_sangre = id_sangre;
    }
    
    protected int agregar(){return 0;}
    protected int modificar(){return 0;}
    protected int eliminar(){return 0;}
    //protected void mostrar(){}
}
