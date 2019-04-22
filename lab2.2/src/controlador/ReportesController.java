/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.DAO.VendedorDAO;
import modelo.DAO.VentaDAO;
import modelo.Vendedor;
import modelo.Venta;
import vista.VReportes;

/**
 *
 * @author valen
 */
public class ReportesController implements ActionListener {
    VReportes vreportes;

    public ReportesController(VReportes vreportes) {
        this.vreportes = vreportes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("obtener")) {
            VentaDAO ventaDAO = new VentaDAO();
            VendedorDAO vDAO = new VendedorDAO();
            int numeroMes = vreportes.getCbMes().getSelectedIndex() + 1;
            ArrayList<Integer> ventasMejorVendedor = new ArrayList<>();
            ventasMejorVendedor = ventaDAO.getVentasMejorVendedor(String.valueOf(numeroMes));
            ArrayList<Vendedor> vendedores = new ArrayList<>();
            vendedores = vDAO.getVendedores();
            String Nombre = "";
            for (int i = 0; i < vendedores.size(); i++) {
                if (vendedores.get(i).getId_vendedor() == ventasMejorVendedor.get(0)) {
                    Nombre = vendedores.get(i).getNombre() + " " + vendedores.get(i).getApellido();
                }
            }
            vreportes.setLMejorVendedor(Nombre);
            vreportes.setLTotal(String.valueOf(ventasMejorVendedor.get(1)));
                        
            ArrayList<Venta> VentasMes = new ArrayList<>();
            VentasMes = ventaDAO.getVentasMes(String.valueOf(numeroMes));
            int totalMes = 0;
            Venta ventaMayor = VentasMes.get(0);
            for (int i = 0; i < VentasMes.size(); i++) {
                totalMes = totalMes + VentasMes.get(i).getMonto();
                if (VentasMes.get(i).getMonto() > ventaMayor.getMonto()) {
                    ventaMayor = VentasMes.get(i);
                }
            }
            int promedio = (int) (totalMes / VentasMes.size());
            
            for (int i = 0; i < vendedores.size(); i++) {
                if (vendedores.get(i).getId_vendedor() == ventaMayor.getId_vendedor()) {
                    Nombre = vendedores.get(i).getNombre() + " " + vendedores.get(i).getApellido();
                }
            }
            vreportes.setLMayor(String.valueOf(ventaMayor.getMonto()));
            vreportes.setLVendedor(Nombre);
            vreportes.setLPromedio(String.valueOf(promedio));

        } else if (e.getActionCommand().equals("cerrar")) {
            vreportes.dispose();
        } else if (e.getActionCommand().equals("imprimir")) {
            JOptionPane.showMessageDialog(null, "Imprimiendo reporte...", "Imprimir", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
