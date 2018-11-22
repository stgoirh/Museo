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
public class Devolucion implements Folio {
	int folio;
	String fecha;
	String resolucion;
	String comentario;
	Museo museoOrigen;
	Museo museoDestino;
	ArrayList<Obra> obrasPrestadas = new ArrayList<>();
	Seguro seguro;
	DetalleDevolucion detalle;

	public Devolucion(int folioActual, String fecha, String resolucion, String comentario, Museo museoOrigen,
			Museo museoDestino, Seguro seguro, DetalleDevolucion detalle) {
		this.folio = generarFolio(folioActual);
		this.fecha = fecha;
		this.resolucion = resolucion;
		this.comentario = comentario;
		this.museoOrigen = museoOrigen;
		this.museoDestino = museoDestino;
		this.seguro = seguro;
		this.detalle = detalle;
		this.museoOrigen.getDevoluciones().add(this);
	}

	public void devolverObras() {
		for (int i = 0; i < obrasPrestadas.size(); i++) {
			if (museoDestino.getObrasEnExposicion().contains(obrasPrestadas.get(i))) {
				museoDestino.getObrasEnExposicion().remove(obrasPrestadas.get(i));
				museoOrigen.getObrasEnExposicion().add(obrasPrestadas.get(i));
				detalle.nuevaLinea("la obra " + obrasPrestadas.get(i).getNombreObra() + " se ha devuelto");
			} else {
				detalle.nuevaLinea("la obra " + obrasPrestadas.get(i).getNombreObra() + " no se encuentra en el museo");
			}
		}

	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Museo getMuseoOrigen() {
		return museoOrigen;
	}

	public void setMuseoOrigen(Museo museoOrigen) {
		this.museoOrigen = museoOrigen;
	}

	public Museo getMuseoDestino() {
		return museoDestino;
	}

	public void setMuseoDestino(Museo museoDestino) {
		this.museoDestino = museoDestino;
	}

	public ArrayList<Obra> getObrasPrestadas() {
		return obrasPrestadas;
	}

	public void setObrasPrestadas(ArrayList<Obra> obrasPrestadas) {
		this.obrasPrestadas = obrasPrestadas;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	@Override
	public int generarFolio(int folioActual) {
		// TODO Auto-generated method stub
		return folioActual + 1;
	}

	public void agregarObra(Obra obra) {
		if (obrasPrestadas.contains(obra)) {
			System.out.println("la obra ya esta en la lista de devolución");
		} else if (museoDestino.getObrasEnExposicion().contains(obra)) {
			obrasPrestadas.add(obra);
			detalle.nuevaLinea("la obra " + obra.getNombreObra() + " se ha añadido a la lista de devolución");
		} else {
			System.out.println("la obra no se encuentra");
		}
	}

	public void agregarObra(Obra obra, int pos) {
		if (obrasPrestadas.contains(obra)) {
			System.out.println("la obra ya se encuentra en la lista de devolución");
		} else {
			obrasPrestadas.add(pos, obra);
			detalle.nuevaLinea("la obra " + obra.getNombreObra()
					+ " se ha añadido a la lista de devolución en la posición " + pos);
		}
	}

	public void quitarObra(Obra obra) {
		if (obrasPrestadas.contains(obra)) {
			obrasPrestadas.remove(obra);
			detalle.nuevaLinea("la obra " + obra.getNombreObra() + " se ha eliminado de la lista de devolución");
		} else {
			System.out.println("la obra no se encuentra en la lista de devolución");
		}

	}

}
