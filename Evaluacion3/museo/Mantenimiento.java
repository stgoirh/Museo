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
public class Mantenimiento {
	Museo museo;

	private ArrayList<Obra> obrasEnMantenimiento = new ArrayList<>();

	public Mantenimiento(Museo museo) {
		this.museo = museo;
	}

	// obras
	public void agregarNuevaObra(Obra obra) {
		if (museo.getObrasEnExposicion().isEmpty()) {
			museo.getObrasEnExposicion().add(obra);
			System.out.println("se ha añadido la obra al museo");
		} else if (museo.getObrasEnExposicion().contains(obra)) {
			System.out.println("la obra ya se encuentra en el museo o en la cola de mantenimiento");
		} else {
			museo.getObrasEnExposicion().add(obra);
			System.out.println("se ha añadido la obra al museo");
		}
	}

	public void agregarAMantenimiento(Obra obra) {
		if (this.obrasEnMantenimiento.contains(obra)) {
			System.out.println("la obra ya se encuentra en la cola de mantenimiento");
		} else {
			museo.getObrasEnExposicion().remove(obra);
			this.obrasEnMantenimiento.add(obra);
			System.out.println("se ha añadido la obra a la cola de mantenimiento");
		}
	}

	public void quitarDeMantenimiento(Obra obra) {
		if (this.obrasEnMantenimiento.contains(obra)) {
			this.obrasEnMantenimiento.remove(obra);
		} else {
			System.out.println("la obra no se encuentra en la cola de mantenimiento");
		}
	}

	public void actualizarDescipcionObra(Obra obra, String desc) {
		if (this.obrasEnMantenimiento.contains(obra)) {
			obra.setDescripcion(desc);
		} else {
			System.out.println("la obra no se encuentra en la cola de mantenimiento");
		}
	}

	public void cambiarDeLocacion(Obra obra, String nLocacion) {
		if (this.obrasEnMantenimiento.contains(obra)) {
			obra.setUbicacion(nLocacion);
		} else {
			System.out.println("la obra no se encuentra en la cola de mantenimiento");
		}
	}

	public void terminarMantenimiento(Obra obra) {
		if (this.obrasEnMantenimiento.contains(obra)) {
			quitarDeMantenimiento(obra);
			System.out.println("se ha terminado el mantenimiento de la obra");
			museo.getObrasEnExposicion().add(obra);
		} else {
			System.out.println("la obra no se encuentra en la cola de mantenimiento");
		}
	}
	
	//
	// exposiciones, etc
	public void crearExposicion(String nombreExposicion, String fechaInicio, String fechaFin, String lugar) {
		String evento;
		evento = nombreExposicion + " desarrollado desde " + fechaInicio + " hasta " + fechaFin + " en " + lugar
				+ " del museo";
		museo.getExposiciones().add(evento);
	}

	public void eliminarEvento(int pos) {
		museo.getExposiciones().remove(pos);
		System.out.println("se ha removido el evento");
	}

	//
	// personal del museo
	public void contratarPersonal(Personal persona) {
		if (museo.getPersonalMuseo().contains(persona)) {
			System.out.println("ese empleado ya se encuentra contratado");
		} else {
			museo.getPersonalMuseo().add(persona);
			System.out.println("se ha contratado a " + persona.getNombre());
		}
	}

	public void despedirPersonal(Personal persona) {
		if (museo.getPersonalMuseo().contains(persona)) {
			museo.getPersonalMuseo().remove(persona);
			System.out.println("se ha despedido a: " + persona.getNombre());
		} else {
			System.out.println("no se encuentra contratado");
		}
	}


	public ArrayList<Obra> getObrasEnMantenimiento() {
		return obrasEnMantenimiento;
	}

	public void setObrasEnMantenimiento(ArrayList<Obra> obrasEnMantenimiento) {
		this.obrasEnMantenimiento = obrasEnMantenimiento;
	}
}
