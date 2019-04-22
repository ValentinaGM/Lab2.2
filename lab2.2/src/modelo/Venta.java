/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author valen
 */

public class Venta {

    private int id_venta;
    private String sucursal;
    private int monto;
    private Date fecha;
    private int id_vendedor;

    public Venta(int id_venta, String sucursal, int monto, Date fecha, int id_vendedor) {
        this.id_venta = id_venta;
        this.sucursal = sucursal;
        this.monto = monto;
        this.fecha = fecha;
        this.id_vendedor = id_vendedor;
    }

    public int getId_venta() {
        return id_venta;
    }

    public String getSucursal() {
        return sucursal;
    }

    public int getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

}
