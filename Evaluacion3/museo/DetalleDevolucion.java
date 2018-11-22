package museo;

import java.util.ArrayList;

public class DetalleDevolucion implements Detalle{
	
	ArrayList<String> listaDetalle = new ArrayList<>();
	
	
	public ArrayList<String> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(ArrayList<String> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	@Override
	public void nuevaLinea(String detalle) {
		listaDetalle.add(detalle);
		System.out.println("se ha agregado una linea a detalle de devolución");
	}

	@Override
	public void acutalizaLinea(String detalle, int pos) {
		listaDetalle.add(pos, detalle);		
	}

	@Override
	public void eliminaLinea(int pos) {
		listaDetalle.remove(pos);
		System.out.println("se ha eliminado una linea del detalle de devolución");
	}

	@Override
	public void mostrarDetalle() {
		for (String string : listaDetalle) {
			System.out.println(string);
		}
		
	}

	@Override
	public String verDetalle(int pos) {
		return listaDetalle.get(pos);		
	}
	
	

}
