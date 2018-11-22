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
public class Persona {
    private String nombre;
    private String telefono;
    private int rut;
    private Nacionalidad nacionalidad;

    public Persona(String nombre, String telefono, Nacionalidad nacionalidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.setNacionalidad(nacionalidad);
    }

    public Persona(String nombre, String telefono, int rut, Nacionalidad nacionalidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.rut = rut;
        this.setNacionalidad(nacionalidad);
    }

    public Persona(String nombre, Nacionalidad nacionalidad) {
        this.nombre = nombre;
        this.setNacionalidad(nacionalidad);
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
    
}