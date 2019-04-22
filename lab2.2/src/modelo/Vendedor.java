/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author valen
 */
public class Vendedor {

    private int id_vendedor;
    private String nombre;
    private String apellido;
    private String rut;

    public Vendedor(int id_vendedor, String nombre, String apellido, String rut) {
        this.id_vendedor = id_vendedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRut() {
        return rut;
    }

    public String toString() {
        return this.nombre + " " + apellido;
    }
}
