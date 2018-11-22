/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo;

/**
 *
 * @author 19479689-7
 */
public class Seguro {
    int identificador;
    String descripcion;
    String fecha;
    int monto;

    public Seguro(int identificador, String descripcion, String fecha, int monto) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.monto = monto;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    
}
