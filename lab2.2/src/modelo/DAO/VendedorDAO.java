/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Vendedor;

/**
 *
 * @author valen
 */
public class VendedorDAO {

    Conexion con;

    public VendedorDAO() {
        this.con = new Conexion();
    }

    public boolean añadirVendedor(Vendedor v) {
        boolean respuesta = false;
        Connection accesoBD = con.getConexion();

        try {
            String sql = "INSERT INTO vendedor VALUES ( NULL ,'" + v.getNombre() + "', '" + v.getApellido() + "', '" + v.getRut() + "')";
            Statement st = accesoBD.createStatement();
            st.executeUpdate(sql);
            respuesta = true;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
        }
        return respuesta;
    }

    public ArrayList<Vendedor> getVendedores() {

        ArrayList<Vendedor> vendedores = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM Vendedor";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_vendedor = resultados.getInt("id_vendedor");
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                String rut = resultados.getString("rut");
                vendedores.add(new Vendedor(id_vendedor, nombre, apellido, rut));
            }
            accesoBD.close();
            return vendedores;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

}
