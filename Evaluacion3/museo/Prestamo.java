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
public class Prestamo implements Folio {
	int folio;
	String fecha;
	String resolucion;
	String comentario;
	Museo museoOrigen;
	Museo museoDestino;
	ArrayList<Obra> obrasPrestadas = new ArrayList<>();
	Seguro seguro;
	DetallePrestamo detalle;

	public Prestamo(int folioActual, String fecha, String resolucion, String comentario, Museo museoOrigen,
			Museo museoDestino, Seguro seguro, DetallePrestamo detalle) {
		this.folio = generarFolio(folioActual);
		this.fecha = fecha;
		this.resolucion = resolucion;
		this.comentario = comentario;
		this.museoOrigen = museoOrigen;
		this.museoDestino = museoDestino;
		this.seguro = seguro;
		this.detalle = detalle;
		this.museoOrigen.getPrestamos().add(this);
	}

	public void comenzarPrestamo() {
		for (int i = 0; i < obrasPrestadas.size(); i++) {
			if (museoOrigen.getObrasEnExposicion().contains(obrasPrestadas.get(i))) {
				museoOrigen.getObrasEnExposicion().remove(obrasPrestadas.get(i));
				museoDestino.getObrasEnExposicion().add(obrasPrestadas.get(i));
				detalle.nuevaLinea("la obra " + obrasPrestadas.get(i).getNombreObra() + "se ha prestado al museo");
			} else {
				detalle.nuevaLinea("la obra " + obrasPrestadas.get(i).getNombreObra() + " no se encuentra en el museo");
			}
		}

	}

	/*
	 * public void terminarPrestamo(){ if
	 * (museoDestino.getObrasEnExposicion().contains(obra)) {
	 * museoDestino.getObrasEnExposicion().remove(obra);
	 * museoOrigen.getObrasEnExposicion().add(obra); }else{
	 * System.out.println("la obra no se encuentra en el museo"); } }
	 */
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

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public ArrayList<Obra> getObrasPrestadas() {
		return obrasPrestadas;
	}

	public void setObrasPrestadas(ArrayList<Obra> obrasPrestadas) {
		this.obrasPrestadas = obrasPrestadas;
	}

	@Override
	public int generarFolio(int folioActual) {
		// TODO Auto-generated method stub
		return folioActual + 1;
	}

	public void agregarObra(Obra obra) {
		if (obrasPrestadas.contains(obra)) {
			System.out.println("la obra ya se encuentra en la lista");
		} else if (museoOrigen.getObrasEnExposicion().contains(obra)) {
			obrasPrestadas.add(obra);
			detalle.nuevaLinea("se ha añadido la obra " + obra.getNombreObra() + "a la lista de prestamos");
		} else {
			System.out.println("la obra no se encuentra");
		}
	}

	public void agregarObra(Obra obra, int pos) {
		if (obrasPrestadas.contains(obra)) {
			System.out.println("la obra ya se encuentra en la lista de prestamo");
		} else {
			obrasPrestadas.add(pos, obra);
			detalle.nuevaLinea("se ha añadido la obra" + obra.getNombreObra() + "a la posicion: " + pos
					+ "a la lista de prestamos");
		}
	}

	public void quitarObra(Obra obra) {
		if (obrasPrestadas.contains(obra)) {
			obrasPrestadas.remove(obra);
			detalle.nuevaLinea("la obra se ha removido la obra" + obra.getNombreObra() + " de la lista de prestamo");
		} else {
			System.out.println("la obra no se encuentra en la lista de prestamo");
		}

	}

	public DetallePrestamo getDetalle() {
		return detalle;
	}

	public void setDetalle(DetallePrestamo detalle) {
		this.detalle = detalle;
	}
}
