/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Vendedor;
import modelo.DAO.VendedorDAO;
import vista.VentanaInicio;
import vista.RegistrarVenta;
import vista.VReportes;

/**
 *
 * @author valen
 */
public class InicioController implements ActionListener {

    public InicioController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        VendedorDAO vd = new VendedorDAO();        
        ArrayList<Vendedor> vendedores = new ArrayList();
        vendedores = vd.getVendedores();
        if (e.getActionCommand().equals("registrar")) {
            RegistrarVenta registrarVenta = new RegistrarVenta();
            DefaultComboBoxModel model = new DefaultComboBoxModel();

            for (int i = 0; i < vendedores.size(); i++) {
                model.addElement(vendedores.get(i));
            }

            registrarVenta.getCbVendedor().setModel(model);
            registrarVenta.setVisible(true);
        }

        if (e.getActionCommand().equals("reporte")) {
            VReportes reporte = new VReportes();
            reporte.setVisible(true);
        }

    }
}
