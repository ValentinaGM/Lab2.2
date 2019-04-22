/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import modelo.Venta;

/**
 *
 * @author valen
 */
public class VentaDAO {

    Conexion con;

    public VentaDAO() {
        con = new Conexion();
    }

    public boolean añadirVenta(Venta v) {
        boolean respuesta = false;
        Connection accesoBD = con.getConexion();

        try {
            String sql = "INSERT INTO venta VALUES ( NULL ,'" + v.getSucursal() + "', '" + v.getMonto() + "', '" + v.getFecha() + "','" + v.getId_vendedor() + "')";
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
    
    public ArrayList<Venta> getVentasMes(String mes) {

        ArrayList<Venta> ventas = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM venta WHERE fecha BETWEEN '2019-" + mes + "-01' and '2019-" + mes + "-31'";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int idVenta = Integer.parseInt(resultados.getString("id_venta"));
                String sucursal = resultados.getString("sucursal");
                int monto = Integer.parseInt(resultados.getString("monto"));
                Date fecha = resultados.getDate("fecha");
                int idVendedor = Integer.parseInt(resultados.getString("id_vendedor"));
                ventas.add(new Venta(idVenta, sucursal, monto, fecha, idVendedor));
            }
            accesoBD.close();
            return ventas;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Integer> getVentasMejorVendedor(String mes) {
        ArrayList<Integer> ventasMejorVendedor = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT id_vendedor, SUM(monto) AS total FROM venta WHERE fecha BETWEEN '2019-" + mes + "-01' and '2019-" + mes + "-31' Group By id_vendedor order BY total DESC";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) {
                int idMejorVendedor = Integer.parseInt(resultados.getString("id_vendedor"));
                int totalMejorVendedor = Integer.parseInt(resultados.getString("total"));
                ventasMejorVendedor.add(idMejorVendedor);
                ventasMejorVendedor.add(totalMejorVendedor);
            }            
            return ventasMejorVendedor;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

}
