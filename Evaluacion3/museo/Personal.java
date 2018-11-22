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
public class Personal extends Persona {

    private String cargo;
    private String especialidad;
    private int paga;

    public Personal(String nombre, String telefono, int rut, Nacionalidad nacionalidad) {
        super(nombre, telefono, rut, nacionalidad);
    }

    public Personal(String cargo, String nombre, String telefono, int rut, Nacionalidad nacionalidad) {
        super(nombre, telefono, rut, nacionalidad);
        this.cargo = cargo;
    }

    public Personal(String cargo, String especialidad, String nombre, String telefono, int rut, Nacionalidad nacionalidad) {
        super(nombre, telefono, rut, nacionalidad);
        this.cargo = cargo;
        this.especialidad = especialidad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

	public int getPaga() {
		return paga;
	}

	public void setPaga(int paga) {
		this.paga = paga;
	}

}
