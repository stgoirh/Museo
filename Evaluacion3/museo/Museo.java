/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo;

import java.util.ArrayList;

/**
 *
 * @author 19479689-7
 */
public class Museo {
	private int idMuseo;
	private String nombreMuseo;
	private String direccion;
	private String pais;
	private String contacto;// Tel√©fono probablemente
	private ArrayList<Obra> obrasEnExposicion = new ArrayList<>();
	private ArrayList<Personal> personalMuseo = new ArrayList<>();
	private ArrayList<String> exposiciones = new ArrayList<>();
	private ArrayList<Prestamo> prestamos = new ArrayList<>();
	private ArrayList<Devolucion> devoluciones = new ArrayList<>();

	public Museo(int idMuseo, String nombreMuseo, String direccion, String pais, String contacto) {
		this.idMuseo = idMuseo;
		this.nombreMuseo = nombreMuseo;
		this.direccion = direccion;
		this.pais = pais;
		this.contacto = contacto;
	}

	public int getIdMuseo() {
		return idMuseo;
	}

	public void setIdMuseo(int idMuseo) {
		this.idMuseo = idMuseo;
	}

	public String getNombreMuseo() {
		return nombreMuseo;
	}

	public void setNombreMuseo(String nombreMuseo) {
		this.nombreMuseo = nombreMuseo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public ArrayList<Obra> getObrasEnExposicion() {
		return obrasEnExposicion;
	}

	public void setObrasEnExposicion(ArrayList<Obra> obrasEnExposicion) {
		this.obrasEnExposicion = obrasEnExposicion;
	}

	public ArrayList<Personal> getPersonalMuseo() {
		return personalMuseo;
	}

	public void setPersonalMuseo(ArrayList<Personal> personalMuseo) {
		this.personalMuseo = personalMuseo;
	}

	public ArrayList<String> getExposiciones() {
		return exposiciones;
	}

	public void setExposiciones(ArrayList<String> exposiciones) {
		this.exposiciones = exposiciones;
	}

	public void mostrarObrasEnExposicion() {
		for (int i = 0; i < exposiciones.size(); i++) {
			if (exposiciones.isEmpty()) {
				System.out.println("no hay exposiciones en este momento");
			} else {
				System.out.println(exposiciones.get(i));
			}
		}
	}

	public boolean buscarObra(String nomObra) {
		for (int i = 0; i < obrasEnExposicion.size(); i++) {
			if (obrasEnExposicion.get(i).getNombreObra().contains(nomObra)) {
				System.out.println("nombre obra: " + obrasEnExposicion.get(i).getNombreObra());
				System.out.println("descripciÛn: " + obrasEnExposicion.get(i).getDescripcion());
				System.out.println("autor: " + obrasEnExposicion.get(i).getAutor().getNombre());
				return true;
			}
		}
		return false;
	}

	public Obra buscarObra(String nomObra, ArrayList<Obra> lista) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNombreObra().contains(nomObra)) {
				System.out.println("nombre obra: " + lista.get(i).getNombreObra());
				System.out.println("descripciÛn: " + lista.get(i).getDescripcion());
				System.out.println("autor: " + lista.get(i).getAutor().getNombre());
				return lista.get(i);
			}
		}
		return null;
	}	

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public ArrayList<Devolucion> getDevoluciones() {
		return devoluciones;
	}

	public void setDevoluciones(ArrayList<Devolucion> devoluciones) {
		this.devoluciones = devoluciones;
	}
}