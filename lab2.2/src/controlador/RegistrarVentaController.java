/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.DAO.VentaDAO;
import modelo.Vendedor;
import modelo.Venta;
import vista.RegistrarVenta;

/**
 *
 * @author valen
 */
public class RegistrarVentaController implements ActionListener {

    public RegistrarVenta registrarVenta;

    public RegistrarVentaController(RegistrarVenta registrarVenta) {
        this.registrarVenta = registrarVenta;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("registrar venta")) {
            String sucursal = (String) registrarVenta.getCbSucursal().getSelectedItem();
            int monto = Integer.parseInt(registrarVenta.getTfMonto().getText());
            Date fecha = this.formatoFecha(registrarVenta.getTfFecha().getText());
            Vendedor v = (Vendedor) registrarVenta.getCbVendedor().getSelectedItem();
            VentaDAO vd = new VentaDAO();
            if (vd.añadirVenta(new Venta(0, sucursal, monto, fecha, v.getId_vendedor()))) {
                JOptionPane.showMessageDialog(null, "Venta ingresada con éxito", "Nueva Venta", JOptionPane.INFORMATION_MESSAGE);
                registrarVenta.dispose();
            }

        }
    }

    public Date formatoFecha(String strFecha) {
        Date fecha = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        try {
            fecha = formato.parse(strFecha);            
        } catch (Exception e) {
            System.out.println(e);
        }
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        return fechaSQL;
    }
}
