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
public class Administrador {
    private String usuario = "admin";
    private String contrasena = "admin";
    private Museo museo;
    private ArrayList<Personal> empleados;

    public Administrador(Museo museo) {
        this.setMuseo(museo);
    }
    public void agregarEmpleado(Personal empleado){
        if (empleados.contains(empleado)) {
            System.out.println("el empleado ya a sido agregado");
        }else{
            empleados.add(empleado);
            System.out.println("el empleado ha sido agregado");
        }
    }
    public void despedirEmpleado(Personal empleado){
        if (empleados.contains(empleado)) {
            empleados.remove(empleado);
            System.out.println("el empleado a sido despedido");
        }else{           
            System.out.println("el empleado no se encuentra");
        }
    }
    public boolean login(String usuario, String contrasena) {
    	if (usuario.equals(this.usuario) && contrasena.equals(this.contrasena)) {
			return true;
		}else {
			return false;
		}
    }
	public Museo getMuseo() {
		return museo;
	}
	public void setMuseo(Museo museo) {
		this.museo = museo;
	}
}
