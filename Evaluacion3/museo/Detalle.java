package museo;

public interface Detalle {
	public void nuevaLinea(String detalle);
	public void acutalizaLinea(String detalle, int pos);
	public void eliminaLinea(int pos);
	public void mostrarDetalle();
	public String verDetalle(int pos);
}
