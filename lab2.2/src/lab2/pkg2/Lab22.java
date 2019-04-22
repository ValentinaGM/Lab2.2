/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.pkg2;

import java.awt.Dimension;
import java.awt.Toolkit;
import modelo.DAO.VendedorDAO;
import modelo.Vendedor;
import vista.VentanaInicio;

/**
 *
 * @author valen
 */
public class Lab22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        VentanaInicio inicio = new VentanaInicio();
        VendedorDAO vd = new VendedorDAO();
        Vendedor vale = new Vendedor(1,"Valentina","Garcia","");
        Vendedor ivana = new Vendedor(2,"Ivana","Perich","");
        vd.añadirVendedor(vale);
        vd.añadirVendedor(ivana);
        inicio.setVisible(true);
    }

}
